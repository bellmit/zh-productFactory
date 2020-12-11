package zh.productfactory.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "gender", length = 64)
    private String gender;

    @Column(name = "name", length = 64)
    private String name;
}
