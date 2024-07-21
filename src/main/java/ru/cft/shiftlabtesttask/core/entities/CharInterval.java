package ru.cft.shiftlabtesttask.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "character_intervals")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Character leftBorder;
    Character rightBorder;
}
