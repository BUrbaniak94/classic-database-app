package pl.burbaniak.classicdatabase.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "offices")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class Office {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public Office(Long officeCode, String city, String phone, String addressLine1, String addressLine2, String state, String country, String postalCode, String territory) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
    }
}
