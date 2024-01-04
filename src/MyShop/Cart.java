package MyShop;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
    private HashMap<Product, Integer> items = new HashMap<Product, Integer>();
    public void showItems() {
        for (Map.Entry<Product, Integer> entrySet : items.entrySet()) {
            System.out.println(entrySet.getKey().getName() + " : " + entrySet.getValue() +"개");
        }
    }

    public boolean addProduct(Product product, int amount) {
//        if (items.containsKey(product.getKey())) { // 만약 동일한 상품이 이미 있으면
//            items.replace(product, items.get(product) + count);
//        } else { items.put(product, count); }

        items.merge(product, amount, Integer::sum);

        return true;
    }

    public boolean removeProduct(Product product, int count) {
        try {
            int count_val = items.get(product);

            if (count > count_val) { // 장바구니에 있는 상품의 개수보다 많은 값을 입력하면
                System.out.println("그 상품은 개수가 그것보다 적은데요?");
                return false;
            } else if (count == count_val) {
                items.remove(product);
                return true;
            } else {
                items.replace(product, items.get(product) - count);
                return true;
            }
        } catch(NullPointerException e) {
            System.out.println("그런 상품은 없는데여?");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Map<String, Integer> showItemsStream() {
        return items.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
    }

}
























