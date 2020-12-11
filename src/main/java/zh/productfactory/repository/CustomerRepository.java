package zh.productfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zh.productfactory.entity.Customer;
import zh.productfactory.entity.Product;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}