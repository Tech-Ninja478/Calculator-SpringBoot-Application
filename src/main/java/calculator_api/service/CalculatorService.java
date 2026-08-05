package calculator_api.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int a, int b){
        return a + b;
    }   

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }   

    public double divide(int a, int b){
        return(double) a / b;
    }  

    public double modulus(int a, int b){
        return(double) a % b;
    } 

    public int power(int a, int b){
        return(int) Math.pow(a, b);
    }
       
}