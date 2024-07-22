package ru.cft.shiftlabtesttask.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.shiftlabtesttask.core.entities.DigitInterval;

import java.util.Optional;

@Repository
public interface DigitIntervalRepository extends JpaRepository<DigitInterval,Integer> {

    Optional<DigitInterval> findFirstByOrderByLeftBorderAscRightBorder();
}
