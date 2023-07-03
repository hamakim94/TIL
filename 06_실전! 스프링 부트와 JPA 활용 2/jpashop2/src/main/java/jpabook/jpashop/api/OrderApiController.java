package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.query.OrderFlatDto;
import jpabook.jpashop.repository.order.query.OrderItemQueryDto;
import jpabook.jpashop.repository.order.query.OrderQueryDto;
import jpabook.jpashop.repository.order.query.OrderQueryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;

    @GetMapping("/api/v1/orders")
    public Result ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o -> o.getItem().getName());

        }
        return new Result(all);
    }

    @GetMapping("/api/v2/orders")
    public Result orderV2(){
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(toList());

        return new Result(result);
    }

    @GetMapping("/api/v3/orders")
    public Result orderV3(){
        List<Order> orders = orderRepository.findAllWithItem();

        for (Order order : orders) {
            System.out.println("order = " + order + " id = " + order.getId());
        }
        List<OrderDto> result = orders.stream().map(OrderDto::new).collect(toList());
        return new Result(result);
    }

    @GetMapping("/api/v3.1/orders")
    public Result orderV3_page(@RequestParam(value = "offset", defaultValue = "0") int offset,
                               @RequestParam(value = "limit", defaultValue = "100") int limit
    ){
        // @ToOne -> fetch join
        List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit);
        List<OrderDto> result = orders.stream().map(OrderDto::new).collect(toList());
        return new Result(result);
    }

    @GetMapping("/api/v4/orders")
    public Result orderV4() {
        return new Result(orderQueryRepository.findOrderQueryDtos());
    }

    @GetMapping("/api/v5/orders")
    public Result orderV5() {
        return new Result(orderQueryRepository.findAllByDto_optimization());
    }

    @GetMapping("/api/v6/orders")

    public Result order6() {

        List<OrderFlatDto> flats = orderQueryRepository.findAllByDto_flat();
        return new Result(flats.stream()
                .collect(groupingBy(o -> new OrderQueryDto(o.getOrderId(),
                                o.getName(), o.getOrderDate(), o.getOrderStatus(), o.getAddress()),
                        mapping(o -> new OrderItemQueryDto(o.getOrderId(),
                                o.getItemName(), o.getOrderPrice(), o.getCount()), toList())
                )).entrySet().stream()
                .map(e -> new OrderQueryDto(e.getKey().getOrderId(),
                        e.getKey().getName(), e.getKey().getOrderDate(), e.getKey().getOrderStatus(),
                        e.getKey().getAddress(), e.getValue()))
                .collect(toList()));

    }
    @Data
    class OrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();

            orderItems = order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem)).collect(toList());
        }
    }

    @Data
    static class OrderItemDto {
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

    @Data
    @AllArgsConstructor
    class Result<T>{
        private T data;
    }
}
