package guru.springframework.orderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * OrderApproval
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 27/09/2026 - 09:31
 * @since 1.25
 */
@Entity
@Getter
@Setter
public class OrderApproval extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "order_header_id")
    private OrderHeader orderHeader;

    private String approvedBy;

}
