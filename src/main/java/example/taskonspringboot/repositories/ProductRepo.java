package example.taskonspringboot.repositories;

import example.taskonspringboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {


}
