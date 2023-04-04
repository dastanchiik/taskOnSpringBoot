package example.taskonspringboot.dto.request;


import example.taskonspringboot.models.ProductStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String productName;
    private String description;
    private ProductStatus status;
}
