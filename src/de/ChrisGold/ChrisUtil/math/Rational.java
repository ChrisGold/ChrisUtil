package de.ChrisGold.ChrisUtil.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @author Christian Goldapp
 */
public class Rational {

    public static final Rational ONE = Rational.valueOf(1);
    public static final Rational HALF = Rational.valueOf(0.5);
    public static final Rational MINUS_ONE = Rational.valueOf(-1);
    public static final Rational PI = Rational.valueOf(Math.PI);
    public static final Rational E = Rational.valueOf(Math.E);

    private final BigInteger numerator;
    private final BigInteger denominator;

    /**
     * Constructs a new {@code Rational}.
     *
     * @param val A {@code BigInteger} that represents the value.
     */
    private Rational(BigInteger val) {
        this.numerator = val;
        this.denominator = BigInteger.ONE;
    }

    /**
     * Constructs a new {@code Rational}.
     *
     * @param numerator   A {@code BigInteger} that represents the numerator.
     * @param denominator A {@code BigInteger} that represents the denominator.
     */
    private Rational(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return toString(10);
    }

    public BigDecimal toBigDecimal() {
        BigDecimal num = new BigDecimal(numerator);
        BigDecimal den = new BigDecimal(denominator);
        return num.divide(den, RoundingMode.HALF_DOWN);
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

    public String toString(int radix) {
        return String.format("%s / %s", numerator.toString(radix), denominator.toString(radix));
    }

    public String toDecimalString(){
        return toBigDecimal().toString();
    }

    public Rational add(Rational val){
        BigInteger num = this.numerator.multiply(val.denominator).add(val.numerator.multiply(this.denominator));
        BigInteger den = this.denominator.multiply(val.denominator);
        return Rational.valueOf(num, den);
    }

    public Rational add(long val){
        return this.add(Rational.valueOf(val));
    }

    public Rational add(double val){
        return this.add(Rational.valueOf(val));
    }

    public Rational subtract(Rational val){
        val = val.multiply(-1);
        return add(val);
    }

    public Rational subtract(long val){
        return this.subtract(Rational.valueOf(val));
    }

    public Rational subtract(double val){
        return this.subtract(Rational.valueOf(val));
    }

    public Rational multiply(Rational val){
        return Rational.valueOf(this.numerator.multiply(val.numerator), this.denominator.multiply(val.denominator));
    }

    public Rational multiply(long val){
        return Rational.valueOf(this.numerator.multiply(BigInteger.valueOf(val)), this.denominator);
    }

    public Rational multiply(double val){
        return this.multiply(Rational.valueOf(val));
    }

    public Rational divide(Rational val){
        return Rational.valueOf(this.numerator.multiply(val.denominator), this.denominator.multiply(val.numerator));
    }

    public Rational divide(long val){
        return divide(Rational.valueOf(val));
    }

    public Rational divide(double val){
        return divide(Rational.valueOf(val));
    }

    public Rational abs(){
        return Rational.valueOf(numerator.abs(), denominator.abs());
    }

    public Rational pow(int val){
        return Rational.valueOf(numerator.pow(val), denominator.pow(val));
    }

    public static Rational valueOf(BigDecimal val) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        int sign = val.signum();
        int scale = val.scale();
        //Work with absolute values from now on
        val = val.abs();

        if (scale == 0) {
            numerator = val.unscaledValue();
            denominator = BigInteger.ONE;
        } else if (scale < 0) {
            numerator = val.unscaledValue().multiply(BigInteger.TEN.pow(-1 * scale));
            denominator = BigInteger.ONE;
        } else if (scale > 0) {
            numerator = val.unscaledValue();
            denominator = BigInteger.TEN.pow(scale);
        }

        //Restore the sign.
        if (sign < 0) {
            numerator = numerator.multiply(BigInteger.valueOf(-1));
        }

        //Reduce the result
        return valueOf(numerator, denominator);
    }

    public static Rational valueOf(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
        return new Rational(numerator, denominator);
    }

    public static Rational valueOf(double val) {
        return valueOf(BigDecimal.valueOf(val));
    }

    public static Rational valueOf(String s) {
        if (!s.contains("/")) {
            return valueOf(Double.parseDouble(s));
        }
        String[] parts = s.split("/");
        BigInteger numerator = new BigInteger(parts[0]);
        BigInteger denominator = new BigInteger(parts[1]);
        return valueOf(numerator, denominator);
    }

    public static void main(String[] args) {
        Rational r = Rational.valueOf(Math.PI);
        r = r.pow(1000);
        System.out.println(r);
    }
}
