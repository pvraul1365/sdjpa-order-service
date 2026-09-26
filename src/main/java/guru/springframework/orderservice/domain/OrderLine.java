package guru.springframework.orderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * OrderLine
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 26/09/2026 - 12:58
 * @since 1.25
 */
@Entity
@Getter
@Setter
public class OrderLine extends BaseEntity {

    private Integer quantityOrdered;

    @ManyToOne
    private OrderHeader orderHeader;

    @ManyToOne
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(quantityOrdered, orderLine.quantityOrdered) && Objects.equals(orderHeader, orderLine.orderHeader) && Objects.equals(product, orderLine.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantityOrdered, product);
    }
}
