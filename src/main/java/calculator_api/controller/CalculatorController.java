package calculator_api.controller;

import calculator_api.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Calculator API Project!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is Healthy and Working!";
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b){
        return calculatorService.add(a, b);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b){
        return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b){
        return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam int a, @RequestParam int b){
        return calculatorService.divide(a, b);
    }

    @GetMapping("/modulus")
    public double modulus(@RequestParam int a, @RequestParam int b){
        return calculatorService.modulus(a, b);
    }

    @GetMapping("/power")
    public int power(@RequestParam int a, @RequestParam int b){
        return calculatorService.power(a, b);
    }
}