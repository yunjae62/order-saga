package ex.order.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    private String id;

    private String userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Integer orderPrice;

    private String paymentId;

    private Integer usedPoint;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    public static Order create(String id, String userId) {
        Order order = new Order();

        order.id = id;
        order.userId = userId;
        order.status = OrderStatus.PAYMENT_REQUESTED;
        order.orderPrice = 0;
        order.usedPoint = 0;

        return order;
    }
}
