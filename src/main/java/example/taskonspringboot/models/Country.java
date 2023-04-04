package example.taskonspringboot.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Product product;

    public Country(String countryName, Product product) {
        this.countryName = countryName;
        this.product = product;
    }
}
