package example.taskonspringboot.api;

import example.taskonspringboot.dto.request.ProductRequest;
import example.taskonspringboot.models.Product;
import example.taskonspringboot.server.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductApi {
    private static ProductService service;

    @PostMapping("/save")
    public String registerProduct(ProductRequest productRequest) {
        service.saveProduct(productRequest);
        return "saved ✅";
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
}
