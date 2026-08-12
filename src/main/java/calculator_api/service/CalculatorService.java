package calculator_api.service;

import calculator_api.repository.CalculationRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculationRepository calculationRepository;

    public CalculatorService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public int add(int a, int b) {
        int result = a + b;
        calculationRepository.saveCalculation(a + " + " + b, result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        calculationRepository.saveCalculation(a + " - " + b, result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        calculationRepository.saveCalculation(a + " * " + b, result);
        return result;
    }

    public double divide(int a, int b) {
        double result = (double) a / b;
        calculationRepository.saveCalculation(a + " / " + b, result);
        return result;
    }

    public double modulus(int a, int b) {
        double result = (double) a % b;
        calculationRepository.saveCalculation(a + " % " + b, result);
        return result;
    }

    public int power(int a, int b) {
        int result = (int) Math.pow(a, b);
        calculationRepository.saveCalculation(a + " ^ " + b, result);
        return result;
    }
}