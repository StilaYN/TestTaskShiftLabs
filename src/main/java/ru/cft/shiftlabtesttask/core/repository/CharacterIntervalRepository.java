package ru.cft.shiftlabtesttask.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.shiftlabtesttask.core.entities.CharInterval;

import java.util.Optional;

@Repository
public interface CharacterIntervalRepository extends JpaRepository<CharInterval, Integer> {

    Optional<CharInterval> findFirstByOrderByLeftBorderAscRightBorder();
}
