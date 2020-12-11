package zh.productfactory.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "formula_var")
@Data
public class FormulaVar {
    @Id
    @GeneratedValue(generator = "idGenerator")
    public String id;

    @Column(name = "value", length = 64)
    public String value;

    @Column(name = "name", length = 64)
    public String name;

    @Column(name = "desc", length = 64)
    private String desc;
}
