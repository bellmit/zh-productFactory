package zh.productfactory.entity;

import lombok.Data;
import javax.persistence.*;

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
}
