package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Embedded
    private Address address;
    private DeliveryStatus status;


    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;


}
