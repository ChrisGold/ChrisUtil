package de.ChrisGold.ChrisUtil.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * @author Christian Goldapp
 */
public class Rational{

    public static final Rational ONE = new Rational(1);
    public static final Rational HALF = new Rational(0.5);
    public static final Rational MINUS_ONE = new Rational(-1);
    public static final Rational PI = new Rational(Math.PI);
    public static final Rational E = new Rational(Math.E);

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
        int sign = val.signum();
        //Work with absolute values from now now
        val = val.abs();
        //Determine if we can get away with a denominator = 1
        boolean isInteger = val.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO);
        if(isInteger){
            this.numerator = val.toBigIntegerExact();
            this.denominator = BigInteger.ONE;
            if(sign == -1) numerator = numerator.multiply(BigInteger.valueOf(-1));
        }
        else{

        }
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

    public int intValue(){
        return toBigInteger().intValue();
    }

    public long longValue(){
        return toBigInteger().longValue();
    }

    public double doubleValue(){
        return toBigDecimal().doubleValue();
    }

    public BigInteger toBigInteger(){
        return numerator.divide(denominator);
    }

    public BigDecimal toBigDecimal(){
        BigDecimal decNum = new BigDecimal(numerator);
        BigDecimal decDen = new BigDecimal(denominator);
        return decNum.divide(decDen, MathContext.DECIMAL128);
    }

    @Override
    public String toString() {
        return String.format("%d / %d", numerator, denominator);
    }

    public String toDecimalString(){
        return toBigDecimal().toString();
    }

    public Rational add(Rational val){
        BigInteger num = this.numerator.multiply(val.denominator).add(val.numerator.multiply(this.denominator));
        BigInteger den = this.denominator.multiply(val.denominator);
        return new Rational(num, den);
    }

    public Rational add(long val){
        return this.add(new Rational(val));
    }

    public Rational add(double val){
        return this.add(new Rational(val));
    }

    public Rational subtract(Rational val){
        val = val.multiply(-1);
        return add(val);
    }

    public Rational subtract(long val){
        return this.subtract(new Rational(val));
    }

    public Rational subtract(double val){
        return this.subtract(new Rational(val));
    }

    public Rational multiply(Rational val){
        return new Rational(this.numerator.multiply(val.numerator), this.denominator.multiply(val.denominator));
    }

    public Rational multiply(long val){
        return new Rational(this.numerator.multiply(BigInteger.valueOf(val)), this.denominator);
    }

    public Rational multiply(double val){
        return this.multiply(new Rational(val));
    }

    public Rational divide(Rational val){
        return new Rational(this.numerator.multiply(val.denominator), this.denominator.multiply(val.numerator));
    }

    public Rational divide(long val){
        return divide(new Rational(val));
    }

    public Rational divide(double val){
        return divide(new Rational(val));
    }

    public Rational abs(){
        return new Rational(numerator.abs(), denominator.abs());
    }

    public Rational pow(int val){
        return new Rational(numerator.pow(val), denominator.pow(val));
    }
}
