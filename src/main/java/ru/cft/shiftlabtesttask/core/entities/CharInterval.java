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
public class CharInterval implements Interval<Character, CharInterval> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Character leftBorder;
    Character rightBorder;

    @Override
    protected Object clone() {
        return CharInterval.builder()
            .leftBorder(leftBorder)
            .rightBorder(rightBorder)
            .build();
    }

    @Override
    public int compareTo(CharInterval o) {
        if (o == null) {
            throw new NullPointerException("");
        }
        if (getLeftBorder() < o.getLeftBorder()) {
            return -1;
        } else if (getLeftBorder() > o.getLeftBorder()) {
            return 1;
        } else {
            return getRightBorder().compareTo(o.getRightBorder());
        }
    }

    @Override
    public CharInterval combine(CharInterval secondInterval) {
        if (secondInterval == null) {
            throw new NullPointerException("Нельзя объединить с пустым интервалом");
        }
        CharInterval leftInterval = (getLeftBorder() < secondInterval.getLeftBorder()) ? this : secondInterval;
        CharInterval rightInterval = (leftInterval.equals(this)) ? secondInterval : this;
        if (leftInterval.getLeftBorder() == rightInterval.getLeftBorder()
            && leftInterval.getRightBorder() == rightInterval.getRightBorder()) {
            return (CharInterval) this.clone();
        } else if (leftInterval.getRightBorder() < rightInterval.getLeftBorder()) {
            return null;
        } else
            return CharInterval.builder()
                .leftBorder(leftInterval.getLeftBorder())
                .rightBorder((leftInterval.getRightBorder() > rightInterval.getRightBorder())
                    ? leftInterval.getRightBorder() : rightInterval.getRightBorder())
                .build();
    }
}
