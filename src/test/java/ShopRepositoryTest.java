import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "компьютер", 120_000);
        Product product2 = new Product(45, "продукты", 900);
        Product product3 = new Product(129, "дом", 10_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(45);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "компьютер", 120_000);
        Product product2 = new Product(45, "продукты", 900);
        Product product3 = new Product(129, "дом", 10_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(133457)
        );


    }
}
