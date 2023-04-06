package example.taskonspringboot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private Boolean isBlock;
    @CreationTimestamp
    private LocalDateTime createAt;

    @ManyToOne
    private SubCategory subCategory;
}
