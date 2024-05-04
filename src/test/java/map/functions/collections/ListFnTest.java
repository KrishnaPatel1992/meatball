package map.functions.collections;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;

import static map.functions.collections.ListFn.*;

public class ListFnTest {

    private final Meatball meatball = new Meatball(
            "list", new ArrayList<>( List.of( 1, 2, 3, 4, 5, 6 ) ),
            "array", new Integer[]{ 1, 2, 3, 4, 5, 6 },
            "numbers", new ArrayList<>( List.of( 4 ) ),
            "set", new HashSet<>( Set.of( 1, 2, 3, 4, 5, 6 ) ),
            "strings", List.of( "text" ),
            "sixes", List.of( 6 ),
            "number", 4,
            "two", 2,
            "six", 6,
            "five", 5,
            "string", "text" );

    private final Supplier<Map<String, Object>> mapSupplier = () -> new HashMap<>( meatball );

    private final Supplier<List<Integer>> listWithNullSupplier = () -> {
        final var list = new ArrayList<>( List.of( 1, 2, 3, 4, 5, 6 ) );
        list.add( null );
        return list;
    };

    private final Supplier<List<Integer>> smallListWithNullSupplier = () -> {
        final var list = new ArrayList<>( List.of( 1, 2, 3, 4, 5 ) );
        list.add( null );
        return list;
    };

    void indexOfElementWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( null, 4 ).apply( map ) );
        Assertions.assertEquals( 3, indexOfElement( "list", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "stack", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "number", 4 ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", null ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", "hello" ).apply( map ) );
    }

    @Test
    void indexOfElementWrapperTests() {
        indexOfElementWrapperTests( meatball );
        indexOfElementWrapperTests( mapSupplier.get() );
    }

    void indexOfElementWithElementKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( null, Integer.class, "number" ).apply( map ) );
        Assertions.assertEquals( 3, indexOfElement( "list", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "stack", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "number", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", null, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "list", String.class, "number" ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", Integer.class, null ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", String.class, "string" ).apply( map ) );
    }

    @Test
    void indexOfElementWithElementKeyWrapperTests() {
        indexOfElementWithElementKeyWrapperTests( meatball );
        indexOfElementWithElementKeyWrapperTests( mapSupplier.get() );
    }

    void indexOfElementWithFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( null, 4, 2 ).apply( map ) );
        Assertions.assertEquals( 3, indexOfElement( "list", 4, 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "stack", 4, 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "number", 4, 2 ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", null, 2 ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", "string", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", 4, (Integer) null ).apply( map ) );

    }

    @Test
    void indexOfElementWithFromIndexWrapperTests() {
        indexOfElementWithFromIndexWrapperTests( meatball );
        indexOfElementWithFromIndexWrapperTests( mapSupplier.get() );
    }

    private void indexOfElementWithElementKeyAndFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( null, Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertEquals( 3, indexOfElement( "list", Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "stack", Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "number", Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", null, "number", 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "list", String.class, "number", 2 ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", Integer.class, null, 2 ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", Integer.class, "num", 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "list", Integer.class, "string", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", Integer.class, "number", (Integer) null ).apply( map ) );
    }

    @Test
    void indexOfElementWithElementKeyAndFromIndexWrapperTests() {
        indexOfElementWithElementKeyAndFromIndexWrapperTests( meatball );
        indexOfElementWithElementKeyAndFromIndexWrapperTests( mapSupplier.get() );
    }

    private void indexOfElementWithFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( null, 5, "number" ).apply( map ) );
        Assertions.assertEquals( 4, indexOfElement( "list", 5, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "stack", 5, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "number", 5, "number" ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", (Integer) null, "number" ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", "hello", "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", 5, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", 5, "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "list", 5, "string" ).apply( map ) );
    }

    @Test
    void indexOfElementWithFromIndexKeyWrapperTests() {
        indexOfElementWithFromIndexKeyWrapperTests( meatball );
        indexOfElementWithFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void indexOfElementWithElementKeyAndFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( null, Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertEquals( 3, indexOfElement( "list", Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "stack", Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "number", Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", null, "number", "two" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "list", String.class, "number", "two" ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", Integer.class, null, "two" ).apply( map ) );
        Assertions.assertEquals( -1, indexOfElement( "list", Integer.class, "num", "two" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "list", Integer.class, "string", "two" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", Integer.class, "number", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> indexOfElement( "list", Integer.class, "number", "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> indexOfElement( "list", Integer.class, "number", "string" ).apply( map ) );
    }

    @Test
    void indexOfElementWithElementKeyAndFromIndexKeyWrapperTests() {
        indexOfElementWithElementKeyAndFromIndexKeyWrapperTests( meatball );
        indexOfElementWithElementKeyAndFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfElementWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( null, 4 ).apply( map ) );
        Assertions.assertEquals( 3, lastIndexOfElement( "list", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "stack", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "number", 4 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", null ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", "hello" ).apply( map ) );
    }

    @Test
    void lastIndexOfElementWrapperTests() {
        lastIndexOfElementWrapperTests( meatball );
        lastIndexOfElementWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfElementWithElementKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( null, Integer.class, "number" ).apply( map ) );
        Assertions.assertEquals( 3, lastIndexOfElement( "list", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "stack", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "number", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", null, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "list", String.class, "number" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, null ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", String.class, "string" ).apply( map ) );
    }

    @Test
    void lastIndexOfElementWithElementKeyWrapperTests() {
        lastIndexOfElementWithElementKeyWrapperTests( meatball );
        lastIndexOfElementWithElementKeyWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfElementWithFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( null, 4, 2 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", 4, 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "stack", 4, 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "number", 4, 2 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", null, 2 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", "string", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", 4, (Integer) null ).apply( map ) );
    }

    @Test
    void lastIndexOfElementWithFromIndexWrapperTests() {
        lastIndexOfElementWithFromIndexWrapperTests( meatball );
        lastIndexOfElementWithFromIndexWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfElementWithElementKeyAndFromIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( null, Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "stack", Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "number", Integer.class, "number", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", null, "number", 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "list", String.class, "number", 2 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, null, 2 ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, "num", 2 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "list", Integer.class, "string", 2 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", Integer.class, "number", (Integer) null ).apply( map ) );
    }

    @Test
    void lastIndexOfElementWithElementKeyAndFromIndexWrapperTests() {
        lastIndexOfElementWithElementKeyAndFromIndexWrapperTests( meatball );
        lastIndexOfElementWithElementKeyAndFromIndexWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfElementWithFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( null, 5, "number" ).apply( map ) );
        Assertions.assertEquals( 4, lastIndexOfElement( "list", 5, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "stack", 5, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "number", 5, "number" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", (Integer) null, "number" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", "hello", "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", 5, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", 5, "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "list", 5, "string" ).apply( map ) );

    }

    @Test
    void lastIndexOfElementWithFromIndexKeyWrapperTests() {
        lastIndexOfElementWithFromIndexKeyWrapperTests( meatball );
        lastIndexOfElementWithFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void lastIndexOfElementWithElementKeyAndFromIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( null, Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "stack", Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "number", Integer.class, "number", "two" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", null, "number", "two" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "list", String.class, "number", "two" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, null, "two" ).apply( map ) );
        Assertions.assertEquals( -1, lastIndexOfElement( "list", Integer.class, "num", "two" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "list", Integer.class, "string", "two" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", Integer.class, "number", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOfElement( "list", Integer.class, "number", "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> lastIndexOfElement( "list", Integer.class, "number", "string" ).apply( map ) );
    }

    @Test
    void lastIndexOfElementWithElementKeyAndFromIndexKeyWrapperTests() {
        lastIndexOfElementWithElementKeyAndFromIndexKeyWrapperTests( meatball );
        lastIndexOfElementWithElementKeyAndFromIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void binarySearchListWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( null, 4 ).apply( map ) );
        Assertions.assertEquals( 3, binarySearchList( "list", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( "stack", 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> binarySearchList( "number", 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( "list", null ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> binarySearchList( "list", "hello" ).apply( map ) );
    }

    @Test
    void binarySearchListWrapperTests() {
        binarySearchListWrapperTests( meatball );
        binarySearchListWrapperTests( mapSupplier.get() );
    }

    private void binarySearchListWithElementKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( null, Integer.class, "number" ).apply( map ) );
        Assertions.assertEquals( 3, binarySearchList( "list", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( "stack", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> binarySearchList( "number", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( "list", null, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> binarySearchList( "list", String.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( "list", Integer.class, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> binarySearchList( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> binarySearchList( "list", String.class, "string" ).apply( map ) );
    }

    @Test
    void binarySearchListWithElementKeyWrapperTests() {
        binarySearchListWithElementKeyWrapperTests( meatball );
        binarySearchListWithElementKeyWrapperTests( mapSupplier.get() );
    }

    private void getFromListWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> getFromList( null, Integer.class, 3 ).apply( map ) );
        Assertions.assertEquals( 4, getFromList( "list", Integer.class, 3 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> getFromList( "stack", Integer.class, 3 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> getFromList( "number", Integer.class, 3 ).apply( map ) );
        Assertions.assertEquals( 4, getFromList( "list", null, 3 ).apply( map ) );
        Assertions.assertEquals( 4, getFromList( "list", String.class, 3 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> getFromList( "list", Integer.class, (Integer) null ).apply( map ) );
    }

    @Test
    void getFromListWrapperTests() {
        getFromListWrapperTests( meatball );
        getFromListWrapperTests( mapSupplier.get() );
    }

    private void getFromListWithElementIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> getFromList( null, Integer.class, "number" ).apply( map ) );
        Assertions.assertEquals( 5, getFromList( "list", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> getFromList( "stack", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> getFromList( "number", Integer.class, "number" ).apply( map ) );
        Assertions.assertEquals( 5, getFromList( "list", null, "number" ).apply( map ) );
        Assertions.assertEquals( 5, getFromList( "list", String.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> getFromList( "list", Integer.class, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> getFromList( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> getFromList( "list", String.class, "string" ).apply( map ) );
    }

    @Test
    void getFromListWithElementIndexKeyWrapperTests() {
        getFromListWithElementIndexKeyWrapperTests( meatball );
        getFromListWithElementIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void sublistWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> sublist( null, Integer.class, 3 ).apply( map ) );
        Assertions.assertEquals( List.of( 4, 5, 6 ), sublist( "list", Integer.class, 3 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "stack", Integer.class, 3 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "number", Integer.class, 3 ).apply( map ) );
        Assertions.assertEquals( List.of( 4, 5, 6 ), sublist( "list", null, 3 ).apply( map ) );
        Assertions.assertEquals( List.of( 4, 5, 6 ), sublist( "list", String.class, 3 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, (Integer) null ).apply( map ) );
    }

    @Test
    void sublistWrapperTests() {
        sublistWrapperTests( meatball );
        sublistWrapperTests( mapSupplier.get() );
    }

    private void sublistWithElementKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> sublist( null, Integer.class, "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 5, 6 ), sublist( "list", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "stack", Integer.class, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "number", Integer.class, "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 5, 6 ), sublist( "list", null, "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 5, 6 ), sublist( "list", String.class, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "list", String.class, "string" ).apply( map ) );
    }

    @Test
    void sublistWithElementKeyWrapperTests() {
        sublistWithElementKeyWrapperTests( meatball );
        sublistWithElementKeyWrapperTests( mapSupplier.get() );
    }

    private void sublistWithBothIndexesWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> sublist( null, Integer.class, 2, 4 ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", Integer.class, 2, 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "stack", Integer.class, 2, 4 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "number", Integer.class, 2, 4 ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", null, 2, 4 ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", String.class, 2, 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, (Integer) null, 4 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, 2, (Integer) null ).apply( map ) );
    }

    @Test
    void sublistWithBothIndexesWrapperTests() {
        sublistWithBothIndexesWrapperTests( meatball );
        sublistWithBothIndexesWrapperTests( mapSupplier.get() );
    }

    private void sublistWithBeginIndexKeyAndEndIndexWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> sublist( null, Integer.class, "number", 5 ).apply( map ) );
        Assertions.assertEquals( List.of( 5 ), sublist( "list", Integer.class, "number", 5 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "stack", Integer.class, "number", 5 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "number", Integer.class, "number", 5 ).apply( map ) );
        Assertions.assertEquals( List.of( 5 ), sublist( "list", null, "number", 5 ).apply( map ) );
        Assertions.assertEquals( List.of( 5 ), sublist( "list", String.class, "number", 5 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, null, 5 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, "num", 5 ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "list", Integer.class, "string", 5 ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, "number", (Integer) null ).apply( map ) );
    }

    @Test
    void sublistWithBeginIndexKeyAndEndIndexWrapperTests() {
        sublistWithBeginIndexKeyAndEndIndexWrapperTests( meatball );
        sublistWithBeginIndexKeyAndEndIndexWrapperTests( mapSupplier.get() );
    }

    private void sublistWithBeginIndexAndEndIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> sublist( null, Integer.class, 2, "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", Integer.class, 2, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "stack", Integer.class, 2, "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "number", Integer.class, 2, "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", null, 2, "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", String.class, 2, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, (Integer) null, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, 2, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, 2, "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "list", Integer.class, 2, "list" ).apply( map ) );
    }

    @Test
    void sublistWithBeginIndexAndEndIndexKeyWrapperTests() {
        sublistWithBeginIndexAndEndIndexKeyWrapperTests( meatball );
        sublistWithBeginIndexAndEndIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void sublistWithBeginIndexKeyAndEndIndexKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> sublist( null, Integer.class, "two", "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", Integer.class, "two", "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "stack", Integer.class, "two", "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "number", Integer.class, "two", "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", null, "two", "number" ).apply( map ) );
        Assertions.assertEquals( List.of( 3, 4 ), sublist( "list", String.class, "two", "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, null, "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, "num", "number" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "list", Integer.class, "string", "number" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, "two", null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> sublist( "list", Integer.class, "two", "num" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> sublist( "list", Integer.class, "two", "string" ).apply( map ) );
    }

    @Test
    void sublistWithBeginIndexKeyAndEndIndexKeyWrapperTests() {
        sublistWithBeginIndexKeyAndEndIndexKeyWrapperTests( meatball );
        sublistWithBeginIndexKeyAndEndIndexKeyWrapperTests( mapSupplier.get() );
    }

    private void addToListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToList( null, 4 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addToList( "list", 4 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "stack", 4 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "number", 4 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "hello" ), addToList( "list", "hello" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addToListWrapperTests() {
        addToListWrapperTests( () -> meatball );
        addToListWrapperTests( mapSupplier );
    }

    private void addToListWithElementKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToList( null, Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addToList( "list", Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "stack", Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "number", Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", null, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "list", String.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "text" ), addToList( "list", String.class, "string" ).apply( mapSupplier.get() ) );

    }

    @Test
    void addToListWithElementKeyWrapperTests() {
        addToListWithElementKeyWrapperTests( () -> meatball );
        addToListWithElementKeyWrapperTests( mapSupplier );
    }

    private void addToListWithInsertionIndexWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToList( null, 4, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addToList( "list", 4, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "stack", 4, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "number", 4, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", null, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "string" ), addToList( "list", "string", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", 4, (Integer) null ).apply( mapSupplier.get() ) );
    }

    @Test
    void addToListWithInsertionIndexWrapperTests() {
        addToListWithInsertionIndexWrapperTests( () -> meatball );
        addToListWithInsertionIndexWrapperTests( mapSupplier );
    }

    private void addToListWithElementKeyAndInsertionIndexWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToList( null, Integer.class, "number", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addToList( "list", Integer.class, "number", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "stack", Integer.class, "number", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "number", Integer.class, "number", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", null, "number", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "list", String.class, "number", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", Integer.class, null, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", Integer.class, "num", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "list", Integer.class, "string", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", Integer.class, "number", (Integer) null ).apply( mapSupplier.get() ) );
    }

    @Test
    void addToListWithElementKeyAndInsertionIndexWrapperTests() {
        addToListWithElementKeyAndInsertionIndexWrapperTests( () -> meatball );
        addToListWithElementKeyAndInsertionIndexWrapperTests( mapSupplier );
    }

    private void addToListWithInsertionIndexKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToList( null, 4, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addToList( "list", 4, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "stack", 4, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "number", 4, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", (Integer) null, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "hello" ), addToList( "list", "hello", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", 4, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", 4, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "list", 4, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addToListWithInsertionIndexKeyWrapperTests() {
        addToListWithInsertionIndexKeyWrapperTests( () -> meatball );
        addToListWithInsertionIndexKeyWrapperTests( mapSupplier );
    }

    private void addToListWithElementKeyAndInsertionIndexKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToList( null, Integer.class, "number", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addToList( "list", Integer.class, "number", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "stack", Integer.class, "number", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "number", Integer.class, "number", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", null, "number", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "list", String.class, "number", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", Integer.class, null, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( listWithNullSupplier.get(), addToList( "list", Integer.class, "num", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "text" ), addToList( "list", String.class, "string", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", Integer.class, "number", null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToList( "list", Integer.class, "number", "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToList( "list", Integer.class, "number", "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addToListWithElementKeyAndInsertionIndexKeyWrapperTests() {
        addToListWithElementKeyAndInsertionIndexKeyWrapperTests( () -> meatball );
        addToListWithElementKeyAndInsertionIndexKeyWrapperTests( mapSupplier );
    }

    private void addAllToListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( null, List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "stack", List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "number", List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "hello" ), addAllToList( "list", List.of( "hello" ) ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToListWrapperTests() {
        addAllToListWrapperTests( () -> meatball );
        addAllToListWrapperTests( mapSupplier );
    }

    private void addAllToListWithElementsKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( null, Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "stack", Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "number", Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", (Class) null, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", String.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "text" ), addAllToList( "list", String.class, "strings" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToListWithElementsKeyWrapperTests() {
        addAllToListWithElementsKeyWrapperTests( () -> meatball );
        addAllToListWithElementsKeyWrapperTests( mapSupplier );
    }

    private void addAllToListWithInsertionIndexWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( null, List.of( 4 ), 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", List.of( 4 ), 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "stack", List.of( 4 ), 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "number", List.of( 4 ), 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", null, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "string" ), addAllToList( "list", List.of( "string" ), 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", List.of( 4 ), (Integer) null ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToListWithInsertionIndexWrapperTests() {
        addAllToListWithInsertionIndexWrapperTests( () -> meatball );
        addAllToListWithInsertionIndexWrapperTests( mapSupplier );
    }

    private void addAllToListWithElementKeyAndInsertionIndexWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( null, Integer.class, "numbers", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", Integer.class, "numbers", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "stack", Integer.class, "numbers", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "number", Integer.class, "numbers", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", null, "numbers", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", String.class, "numbers", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, null, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, "num", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "list", Integer.class, "string", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, "numbers", (Integer) null ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToListWithElementKeyAndInsertionIndexWrapperTests() {
        addAllToListWithElementKeyAndInsertionIndexWrapperTests( () -> meatball );
        addAllToListWithElementKeyAndInsertionIndexWrapperTests( mapSupplier );
    }

    private void addAllToListWithInsertionIndexKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( null, List.of( 4 ), "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", List.of( 4 ), "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "stack", List.of( 4 ), "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "number", List.of( 4 ), "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", (List<Integer>) null, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "hello" ), addAllToList( "list", List.of( "hello" ), "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", List.of( 4 ), null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", List.of( 4 ), "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "list", List.of( 4 ), "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToListWithInsertionIndexKeyWrapperTests() {
        addAllToListWithInsertionIndexKeyWrapperTests( () -> meatball );
        addAllToListWithInsertionIndexKeyWrapperTests( mapSupplier );
    }

    private void addAllToListWithElementsKeyAndInsertionIndexKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( null, Integer.class, "numbers", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", Integer.class, "numbers", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "stack", Integer.class, "numbers", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "number", Integer.class, "numbers", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", null, "numbers", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, 4 ), addAllToList( "list", String.class, "numbers", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, null, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, "num", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "text" ), addAllToList( "list", String.class, "strings", "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, "numbers", null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToList( "list", Integer.class, "numbers", "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToList( "list", Integer.class, "numbers", "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToListWithElementsKeyAndInsertionIndexKeyWrapperTests() {
        addAllToListWithElementsKeyAndInsertionIndexKeyWrapperTests( () -> meatball );
        addAllToListWithElementsKeyAndInsertionIndexKeyWrapperTests( mapSupplier );
    }

    private void setListIndexWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( null, 4, 5 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 4 ), setListIndex( "list", 4, 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "stack", 4, 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "number", 4, 5 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( smallListWithNullSupplier.get(), setListIndex( "list", null, 5 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, "string" ), setListIndex( "list", "string", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", 4, (Integer) null ).apply( mapSupplier.get() ) );
    }

    @Test
    void setListIndexWrapperTests() {
        setListIndexWrapperTests( () -> meatball );
        setListIndexWrapperTests( mapSupplier );
    }

    private void setListIndexWithElementKeyAndInsertionIndexWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( null, Integer.class, "number", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 4 ), setListIndex( "list", Integer.class, "number", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "stack", Integer.class, "number", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "number", Integer.class, "number", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", null, "number", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "list", String.class, "number", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( smallListWithNullSupplier.get(), setListIndex( "list", Integer.class, null, 5 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( smallListWithNullSupplier.get(), setListIndex( "list", Integer.class, "num", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "list", Integer.class, "string", 5 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", Integer.class, "number", (Integer) null ).apply( mapSupplier.get() ) );
    }

    @Test
    void setListIndexWithElementKeyAndInsertionIndexWrapperTests() {
        setListIndexWithElementKeyAndInsertionIndexWrapperTests( () -> meatball );
        setListIndexWithElementKeyAndInsertionIndexWrapperTests( mapSupplier );
    }

    private void setListIndexWithInsertionIndexKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( null, 4, "five" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 4 ), setListIndex( "list", 4, "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "stack", 4, "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "number", 4, "five" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( smallListWithNullSupplier.get(), setListIndex( "list", (Integer) null, "five" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, "hello" ), setListIndex( "list", "hello", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", 4, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", 4, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "list", 4, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void setListIndexWithInsertionIndexKeyWrapperTests() {
        setListIndexWithInsertionIndexKeyWrapperTests( () -> meatball );
        setListIndexWithInsertionIndexKeyWrapperTests( mapSupplier );
    }

    private void setListIndexWithElementKeyAndInsertionIndexKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( null, Integer.class, "number", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 4 ), setListIndex( "list", Integer.class, "number", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "stack", Integer.class, "number", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "number", Integer.class, "number", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", null, "number", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "list", String.class, "number", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( smallListWithNullSupplier.get(), setListIndex( "list", Integer.class, null, "five" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( smallListWithNullSupplier.get(), setListIndex( "list", Integer.class, "num", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, "text" ), setListIndex( "list", String.class, "string", "five" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", Integer.class, "number", null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> setListIndex( "list", Integer.class, "number", "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> setListIndex( "list", Integer.class, "number", "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void setListIndexWithElementKeyAndInsertionIndexKeyWrapperTests() {
        setListIndexWithElementKeyAndInsertionIndexKeyWrapperTests( () -> meatball );
        setListIndexWithElementKeyAndInsertionIndexKeyWrapperTests( mapSupplier );
    }

    private void removeFromListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeFromList( null, 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), removeFromList( "list", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeFromList( "stack", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeFromList( "number", 6 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), removeFromList( "list", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), removeFromList( "list", "hello" ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeFromListWrapperTests() {
        removeFromListWrapperTests( () -> meatball );
        removeFromListWrapperTests( mapSupplier );
    }

    void removeFromListWithElementKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeFromList( null, Integer.class, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), removeFromList( "list", Integer.class, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeFromList( "stack", Integer.class, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeFromList( "number", Integer.class, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeFromList( "list", null, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeFromList( "list", String.class, "six" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), removeFromList( "list", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), removeFromList( "list", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), removeFromList( "list", String.class, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeFromListWithElementKeyWrapperTests() {
        removeFromListWithElementKeyWrapperTests( () -> meatball );
        removeFromListWithElementKeyWrapperTests( mapSupplier );
    }

    private void removeAllFromListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromList( null, List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), removeAllFromList( "list", List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromList( "stack", List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeAllFromList( "number", List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromList( "list", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), removeAllFromList( "list", List.of( "hello" ) ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeAllFromListWrapperTests() {
        removeAllFromListWrapperTests( () -> meatball );
        removeAllFromListWrapperTests( mapSupplier );
    }

    private void removeAllFromListWithElementsKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromList( null, Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), removeAllFromList( "list", Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromList( "stack", Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeAllFromList( "number", Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), removeAllFromList( "list", null, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), removeAllFromList( "list", String.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromList( "list", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromList( "list", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), removeAllFromList( "list", String.class, "strings" ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeAllFromListWithElementsKeyWrapperTests() {
        removeAllFromListWithElementsKeyWrapperTests( () -> meatball );
        removeAllFromListWithElementsKeyWrapperTests( mapSupplier );
    }

    private void retainAllInListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInList( null, List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6 ), retainAllInList( "list", List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInList( "stack", List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> retainAllInList( "number", List.of( 6 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInList( "list", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of(), retainAllInList( "list", List.of( "hello" ) ).apply( mapSupplier.get() ) );
    }

    @Test
    void retainAllInListWrapperTests() {
        retainAllInListWrapperTests( () -> meatball );
        retainAllInListWrapperTests( mapSupplier );
    }

    private void retainAllInListWithElementsKeyWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInList( null, Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6 ), retainAllInList( "list", Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInList( "stack", Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> retainAllInList( "number", Integer.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6 ), retainAllInList( "list", null, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6 ), retainAllInList( "list", String.class, "sixes" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInList( "list", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInList( "list", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of(), retainAllInList( "list", String.class, "strings" ).apply( mapSupplier.get() ) );
    }

    @Test
    void retainAllInListWithElementsKeyWrapperTests() {
        retainAllInListWithElementsKeyWrapperTests( () -> meatball );
        retainAllInListWithElementsKeyWrapperTests( mapSupplier );
    }

    private void clearListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> clearList( null, Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of(), clearList( "list", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> clearList( "stack", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> clearList( "number", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of(), clearList( "list", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of(), clearList( "list", String.class ).apply( mapSupplier.get() ) );
    }

    @Test
    void clearListWrapperTests() {
        clearListWrapperTests( () -> meatball );
        clearListWrapperTests( mapSupplier );
    }

    private void sortListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> sortList( null, Collections.reverseOrder() ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6, 5, 4, 3, 2, 1 ), sortList( "list", Collections.reverseOrder() ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> sortList( "stack", Collections.reverseOrder() ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> sortList( "number", Collections.reverseOrder() ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), sortList( "list", null ).apply( mapSupplier.get() ) );
    }

    @Test
    void sortListWrapperTests() {
        sortListWrapperTests( () -> meatball );
        sortListWrapperTests( mapSupplier );
    }

    private void reverseListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> reverseList( null, Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6, 5, 4, 3, 2, 1 ), reverseList( "list", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> reverseList( "stack", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> reverseList( "number", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6, 5, 4, 3, 2, 1 ), reverseList( "list", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( List.of( 6, 5, 4, 3, 2, 1 ), reverseList( "list", String.class ).apply( mapSupplier.get() ) );
    }

    @Test
    void reverseListWrapperTests() {
        reverseListWrapperTests( () -> meatball );
        reverseListWrapperTests( mapSupplier );
    }

    private void shuffleListWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> shuffleList( null, Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertTrue( shuffleList( "list", Integer.class ).apply( mapSupplier.get() ).containsAll( List.of( 1, 2, 3, 4, 5, 6 ) ) );
        Assertions.assertNotSame( List.of( 1, 2, 3, 4, 5, 6 ), shuffleList( "list", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> shuffleList( "stack", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> shuffleList( "number", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertTrue( shuffleList( "list", null ).apply( mapSupplier.get() ).containsAll( List.of( 1, 2, 3, 4, 5, 6 ) ) );
        Assertions.assertTrue( shuffleList( "list", String.class ).apply( mapSupplier.get() ).containsAll( List.of( 1, 2, 3, 4, 5, 6 ) ) );
    }

    @Test
    void shuffleListWrapperTests() {
        shuffleListWrapperTests( () -> meatball );
        shuffleListWrapperTests( mapSupplier );
    }

    private void intersectionWithListWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> intersectionWithList( null, List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertEquals( List.of( 6 ), intersectionWithList( "list", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> intersectionWithList( "stack", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> intersectionWithList( "number", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> intersectionWithList( "list", null ).apply( map ) );
        Assertions.assertEquals( List.of(), intersectionWithList( "list", List.of( "hello" ) ).apply( map ) );
    }

    @Test
    void intersectionWithListWrapperTests() {
        intersectionWithListWrapperTests( meatball );
        intersectionWithListWrapperTests( mapSupplier.get() );
    }

    private void intersectionWithListWithElementsKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> intersectionWithList( null, Integer.class, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 6 ), intersectionWithList( "list", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> intersectionWithList( "stack", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> intersectionWithList( "number", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 6 ), intersectionWithList( "list", null, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 6 ), intersectionWithList( "list", String.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> intersectionWithList( "list", Integer.class, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> intersectionWithList( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertEquals( List.of(), intersectionWithList( "list", String.class, "strings" ).apply( map ) );
    }

    @Test
    void intersectionWithListWithElementsKeyWrapperTests() {
        intersectionWithListWithElementsKeyWrapperTests( meatball );
        intersectionWithListWithElementsKeyWrapperTests( mapSupplier.get() );
    }

    private void complementWithListWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> complementWithList( null, List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), complementWithList( "list", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> complementWithList( "stack", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> complementWithList( "number", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> complementWithList( "list", null ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), complementWithList( "list", List.of( "hello" ) ).apply( map ) );
    }

    @Test
    void complementWithListWrapperTests() {
        complementWithListWrapperTests( meatball );
        complementWithListWrapperTests( mapSupplier.get() );
    }

    private void complementWithListWithElementsKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> complementWithList( null, Integer.class, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), complementWithList( "list", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> complementWithList( "stack", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> complementWithList( "number", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), complementWithList( "list", null, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), complementWithList( "list", String.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> complementWithList( "list", Integer.class, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> complementWithList( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), complementWithList( "list", String.class, "strings" ).apply( map ) );
    }

    @Test
    void complementWithListWithElementsKeyWrapperTests() {
        complementWithListWithElementsKeyWrapperTests( meatball );
        complementWithListWithElementsKeyWrapperTests( mapSupplier.get() );
    }

    private void differenceBetweenListsWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> differenceBetweenLists( null, List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 7 ), differenceBetweenLists( "list", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> differenceBetweenLists( "stack", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> differenceBetweenLists( "number", List.of( 6, 7 ) ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> differenceBetweenLists( "list", null ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "hello" ), differenceBetweenLists( "list", List.of( "hello" ) ).apply( map ) );
    }

    @Test
    void differenceBetweenListsWrapperTests() {
        differenceBetweenListsWrapperTests( meatball );
        differenceBetweenListsWrapperTests( mapSupplier.get() );
    }

    private void differenceBetweenListsWithElementsKeyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> differenceBetweenLists( null, Integer.class, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), differenceBetweenLists( "list", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> differenceBetweenLists( "stack", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> differenceBetweenLists( "number", Integer.class, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), differenceBetweenLists( "list", null, "sixes" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), differenceBetweenLists( "list", String.class, "sixes" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> differenceBetweenLists( "list", Integer.class, null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> differenceBetweenLists( "list", Integer.class, "num" ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6, "text" ), differenceBetweenLists( "list", String.class, "strings" ).apply( map ) );
    }

    @Test
    void differenceBetweenListsWithElementsKeyWrapperTests() {
        differenceBetweenListsWithElementsKeyWrapperTests( meatball );
        differenceBetweenListsWithElementsKeyWrapperTests( mapSupplier.get() );
    }

    private void castListToArrayWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> castListToArray( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), Arrays.stream( castListToArray( "list", Integer.class ).apply( map ) ).toList() );
        Assertions.assertThrows( NullPointerException.class, () -> castListToArray( "stack", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> castListToArray( "number", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> castListToArray( "list", null ).apply( map ) );
        Assertions.assertThrows( ArrayStoreException.class, () -> castListToArray( "list", String.class ).apply( map ) );
    }

    @Test
    void castListToArrayWrapperTests() {
        castListToArrayWrapperTests( meatball );
        castListToArrayWrapperTests( mapSupplier.get() );
    }

    private void castArrayToListWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> castArrayToList( null, Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), castArrayToList( "array", Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> castArrayToList( "stack", Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> castArrayToList( "number", Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), castArrayToList( "array", null, ArrayList.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), castArrayToList( "array", String.class, ArrayList.class ).apply( map ) );
        Assertions.assertThrows( RuntimeException.class, () -> castArrayToList( "array", Integer.class, null ).apply( map ) );
    }

    @Test
    void castArrayToListWrapperTests() {
        castArrayToListWrapperTests( meatball );
        castArrayToListWrapperTests( mapSupplier.get() );
    }

    private void castListToSetWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> castListToSet( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 4, 5, 6 ), castListToSet( "list", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> castListToSet( "stack", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> castListToSet( "number", Integer.class ).apply( map ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 4, 5, 6 ), castListToSet( "list", null ).apply( map ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 4, 5, 6 ), castListToSet( "list", String.class ).apply( map ) );
    }

    @Test
    void castListToSetWrapperTests() {
        castListToSetWrapperTests( meatball );
        castListToSetWrapperTests( mapSupplier.get() );
    }

    private void castSetToListWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> castSetToList( null, Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), castSetToList( "set", Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> castSetToList( "stack", Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> castSetToList( "number", Integer.class, ArrayList.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), castSetToList( "set", null, ArrayList.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), castSetToList( "set", String.class, ArrayList.class ).apply( map ) );
        Assertions.assertThrows( RuntimeException.class, () -> castSetToList( "set", Integer.class, null ).apply( map ) );
    }

    @Test
    void castSetToListWrapperTests() {
        castSetToListWrapperTests( meatball );
        castSetToListWrapperTests( mapSupplier.get() );
    }

}
