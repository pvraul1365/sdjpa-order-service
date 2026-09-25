package guru.springframework.orderservice.repository;

import guru.springframework.orderservice.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderHeaderRepository
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 25/09/2026 - 15:37
 * @since 1.25
 */
public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
}
