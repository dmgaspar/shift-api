package com.company.shift.shift_api.controller;


import com.company.shift.shift_api.domain.Operator;
import com.company.shift.shift_api.exception.ResourceAlreadyExistException;
import com.company.shift.shift_api.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/cpn/operators")
public class OperatorController {

    private OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping
    public ResponseEntity<List<Operator>> getAllOperators() {
        List<Operator> operators = operatorService.getAllOperators();
        return ResponseEntity.ok(operators);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operator> getOperatorById(@PathVariable Long id) {
        Optional<Operator> operator = operatorService.getOperatorById(id);
        return operator.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<List<Operator>> createOperators(@RequestBody List<Operator> operators) {
        List<Operator> createdOperators =  operatorService.createOperators(operators);

       return ResponseEntity.status(HttpStatus.CREATED).body(createdOperators);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Operator> updateOperator(@PathVariable Long id, @RequestBody Operator operator) {
        Optional<Operator> updatedOperator = operatorService.updateOperator(id, operator);
        return updatedOperator.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}