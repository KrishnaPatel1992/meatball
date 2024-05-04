package map.functions.primitives;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static map.functions.primitives.BooleanFn.*;

public class BooleanFnTest {

    private final Meatball meatball = new Meatball(
            "true", true,
            "false", false,
            "year", 1992
    );

    private final Supplier<Map<String, Object>> mapSupplier = () -> new HashMap<>( meatball );

    private void andWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> and( null, true ).test( map ) );
        Assertions.assertTrue( and( "true", true ).test( map ) );
        Assertions.assertFalse( and( "true", false ).test( map ) );
        Assertions.assertFalse( and( "false", true ).test( map ) );
        Assertions.assertFalse( and( "false", false ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> and( "maybe", true ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> and( "year", true ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> and( "true", (Boolean) null ).test( map ) );
    }

    @Test
    void andWrapperTests() {
        andWrapperTests( meatball );
        andWrapperTests( mapSupplier.get() );
    }

    private void andWithAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> and( null, "true" ).test( map ) );
        Assertions.assertTrue( and( "true", "true" ).test( map ) );
        Assertions.assertFalse( and( "true", "false" ).test( map ) );
        Assertions.assertFalse( and( "false", "true" ).test( map ) );
        Assertions.assertFalse( and( "false", "false" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> and( "maybe", "true" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> and( "year", "true" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> and( "true", (String) null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> and( "true", "maybe" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> and( "true", "year" ).test( map ) );
    }

    @Test
    void andWithAssociatedValueWrapperTests() {
        andWithAssociatedValueWrapperTests( meatball );
        andWithAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void orWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> or( null, true ).test( map ) );
        Assertions.assertTrue( or( "true", true ).test( map ) );
        Assertions.assertTrue( or( "true", false ).test( map ) );
        Assertions.assertTrue( or( "false", true ).test( map ) );
        Assertions.assertFalse( or( "false", false ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> or( "maybe", true ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> or( "year", true ).test( map ) );
        Assertions.assertTrue( or( "true", (Boolean) null ).test( map ) );
    }

    @Test
    void orWrapperTests() {
        orWrapperTests( meatball );
        orWrapperTests( mapSupplier.get() );
    }

    private void orWithAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> or( null, "true" ).test( map ) );
        Assertions.assertTrue( or( "true", "true" ).test( map ) );
        Assertions.assertTrue( or( "true", "false" ).test( map ) );
        Assertions.assertTrue( or( "false", "true" ).test( map ) );
        Assertions.assertFalse( or( "false", "false" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> or( "maybe", "true" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> or( "year", "true" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> or( "false", (String) null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> or( "false", "maybe" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> or( "false", "year" ).test( map ) );
    }

    @Test
    void orWithAssociatedValueWrapperTests() {
        orWithAssociatedValueWrapperTests( meatball );
        orWithAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void xorWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> xor( null, true ).test( map ) );
        Assertions.assertFalse( xor( "true", true ).test( map ) );
        Assertions.assertTrue( xor( "true", false ).test( map ) );
        Assertions.assertTrue( xor( "false", true ).test( map ) );
        Assertions.assertFalse( xor( "false", false ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> xor( "maybe", true ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> xor( "year", true ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> xor( "true", (Boolean) null ).test( map ) );
    }

    @Test
    void xorWrapperTests() {
        xorWrapperTests( meatball );
        xorWrapperTests( mapSupplier.get() );
    }

    private void xorWithAssociatedValueWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> xor( null, "true" ).test( map ) );
        Assertions.assertFalse( xor( "true", "true" ).test( map ) );
        Assertions.assertTrue( xor( "true", "false" ).test( map ) );
        Assertions.assertTrue( xor( "false", "true" ).test( map ) );
        Assertions.assertFalse( xor( "false", "false" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> xor( "maybe", "true" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> xor( "year", "true" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> xor( "true", (String) null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> xor( "true", "maybe" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> xor( "true", "year" ).test( map ) );
    }

    @Test
    void xorWithAssociatedValueWrapperTests() {
        xorWithAssociatedValueWrapperTests( meatball );
        xorWithAssociatedValueWrapperTests( mapSupplier.get() );
    }

    private void notWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> not( null ).test( map ) );
        Assertions.assertFalse( not( "true" ).test( map ) );
        Assertions.assertTrue( not( "false" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> not( "maybe" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> not( "year" ).test( map ) );
    }

    @Test
    void notWrapperTests() {
        notWrapperTests( meatball );
        notWrapperTests( mapSupplier.get() );
    }

}
