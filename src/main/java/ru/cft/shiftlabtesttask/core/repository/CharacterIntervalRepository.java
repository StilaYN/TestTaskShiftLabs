package ru.cft.shiftlabtesttask.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shiftlabtesttask.core.entities.CharInterval;

import java.util.Optional;

public interface CharacterIntervalRepository extends JpaRepository<CharInterval, Integer> {

    Optional<CharInterval> findFirstByOrderByLeftBorderAscRightBorder();
}
