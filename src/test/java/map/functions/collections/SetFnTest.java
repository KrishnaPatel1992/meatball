package map.functions.collections;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;

import static map.functions.collections.SetFn.*;

public class SetFnTest {

    private final Meatball meatball = new Meatball(
            "set", new HashSet<>( List.of( 1, 2, 3 ) ),
            "number", 1992,
            "string", "text",
            "numbers", new ArrayList<>( List.of( 1992 ) ),
            "three", 3,
            "listWithThree", new ArrayList<>( List.of( 3 ) ) );
    private final Supplier<Map<String, Object>> mapSupplier = () -> new HashMap<>( meatball );

    private final Supplier<Set<Integer>> setWithNullSupplier = () -> {
        final var setWithNull = new HashSet<>( List.of( 1, 2, 3 ) );
        setWithNull.add( null );
        return setWithNull;
    };

    private void addToSetWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToSet( null, 4 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 4 ), addToSet( "set", 4 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToSet( "stack", 4 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToSet( "number", 4 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( setWithNullSupplier.get(), addToSet( "set", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, "hello" ), addToSet( "set", "hello" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addToSetWrapperTests() {
        addToSetWrapperTests( () -> meatball );
        addToSetWrapperTests( mapSupplier );
    }

    private void addToSetWithElementClassWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addToSet( null, Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 1992 ), addToSet( "set", Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToSet( "stack", Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToSet( "number", Integer.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addToSet( "set", null, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addToSet( "set", String.class, "number" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( setWithNullSupplier.get(), addToSet( "set", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( setWithNullSupplier.get(), addToSet( "set", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, "text" ), addToSet( "set", String.class, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addToSetWithElementClassWrapperTests() {
        addToSetWithElementClassWrapperTests( () -> meatball );
        addToSetWithElementClassWrapperTests( mapSupplier );
    }

    private void addAllToSetWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToSet( null, List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 4 ), addAllToSet( "set", List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToSet( "stack", List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToSet( "number", List.of( 4 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToSet( "set", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, "hello" ), addAllToSet( "set", List.of( "hello" ) ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToSetWrapperTests() {
        addAllToSetWrapperTests( () -> meatball );
        addAllToSetWrapperTests( mapSupplier );
    }

    private void addAllToSetWithElementClassWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> addAllToSet( null, Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 1992 ), addAllToSet( "set", Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToSet( "stack", Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToSet( "number", Integer.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 1992 ), addAllToSet( "set", null, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3, 1992 ), addAllToSet( "set", String.class, "numbers" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToSet( "set", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> addAllToSet( "set", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> addAllToSet( "set", String.class, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void addAllToSetWithElementClassWrapperTests() {
        addAllToSetWithElementClassWrapperTests( () -> meatball );
        addAllToSetWithElementClassWrapperTests( mapSupplier );
    }

    private void removeFromSetWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeFromSet( null, 3 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2 ), removeFromSet( "set", 3 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeFromSet( "stack", 3 ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeFromSet( "number", 3 ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), removeFromSet( "set", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), removeFromSet( "set", "hello" ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeFromSetWrapperTests() {
        removeFromSetWrapperTests( () -> meatball );
        removeFromSetWrapperTests( mapSupplier );
    }

    private void removeFromSetWithElementClassWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeFromSet( null, Integer.class, "three" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2 ), removeFromSet( "set", Integer.class, "three" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeFromSet( "stack", Integer.class, "three" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeFromSet( "number", Integer.class, "three" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeFromSet( "set", null, "three" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeFromSet( "set", String.class, "three" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), removeFromSet( "set", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), removeFromSet( "set", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), removeFromSet( "set", String.class, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeFromSetWithElementClassWrapperTests() {
        removeFromSetWithElementClassWrapperTests( () -> meatball );
        removeFromSetWithElementClassWrapperTests( mapSupplier );
    }

    private void removeAllFromSetWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromSet( null, List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2 ), removeAllFromSet( "set", List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromSet( "stack", List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeAllFromSet( "number", List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromSet( "set", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), removeAllFromSet( "set", List.of( "hello" ) ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeAllFromSetWrapperTests() {
        removeAllFromSetWrapperTests( () -> meatball );
        removeAllFromSetWrapperTests( mapSupplier );
    }

    private void removeAllFromSetWithElementClassWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromSet( null, Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2 ), removeAllFromSet( "set", Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromSet( "stack", Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeAllFromSet( "number", Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2 ), removeAllFromSet( "set", null, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 1, 2 ), removeAllFromSet( "set", String.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromSet( "set", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> removeAllFromSet( "set", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> removeAllFromSet( "set", String.class, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void removeAllFromSetWithElementClassWrapperTests() {
        removeAllFromSetWithElementClassWrapperTests( () -> meatball );
        removeAllFromSetWithElementClassWrapperTests( mapSupplier );
    }

    private void retainAllInSetWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInSet( null, List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 3 ), retainAllInSet( "set", List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInSet( "stack", List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> retainAllInSet( "number", List.of( 3 ) ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInSet( "set", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of(), retainAllInSet( "set", List.of( "hello" ) ).apply( mapSupplier.get() ) );
    }

    @Test
    void retainAllInSetWrapperTests() {
        retainAllInSetWrapperTests( () -> meatball );
        retainAllInSetWrapperTests( mapSupplier );
    }

    private void retainAllInSetWithElementClassWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInSet( null, Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 3 ), retainAllInSet( "set", Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInSet( "stack", Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> retainAllInSet( "number", Integer.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 3 ), retainAllInSet( "set", null, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of( 3 ), retainAllInSet( "set", String.class, "listWithThree" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInSet( "set", Integer.class, null ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> retainAllInSet( "set", Integer.class, "num" ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> retainAllInSet( "set", String.class, "string" ).apply( mapSupplier.get() ) );
    }

    @Test
    void retainAllInSetWithElementClassWrapperTests() {
        retainAllInSetWithElementClassWrapperTests( () -> meatball );
        retainAllInSetWithElementClassWrapperTests( mapSupplier );
    }

    private void clearSetWrapperTests( Supplier<Map<String, Object>> mapSupplier ) {
        Assertions.assertThrows( NullPointerException.class, () -> clearSet( null, Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of(), clearSet( "set", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> clearSet( "stack", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> clearSet( "number", Integer.class ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of(), clearSet( "set", null ).apply( mapSupplier.get() ) );
        Assertions.assertEquals( Set.of(), clearSet( "set", String.class ).apply( mapSupplier.get() ) );
    }

    @Test
    void clearSetWrapperTests() {
        clearSetWrapperTests( () -> meatball );
        clearSetWrapperTests( mapSupplier );
    }

}
