package com.company.shift.shift_api.service;

import com.company.shift.shift_api.domain.Operator;

import java.util.List;
import java.util.Optional;

public interface OperatorService {

    public List<Operator> getAllOperators();

    public Optional<Operator> getOperatorById(Long id);

    public Optional<Operator> updateOperator(Long id, Operator operator);

    public List<Operator>  createOperators(List<Operator> operators);

    public  Optional<Operator> findByName(Operator operator);
}
