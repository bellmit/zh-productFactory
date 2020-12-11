package zh.productfactory.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "formula_express")
@Data
public class FormulaExpress {
    @Id
    @GeneratedValue(generator = "idGenerator")
    public String id;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "express", length = 64)
    public String express;

    @Column(name = "desc", length = 64)
    private String desc;
}
