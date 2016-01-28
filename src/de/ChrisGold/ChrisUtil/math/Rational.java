package de.ChrisGold.ChrisUtil.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Christian Goldapp
 */
public class Rational{
    private BigInteger numerator = BigInteger.ONE;
    private BigInteger denominator = BigInteger.ONE;

    /**
     * Constructs a new {@code Rational}.
     * @param val A {@code BigInteger} that represents the value.
     */
    public Rational(BigInteger val){
        this.numerator = val;
        reduce();
    }

    /**
     * Constructs a new {@code Rational}.
     * @param numerator A {@code BigInteger} that represents the numerator.
     * @param denominator A {@code BigInteger} that represents the denominator.
     */
    public Rational(BigInteger numerator, BigInteger denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    /**
     * Constructs a new {@code Rational}.
     * @param val A {@code BigDecimal} that represents the value.
     */
    public Rational(BigDecimal val){
        numerator = val.unscaledValue();
        denominator = BigInteger.TEN.pow(-1 * val.scale());
        reduce();
    }

    /**
     * Constructs a new {@code Rational}.
     * @param val A {@code double} that represents the value.
     */
    public Rational(double val){
        this(BigDecimal.valueOf(val));
    }

    /**
     * Constructs a new {@code Rational}.
     * @param val A {@code long} that represents the value.
     */
    public Rational(long val){
        this(BigInteger.valueOf(val));
    }

    /**
     * Reduces the {@code Rational} by setting numerator and denominator to the smallest possible pair of whole numbers
     * that can represent the value.
     */
    private void reduce(){
        if(denominator.equals(BigInteger.ZERO)) throw new ArithmeticException("Denominator is zero!");
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

}
