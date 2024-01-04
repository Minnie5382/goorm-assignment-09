import MyShop.Cart;
import MyShop.Product;

import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 상품 목록, 상품 객체 생성
        Set<Product> productList = new HashSet<>();

        Product kasha = new Product(1000, "도도 장난감", 1000);
        Product food = new Product(1001, "지용이 사료", 2000);
        Product bottle = new Product(1002, "샤샤 물통", 3000);
        Product cloth = new Product(1003, "정우 꼬까옷", 4000);
        Product blanket = new Product(1004, "지용이 담요", 5000);

        // 상품리스트에서 상품을 넣는다.
        productList.add(kasha);
        productList.add(food);
        productList.add(bottle);
        productList.add(cloth);
        productList.add(blanket);

        System.out.println("민희's 펫샵 상품 목록 : ");
        for(Product p : productList) {
            System.out.println(p.getName()+": "+p.getPrice()+"원");
        }

        System.out.println("\n=== 쇼핑 시작 ===");

        // 장바구니 생성
        Cart cart = new Cart();

        // 장바구니에 상품 추가
        System.out.println("\n((( 장바구니에 샤샤 물통 3개 담는 중 )))");
        cart.addProduct(bottle, 3);
        System.out.println("((( 장바구니에 도도 장난감 10개 담는 중 )))");
        cart.addProduct(kasha, 10);
        System.out.println("((( 장바구니에 정우 꼬까옷 1개 담는 중 )))");
        cart.addProduct(cloth, 1);
        cart.showItems();

        // 장바구니에 상품 삭제
        System.out.println("\n((( 장바구니에서 도도 장난감 5개 빼는 중 )))");
        cart.removeProduct(kasha, 5);
        cart.showItems();

        System.out.println("\n((( 장바구니에서 샤샤 물통 전부 다 빼는 중 )))");
        cart.removeProduct(bottle, 3);
        cart.showItems();

        System.out.println("\n((( 장바구니에서 정우 꼬까옷 3개 빼는 중 - 에러 테스트)))");
        cart.removeProduct(cloth, 3);
        cart.showItems();

        System.out.println("\n((( 장바구니에서 지용이 담요 1개 빼는 중 - 에러 테스트)))");
        cart.removeProduct(blanket, 1);
        cart.showItems();

    }
}