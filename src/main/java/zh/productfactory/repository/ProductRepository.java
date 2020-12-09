package zh.productfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zh.productfactory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}