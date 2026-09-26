package guru.springframework.orderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * Product
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 26/09/2026 - 12:29
 * @since 1.25
 */
@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(description, product.description) && productStatus == product.productStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, productStatus);
    }
}
