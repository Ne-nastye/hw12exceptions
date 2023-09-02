import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 60_000);
        Product product2 = new Product(11, "Электронная сигарета", 1_000);
        Product product3 = new Product(111, "Кофе", 200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(11);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Книга", 1_000);
        Product product2 = new Product(11, "Электронная сигарета", 2_000);
        Product product3 = new Product(111, "Кофе", 250);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(2)
        );
    }

}