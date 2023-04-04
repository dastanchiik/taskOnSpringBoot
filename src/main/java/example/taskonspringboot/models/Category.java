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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "category")
    @ToString.Exclude
    private List<SubCategory> categories;

    public Category(String categoryName, List<SubCategory> categories) {
        this.categoryName = categoryName;
        this.categories = categories;
    }
}
