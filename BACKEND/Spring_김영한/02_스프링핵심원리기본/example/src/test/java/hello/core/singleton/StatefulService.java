package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유자허눈 필드, 싱글턴이라서, 값이 공유가 되버린다..

//    public void order(String name, int price) {
//        System.out.println("name  = " + name + "price = " + price);
//        this.price = price; // 여기가 문제
//    }

//    public int getPrice() {
//        return price;
//    }

    // 무상태로!!!


    public int  order(String name, int price) {
        System.out.println("name  = " + name + "price = " + price);
        return price;
    } // 지역 변수로 따로 담을 수 있게 된다~


}
