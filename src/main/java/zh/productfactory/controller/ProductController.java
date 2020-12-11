package zh.productfactory.controller;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import zh.productfactory.entity.Customer;
import zh.productfactory.entity.Policy;
import zh.productfactory.entity.Product;
import zh.productfactory.repository.CustomerRepository;
import zh.productfactory.repository.PolicyRepository;
import zh.productfactory.repository.ProductRepository;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job processJob;

    @GetMapping("/product")
    public Page<Product> product_list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return productRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @GetMapping("/policy")
    public Page<Policy> policy(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return policyRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @GetMapping("/policy/{id}")
    public Policy policy_detail(@PathVariable("id") String id) {
        Optional<Policy> optional = policyRepository.findById(id);
        return optional.orElseGet(Policy::new);
    }

    @GetMapping("/customer")
    public Page<Customer> customer(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return customerRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    @RequestMapping("/invokejob")
    public String handle() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(processJob, jobParameters);

        return "Batch job has been invoked ...";
    }
}
