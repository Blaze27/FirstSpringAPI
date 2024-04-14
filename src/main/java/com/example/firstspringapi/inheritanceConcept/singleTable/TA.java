package com.example.firstspringapi.inheritanceConcept.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "TA")
public class TA extends User {
    private int numberOfSessions;
    private double averageRating;
}
