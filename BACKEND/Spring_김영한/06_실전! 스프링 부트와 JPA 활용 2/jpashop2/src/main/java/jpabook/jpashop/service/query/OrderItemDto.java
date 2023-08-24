package jpabook.jpashop.service.query;

import jpabook.jpashop.domain.OrderItem;
import lombok.Data;

@Data
class OrderItemDto {
    // 사용자 요구 사항 3가지일 경우
    private String itemName;  // 상품 명
    private int orderPrice; // 주문 가격
    private int count; // 주문 수량
    public OrderItemDto(OrderItem orderItem) {
        itemName = orderItem.getItem().getName();
        orderPrice = orderItem.getOrderPrice();
        count = orderItem.getCount();
    }
}
