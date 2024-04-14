package com.example.firstspringapi.inheritanceConcept.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "Mentor")
public class Mentor extends User {
    private double mentorRating;
}
