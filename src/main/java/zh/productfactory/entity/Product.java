package zh.productfactory.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "code", length = 64)
    private String code;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "sa", length = 64)
    public String sa;

    @Column(name = "fee_formula_id", length = 255)
    public String fee_formula_id;

    //@OneToMany(mappedBy = "product")
    //private List<Policy> policies;
}
