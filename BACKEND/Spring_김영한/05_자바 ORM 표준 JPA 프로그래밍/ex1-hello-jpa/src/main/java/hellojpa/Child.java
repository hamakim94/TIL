package hellojpa;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Embeddable
    public static class Address {

        private String city;
        private String street;
        private String zipcode;

        public Address() {
        }

        public Address(String city, String street, String zipcode) {
            this.city = city;
            this.street = street;
            this.zipcode = zipcode;
        }

    }

    @Embeddable
    public static class Period {

        LocalDateTime startDate;
        LocalDateTime endDate;

        public Period() {
        }

        public Period(LocalDateTime startDate, LocalDateTime endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

    }
}
