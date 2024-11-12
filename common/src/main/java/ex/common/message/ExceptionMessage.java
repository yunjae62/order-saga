package ex.common.message;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.PAYMENT_REQUIRED;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    /* 글로벌 1000번대 */

    // 권한 없음 403
    NOT_AUTHORIZED(HttpStatus.FORBIDDEN, "1000", "해당 요청에 대한 권한이 없습니다."),
    // 잘못된 형식의 입력 400
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "1001", "유효하지 않은 입력값입니다."),
    // 존재하지 않는 값 404
    NOT_FOUND(HttpStatus.NOT_FOUND, "1002", "존재하지 않는 입력값입니다."),
    // 시스템 에러 500
    SYSTEM_ERROR(INTERNAL_SERVER_ERROR, "1003", "알 수 없는 에러가 발생했습니다."),

    /* 결제 2000번대 */

    // 잔액 부족 402
    INSUFFICIENT_BALANCE(PAYMENT_REQUIRED, "2001", "충전금이 부족합니다."),
    PAY_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "2002", "간편결제 사용자가 존재하지 않습니다."),
    INVALID_PASSWORD(BAD_REQUEST, "2003", "비밀번호가 일치하지 않습니다."),
    PAY_USER_DUPLICATE(BAD_REQUEST, "2004", "이미 등록된 사용자입니다."),
    PAYMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "2005", "결제 정보가 존재하지 않습니다."),

    /* 유저 3000번대 */

    POINT_ISSUE_LACK(BAD_REQUEST, "3001", "적립금이 부족합니다."),
    USER_DUPLICATE_EMAIL(BAD_REQUEST, "3002", "이메일이 중복 됩니다."),
    USER_NOT_FOUND(NOT_FOUND.httpStatus, "3003", "사용자가 존재하지 않습니다."),


    /* 브랜드 4000번대 */
    BRAND_NOT_FOUND(HttpStatus.NOT_FOUND, "4001", "해당 브랜드를 찾을 수 없습니다."),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "4002", "해당 카테고리를 찾을 수 없습니다."),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "4003", "해당 상품을 찾을 수 없습니다."),
    PRODUCT_INVENTORY_LACK(BAD_REQUEST, "4004", "재고가 부족합니다."),
    INVALID_DISCOUNT_AMOUNT(BAD_REQUEST, "4005", "상품 할인가격이 상품 가격보다 높을 수 없습니다."),


    /* 주문 5000번대 */

    // 현재 주문 상태에서 바뀔 수 없는 주문 상태로 변경하려 할 때
    INVALID_ORDER_STATUS(CONFLICT, "5001", "현재 주문 상태에서는 요청하신 상태 변경이 불가합니다."),
    // 결제 요청 금액과 최종 주문 금액 값이 일치하지 않을 때
    NOT_EQUALS_PRICE(CONFLICT, "5002", "결제 요청 금액과 주문 금액이 일치하지 않습니다."),
    // 주문 취소가 가능하지 않은 주문 상태일 때.
    IMPOSSIBLE_CANCEL_ORDER_PAYMENT(CONFLICT, "5003", "주문 취소가 불가한 주문 상태입니다."),
    // FeignException 메시지, 코드 파싱 실패 시
    FEIGN_CLIENT_PARSE_ERROR(CONFLICT, "5004", "FeignException 메시지 파싱 실패"),

    /* 쿠폰 6000번대 */

    // 유효하지 않은 할인율 정책
    INVALID_INPUT_COUPON_DISCOUNT_RATE(BAD_REQUEST, "6000", "쿠폰 할인율은 1% ~ 100% 만 입력할 수 있습니다."),
    // 발급 일자가 아닌데, 발급 받으려고 할 때
    COUPON_ISSUE_PERIOD(BAD_REQUEST, "6001", "쿠폰 발급 일자가 아닙니다."),
    // 쿠폰 발급 수량 초과
    COUPON_ISSUE_QUANTITY_LIMITED(BAD_REQUEST, "6002", "쿠폰이 소진되어 더 이상 발급 받으실 수 없습니다."),

    COUPON_INVALID_INPUT_FIRST_COME_FIRST_SERVED(BAD_REQUEST, "6003", "선착순 쿠폰은 발급 수량을 입력해야 합니다."),

    COUPON_INVALID_INPUT_RATE(BAD_REQUEST, "6004", "정률 쿠폰은 할인율을 입력해야 합니다."),

    COUPON_INVALID_INPUT_RATE_DONT_WRITE_DISCOUNT_AMOUNT(BAD_REQUEST, "6005", "정률 쿠폰은 할인 금액을 입력 할 수 없습니다."),

    COUPON_INVALID_INPUT_AMOUNT(BAD_REQUEST, "6006", "정액 쿠폰은 할인 금액을 입력해야 합니다."),

    COUPON_INVALID_INPUT_AMOUNT_DONT_WRITE_DISCOUNT_RATE(BAD_REQUEST, "6007", "정액 쿠폰은 할인율을 입력 할 수 없습니다."),

    COUPON_INVALID_INPUT_UNLIMITED(BAD_REQUEST, "6008", "무제한 쿠폰은 발급 수량을 입력할 수 없습니다."),

    DUPLICATED_COUPON_ISSUE(BAD_REQUEST, "6009", "이미 발급 된 쿠폰입니다."),

    COUPON_CAN_NOT_USE(BAD_REQUEST, "6010", "해당 쿠폰을 사용할 수 없습니다."),


    /* 타임세일 7000번대 */

    TIME_SALE_PRODUCT_LIMITED_SALE(BAD_REQUEST, "7000", "재고가 소진되어 더 이상 할인 가격으로 구매할 수 없습니다."),

    TIME_SALE_PRODUCT_PERIOD(BAD_REQUEST, "7001", "타임세일 일자가 아닙니다."),

    TIME_SALE_END_DATE_IS_BEFORE_NOW(BAD_REQUEST, "7002", "타임세일 종료일은 현재 시간보다 이전 일 수 없습니다."),

    TIME_SALE_START_DATE_IS_AFTER_END_DATE(BAD_REQUEST, "7003", "타임세일 시작일은 종료일보다 이전 일 수 없습니다."),

    TIME_SALE_START_DATE_IS_EQUALS_END_DATE(BAD_REQUEST, "7004", "타임세일 시작일은 종료일과 같을 수 없습니다."),

    REQUEST_LIST_SIZE_LIMIT(BAD_REQUEST, "7005", "목록 요청은 100개 까지만 할 수 있습니다."),

    /* 게이트웨이 8000번대 */
    GATEWAY_INVALID_CONNECTED(SERVICE_UNAVAILABLE, "8001", "서비스에 접속할 수 없습니다. 잠시 후 다시 접속해주세요");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
