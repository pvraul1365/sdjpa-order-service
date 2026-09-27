package guru.springframework.orderservice.repository;

import guru.springframework.orderservice.domain.OrderApproval;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderApprovalRepository
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 27/09/2026 - 09:33
 * @since 1.25
 */
public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {
}
