package com.example.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.model.naming.NamingStrategies;

import javax.persistence.Id;
import java.math.BigDecimal;

@MappedEntity(value = "accounts", namingStrategy = NamingStrategies.UnderScoreSeparatedLowerCase.class)
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String accountNumber;
    private BigDecimal balance;
    private String status;

    // Constructors, Getters, and Setters
}
