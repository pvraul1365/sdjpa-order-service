package guru.springframework.orderservice.repository;

import guru.springframework.orderservice.domain.Customer;
import guru.springframework.orderservice.domain.OrderApproval;
import guru.springframework.orderservice.domain.OrderHeader;
import guru.springframework.orderservice.domain.OrderLine;
import guru.springframework.orderservice.domain.Product;
import guru.springframework.orderservice.domain.ProductStatus;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderRepositoryTest {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderApprovalRepository orderApprovalRepository;

    Product product;

    @BeforeEach
    void setup() {
        Product newProduct = new Product();
        newProduct.setDescription("Test Product");
        newProduct.setProductStatus(ProductStatus.NEW);
        product = productRepository.saveAndFlush(newProduct);
    }

    @Test
    void testGetCategory() {
        var product = productRepository.findByDescription("PRODUCT1");
        assertNotNull(product);
        assertNotNull(product.getCategories());
    }

    @Test
    void testSaveOrder() {
        var customer = new Customer();
        customer.setCustomerName("Test Customer");
        var orderHeader = new OrderHeader();
        orderHeader.setCustomer(customer);
        var savedOrder = orderHeaderRepository.save(orderHeader);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());

        var fetchedOrder = orderHeaderRepository.getReferenceById(savedOrder.getId());

        assertNotNull(fetchedOrder);
        assertNotNull(fetchedOrder.getId());
        assertNotNull(fetchedOrder.getCreatedDate());
        assertNotNull(fetchedOrder.getLastModifiedDate());
    }

    @Test
    void testSaveOrderWithLine() {
        var customer = new Customer();
        customer.setCustomerName("Test Customer");
        var orderHeader = new OrderHeader();
        orderHeader.setCustomer(customer);

        var orderLine = new OrderLine();
        orderLine.setQuantityOrdered(5);
        orderLine.setProduct(product);

        orderHeader.addOrderLine(orderLine);

        var orderApproval = new OrderApproval();
        orderApproval.setApprovedBy("Test Approver");
        var savedApproval = orderApprovalRepository.save(orderApproval);
        orderHeader.setOrderApproval(savedApproval);

        var savedOrder = orderHeaderRepository.save(orderHeader);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getOrderLines());
        assertEquals(1, savedOrder.getOrderLines().size());

        var fetchedOrder = orderHeaderRepository.getReferenceById(savedOrder.getId());
        assertNotNull(fetchedOrder);
        assertEquals(1, fetchedOrder.getOrderLines().size());

    }
}