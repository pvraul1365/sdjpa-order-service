package guru.springframework.orderservice.repository;

import guru.springframework.orderservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 26/09/2026 - 12:32
 * @since 1.25
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDescription(String description);

}
