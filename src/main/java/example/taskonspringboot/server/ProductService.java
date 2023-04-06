package example.taskonspringboot.server;

import example.taskonspringboot.dto.request.ProductRequest;
import example.taskonspringboot.exception.MyException;
import example.taskonspringboot.models.Product;
import example.taskonspringboot.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repo;

    public void saveProduct(ProductRequest newProduct) {
        Product product = new Product();
        product.setStatus(newProduct.getStatus());
        product.setProductName(newProduct.getProductName());
        product.setDescription(newProduct.getDescription());
        repo.save(product);
    }

    public Product getProductById(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("wrong id"));
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public void deleteProductById(Long id){
        boolean check = repo.existsById(id);
        if (!check) {
            throw new MyException("wrong id");
        }
        repo.deleteById(id);
    }

    public void updateProductById(Long id,ProductRequest request){
        boolean check = repo.existsById(id);
        if (!check) {
            throw new MyException("wrong id");
        }
        Product product = new Product();
        product.setDescription(request.getDescription());
        product.setStatus(request.getStatus());
        product.setProductName(request.getProductName());
        repo.save(product);
    }
}
