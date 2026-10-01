package exam.ss8.controller;

import exam.ss8.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/divide")
    public ResponseEntity<Double> divide(
            @RequestParam Double a,
            @RequestParam Double b) {

        Double result = mathService.divide(a, b);

        return ResponseEntity.ok(result);
    }
}