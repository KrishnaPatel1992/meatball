package map.functions.primitives;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static map.functions.primitives.MathFn.*;

public class MathFnTest {

    private final Meatball meatball = new Meatball(
            "year", 1992,
            "eyeColour", "Brown",
            "past", 1980,
            "two", 2,
            "platform", 9.75
    );

    private final Supplier<Map<String, Object>> mapSupplier = () -> new HashMap<>( meatball );

    private void isGreaterThanWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( null, 2077, Integer.class ).test( map ) );
        Assertions.assertFalse( isGreaterThan( "year", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( "unknown", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isGreaterThan( "eyeColour", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( "year", (Integer) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( "year", 2077, null ).test( map ) );
    }

    @Test
    void isGreaterThanWrapperTests() {
        isGreaterThanWrapperTests( meatball );
        isGreaterThanWrapperTests( mapSupplier.get() );
    }

    private void isGreaterThanAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( null, "past", Integer.class ).test( map ) );
        Assertions.assertTrue( isGreaterThan( "year", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( "unknown", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isGreaterThan( "eyeColour", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( "year", (String) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( "year", "unknown", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isGreaterThan( "year", "eyeColour", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThan( "year", "past", null ).test( map ) );
    }

    @Test
    void isGreaterThanAssociatedValueWrapperTests() {
        isGreaterThanAssociatedValueWrapperTests( meatball );
        isGreaterThanAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void isGreaterThanOrEqualToWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( null, 2077, Integer.class ).test( map ) );
        Assertions.assertFalse( isGreaterThanOrEqualTo( "year", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( "unknown", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isGreaterThanOrEqualTo( "eyeColour", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( "year", (Integer) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( "year", 2077, null ).test( map ) );
    }

    @Test
    void isGreaterThanOrEqualToWrapperTests() {
        isGreaterThanOrEqualToWrapperTests( meatball );
        isGreaterThanOrEqualToWrapperTests( mapSupplier.get() );
    }

    private void isGreaterThanOrEqualToAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( null, "past", Integer.class ).test( map ) );
        Assertions.assertTrue( isGreaterThanOrEqualTo( "year", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( "unknown", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isGreaterThanOrEqualTo( "eyeColour", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( "year", (String) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( "year", "unknown", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isGreaterThanOrEqualTo( "year", "eyeColour", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isGreaterThanOrEqualTo( "year", "past", null ).test( map ) );
    }

    @Test
    void isGreaterThanOrEqualToAssociatedValueWrapperTests() {
        isGreaterThanOrEqualToAssociatedValueWrapperTests( meatball );
        isGreaterThanOrEqualToAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void isLessThanWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( null, 2077, Integer.class ).test( map ) );
        Assertions.assertTrue( isLessThan( "year", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( "unknown", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isLessThan( "eyeColour", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( "year", (Integer) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( "year", 2077, null ).test( map ) );
    }

    @Test
    void isLessThanWrapperTests() {
        isLessThanWrapperTests( meatball );
        isLessThanWrapperTests( mapSupplier.get() );
    }

    private void isLessThanAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( null, "past", Integer.class ).test( map ) );
        Assertions.assertFalse( isLessThan( "year", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( "unknown", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isLessThan( "eyeColour", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( "year", (String) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( "year", "unknown", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isLessThan( "year", "eyeColour", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThan( "year", "past", null ).test( map ) );
    }

    @Test
    void isLessThanAssociatedValueWrapperTests() {
        isLessThanAssociatedValueWrapperTests( meatball );
        isLessThanAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void isLessThanOrEqualToWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( null, 2077, Integer.class ).test( map ) );
        Assertions.assertTrue( isLessThanOrEqualTo( "year", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( "unknown", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isLessThanOrEqualTo( "eyeColour", 2077, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( "year", (Integer) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( "year", 2077, null ).test( map ) );
    }

    @Test
    void isLessThanOrEqualToWrapperTests() {
        isLessThanOrEqualToWrapperTests( meatball );
        isLessThanOrEqualToWrapperTests( mapSupplier.get() );
    }

    private void isLessThanOrEqualToAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( null, "past", Integer.class ).test( map ) );
        Assertions.assertFalse( isLessThanOrEqualTo( "year", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( "unknown", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isLessThanOrEqualTo( "eyeColour", "past", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( "year", (String) null, Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( "year", "unknown", Integer.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isLessThanOrEqualTo( "year", "eyeColour", Integer.class ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isLessThanOrEqualTo( "year", "past", null ).test( map ) );
    }

    @Test
    void isLessThanOrEqualToAssociatedValueWrapperTests() {
        isLessThanOrEqualToAssociatedValueWrapperTests( meatball );
        isLessThanOrEqualToAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void addWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> add( null, 2077, Integer.class ).apply( map ) );
        Assertions.assertEquals( 4069, add( "year", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> add( "unknown", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> add( "eyeColour", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> add( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> add( "year", 2077, null ).apply( map ) );
    }

    @Test
    void addWrapperTests() {
        addWrapperTests( meatball );
        addWrapperTests( mapSupplier.get() );
    }

    private void addAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> add( null, "past", Integer.class ).apply( map ) );
        Assertions.assertEquals( 3972, add( "year", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> add( "unknown", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> add( "eyeColour", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> add( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> add( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> add( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> add( "year", "past", null ).apply( map ) );
    }

    @Test
    void addAssociatedValueWrapperTests() {
        addAssociatedValueWrapperTests( meatball );
        addAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void subtractWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> subtract( null, 2077, Integer.class ).apply( map ) );
        Assertions.assertEquals( -85, subtract( "year", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> subtract( "unknown", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> subtract( "eyeColour", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> subtract( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> subtract( "year", 2077, null ).apply( map ) );
    }

    @Test
    void subtractWrapperTests() {
        subtractWrapperTests( meatball );
        subtractWrapperTests( mapSupplier.get() );
    }

    private void subtractAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> subtract( null, "past", Integer.class ).apply( map ) );
        Assertions.assertEquals( 12, subtract( "year", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> subtract( "unknown", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> subtract( "eyeColour", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> subtract( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> subtract( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> subtract( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> subtract( "year", "past", null ).apply( map ) );
    }

    @Test
    void subtractAssociatedValueWrapperTests() {
        subtractAssociatedValueWrapperTests( meatball );
        subtractAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void multiplyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> multiply( null, 2077, Integer.class ).apply( map ) );
        Assertions.assertEquals( 4137384, multiply( "year", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> multiply( "unknown", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> multiply( "eyeColour", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> multiply( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> multiply( "year", 2077, null ).apply( map ) );
    }

    @Test
    void multiplyWrapperTests() {
        multiplyWrapperTests( meatball );
        multiplyWrapperTests( mapSupplier.get() );
    }

    private void multiplyAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> multiply( null, "past", Integer.class ).apply( map ) );
        Assertions.assertEquals( 3944160, multiply( "year", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> multiply( "unknown", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> multiply( "eyeColour", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> multiply( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> multiply( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> multiply( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> multiply( "year", "past", null ).apply( map ) );
    }

    @Test
    void multiplyAssociatedValueWrapperTests() {
        multiplyAssociatedValueWrapperTests( meatball );
        multiplyAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void divideWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> divide( null, 2077, Integer.class ).apply( map ) );
        Assertions.assertEquals( 0, divide( "year", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> divide( "unknown", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> divide( "eyeColour", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> divide( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> divide( "year", 2077, null ).apply( map ) );
    }

    @Test
    void divideWrapperTests() {
        divideWrapperTests( meatball );
        divideWrapperTests( mapSupplier.get() );
    }

    private void divideAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> divide( null, "past", Integer.class ).apply( map ) );
        Assertions.assertEquals( 1, divide( "year", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> divide( "unknown", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> divide( "eyeColour", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> divide( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> divide( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> divide( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> divide( "year", "past", null ).apply( map ) );
    }

    @Test
    void divideAssociatedValueWrapperTests() {
        divideAssociatedValueWrapperTests( meatball );
        divideAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void modWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> mod( null, 2, Integer.class ).apply( map ) );
        Assertions.assertEquals( 0, mod( "year", 2, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> mod( "unknown", 2, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> mod( "eyeColour", 2, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> mod( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> mod( "year", 2, null ).apply( map ) );
    }

    @Test
    void modWrapperTests() {
        modWrapperTests( meatball );
        modWrapperTests( mapSupplier.get() );
    }

    private void modAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> mod( null, "two", Integer.class ).apply( map ) );
        Assertions.assertEquals( 0, mod( "year", "two", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> mod( "unknown", "two", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> mod( "eyeColour", "two", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> mod( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> mod( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> mod( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> mod( "year", "two", null ).apply( map ) );
    }

    @Test
    void modAssociatedValueWrapperTests() {
        modAssociatedValueWrapperTests( meatball );
        modAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void minWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> min( null, 2077, Integer.class ).apply( map ) );
        Assertions.assertEquals( 1992, min( "year", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "unknown", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> min( "eyeColour", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "year", 2077, null ).apply( map ) );
    }

    @Test
    void minWrapperTests() {
        minWrapperTests( meatball );
        minWrapperTests( mapSupplier.get() );
    }

    private void minAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> min( null, "past", Integer.class ).apply( map ) );
        Assertions.assertEquals( 1980, min( "year", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "unknown", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> min( "eyeColour", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> min( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "year", "past", null ).apply( map ) );
    }

    @Test
    void minAssociatedValueWrapperTests() {
        minAssociatedValueWrapperTests( meatball );
        minAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void maxWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> max( null, 2077, Integer.class ).apply( map ) );
        Assertions.assertEquals( 2077, max( "year", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "unknown", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> max( "eyeColour", 2077, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "year", 2077, null ).apply( map ) );
    }

    @Test
    void maxWrapperTests() {
        maxWrapperTests( meatball );
        maxWrapperTests( mapSupplier.get() );
    }

    private void maxAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> max( null, "past", Integer.class ).apply( map ) );
        Assertions.assertEquals( 1992, max( "year", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "unknown", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> max( "eyeColour", "past", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> max( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "year", "past", null ).apply( map ) );
    }

    @Test
    void maxAssociatedValueWrapperTests() {
        maxAssociatedValueWrapperTests( meatball );
        maxAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void powWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> pow( null, 2, Integer.class ).apply( map ) );
        Assertions.assertEquals( 3968064, pow( "year", 2, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> pow( "unknown", 2, Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> pow( "eyeColour", 2, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> pow( "year", (Integer) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> pow( "year", 2, null ).apply( map ) );
    }

    @Test
    void powWrapperTests() {
        powWrapperTests( meatball );
        powWrapperTests( mapSupplier.get() );
    }

    private void powAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> pow( null, "two", Integer.class ).apply( map ) );
        Assertions.assertEquals( 3968064, pow( "year", "two", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> pow( "unknown", "two", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> pow( "eyeColour", "two", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> pow( "year", (String) null, Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> pow( "year", "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> pow( "year", "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> pow( "year", "two", null ).apply( map ) );
    }

    @Test
    void powAssociatedValueWrapperTests() {
        powAssociatedValueWrapperTests( meatball );
        powAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void logWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> log( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( 1.0, Math.round( log( "two", Integer.class ).apply( map ) ) );
        Assertions.assertThrows( NullPointerException.class, () -> log( "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> log( "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> log( "two", null ).apply( map ) );
    }

    @Test
    void logWrapperTests() {
        logWrapperTests( meatball );
        logWrapperTests( mapSupplier.get() );
    }

    private void sqrtWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> sqrt( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( 44, sqrt( "year", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sqrt( "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sqrt( "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sqrt( "year", null ).apply( map ) );
    }

    @Test
    void sqrtWrapperTests() {
        sqrtWrapperTests( meatball );
        sqrtWrapperTests( mapSupplier.get() );
    }

    private void absWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> abs( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( 1992, abs( "year", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> abs( "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> abs( "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> abs( "year", null ).apply( map ) );
    }

    @Test
    void absWrapperTests() {
        absWrapperTests( meatball );
        absWrapperTests( mapSupplier.get() );
    }

    private void negateWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> negate( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( -1992, negate( "year", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> negate( "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> negate( "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> negate( "year", null ).apply( map ) );
    }

    @Test
    void negateWrapperTests() {
        negateWrapperTests( meatball );
        negateWrapperTests( mapSupplier.get() );
    }

    private void ceilWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> ceil( null, Double.class ).apply( map ) );
        Assertions.assertEquals( 10, ceil( "platform", Double.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> ceil( "unknown", Double.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> ceil( "eyeColour", Double.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> ceil( "platform", null ).apply( map ) );

    }

    @Test
    void ceilWrapperTests() {
        ceilWrapperTests( meatball );
        ceilWrapperTests( mapSupplier.get() );
    }

    private void floorWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> floor( null, Double.class ).apply( map ) );
        Assertions.assertEquals( 9, floor( "platform", Double.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> floor( "unknown", Double.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> floor( "eyeColour", Double.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> floor( "platform", null ).apply( map ) );
    }

    @Test
    void floorWrapperTests() {
        floorWrapperTests( meatball );
        floorWrapperTests( mapSupplier.get() );
    }

    private void roundWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> round( null, Double.class ).apply( map ) );
        Assertions.assertEquals( 10, round( "platform", Double.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> round( "unknown", Double.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> round( "eyeColour", Double.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> round( "platform", null ).apply( map ) );

    }

    @Test
    void roundWrapperTests() {
        roundWrapperTests( meatball );
        roundWrapperTests( mapSupplier.get() );
    }

    private void castNumberToWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> castNumberTo( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( (short) 1992, castNumberTo( "year", Short.class ).apply( map ) );
        Assertions.assertEquals( 1992, castNumberTo( "year", Integer.class ).apply( map ) );
        Assertions.assertEquals( 1992L, castNumberTo( "year", Long.class ).apply( map ) );
        Assertions.assertEquals( 1992.0F, castNumberTo( "year", Float.class ).apply( map ) );
        Assertions.assertEquals( 1992.0, castNumberTo( "year", Double.class ).apply( map ) );
        Assertions.assertEquals( new BigInteger( "1992" ), castNumberTo( "year", BigInteger.class ).apply( map ) );
        Assertions.assertEquals( new BigDecimal( "1992" ), castNumberTo( "year", BigDecimal.class ).apply( map ) );
        Assertions.assertEquals( "1992", castNumberTo( "year", String.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> castNumberTo( "unknown", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> castNumberTo( "eyeColour", Integer.class ).apply( map ) );
        Assertions.assertThrows( UnsupportedOperationException.class, () -> castNumberTo( "year", null ).apply( map ) );
    }

    @Test
    void castNumberToWrapperTests() {
        castNumberToWrapperTests( meatball );
        castNumberToWrapperTests( mapSupplier.get() );
    }

}
