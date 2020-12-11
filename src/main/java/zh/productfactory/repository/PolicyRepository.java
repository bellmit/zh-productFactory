package zh.productfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zh.productfactory.entity.Policy;
import zh.productfactory.entity.Product;

public interface PolicyRepository extends JpaRepository<Policy, String> {
}