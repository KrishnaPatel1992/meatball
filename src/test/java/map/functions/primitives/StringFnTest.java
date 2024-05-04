package map.functions.primitives;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

import static map.functions.primitives.StringFn.*;

public class StringFnTest {

    private final Meatball meatball = new Meatball(
            "name", "Guybrush Threepwood",
            "nameFragment", "brush ",
            "surname", "Threepwood",
            "minutes", 10,
            "numCandles", 4,
            "six", 6,
            "smallLetter", "a",
            "bigLetter", "b",
            "blank", "" );

    private final Supplier<Map<String, Object>> mapSupplier = () -> new HashMap<>( meatball );

    private void indexOfSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( null, "Threepwood" ).apply( map ) );
        Assertions.assertEquals( 9, indexOfSubstr( "name", "Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "island", "Threepwood" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfSubstr( "minutes", "Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "name", null ).apply( map ) );
    }

    @Test
    void indexOfSubstrWrapperTests() {
        indexOfSubstrWrapperTests( meatball );
        indexOfSubstrWrapperTests( mapSupplier.get() );
    }

    private void indexOfAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( null, "surname" ).apply( map ) );
        Assertions.assertEquals( 9, indexOfAssociatedSubstr( "name", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "island", "surname" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfAssociatedSubstr( "minutes", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfAssociatedSubstr( "name", "minutes" ).apply( map ) );
    }

    @Test
    void indexOfAssociatedSubstrWrapperTests() {
        indexOfAssociatedSubstrWrapperTests( meatball );
        indexOfAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void indexOfSubstrWithFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( null, "Threepwood", 4 ).apply( map ) );
        Assertions.assertEquals( 9, indexOfSubstr( "name", "Threepwood", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "island", "Threepwood", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfSubstr( "minutes", "Threepwood", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "name", null, 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "name", "Threepwood", (Integer) null ).apply( map ) );
    }

    @Test
    void indexOfSubstrWithFromIndexWrapperTests() {
        indexOfSubstrWithFromIndexWrapperTests( meatball );
        indexOfSubstrWithFromIndexWrapperTests( mapSupplier.get() );
    }

    private void indexOfAssociatedSubstrWithFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( null, "surname", 4 ).apply( map ) );
        Assertions.assertEquals( 9, indexOfAssociatedSubstr( "name", "surname", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "island", "surname", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfAssociatedSubstr( "minutes", "surname", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", null, 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", "island", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfAssociatedSubstr( "name", "minutes", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", "surname", (Integer) null ).apply( map ) );
    }

    @Test
    void indexOfAssociatedSubstrWithFromIndexWrapperTests() {
        indexOfAssociatedSubstrWithFromIndexWrapperTests( meatball );
        indexOfAssociatedSubstrWithFromIndexWrapperTests( mapSupplier.get() );
    }

    private void indexOfSubstrWithFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( null, "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertEquals( 9, indexOfSubstr( "name", "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "island", "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfSubstr( "minutes", "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "name", null, "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "name", "Threepwood", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfSubstr( "name", "Threepwood", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfSubstr( "name", "Threepwood", "name" ).apply( map ) );

    }

    @Test
    void indexOfSubstrWithFromIndexKeyWrapperTests() {
        indexOfSubstrWithFromIndexKeyWrapperTests( meatball );
        indexOfSubstrWithFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void indexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( null, "surname", "numCandles" ).apply( map ) );
        Assertions.assertEquals( 9, indexOfAssociatedSubstr( "name", "surname", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "island", "surname", "numCandles" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfAssociatedSubstr( "minutes", "surname", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", null, "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", "island", "numCandles" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfAssociatedSubstr( "name", "minutes", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", "surname", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfAssociatedSubstr( "name", "surname", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfAssociatedSubstr( "name", "surname", "name" ).apply( map ) );
    }

    @Test
    void indexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests() {
        indexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests( meatball );
        indexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( null, "Threepwood" ).apply( map ) );
        Assertions.assertEquals( 9, lastIndexOfSubstr( "name", "Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "island", "Threepwood" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfSubstr( "minutes", "Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "name", null ).apply( map ) );
    }

    @Test
    void lastIndexOfSubstrWrapperTests() {
        lastIndexOfSubstrWrapperTests( meatball );
        lastIndexOfSubstrWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( null, "surname" ).apply( map ) );
        Assertions.assertEquals( 9, lastIndexOfAssociatedSubstr( "name", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "island", "surname" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfAssociatedSubstr( "minutes", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfAssociatedSubstr( "name", "minutes" ).apply( map ) );
    }

    @Test
    void lastIndexOfAssociatedSubstrWrapperTests() {
        lastIndexOfAssociatedSubstrWrapperTests( meatball );
        lastIndexOfAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfSubstrWithFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( null, "Threepwood", 4 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfSubstr( "name", "Threepwood", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "island", "Threepwood", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfSubstr( "minutes", "Threepwood", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "name", null, 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "name", "Threepwood", (Integer) null ).apply( map ) );

    }

    @Test
    void lastIndexOfSubstrWithFromIndexWrapperTests() {
        lastIndexOfSubstrWithFromIndexWrapperTests( meatball );
        lastIndexOfSubstrWithFromIndexWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfAssociatedSubstrWithFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( null, "surname", 4 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfAssociatedSubstr( "name", "surname", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "island", "surname", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfAssociatedSubstr( "minutes", "surname", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", null, 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", "island", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfAssociatedSubstr( "name", "minutes", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", "surname", (Integer) null ).apply( map ) );
    }

    @Test
    void lastIndexOfAssociatedSubstrWithFromIndexWrapperTests() {
        lastIndexOfAssociatedSubstrWithFromIndexWrapperTests( meatball );
        lastIndexOfAssociatedSubstrWithFromIndexWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfSubstrWithFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( null, "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfSubstr( "name", "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "island", "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfSubstr( "minutes", "Threepwood", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "name", null, "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "name", "Threepwood", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfSubstr( "name", "Threepwood", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfSubstr( "name", "Threepwood", "name" ).apply( map ) );
    }

    @Test
    void lastIndexOfSubstrWithFromIndexKeyWrapperTests() {
        lastIndexOfSubstrWithFromIndexKeyWrapperTests( meatball );
        lastIndexOfSubstrWithFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( null, "surname", "numCandles" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfAssociatedSubstr( "name", "surname", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "island", "surname", "numCandles" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfAssociatedSubstr( "minutes", "surname", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", null, "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", "island", "numCandles" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfAssociatedSubstr( "name", "minutes", "numCandles" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", "surname", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfAssociatedSubstr( "name", "surname", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfAssociatedSubstr( "name", "surname", "name" ).apply( map ) );
    }

    @Test
    void lastIndexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests() {
        lastIndexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests( meatball );
        lastIndexOfAssociatedSubstrWithSubstrKeyAndFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void lengthOfStringWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lengthOfString( null ).apply( map ) );
        Assertions.assertEquals( 19, lengthOfString( "name" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lengthOfString( "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lengthOfString( "minutes" ).apply( map ) );
    }

    @Test
    void lengthOfStringWrapperTests() {
        lengthOfStringWrapperTests( meatball );
        lengthOfStringWrapperTests( mapSupplier.get() );
    }

    private void substringWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> substring( null, 9 ).apply( map ) );
        Assertions.assertEquals( "Threepwood", substring( "name", 9 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "island", 9 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "minutes", 9 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "name", (Integer) null ).apply( map ) );
    }

    @Test
    void substringWrapperTests() {
        substringWrapperTests( meatball );
        substringWrapperTests( mapSupplier.get() );
    }

    private void substringWithBeginIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> substring( null, "six" ).apply( map ) );
        Assertions.assertEquals( "wood", substring( "surname", "six" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "island", "six" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "minutes", "six" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "surname", "name" ).apply( map ) );
    }

    @Test
    void substringWithBeginIndexKeyWrapperTests() {
        substringWithBeginIndexKeyWrapperTests( meatball );
        substringWithBeginIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void substringWithBeginIndexAndEndIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> substring( null, 6, 10 ).apply( map ) );
        Assertions.assertEquals( "wood", substring( "surname", 6, 10 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "island", 6, 10 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "minutes", 6, 10 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", null, 10 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", 6, null ).apply( map ) );
    }

    @Test
    void substringWithBeginIndexAndEndIndexWrapperTests() {
        substringWithBeginIndexAndEndIndexWrapperTests( meatball );
        substringWithBeginIndexAndEndIndexWrapperTests( mapSupplier.get() );
    }

    private void substringWithBeginIndexKeyAndEndIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> substring( null, "six", 10 ).apply( map ) );
        Assertions.assertEquals( "wood", substring( "surname", "six", 10 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "island", "six", 10 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "minutes", "six", 10 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", null, 10 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", "island", 10 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "surname", "name", 10 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", "six", (Integer) null ).apply( map ) );
    }

    @Test
    void substringWithBeginIndexKeyAndEndIndexWrapperTests() {
        substringWithBeginIndexKeyAndEndIndexWrapperTests( meatball );
        substringWithBeginIndexKeyAndEndIndexWrapperTests( mapSupplier.get() );
    }

    private void substringWithBeginIndexAndEndIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> substring( null, 6, "minutes" ).apply( map ) );
        Assertions.assertEquals( "wood", substring( "surname", 6, "minutes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "island", 6, "minutes" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "minutes", 6, "minutes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", null, "minutes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", 6, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", 6, "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "surname", 6, "name" ).apply( map ) );
    }

    @Test
    void substringWithBeginIndexAndEndIndexKeyWrapperTests() {
        substringWithBeginIndexAndEndIndexKeyWrapperTests( meatball );
        substringWithBeginIndexAndEndIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void substringWithBeginIndexKeyAndEndIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> substring( null, "six", "minutes" ).apply( map ) );
        Assertions.assertEquals( "wood", substring( "surname", "six", "minutes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "island", "six", "minutes" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "minutes", "six", "minutes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", null, "minutes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", "island", "minutes" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "surname", "name", "minutes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", "six", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> substring( "surname", "six", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> substring( "surname", "six", "name" ).apply( map ) );
    }

    @Test
    void substringWithBeginIndexKeyAndEndIndexKeyWrapperTests() {
        substringWithBeginIndexKeyAndEndIndexKeyWrapperTests( meatball );
        substringWithBeginIndexKeyAndEndIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void prefixUntilFirstIndexOfSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfSubstr( null, theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertEquals( "Guybrush", prefixUntilFirstIndexOfSubstr( "name", theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfSubstr( "island", theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilFirstIndexOfSubstr( "minutes", theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfSubstr( "name", (Function<Map<String, Object>, String>) null ).apply( map ) );
        Assertions.assertEquals( "", prefixUntilFirstIndexOfSubstr( "name", theMap -> " Sleepgood" ).apply( map ) );
    }

    @Test
    void prefixUntilFirstIndexOfSubstrWrapperTests() {
        prefixUntilFirstIndexOfSubstrWrapperTests( meatball );
        prefixUntilFirstIndexOfSubstrWrapperTests( mapSupplier.get() );
    }

    private void prefixUntilFirstIndexOfSubstrWithSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfSubstr( null, " Threepwood" ).apply( map ) );
        Assertions.assertEquals( "Guybrush", prefixUntilFirstIndexOfSubstr( "name", " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfSubstr( "island", " Threepwood" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilFirstIndexOfSubstr( "minutes", " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfSubstr( "name", (String) null ).apply( map ) );
    }

    @Test
    void prefixUntilFirstIndexOfSubstrWithSubstrWrapperTests() {
        prefixUntilFirstIndexOfSubstrWithSubstrWrapperTests( meatball );
        prefixUntilFirstIndexOfSubstrWithSubstrWrapperTests( mapSupplier.get() );
    }

    private void prefixUntilFirstIndexOfAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfAssociatedSubstr( null, "surname" ).apply( map ) );
        Assertions.assertEquals( "Guybrush ", prefixUntilFirstIndexOfAssociatedSubstr( "name", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfAssociatedSubstr( "island", "surname" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilFirstIndexOfAssociatedSubstr( "minutes", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfAssociatedSubstr( "name", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilFirstIndexOfAssociatedSubstr( "name", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilFirstIndexOfAssociatedSubstr( "name", "minutes" ).apply( map ) );
    }

    @Test
    void prefixUntilFirstIndexOfAssociatedSubstrWrapperTests() {
        prefixUntilFirstIndexOfAssociatedSubstrWrapperTests( meatball );
        prefixUntilFirstIndexOfAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void prefixUntilLastIndexOfSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfSubstr( null, theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertEquals( "Guybrush", prefixUntilLastIndexOfSubstr( "name", theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfSubstr( "island", theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilLastIndexOfSubstr( "minutes", theMap -> " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfSubstr( "name", (Function<Map<String, Object>, String>) null ).apply( map ) );
        Assertions.assertEquals( "", prefixUntilLastIndexOfSubstr( "name", theMap -> " Sleepgood" ).apply( map ) );
    }

    @Test
    void prefixUntilLastIndexOfSubstrWrapperTests() {
        prefixUntilLastIndexOfSubstrWrapperTests( meatball );
        prefixUntilLastIndexOfSubstrWrapperTests( mapSupplier.get() );
    }

    private void prefixUntilLastIndexOfSubstrWithSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfSubstr( null, " Threepwood" ).apply( map ) );
        Assertions.assertEquals( "Guybrush", prefixUntilLastIndexOfSubstr( "name", " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfSubstr( "island", " Threepwood" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilLastIndexOfSubstr( "minutes", " Threepwood" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfSubstr( "name", (String) null ).apply( map ) );
    }

    @Test
    void prefixUntilLastIndexOfSubstrWithSubstrWrapperTests() {
        prefixUntilLastIndexOfSubstrWithSubstrWrapperTests( meatball );
        prefixUntilLastIndexOfSubstrWithSubstrWrapperTests( mapSupplier.get() );
    }

    private void prefixUntilLastIndexOfAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfAssociatedSubstr( null, "surname" ).apply( map ) );
        Assertions.assertEquals( "Guybrush ", prefixUntilLastIndexOfAssociatedSubstr( "name", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfAssociatedSubstr( "island", "surname" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilLastIndexOfAssociatedSubstr( "minutes", "surname" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfAssociatedSubstr( "name", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> prefixUntilLastIndexOfAssociatedSubstr( "name", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> prefixUntilLastIndexOfAssociatedSubstr( "name", "minutes" ).apply( map ) );
    }

    @Test
    void prefixUntilLastIndexOfAssociatedSubstrWrapperTests() {
        prefixUntilLastIndexOfAssociatedSubstrWrapperTests( meatball );
        prefixUntilLastIndexOfAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void suffixUntilFirstIndexOfSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfSubstr( null, theMap -> "brush " ).apply( map ) );
        Assertions.assertEquals( "brush Threepwood", suffixUntilFirstIndexOfSubstr( "name", theMap -> "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfSubstr( "island", theMap -> "brush " ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilFirstIndexOfSubstr( "minutes", theMap -> "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfSubstr( "name", (Function<Map<String, Object>, String>) null ).apply( map ) );
        Assertions.assertEquals( "", suffixUntilFirstIndexOfSubstr( "name", theMap -> "Sleepgood " ).apply( map ) );

    }

    @Test
    void suffixUntilFirstIndexOfSubstrWrapperTests() {
        suffixUntilFirstIndexOfSubstrWrapperTests( meatball );
        suffixUntilFirstIndexOfSubstrWrapperTests( mapSupplier.get() );
    }

    private void suffixUntilFirstIndexOfSubstrWithSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfSubstr( null, "brush " ).apply( map ) );
        Assertions.assertEquals( "brush Threepwood", suffixUntilFirstIndexOfSubstr( "name", "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfSubstr( "island", "brush " ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilFirstIndexOfSubstr( "minutes", "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfSubstr( "name", (String) null ).apply( map ) );
    }

    @Test
    void suffixUntilFirstIndexOfSubstrWithSubstrWrapperTests() {
        suffixUntilFirstIndexOfSubstrWithSubstrWrapperTests( meatball );
        suffixUntilFirstIndexOfSubstrWithSubstrWrapperTests( mapSupplier.get() );
    }

    private void suffixUntilFirstIndexOfAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfAssociatedSubstr( null, "nameFragment" ).apply( map ) );
        Assertions.assertEquals( "brush Threepwood", suffixUntilFirstIndexOfAssociatedSubstr( "name", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfAssociatedSubstr( "island", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilFirstIndexOfAssociatedSubstr( "minutes", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfAssociatedSubstr( "name", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilFirstIndexOfAssociatedSubstr( "name", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilFirstIndexOfAssociatedSubstr( "name", "minutes" ).apply( map ) );
    }

    @Test
    void suffixUntilFirstIndexOfAssociatedSubstrWrapperTests() {
        suffixUntilFirstIndexOfAssociatedSubstrWrapperTests( meatball );
        suffixUntilFirstIndexOfAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void suffixUntilLastIndexOfSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfSubstr( null, theMap -> "brush " ).apply( map ) );
        Assertions.assertEquals( "brush Threepwood", suffixUntilLastIndexOfSubstr( "name", theMap -> "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfSubstr( "island", theMap -> "brush " ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilLastIndexOfSubstr( "minutes", theMap -> "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfSubstr( "name", (Function<Map<String, Object>, String>) null ).apply( map ) );
        Assertions.assertEquals( "", suffixUntilLastIndexOfSubstr( "name", theMap -> "Sleepgood " ).apply( map ) );
    }

    @Test
    void suffixUntilLastIndexOfSubstrWrapperTests() {
        suffixUntilLastIndexOfSubstrWrapperTests( meatball );
        suffixUntilLastIndexOfSubstrWrapperTests( mapSupplier.get() );
    }

    private void suffixUntilLastIndexOfSubstrWithSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfSubstr( null, "brush " ).apply( map ) );
        Assertions.assertEquals( "brush Threepwood", suffixUntilLastIndexOfSubstr( "name", "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfSubstr( "island", "brush " ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilLastIndexOfSubstr( "minutes", "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfSubstr( "name", (String) null ).apply( map ) );
    }

    @Test
    void suffixUntilLastIndexOfSubstrWithSubstrWrapperTests() {
        suffixUntilLastIndexOfSubstrWithSubstrWrapperTests( meatball );
        suffixUntilLastIndexOfSubstrWithSubstrWrapperTests( mapSupplier.get() );
    }

    private void suffixUntilLastIndexOfAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfAssociatedSubstr( null, "nameFragment" ).apply( map ) );
        Assertions.assertEquals( "brush Threepwood", suffixUntilLastIndexOfAssociatedSubstr( "name", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfAssociatedSubstr( "island", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilLastIndexOfAssociatedSubstr( "minutes", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfAssociatedSubstr( "name", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> suffixUntilLastIndexOfAssociatedSubstr( "name", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> suffixUntilLastIndexOfAssociatedSubstr( "name", "minutes" ).apply( map ) );
    }

    @Test
    void suffixUntilLastIndexOfAssociatedSubstrWrapperTests() {
        suffixUntilLastIndexOfAssociatedSubstrWrapperTests( meatball );
        suffixUntilLastIndexOfAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void startsWithSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> startsWithSubstr( null, "brush " ).test( map ) );
        Assertions.assertTrue( startsWithSubstr( "name", "Guybrush" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> startsWithSubstr( "island", "brush " ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> startsWithSubstr( "minutes", "brush " ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> startsWithSubstr( "name", null ).test( map ) );
    }

    @Test
    void startsWithSubstrWrapperTests() {
        startsWithSubstrWrapperTests( meatball );
        startsWithSubstrWrapperTests( mapSupplier.get() );
    }

    private void startsWithAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> startsWithAssociatedSubstr( null, "nameFragment" ).test( map ) );
        Assertions.assertFalse( startsWithAssociatedSubstr( "name", "nameFragment" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> startsWithAssociatedSubstr( "island", "nameFragment" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> startsWithAssociatedSubstr( "minutes", "nameFragment" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> startsWithAssociatedSubstr( "name", null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> startsWithAssociatedSubstr( "name", "island" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> startsWithAssociatedSubstr( "name", "minutes" ).test( map ) );
    }

    @Test
    void startsWithAssociatedSubstrWrapperTests() {
        startsWithAssociatedSubstrWrapperTests( meatball );
        startsWithAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void endsWithSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> endsWithSubstr( null, "brush " ).test( map ) );
        Assertions.assertTrue( endsWithSubstr( "name", "Threepwood" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> endsWithSubstr( "island", "brush " ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> endsWithSubstr( "minutes", "brush " ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> endsWithSubstr( "name", null ).test( map ) );
    }

    @Test
    void endsWithSubstrWrapperTests() {
        endsWithSubstrWrapperTests( meatball );
        endsWithSubstrWrapperTests( mapSupplier.get() );
    }

    private void endsWithAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> endsWithAssociatedSubstr( null, "nameFragment" ).test( map ) );
        Assertions.assertTrue( endsWithAssociatedSubstr( "name", "surname" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> endsWithAssociatedSubstr( "island", "nameFragment" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> endsWithAssociatedSubstr( "minutes", "nameFragment" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> endsWithAssociatedSubstr( "name", null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> endsWithAssociatedSubstr( "name", "island" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> endsWithAssociatedSubstr( "name", "minutes" ).test( map ) );
    }

    @Test
    void endsWithAssociatedSubstrWrapperTests() {
        endsWithAssociatedSubstrWrapperTests( meatball );
        endsWithAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void containsSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> containsSubstr( null, "brush " ).test( map ) );
        Assertions.assertTrue( containsSubstr( "name", "Threepwood" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsSubstr( "island", "brush " ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> containsSubstr( "minutes", "brush " ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsSubstr( "name", null ).test( map ) );
    }

    @Test
    void containsSubstrWrapperTests() {
        containsSubstrWrapperTests( meatball );
        containsSubstrWrapperTests( mapSupplier.get() );
    }

    private void containsAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> containsAssociatedSubstr( null, "nameFragment" ).test( map ) );
        Assertions.assertTrue( containsAssociatedSubstr( "name", "surname" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAssociatedSubstr( "island", "nameFragment" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> containsAssociatedSubstr( "minutes", "nameFragment" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAssociatedSubstr( "name", null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAssociatedSubstr( "name", "island" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> containsAssociatedSubstr( "name", "minutes" ).test( map ) );
    }

    @Test
    void containsAssociatedSubstrWrapperTests() {
        containsAssociatedSubstrWrapperTests( meatball );
        containsAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void compareToSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> compareToSubstr( null, "brush " ).apply( map ) );
        Assertions.assertEquals( -1, compareToSubstr( "smallLetter", "b" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> compareToSubstr( "island", "brush " ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> compareToSubstr( "minutes", "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> compareToSubstr( "smallLetter", null ).apply( map ) );
    }

    @Test
    void compareToSubstrWrapperTests() {
        compareToSubstrWrapperTests( meatball );
        compareToSubstrWrapperTests( mapSupplier.get() );
    }

    private void compareToAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> compareToAssociatedSubstr( null, "nameFragment" ).apply( map ) );
        Assertions.assertEquals( -1, compareToAssociatedSubstr( "smallLetter", "bigLetter" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> compareToAssociatedSubstr( "island", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> compareToAssociatedSubstr( "minutes", "nameFragment" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> compareToAssociatedSubstr( "name", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> compareToAssociatedSubstr( "name", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> compareToAssociatedSubstr( "name", "minutes" ).apply( map ) );
    }

    @Test
    void compareToAssociatedSubstrWrapperTests() {
        compareToAssociatedSubstrWrapperTests( meatball );
        compareToAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void matchesRegexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> matchesRegex( null, "brush " ).test( map ) );
        Assertions.assertTrue( matchesRegex( "surname", "([A-Z])\\w+" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> matchesRegex( "island", "brush " ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> matchesRegex( "minutes", "brush " ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> matchesRegex( "smallLetter", null ).test( map ) );
    }

    @Test
    void matchesRegexWrapperTests() {
        matchesRegexWrapperTests( meatball );
        matchesRegexWrapperTests( mapSupplier.get() );
    }

    private void concatenateWithWrapperTests( Map<String, Object> map ) {
        Assertions.assertEquals( "b", concatenateWith( null, "b" ).apply( map ) );
        Assertions.assertEquals( "ab", concatenateWith( "smallLetter", "b" ).apply( map ) );
        Assertions.assertEquals( "b", concatenateWith( "island", "b" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> concatenateWith( "minutes", "b" ).apply( map ) );
        Assertions.assertEquals( "a", concatenateWith( "smallLetter", null ).apply( map ) );
    }

    @Test
    void concatenateWithWrapperTests() {
        concatenateWithWrapperTests( meatball );
        concatenateWithWrapperTests( mapSupplier.get() );
    }

    private void concatenateWithWithDelimiterWrapperTests( Map<String, Object> map ) {
        Assertions.assertEquals( ",b", concatenateWith( null, "b", "," ).apply( map ) );
        Assertions.assertEquals( "a,b", concatenateWith( "smallLetter", "b", "," ).apply( map ) );
        Assertions.assertEquals( ",b", concatenateWith( "island", "b", "," ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> concatenateWith( "minutes", "b", "," ).apply( map ) );
        Assertions.assertEquals( "a,", concatenateWith( "smallLetter", null, "," ).apply( map ) );
        Assertions.assertEquals( "ab", concatenateWith( "smallLetter", "b", null ).apply( map ) );
    }

    @Test
    void concatenateWithWithDelimiterWrapperTests() {
        concatenateWithWithDelimiterWrapperTests( meatball );
        concatenateWithWithDelimiterWrapperTests( mapSupplier.get() );
    }

    private void concatenateWithAssociatedWrapperTests( Map<String, Object> map ) {
        Assertions.assertEquals( "b", concatenateWithAssociated( null, "bigLetter" ).apply( map ) );
        Assertions.assertEquals( "ab", concatenateWithAssociated( "smallLetter", "bigLetter" ).apply( map ) );
        Assertions.assertEquals( "b", concatenateWithAssociated( "island", "bigLetter" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> concatenateWithAssociated( "minutes", "bigLetter" ).apply( map ) );
        Assertions.assertEquals( "a", concatenateWithAssociated( "smallLetter", null ).apply( map ) );
        Assertions.assertEquals( "a", concatenateWithAssociated( "smallLetter", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> concatenateWithAssociated( "smallLetter", "minutes" ).apply( map ) );
    }

    @Test
    void concatenateWithAssociatedWrapperTests() {
        concatenateWithAssociatedWrapperTests( meatball );
        concatenateWithAssociatedWrapperTests( mapSupplier.get() );
    }

    private void concatenateWithAssociatedWithDelimiterWrapperTests( Map<String, Object> map ) {
        Assertions.assertEquals( ",b", concatenateWithAssociated( null, "bigLetter", "," ).apply( map ) );
        Assertions.assertEquals( "a,b", concatenateWithAssociated( "smallLetter", "bigLetter", "," ).apply( map ) );
        Assertions.assertEquals( ",b", concatenateWithAssociated( "island", "bigLetter", "," ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> concatenateWithAssociated( "minutes", "bigLetter", "," ).apply( map ) );
        Assertions.assertEquals( "a,", concatenateWithAssociated( "smallLetter", null, "," ).apply( map ) );
        Assertions.assertEquals( "a,", concatenateWithAssociated( "smallLetter", "island", "," ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> concatenateWithAssociated( "smallLetter", "minutes", "," ).apply( map ) );
        Assertions.assertEquals( "ab", concatenateWithAssociated( "smallLetter", "bigLetter", null ).apply( map ) );
    }

    @Test
    void concatenateWithAssociatedWithDelimiterWrapperTests() {
        concatenateWithAssociatedWithDelimiterWrapperTests( meatball );
        concatenateWithAssociatedWithDelimiterWrapperTests( mapSupplier.get() );
    }

    private void splitWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> split( null, "brush " ).apply( map ) );
        Assertions.assertEquals( List.of( "Guybrush", "Threepwood" ), split( "name", " " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> split( "island", "brush " ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> split( "minutes", "brush " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> split( "smallLetter", null ).apply( map ) );
    }

    @Test
    void splitWrapperTests() {
        splitWrapperTests( meatball );
        splitWrapperTests( mapSupplier.get() );
    }

    private void tokenizeWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> tokenize( null, " " ).apply( map ) );
        Assertions.assertEquals( List.of( "Guybrush", "Threepwood" ), tokenize( "name", " " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> tokenize( "island", " " ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> tokenize( "minutes", " " ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> tokenize( "name", null ).apply( map ) );
    }

    @Test
    void tokenizeWrapperTests() {
        tokenizeWrapperTests( meatball );
        tokenizeWrapperTests( mapSupplier.get() );
    }

    private void tokenizeSupportsStringsOfVaryingLengths( Map<String, Object> map ) {
        Assertions.assertEquals( List.of(), tokenize( "blank", "," ).apply( map ) );
        Assertions.assertEquals( List.of(), tokenize( "smallLetter", "a" ).apply( map ) );
        Assertions.assertEquals( List.of( "a" ), tokenize( "smallLetter", " " ).apply( map ) );
        Assertions.assertEquals( List.of( "Guybrush Threepwood" ), tokenize( "name", "x" ).apply( map ) );
    }

    @Test
    void tokenizeSupportsStringsOfVaryingLengths() {
        tokenizeSupportsStringsOfVaryingLengths( meatball );
        tokenizeSupportsStringsOfVaryingLengths( mapSupplier.get() );
    }

    private void trimWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> trim( null ).apply( map ) );
        Assertions.assertEquals( "brush", trim( "nameFragment" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> trim( "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> trim( "minutes" ).apply( map ) );
    }

    @Test
    void trimWrapperTests() {
        trimWrapperTests( meatball );
        trimWrapperTests( mapSupplier.get() );
    }

    private void stripWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> strip( null ).apply( map ) );
        Assertions.assertEquals( "brush", strip( "nameFragment" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> strip( "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> strip( "minutes" ).apply( map ) );
    }

    @Test
    void stripWrapperTests() {
        stripWrapperTests( meatball );
        stripWrapperTests( mapSupplier.get() );
    }

    private void toLowerCaseWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> toLowerCase( null ).apply( map ) );
        Assertions.assertEquals( "guybrush threepwood", toLowerCase( "name" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> toLowerCase( "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> toLowerCase( "minutes" ).apply( map ) );
    }

    @Test
    void toLowerCaseWrapperTests() {
        toLowerCaseWrapperTests( meatball );
        toLowerCaseWrapperTests( mapSupplier.get() );
    }

    private void toUpperCaseWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> toUpperCase( null ).apply( map ) );
        Assertions.assertEquals( "GUYBRUSH THREEPWOOD", toUpperCase( "name" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> toUpperCase( "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> toUpperCase( "minutes" ).apply( map ) );
    }

    @Test
    void toUpperCaseWrapperTests() {
        toUpperCaseWrapperTests( meatball );
        toUpperCaseWrapperTests( mapSupplier.get() );
    }

    private void replaceAllWithSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithSubstr( null, "Threep", "Sleep" ).apply( map ) );
        Assertions.assertEquals( "Guybrush Sleepwood", replaceAllWithSubstr( "name", "Threep", "Sleep" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithSubstr( "island", "Threep", "Sleep" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> replaceAllWithSubstr( "minutes", "Threep", "Sleep" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithSubstr( "name", null, "Sleep" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithSubstr( "name", "Threep", null ).apply( map ) );
    }

    @Test
    void replaceAllWithSubstrWrapperTests() {
        replaceAllWithSubstrWrapperTests( meatball );
        replaceAllWithSubstrWrapperTests( mapSupplier.get() );
    }

    private void replaceAllWithAssociatedSubstrWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithAssociatedSubstr( null, "u", "smallLetter" ).apply( map ) );
        Assertions.assertEquals( "brash ", replaceAllWithAssociatedSubstr( "nameFragment", "u", "smallLetter" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithAssociatedSubstr( "island", "u", "smallLetter" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> replaceAllWithAssociatedSubstr( "minutes", "u", "smallLetter" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithAssociatedSubstr( "nameFragment", null, "smallLetter" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithAssociatedSubstr( "nameFragment", "u", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> replaceAllWithAssociatedSubstr( "nameFragment", "u", "island" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> replaceAllWithAssociatedSubstr( "nameFragment", "u", "minutes" ).apply( map ) );
    }

    @Test
    void replaceAllWithAssociatedSubstrWrapperTests() {
        replaceAllWithAssociatedSubstrWrapperTests( meatball );
        replaceAllWithAssociatedSubstrWrapperTests( mapSupplier.get() );
    }

    private void castStringToWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NumberFormatException.class, () -> castStringTo( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( 10, castStringTo( "minutes", Integer.class ).apply( map ) );
        Assertions.assertThrows( NumberFormatException.class, () -> castStringTo( "island", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> castStringTo( "canHoldBreath", Integer.class ).apply( map ) );
        Assertions.assertThrows( UnsupportedOperationException.class, () -> castStringTo( "minutes", null ).apply( map ) );
    }

    @Test
    void castStringToWrapperTests() {
        final var meatball = new Meatball( "minutes", "10", "canHoldBreath", true );
        final var hashmap = new HashMap<>( meatball );

        castStringToWrapperTests( meatball );
        castStringToWrapperTests( hashmap );
    }

    private void castStringToWithSupportedClassesCastsSuccessfully( Map<String, Object> map ) {
        Assertions.assertEquals( (short) 10, castStringTo( "wholeNumber", Short.class ).apply( map ) );
        Assertions.assertEquals( 10, castStringTo( "wholeNumber", Integer.class ).apply( map ) );
        Assertions.assertEquals( 10L, castStringTo( "wholeNumber", Long.class ).apply( map ) );
        Assertions.assertEquals( 10.5F, castStringTo( "decimalNumber", Float.class ).apply( map ) );
        Assertions.assertEquals( 10.5, castStringTo( "decimalNumber", Double.class ).apply( map ) );
        Assertions.assertEquals( true, castStringTo( "boolean", Boolean.class ).apply( map ) );
        Assertions.assertEquals( new BigInteger( "10" ), castStringTo( "wholeNumber", BigInteger.class ).apply( map ) );
        Assertions.assertEquals( new BigDecimal( "10.5" ), castStringTo( "decimalNumber", BigDecimal.class ).apply( map ) );
        Assertions.assertEquals( "10.5", castStringTo( "decimalNumber", String.class ).apply( map ) );

        var characters = castStringTo( "wholeNumber", char[].class ).apply( map );
        Assertions.assertEquals( 2, characters.length );
        Assertions.assertEquals( '1', characters[0] );
        Assertions.assertEquals( '0', characters[1] );

        Assertions.assertEquals( "1", new String( castStringTo( "digit", byte[].class ).apply( map ) ) );
    }

    @Test
    void castStringToWithSupportedClassesCastsSuccessfully() {
        final var meatball = new Meatball(
                "wholeNumber", "10",
                "decimalNumber", "10.5",
                "boolean", "true",
                "digit", "1"
        );

        final var hashmap = new HashMap<>( meatball );

        castStringToWithSupportedClassesCastsSuccessfully( meatball );
        castStringToWithSupportedClassesCastsSuccessfully( hashmap );
    }

    @Test
    void castStringToWithUnsupportedClassThrowsUnsupportedOperationException() {
        Assertions.assertThrows( UnsupportedOperationException.class, () -> castStringTo( "minutes", Random.class ).apply( mapSupplier.get() ) );
    }

}
