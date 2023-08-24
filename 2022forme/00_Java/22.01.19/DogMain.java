package day3;

public class DogMain {
	public static void main(String[] args) {
		
		Dog d = new Dog();
		Dog d2 = new Dog("쫑");
		Dog d3 = new Dog(3);
		Dog d4 = new Dog("메리", 2);
		
		d.info();
		d2.info();
		d3.info();
		d4.info();
	}
}
