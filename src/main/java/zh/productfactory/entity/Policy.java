package zh.productfactory.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "policy")
@Data
public class Policy {
    @Id
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "customer_id", length = 64)
    private String customer_id;

    @Column(name = "product_id", length = 64)
    private String product_id;
}
