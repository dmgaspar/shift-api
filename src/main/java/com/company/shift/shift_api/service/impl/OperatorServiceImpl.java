package com.company.shift.shift_api.service.impl;


import com.company.shift.shift_api.domain.Operator;
import com.company.shift.shift_api.exception.ResourceAlreadyExistException;
import com.company.shift.shift_api.repository.OperatorRepository;
import com.company.shift.shift_api.service.OperatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;

    public OperatorServiceImpl(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public List<Operator> getAllOperators() {
        return operatorRepository.findAll()
                .stream()
                .map(operator -> new Operator(operator.getId(), operator.getName(), operator.getShifts()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Operator> getOperatorById(Long id) {
        return operatorRepository.findById(id)
                .map(operator -> new Operator(operator.getId(), operator.getName(), operator.getShifts()));
    }


    @Override
    public Optional<Operator> updateOperator(Long id, Operator newOperator) {
        return operatorRepository.findById(id).map(operator -> {
            operator.setOperator(newOperator);
            operatorRepository.save(operator);
            return new Operator(operator.getName(), operator.getShifts());
        });
    }

    @Override
    public List<Operator> createOperators(List<Operator> operators) {
        List<Operator> newOperators = new ArrayList<>();

        for (Operator operator : operators) {
            // Check if an operator with the same name already exists
            Optional<Operator> existingOperator = operatorRepository.findByName(operator.getName());

            if (existingOperator.isPresent()) {
                throw new ResourceAlreadyExistException("Operator with name " + operator.getName() + " already exists.");
            } else {
                newOperators.add(operator);
            }
        }
        return operatorRepository.saveAll(newOperators);
    }

    @Override
    public Optional<Operator> findByName(Operator operator) {
        return operatorRepository.findByName(operator.getName());

    }
}

