import MyShop.Cart;
import MyShop.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        // 상품 목록, 상품 객체 생성
        Set<Product> productList = new HashSet<>();

        BufferedReader br;
        String line;
        String path = "/Users/minn/Desktop/goorm/goorm-assignment-09-cart/src/data.csv";
        List<Product> myProducts = new ArrayList<>();

        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));

            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                Product product = new Product(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
                myProducts.add(product);

            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException();
        } catch (IOException e) {
            throw new IOException();
        }

        System.out.println("민희's 펫샵 상품 목록 : ");
        for(Product p : productList) {
            System.out.println(p.getName()+": "+p.getPrice()+"원");
        }

        System.out.println("\n=== 쇼핑 시작 ===");

        // 장바구니 생성
        Cart cart = new Cart();

        // 장바구니에 상품 추가
        System.out.println("\n((( 장바구니에 샤샤 물통 3개 담는 중 )))");
        cart.addProduct(myProducts.get(2), 3);
        System.out.println("((( 장바구니에 도도 장난감 10개 담는 중 )))");
        cart.addProduct(myProducts.get(0), 10);
        System.out.println("((( 장바구니에 정우 꼬까옷 1개 담는 중 )))");
        cart.addProduct(myProducts.get(3), 1);
        cart.showItems();

        // 장바구니에 상품 삭제
        System.out.println("\n((( 장바구니에서 도도 장난감 5개 빼는 중 )))");
        cart.removeProduct(myProducts.get(0), 5);
        cart.showItems();

        System.out.println("\n((( 장바구니에서 샤샤 물통 전부 다 빼는 중 )))");
        cart.removeProduct(myProducts.get(2), 3);
        cart.showItems();

        System.out.println("\n((( 장바구니에서 정우 꼬까옷 3개 빼는 중 - 에러 테스트)))");
        cart.removeProduct(myProducts.get(3), 3);
        cart.showItems();

        System.out.println("\n((( 장바구니에서 지용이 담요 1개 빼는 중 - 에러 테스트)))");
        cart.removeProduct(myProducts.get(4), 1);
        cart.showItems();

    }
}