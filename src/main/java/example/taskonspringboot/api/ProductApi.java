package example.taskonspringboot.api;

import example.taskonspringboot.dto.request.ProductRequest;
import example.taskonspringboot.models.Product;
import example.taskonspringboot.server.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductApi {
    private final ProductService service;

    @PostMapping("/save")
    public String registerProduct(@RequestBody ProductRequest productRequest) {
        service.saveProduct(productRequest);
        return "saved ✅";
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/getProduct/by/{id}")
    public Product getById(@PathVariable Long id){
        return service.getProductById(id);
    }

    @DeleteMapping("/productDelete/by/{id}")
    public String deleteProductById(@PathVariable Long id){
        service.deleteProductById(id);
        return "deleted ✔";
    }

}
