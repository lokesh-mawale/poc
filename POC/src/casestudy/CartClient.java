package casestudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CartClient {

	public static void main(String[] args) {
		
		CartClient cart = new CartClient();
		cart.shop();
		
		int num1 = 40;
		int num2 = 40;
		int num3 = 180;
		int num4 = 180;

		if(num1 == num2)
		System.out.println("A");
		else
		System.out.println("B");

		if(num3 == num4)
		System.out.println("C");
		else
		System.out.println("D");

	}

	private void shop() {
		Product bananaChips = new Product("Banana Chips", 10, Category.FOOD);

		Product softToy = new Product("Soft Toy", 20, Category.TOYS);

		Product mobile = new Product("Samsung Mobile", 20, Category.ELECTORNICS);

		List<Product> productList = new ArrayList<Product>();
		Collections.addAll(productList, bananaChips,softToy,mobile);
		
		Integer totalPrice = productList.stream()
		.map(p->p.getPrice())
		.reduce(0,(a,b)->a+b);
		
		System.out.println("Total Price :: "+totalPrice);

		Integer discountedPrice = productList.stream()
		.map(this::getDiscountedPrice)
		.reduce(0,(a,b)-> a+b);
		
		System.out.println("Discounted Price :: "+discountedPrice);

	}
	
	private int getDiscountedPrice(Product product) {
		int price = product.getPrice();
		int discount = product.getCategory().getDiscount();
		int finalPrice =  price - ((price * discount / 100));
		return finalPrice;
		
	}

}
