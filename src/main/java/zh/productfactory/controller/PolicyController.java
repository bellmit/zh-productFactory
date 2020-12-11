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
import zh.productfactory.entity.*;
import zh.productfactory.repository.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PolicyController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private FormulaExpressRepository formulaExpressRepository;

    @Autowired
    private FormulaVarRepository formulaVarRepository;

    // 计算保单保费
    @RequestMapping("/policy/fee/{id}")
    public BigDecimal policy_fee(@PathVariable("id") String id) {
        // 获得保单数据
        Policy policy = policyRepository.findById(id).orElse(new Policy());

        // 获得产品数据
        Product product = productRepository.findById(policy.id).orElse(new Product());

        // 获得保费计算公式
        FormulaExpress express = formulaExpressRepository.findById(product.fee_formula_id).orElse(new FormulaExpress());

        // 获得公式变量值
        List<FormulaVar> vars = formulaVarRepository.findAll();

        // 填充公式变量
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SA", new BigDecimal(product.sa));
        for (FormulaVar var : vars) {
            map.put(var.name, new BigDecimal(var.value));
        }

        // 公式计算
        Expression compiledExp = AviatorEvaluator.compile(express.express);
        BigDecimal result = (BigDecimal) compiledExp.execute(map);

        return result;
    }
}
