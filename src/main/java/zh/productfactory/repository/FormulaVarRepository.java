package zh.productfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zh.productfactory.entity.Customer;
import zh.productfactory.entity.FormulaVar;

public interface FormulaVarRepository extends JpaRepository<FormulaVar, String> {
}