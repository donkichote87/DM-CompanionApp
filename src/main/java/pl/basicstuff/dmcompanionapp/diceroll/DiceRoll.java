package pl.basicstuff.dmcompanionapp.diceroll;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class DiceRoll {

    @Min(0)
    @Max(10)
    private int k4;
    @Min(0)
    @Max(10)
    private int k6;
    @Min(0)
    @Max(10)
    private int k8;
    @Min(0)
    @Max(10)
    private int k10;
    @Min(0)
    @Max(10)
    private int k12;
    @Min(0)
    @Max(10)
    private int k20;

 }
