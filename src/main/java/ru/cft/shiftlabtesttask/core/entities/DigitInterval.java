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
public class DigitInterval implements Interval<Integer, DigitInterval> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer leftBorder;
    private Integer rightBorder;

    @Override
    protected Object clone() {
        return DigitInterval.builder()
            .leftBorder(leftBorder)
            .rightBorder(rightBorder)
            .build();
    }

    @Override
    public int compareTo(DigitInterval o) {
        if(o==null){
            throw new NullPointerException("");
        }
        if(getLeftBorder()<o.getLeftBorder()){
            return -1;
        }
        else if(getLeftBorder()>getRightBorder()){
            return 1;
        }
        else{
            return getRightBorder().compareTo(o.getRightBorder());
        }
    }

    @Override
    public DigitInterval combine(DigitInterval secondInterval) {
        if (secondInterval == null) {
            throw new NullPointerException("Нельзя объединить с пустым интервалом");
        }
        DigitInterval leftInterval = (getLeftBorder() < secondInterval.getLeftBorder()) ? this : secondInterval;
        DigitInterval rightInterval = (leftInterval.equals(this)) ? secondInterval : this;
        if (leftInterval.getLeftBorder().equals(rightInterval.getLeftBorder())
            && leftInterval.getRightBorder().equals(rightInterval.getRightBorder())) {
            return (DigitInterval) this.clone();
        } else if (leftInterval.getRightBorder() < rightInterval.getLeftBorder()) {
            return null;
        } else
            return DigitInterval.builder()
                .leftBorder(leftInterval.getLeftBorder())
                .rightBorder((leftInterval.getRightBorder() > rightInterval.getRightBorder())
                    ? leftInterval.getRightBorder() : rightInterval.getRightBorder())
                .build();
    }
}
