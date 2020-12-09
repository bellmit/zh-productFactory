package zh.productfactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zh.productfactory.entity.Product;
import zh.productfactory.repository.ProductRepository;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/list")
    public Page<Product> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return productRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }
}
