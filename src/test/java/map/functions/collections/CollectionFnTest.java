package map.functions.collections;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static map.functions.collections.CollectionFn.*;

public class CollectionFnTest {

    private final Meatball meatball = new Meatball( "list", new ArrayList<>( List.of( 1, 2, 3 ) ), "number", 1992, "numbers", new ArrayList<>( List.of( 2, 3 ) ) );
    private final Supplier<HashMap<String, Object>> mapSupplier = () -> new HashMap<>( meatball );

    private void sizeWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> size( null ).apply( map ) );
        Assertions.assertEquals( 3, size( "list" ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> size( "stack" ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> size( "number" ).apply( map ) );
    }

    @Test
    void sizeWrapperTests() {
        sizeWrapperTests( meatball );
        sizeWrapperTests( mapSupplier.get() );
    }

    private void containsWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> contains( null, 3 ).test( map ) );
        Assertions.assertTrue( contains( "list", 3 ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> contains( "stack", 3 ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> contains( "number", 3 ).test( map ) );
        Assertions.assertFalse( contains( "list", null ).test( map ) );
        Assertions.assertFalse( contains( "list", "hello" ).test( map ) );
    }

    @Test
    void containsWrapperTests() {
        containsWrapperTests( meatball );
        containsWrapperTests( mapSupplier.get() );
    }

    private void containsWithClassWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> contains( null, Integer.class, "number" ).test( map ) );
        Assertions.assertFalse( contains( "list", Integer.class, "number" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> contains( "stack", Integer.class, "number" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> contains( "number", Integer.class, "number" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> contains( "list", null, "number" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> contains( "list", String.class, "number" ).test( map ) );
        Assertions.assertFalse( contains( "list", Integer.class, null ).test( map ) );
        Assertions.assertFalse( contains( "list", Integer.class, "num" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> contains( "list", Integer.class, "list" ).test( map ) );

    }

    @Test
    void containsWithClassWrapperTests() {
        containsWithClassWrapperTests( meatball );
        containsWithClassWrapperTests( mapSupplier.get() );
    }

    private void isEmptyWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> isEmpty( null ).test( map ) );
        Assertions.assertFalse( isEmpty( "list" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> isEmpty( "stack" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> isEmpty( "number" ).test( map ) );
    }

    @Test
    void isEmptyWrapperTests() {
        isEmptyWrapperTests( meatball );
        isEmptyWrapperTests( mapSupplier.get() );
    }

    private void containsAllWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> containsAll( null, List.of( 2, 3 ) ).test( map ) );
        Assertions.assertTrue( containsAll( "list", List.of( 2, 3 ) ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAll( "stack", List.of( 2, 3 ) ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> containsAll( "number", List.of( 2, 3 ) ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAll( "list", null ).test( map ) );
        Assertions.assertFalse( containsAll( "list", List.of( "hello" ) ).test( map ) );
    }

    @Test
    void containsAllWrapperTests() {
        containsAllWrapperTests( meatball );
        containsAllWrapperTests( mapSupplier.get() );
    }

    private void containsAllWithClassWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> containsAll( null, Integer.class, "numbers" ).test( map ) );
        Assertions.assertTrue( containsAll( "list", Integer.class, "numbers" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAll( "stack", Integer.class, "numbers" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> containsAll( "number", Integer.class, "numbers" ).test( map ) );
        Assertions.assertTrue( containsAll( "list", null, "numbers" ).test( map ) );
        Assertions.assertTrue( containsAll( "list", String.class, "numbers" ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAll( "list", Integer.class, null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> containsAll( "list", Integer.class, "num" ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> containsAll( "list", Integer.class, "number" ).test( map ) );
    }

    @Test
    void containsAllWithClassWrapperTests() {
        containsAllWithClassWrapperTests( meatball );
        containsAllWithClassWrapperTests( mapSupplier.get() );
    }

    private void minWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> min( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( 1, min( "list", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> min( "stack", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> min( "number", Integer.class ).apply( map ) );
        Assertions.assertEquals( 1, min( "list", null ).apply( map ) );
        Assertions.assertEquals( 1, min( "list", BigDecimal.class ).apply( map ) );

    }

    @Test
    void minWrapperTests() {
        minWrapperTests( meatball );
        minWrapperTests( mapSupplier.get() );
    }

    private void maxWrapperTests( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> max( null, Integer.class ).apply( map ) );
        Assertions.assertEquals( 3, max( "list", Integer.class ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> max( "stack", Integer.class ).apply( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> max( "number", Integer.class ).apply( map ) );
        Assertions.assertEquals( 3, max( "list", null ).apply( map ) );
        Assertions.assertEquals( 3, max( "list", BigDecimal.class ).apply( map ) );
    }

    @Test
    void maxWrapperTests() {
        maxWrapperTests( meatball );
        maxWrapperTests( mapSupplier.get() );
    }

}
