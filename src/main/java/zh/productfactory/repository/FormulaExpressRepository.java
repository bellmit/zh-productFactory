package zh.productfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zh.productfactory.entity.Customer;
import zh.productfactory.entity.FormulaExpress;

public interface FormulaExpressRepository extends JpaRepository<FormulaExpress, String> {
}