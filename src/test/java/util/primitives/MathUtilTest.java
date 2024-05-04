package util.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static util.primitives.MathUtil.*;

public class MathUtilTest {

    @Test
    void compareToNegativeShouldReturnMinusOne() {
        Assertions.assertEquals( -1, compareToZero( (short) -5, Short.class ) );
        Assertions.assertEquals( -1, compareToZero( -5, Integer.class ) );
        Assertions.assertEquals( -1, compareToZero( -5L, Long.class ) );
        Assertions.assertEquals( -1, compareToZero( -5.0F, Float.class ) );
        Assertions.assertEquals( -1, compareToZero( -5.0, Double.class ) );
        Assertions.assertEquals( -1, compareToZero( new BigInteger( "-5" ), BigInteger.class ) );
        Assertions.assertEquals( -1, compareToZero( new BigDecimal( "-5.0" ), BigDecimal.class ) );
    }

    @Test
    void compareToZeroShouldReturnZero() {
        Assertions.assertEquals( 0, compareToZero( (short) 0, Short.class ) );
        Assertions.assertEquals( 0, compareToZero( 0, Integer.class ) );
        Assertions.assertEquals( 0, compareToZero( 0L, Long.class ) );
        Assertions.assertEquals( 0, compareToZero( 0.0F, Float.class ) );
        Assertions.assertEquals( 0, compareToZero( 0.0, Double.class ) );
        Assertions.assertEquals( 0, compareToZero( new BigInteger( "0" ), BigInteger.class ) );
        Assertions.assertEquals( 0, compareToZero( new BigDecimal( "0.0" ), BigDecimal.class ) );
    }

    @Test
    void compareToPositiveShouldReturnOne() {
        Assertions.assertEquals( 1, compareToZero( (short) 7, Short.class ) );
        Assertions.assertEquals( 1, compareToZero( 7, Integer.class ) );
        Assertions.assertEquals( 1, compareToZero( 7L, Long.class ) );
        Assertions.assertEquals( 1, compareToZero( 7.0F, Float.class ) );
        Assertions.assertEquals( 1, compareToZero( 7.0, Double.class ) );
        Assertions.assertEquals( 1, compareToZero( new BigInteger( "7" ), BigInteger.class ) );
        Assertions.assertEquals( 1, compareToZero( new BigDecimal( "7.0" ), BigDecimal.class ) );
    }

    @Test
    void compareToWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> compareToZero( 42, null ) );
    }

    @Test
    void compareToWithNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> compareToZero( null, Integer.class ) );
    }

    @Test
    void isGreaterThanWithGreaterShouldBeTrue() {
        Assertions.assertTrue( isGreaterThan( (short) 3, (short) 1, Short.class ) );
        Assertions.assertTrue( isGreaterThan( 3, 1, Integer.class ) );
        Assertions.assertTrue( isGreaterThan( 3L, 1L, Long.class ) );
        Assertions.assertTrue( isGreaterThan( 3.0F, 1.0F, Float.class ) );
        Assertions.assertTrue( isGreaterThan( 3.0, 1.0, Double.class ) );
        Assertions.assertTrue( isGreaterThan( new BigInteger( "3" ), new BigInteger( "1" ), BigInteger.class ) );
        Assertions.assertTrue( isGreaterThan( new BigDecimal( "3" ), new BigDecimal( "1" ), BigDecimal.class ) );
    }

    @Test
    void isGreaterThanWithEqualShouldBeFalse() {
        Assertions.assertFalse( isGreaterThan( (short) 3, (short) 3, Short.class ) );
        Assertions.assertFalse( isGreaterThan( 3, 3, Integer.class ) );
        Assertions.assertFalse( isGreaterThan( 3L, 3L, Long.class ) );
        Assertions.assertFalse( isGreaterThan( 3.0F, 3.0F, Float.class ) );
        Assertions.assertFalse( isGreaterThan( 3.0, 3.0, Double.class ) );
        Assertions.assertFalse( isGreaterThan( new BigInteger( "3" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertFalse( isGreaterThan( new BigDecimal( "3" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isGreaterThanWithLessShouldBeFalse() {
        Assertions.assertFalse( isGreaterThan( (short) 1, (short) 3, Short.class ) );
        Assertions.assertFalse( isGreaterThan( 1, 3, Integer.class ) );
        Assertions.assertFalse( isGreaterThan( 1L, 3L, Long.class ) );
        Assertions.assertFalse( isGreaterThan( 1.0F, 3.0F, Float.class ) );
        Assertions.assertFalse( isGreaterThan( 1.0, 3.0, Double.class ) );
        Assertions.assertFalse( isGreaterThan( new BigInteger( "1" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertFalse( isGreaterThan( new BigDecimal( "1" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isGreaterThanWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> isGreaterThan( 3, 1, null ) );
    }

    @Test
    void isGreaterThanWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( null, 3, Integer.class ) );
    }

    @Test
    void isGreaterThanWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( 1, null, Integer.class ) );
    }

    @Test
    void isGreaterThanOrEqualToWithGreaterShouldBeTrue() {
        Assertions.assertTrue( isGreaterThanOrEqualTo( (short) 3, (short) 1, Short.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3, 1, Integer.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3L, 1L, Long.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3.0F, 1.0F, Float.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3.0, 1.0, Double.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( new BigInteger( "3" ), new BigInteger( "1" ), BigInteger.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( new BigDecimal( "3" ), new BigDecimal( "1" ), BigDecimal.class ) );
    }

    @Test
    void isGreaterThanOrEqualToWithEqualShouldBeTrue() {
        Assertions.assertTrue( isGreaterThanOrEqualTo( (short) 3, (short) 3, Short.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3, 3, Integer.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3L, 3L, Long.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3.0F, 3.0F, Float.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( 3.0, 3.0, Double.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( new BigInteger( "3" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( new BigDecimal( "3" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isGreaterThanOrEqualToWithLessShouldBeFalse() {
        Assertions.assertFalse( isGreaterThanOrEqualTo( (short) 1, (short) 3, Short.class ) );
        Assertions.assertFalse( isGreaterThanOrEqualTo( 1, 3, Integer.class ) );
        Assertions.assertFalse( isGreaterThanOrEqualTo( 1L, 3L, Long.class ) );
        Assertions.assertFalse( isGreaterThanOrEqualTo( 1.0F, 3.0F, Float.class ) );
        Assertions.assertFalse( isGreaterThanOrEqualTo( 1.0, 3.0, Double.class ) );
        Assertions.assertFalse( isGreaterThanOrEqualTo( new BigInteger( "1" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertFalse( isGreaterThanOrEqualTo( new BigDecimal( "1" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isGreaterOrEqualToThanWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> isGreaterThanOrEqualTo( 3, 1, null ) );
    }

    @Test
    void isGreaterThanOrEqualToWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( null, 3, Integer.class ) );
    }

    @Test
    void isGreaterThanOrEqualToWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( 1, null, Integer.class ) );
    }

    @Test
    void isLessThanWithGreaterShouldBeFalse() {
        Assertions.assertFalse( isLessThan( (short) 3, (short) 1, Short.class ) );
        Assertions.assertFalse( isLessThan( 3, 1, Integer.class ) );
        Assertions.assertFalse( isLessThan( 3L, 1L, Long.class ) );
        Assertions.assertFalse( isLessThan( 3.0F, 1.0F, Float.class ) );
        Assertions.assertFalse( isLessThan( 3.0, 1.0, Double.class ) );
        Assertions.assertFalse( isLessThan( new BigInteger( "3" ), new BigInteger( "1" ), BigInteger.class ) );
        Assertions.assertFalse( isLessThan( new BigDecimal( "3" ), new BigDecimal( "1" ), BigDecimal.class ) );
    }

    @Test
    void isLessThanWithEqualShouldBeFalse() {
        Assertions.assertFalse( isLessThan( (short) 3, (short) 3, Short.class ) );
        Assertions.assertFalse( isLessThan( 3, 3, Integer.class ) );
        Assertions.assertFalse( isLessThan( 3L, 3L, Long.class ) );
        Assertions.assertFalse( isLessThan( 3.0F, 3.0F, Float.class ) );
        Assertions.assertFalse( isLessThan( 3.0, 3.0, Double.class ) );
        Assertions.assertFalse( isLessThan( new BigInteger( "3" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertFalse( isLessThan( new BigDecimal( "3" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isLessThanWithLessShouldBeTrue() {
        Assertions.assertTrue( isLessThan( (short) 1, (short) 3, Short.class ) );
        Assertions.assertTrue( isLessThan( 1, 3, Integer.class ) );
        Assertions.assertTrue( isLessThan( 1L, 3L, Long.class ) );
        Assertions.assertTrue( isLessThan( 1.0F, 3.0F, Float.class ) );
        Assertions.assertTrue( isLessThan( 1.0, 3.0, Double.class ) );
        Assertions.assertTrue( isLessThan( new BigInteger( "1" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertTrue( isLessThan( new BigDecimal( "1" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isLessThanWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> isLessThan( 3, 1, null ) );
    }

    @Test
    void isLessThanWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( null, 3, Integer.class ) );
    }

    @Test
    void isLessThanWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( 1, null, Integer.class ) );
    }

    @Test
    void isLessThanOrEqualToWithGreaterShouldBeFalse() {
        Assertions.assertFalse( isLessThanOrEqualTo( (short) 3, (short) 1, Short.class ) );
        Assertions.assertFalse( isLessThanOrEqualTo( 3, 1, Integer.class ) );
        Assertions.assertFalse( isLessThanOrEqualTo( 3L, 1L, Long.class ) );
        Assertions.assertFalse( isLessThanOrEqualTo( 3.0F, 1.0F, Float.class ) );
        Assertions.assertFalse( isLessThanOrEqualTo( 3.0, 1.0, Double.class ) );
        Assertions.assertFalse( isLessThanOrEqualTo( new BigInteger( "3" ), new BigInteger( "1" ), BigInteger.class ) );
        Assertions.assertFalse( isLessThanOrEqualTo( new BigDecimal( "3" ), new BigDecimal( "1" ), BigDecimal.class ) );
    }

    @Test
    void isLessThanOrEqualToWithEqualShouldBeTrue() {
        Assertions.assertTrue( isLessThanOrEqualTo( (short) 3, (short) 3, Short.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 3, 3, Integer.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 3L, 3L, Long.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 3.0F, 3.0F, Float.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 3.0, 3.0, Double.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( new BigInteger( "3" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( new BigDecimal( "3" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isLessThanOrEqualToWithLessShouldBeTrue() {
        Assertions.assertTrue( isLessThanOrEqualTo( (short) 1, (short) 3, Short.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 1, 3, Integer.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 1L, 3L, Long.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 1.0F, 3.0F, Float.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( 1.0, 3.0, Double.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( new BigInteger( "1" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertTrue( isLessThanOrEqualTo( new BigDecimal( "1" ), new BigDecimal( "3" ), BigDecimal.class ) );
    }

    @Test
    void isLessThanOrEqualToWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> isLessThanOrEqualTo( 3, 1, null ) );
    }

    @Test
    void isLessOrEqualToThanWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( null, 3, Integer.class ) );
    }

    @Test
    void isLessThanOrEqualToWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( 1, null, Integer.class ) );
    }

    @Test
    void addShouldPerformAddition() {
        Assertions.assertEquals( (short) 12, add( (short) 10, (short) 2, Short.class ) );
        Assertions.assertEquals( 12, add( 10, 2, Integer.class ) );
        Assertions.assertEquals( 12L, add( 10L, 2L, Long.class ) );
        Assertions.assertEquals( 12.0F, add( 10.0F, 2.0F, Float.class ) );
        Assertions.assertEquals( 12.0, add( 10.0, 2.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "12" ), add( new BigInteger( "10" ), new BigInteger( "2" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "12.0" ), add( new BigDecimal( "10.0" ), new BigDecimal( "2.0" ), BigDecimal.class ) );
    }

    @Test
    void addWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> add( 10, 2, null ) );
    }

    @Test
    void addWithWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> add( null, 2, Integer.class ) );
    }

    @Test
    void addWithWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> add( 10, null, Integer.class ) );
    }

    @Test
    void subtractShouldPerformSubtraction() {
        Assertions.assertEquals( (short) 8, subtract( (short) 10, (short) 2, Short.class ) );
        Assertions.assertEquals( 8, subtract( 10, 2, Integer.class ) );
        Assertions.assertEquals( 8L, subtract( 10L, 2L, Long.class ) );
        Assertions.assertEquals( 8.0F, subtract( 10.0F, 2.0F, Float.class ) );
        Assertions.assertEquals( 8.0, subtract( 10.0, 2.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "8" ), subtract( new BigInteger( "10" ), new BigInteger( "2" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "8.0" ), subtract( new BigDecimal( "10.0" ), new BigDecimal( "2.0" ), BigDecimal.class ) );
    }

    @Test
    void subtractWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> subtract( 10, 2, null ) );
    }

    @Test
    void subtractWithWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> subtract( null, 2, Integer.class ) );
    }

    @Test
    void subtractWithWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> subtract( 10, null, Integer.class ) );
    }

    @Test
    void multiplyShouldPerformMultiplication() {
        Assertions.assertEquals( (short) 20, multiply( (short) 10, (short) 2, Short.class ) );
        Assertions.assertEquals( 20, multiply( 10, 2, Integer.class ) );
        Assertions.assertEquals( 20L, multiply( 10L, 2L, Long.class ) );
        Assertions.assertEquals( 20.0F, multiply( 10.0F, 2.0F, Float.class ) );
        Assertions.assertEquals( 20.0, multiply( 10.0, 2.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "20" ), multiply( new BigInteger( "10" ), new BigInteger( "2" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "20.00" ), multiply( new BigDecimal( "10.0" ), new BigDecimal( "2.0" ), BigDecimal.class ) );
    }

    @Test
    void multiplyWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> multiply( 10, 2, null ) );
    }

    @Test
    void multiplyWithWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> multiply( null, 2, Integer.class ) );
    }

    @Test
    void multiplyWithWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> multiply( 10, null, Integer.class ) );
    }

    @Test
    void divideShouldPerformDivision() {
        Assertions.assertEquals( (short) 5, divide( (short) 10, (short) 2, Short.class ) );
        Assertions.assertEquals( 5, divide( 10, 2, Integer.class ) );
        Assertions.assertEquals( 5L, divide( 10L, 2L, Long.class ) );
        Assertions.assertEquals( 5.0F, divide( 10.0F, 2.0F, Float.class ) );
        Assertions.assertEquals( 5.0, divide( 10.0, 2.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "5" ), divide( new BigInteger( "10" ), new BigInteger( "2" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "5.0" ), divide( new BigDecimal( "10.0" ), new BigDecimal( "2.0" ), BigDecimal.class ) );
    }

    @Test
    void divideWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> divide( 10, 2, null ) );
    }

    @Test
    void divideWithWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> divide( null, 2, Integer.class ) );
    }

    @Test
    void divideWithWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> divide( 10, null, Integer.class ) );
    }

    @Test
    void modShouldPerformModulus() {
        Assertions.assertEquals( (short) 1, mod( (short) 3, (short) 2, Short.class ) );
        Assertions.assertEquals( 1, mod( 3, 2, Integer.class ) );
        Assertions.assertEquals( 1L, mod( 3L, 2L, Long.class ) );
        Assertions.assertEquals( 1.0F, mod( 3.0F, 2.0F, Float.class ) );
        Assertions.assertEquals( 1.0, mod( 3.0, 2.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "1" ), mod( new BigInteger( "3" ), new BigInteger( "2" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "1.0" ), mod( new BigDecimal( "3.0" ), new BigDecimal( "2.0" ), BigDecimal.class ) );
    }

    @Test
    void modWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> mod( 10, 2, null ) );
    }

    @Test
    void modWithWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> mod( null, 2, Integer.class ) );
    }

    @Test
    void modWithWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> mod( 10, null, Integer.class ) );
    }

    @Test
    void minShouldReturnSmallerValue() {
        Assertions.assertEquals( 1980, min( 1980, 1992 ) );
        Assertions.assertEquals( 1980, min( 1992, 1980 ) );
        Assertions.assertEquals( 1980, min( 1980, 1980 ) );
    }

    @Test
    void minWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> min( null, 1992 ) );
    }

    @Test
    void minWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> min( 1980, null ) );
    }

    @Test
    void maxShouldReturnLargerValue() {
        Assertions.assertEquals( 1992, max( 1980, 1992 ) );
        Assertions.assertEquals( 1992, max( 1992, 1980 ) );
        Assertions.assertEquals( 1992, max( 1992, 1992 ) );
    }

    @Test
    void maxWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> max( null, 1992 ) );
    }

    @Test
    void maxWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> max( 1980, null ) );
    }

    @Test
    void powShouldPerformPower() {
        Assertions.assertEquals( (short) 8, pow( (short) 2, (short) 3, Short.class ) );
        Assertions.assertEquals( 8, pow( 2, 3, Integer.class ) );
        Assertions.assertEquals( 8L, pow( 2L, 3L, Long.class ) );
        Assertions.assertEquals( 8.0F, pow( 2.0F, 3.0F, Float.class ) );
        Assertions.assertEquals( 8.0, pow( 2.0, 3.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "8" ), pow( new BigInteger( "2" ), new BigInteger( "3" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "8.000" ), pow( new BigDecimal( "2.0" ), new BigDecimal( "3.0" ), BigDecimal.class ) );
    }

    @Test
    void powWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> pow( 2, 3, null ) );
    }

    @Test
    void powWithWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> pow( null, 3, Integer.class ) );
    }

    @Test
    void powWithWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> pow( 2, null, Integer.class ) );
    }

    @Test
    void logShouldComputeNaturalLogarithm() {
        Assertions.assertEquals( 2.302585092994046, log( (short) 10, Short.class ) );
        Assertions.assertEquals( 2.302585092994046, log( 10, Integer.class ) );
        Assertions.assertEquals( 2.302585092994046, log( 10L, Long.class ) );
        Assertions.assertEquals( 2.302585092994046, log( 10.0F, Float.class ) );
        Assertions.assertEquals( 2.302585092994046, log( 10.0, Double.class ) );
    }

    @Test
    void logWithUnsupportedTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> log( new BigInteger( "10" ), BigInteger.class ) );
    }

    @Test
    void logWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> log( 10, null ) );
    }

    @Test
    void logWithNullValueShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> log( null, Integer.class ) );
    }

    @Test
    void sqrtShouldPerformSquareRoot() {
        Assertions.assertEquals( (short) 3, sqrt( (short) 9, Short.class ) );
        Assertions.assertEquals( 3, sqrt( 9, Integer.class ) );
        Assertions.assertEquals( 3L, sqrt( 9L, Long.class ) );
        Assertions.assertEquals( 3.0F, sqrt( 9.0F, Float.class ) );
        Assertions.assertEquals( 3.0, sqrt( 9.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "3" ), sqrt( new BigInteger( "9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "3" ), sqrt( new BigDecimal( "9.0" ), BigDecimal.class ) );
    }

    @Test
    void sqrtWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> sqrt( 9, null ) );
    }

    @Test
    void sqrtWithNullValueShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> sqrt( null, Integer.class ) );
    }

    @Test
    void absWithPositiveShouldReturnSame() {
        Assertions.assertEquals( (short) 9, abs( (short) 9, Short.class ) );
        Assertions.assertEquals( 9, abs( 9, Integer.class ) );
        Assertions.assertEquals( 9L, abs( 9L, Long.class ) );
        Assertions.assertEquals( 9.0F, abs( 9.0F, Float.class ) );
        Assertions.assertEquals( 9.0, abs( 9.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "9" ), abs( new BigInteger( "9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "9.0" ), abs( new BigDecimal( "9.0" ), BigDecimal.class ) );
    }

    @Test
    void absWithNegativeShouldReturnPositive() {
        Assertions.assertEquals( (short) 9, abs( (short) -9, Short.class ) );
        Assertions.assertEquals( 9, abs( -9, Integer.class ) );
        Assertions.assertEquals( 9L, abs( -9L, Long.class ) );
        Assertions.assertEquals( 9.0F, abs( -9.0F, Float.class ) );
        Assertions.assertEquals( 9.0, abs( -9.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "9" ), abs( new BigInteger( "-9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "9.0" ), abs( new BigDecimal( "-9.0" ), BigDecimal.class ) );
    }

    @Test
    void absWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> abs( 9, null ) );
    }

    @Test
    void absWithNullValueShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> abs( null, Integer.class ) );
    }

    @Test
    void negateWithPositiveShouldReturnNegative() {
        Assertions.assertEquals( (short) -9, negate( (short) 9, Short.class ) );
        Assertions.assertEquals( -9, negate( 9, Integer.class ) );
        Assertions.assertEquals( -9L, negate( 9L, Long.class ) );
        Assertions.assertEquals( -9.0F, negate( 9.0F, Float.class ) );
        Assertions.assertEquals( -9.0, negate( 9.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "-9" ), negate( new BigInteger( "9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "-9.0" ), negate( new BigDecimal( "9.0" ), BigDecimal.class ) );
    }

    @Test
    void negateWithNegativeShouldReturnPositive() {
        Assertions.assertEquals( (short) 9, negate( (short) -9, Short.class ) );
        Assertions.assertEquals( 9, negate( -9, Integer.class ) );
        Assertions.assertEquals( 9L, negate( -9L, Long.class ) );
        Assertions.assertEquals( 9.0F, negate( -9.0F, Float.class ) );
        Assertions.assertEquals( 9.0, negate( -9.0, Double.class ) );
        Assertions.assertEquals( new BigInteger( "9" ), negate( new BigInteger( "-9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "9.0" ), negate( new BigDecimal( "-9.0" ), BigDecimal.class ) );
    }

    @Test
    void negateWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> negate( 9, null ) );
    }

    @Test
    void negateWithNullValueShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> negate( null, Integer.class ) );
    }

    @Test
    void ceilShouldRoundUp() {
        Assertions.assertEquals( (short) 9, ceil( (short) 9, Short.class ) );
        Assertions.assertEquals( 9, ceil( 9, Integer.class ) );
        Assertions.assertEquals( 9L, ceil( 9L, Long.class ) );
        Assertions.assertEquals( 9.0F, ceil( 8.4F, Float.class ) );
        Assertions.assertEquals( 9.0, ceil( 8.4, Double.class ) );
        Assertions.assertEquals( new BigInteger( "9" ), ceil( new BigInteger( "9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "9" ), ceil( new BigDecimal( "8.4" ), BigDecimal.class ) );
    }

    @Test
    void ceilWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> ceil( 9, null ) );
    }

    @Test
    void ceilWithNullValueShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> ceil( null, Integer.class ) );
    }

    @Test
    void floorShouldRoundDown() {
        Assertions.assertEquals( (short) 9, floor( (short) 9, Short.class ) );
        Assertions.assertEquals( 9, floor( 9, Integer.class ) );
        Assertions.assertEquals( 9L, floor( 9L, Long.class ) );
        Assertions.assertEquals( 9.0F, floor( 9.6F, Float.class ) );
        Assertions.assertEquals( 9.0, floor( 9.6, Double.class ) );
        Assertions.assertEquals( new BigInteger( "9" ), floor( new BigInteger( "9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "9" ), floor( new BigDecimal( "9.6" ), BigDecimal.class ) );
    }

    @Test
    void floorWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> floor( 9, null ) );
    }

    @Test
    void floorWithNullValueShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> floor( null, Integer.class ) );
    }

    @Test
    void roundShouldRoundToClosestWholeNumber() {
        Assertions.assertEquals( (short) 9, round( (short) 9, Short.class ) );
        Assertions.assertEquals( 9, round( 9, Integer.class ) );
        Assertions.assertEquals( 9L, round( 9L, Long.class ) );
        Assertions.assertEquals( 9.0F, round( 8.6F, Float.class ) );
        Assertions.assertEquals( 9.0, round( 8.6, Double.class ) );
        Assertions.assertEquals( new BigInteger( "9" ), round( new BigInteger( "9" ), BigInteger.class ) );
        Assertions.assertEquals( new BigDecimal( "9" ), round( new BigDecimal( "8.6" ), BigDecimal.class ) );
        Assertions.assertEquals( 9.0F, round( 9.4F, Float.class ) );
        Assertions.assertEquals( 9.0, round( 9.4, Double.class ) );
        Assertions.assertEquals( new BigDecimal( "9" ), round( new BigDecimal( "9.4" ), BigDecimal.class ) );
    }

    @Test
    void roundWithNullTypeShouldThrowUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> round( 9, null ) );
    }

    @Test
    void roundWithNullValueShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> round( null, Integer.class ) );
    }

}
