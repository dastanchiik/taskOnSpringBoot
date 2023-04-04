package example.taskonspringboot.server;

import example.taskonspringboot.dto.request.ProductRequest;
import example.taskonspringboot.exception.MyException;
import example.taskonspringboot.models.Product;
import example.taskonspringboot.repositories.ProductRepo;

import java.util.List;

public class ProductService {
    private static ProductRepo repo;

    public void saveProduct(ProductRequest newProduct) {
        Product product = new Product();
        product.setStatus(newProduct.getStatus());
        product.setProductName(newProduct.getProductName());
        product.setDescription(newProduct.getDescription());
        repo.save(product);
    }

    public Product getProduct(Long id) {
        return repo.getById(id);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public void deleteProductById(Long id){
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
