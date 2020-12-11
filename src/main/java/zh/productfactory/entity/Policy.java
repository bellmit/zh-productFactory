package zh.productfactory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "policy")
@Data
public class Policy {
    @Id
    @GeneratedValue(generator = "idGenerator")
    public String id;

    @Column(name = "customer_id", length = 64)
    public String customer_id;

    @Column(name = "product_id", length = 64)
    public String product_id;

    //@ManyToOne
    //private Product product;
}
