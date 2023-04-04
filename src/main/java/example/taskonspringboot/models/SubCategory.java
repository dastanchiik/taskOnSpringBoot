package example.taskonspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @ManyToOne
    private Category category;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "subCategory")
    @ToString.Exclude
    private List<Product>productList;
}
