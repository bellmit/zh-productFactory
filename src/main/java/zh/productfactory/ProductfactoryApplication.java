package zh.productfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@SpringBootApplication
public class ProductfactoryApplication {
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")   //请求的映射路由
    public String home() {
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductfactoryApplication.class, args);
    }
}
