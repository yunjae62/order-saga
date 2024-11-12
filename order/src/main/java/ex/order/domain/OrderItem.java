package ex.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "order_items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    private String id;

    private String productId;

    private Integer quantity;

    private Integer unitPrice;

    private Integer paymentPrice;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public static OrderItem create(String id, String productId, Integer quantity, Integer unitPrice) {
        OrderItem orderItem = new OrderItem();

        orderItem.id = id;
        orderItem.productId = productId;
        orderItem.quantity = quantity;
        orderItem.unitPrice = unitPrice;
        orderItem.paymentPrice = quantity * unitPrice;

        return orderItem;
    }
}
