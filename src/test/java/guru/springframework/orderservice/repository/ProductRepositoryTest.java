package guru.springframework.orderservice.repository;

import guru.springframework.orderservice.domain.Product;
import guru.springframework.orderservice.domain.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * ProductRepositoryTest
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 26/09/2026 - 12:35
 * @since 1.25
 */
@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void testSaveProduct() {

        var product = new Product();
        product.setDescription("Product Description");
        product.setProductStatus(ProductStatus.NEW);

        var savedProduct = productRepository.save(product);

        var fetchedProduct = productRepository.getById(savedProduct.getId());

        assertNotNull(fetchedProduct);
        assertNotNull(fetchedProduct.getDescription());
        assertNotNull(fetchedProduct.getCreatedDate());
        assertNotNull(fetchedProduct.getLastModifiedDate());
        assertNotNull(fetchedProduct.getProductStatus());
    }
}
