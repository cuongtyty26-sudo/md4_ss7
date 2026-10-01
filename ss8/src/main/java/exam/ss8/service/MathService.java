package exam.ss8.service;

import exam.ss8.model.Calculation;
import exam.ss8.repository.CalculationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MathService {

    private final CalculationRepository calculationRepository;

    public MathService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Double divide(Double a, Double b) {

        if (b == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }

        Double result = a / b;

        Calculation calculation = new Calculation();
        calculation.setA(a);
        calculation.setB(b);
        calculation.setResult(result);
        calculation.setCreatedAt(LocalDateTime.now());

        calculationRepository.save(calculation);

        return result;
    }
}