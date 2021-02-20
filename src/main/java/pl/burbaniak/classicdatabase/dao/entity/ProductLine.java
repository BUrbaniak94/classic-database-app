package pl.burbaniak.classicdatabase.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "productlines")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class ProductLine {

    @Id
    @GeneratedValue
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;

    public ProductLine(String productLine, String textDescription, String htmlDescription, String image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }
}
