package functions;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static functions.Fn.*;
import static map.functions.MapFn.*;
import static map.functions.MapFn.has;
import static map.functions.primitives.MathFn.add;
import static map.functions.primitives.MathFn.subtract;

public class FnTest {

    private final Meatball meatballKrishna = new Meatball( "firstName", "Krishna" );
    private final Meatball meatballKrishnaPatel = new Meatball( "firstName", "Krishna", "surname", "Patel" );
    private final Meatball meatballShoppingCart = new Meatball( "apples", 100, "bananas", 200, "peaches", 32 );
    private final Meatball meatballShoppingCartWith99Apples = new Meatball( "apples", 99, "bananas", 200, "peaches", 32 );
    private final Meatball meatballShoppingCartWith99Bagels = new Meatball( "apples", 100, "bananas", 200, "peaches", 32, "bagels", 99 );
    private final Supplier<Map<String, Object>> hashmapKrishnaSupplier = () -> new HashMap<>( meatballKrishna );
    private final Supplier<Map<String, Object>> hashmapKrishnaPatelSupplier = () -> new HashMap<>( meatballKrishnaPatel );
    private final Supplier<Map<String, Object>> hashmapShoppingCartSupplier = () -> new HashMap<>( meatballShoppingCart );
    private final Supplier<Map<String, Object>> hashmapShoppingCartWith99ApplesSupplier = () -> new HashMap<>( meatballShoppingCartWith99Apples );
    private final Supplier<Map<String, Object>> hashmapShoppingCartWith99BagelsSupplier = () -> new HashMap<>( meatballShoppingCartWith99Bagels );

    @Test
    void whenThenOtherwiseFnMeatballConditionallyExecutesThenAndOtherwise() {
        Assertions.assertEquals( meatballShoppingCartWith99Apples, when( has( "apples" ), compute( "apples", subtract( "apples", 1, Integer.class ) ), compute( "bagels", add( "peaches", 67, Integer.class ) ) ).apply( meatballShoppingCart ) );
        Assertions.assertEquals( meatballShoppingCartWith99Bagels, when( has( "plums" ), compute( "apples", subtract( "apples", 1, Integer.class ) ), compute( "bagels", add( "peaches", 67, Integer.class ) ) ).apply( meatballShoppingCart ) );
    }

    @Test
    void whenThenOtherwiseFnHashmapConditionallyExecutesThenAndOtherwise() {
        Assertions.assertEquals( hashmapShoppingCartWith99ApplesSupplier.get(), when( has( "apples" ), compute( "apples", subtract( "apples", 1, Integer.class ) ), compute( "bagels", add( "peaches", 67, Integer.class ) ) ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertEquals( hashmapShoppingCartWith99BagelsSupplier.get(), when( has( "plums" ), compute( "apples", subtract( "apples", 1, Integer.class ) ), compute( "bagels", add( "peaches", 67, Integer.class ) ) ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void whenThenOtherwiseFnWithNullInputsThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> when( null, compute( "apples", subtract( "apples", 1, Integer.class ) ), compute( "bagels", add( "peaches", 67, Integer.class ) ) ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( NullPointerException.class, () -> when( has( "apples" ), null, compute( "bagels", add( "peaches", 67, Integer.class ) ) ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( NullPointerException.class, () -> when( has( "plums" ), compute( "apples", subtract( "apples", 1, Integer.class ) ), null ).apply( meatballShoppingCart ) );
    }

    @Test
    void whenThenFnMeatballConditionallyExecutesThen() {
        Assertions.assertEquals( meatballShoppingCartWith99Apples, when( has( "apples" ), compute( "apples", subtract( "apples", 1, Integer.class ) ) ).apply( meatballShoppingCart ) );
        Assertions.assertEquals( meatballShoppingCart, when( has( "plums" ), compute( "apples", subtract( "apples", 1, Integer.class ) ) ).apply( meatballShoppingCart ) );
    }

    @Test
    void whenThenFnHashmapConditionallyExecutesThen() {
        Assertions.assertEquals( hashmapShoppingCartWith99ApplesSupplier.get(), when( has( "apples" ), compute( "apples", subtract( "apples", 1, Integer.class ) ) ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertEquals( hashmapShoppingCartSupplier.get(), when( has( "plums" ), compute( "apples", subtract( "apples", 1, Integer.class ) ) ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void whenThenFnWithNullInputsThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> when( null, compute( "apples", subtract( "apples", 1, Integer.class ) ) ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> when( has( "apples" ), (Function<Map<String, Object>, Map<String, Object>>) null ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void whenThrowMeatballThrowsExceptionWhenConditionIsSatisfiedOtherwiseDoesNothing() {
        Assertions.assertEquals( meatballShoppingCart, when( hasNot( "apples" ), new NullPointerException() ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( NullPointerException.class, () -> when( hasNot( "milk" ), new NullPointerException() ).apply( meatballShoppingCart ) );
    }

    @Test
    void whenThrowHashmapThrowsExceptionWhenConditionIsSatisfiedOtherwiseDoesNothing() {
        Assertions.assertEquals( hashmapShoppingCartSupplier.get(), when( hasNot( "apples" ), new NullPointerException() ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> when( hasNot( "milk" ), new NullPointerException() ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void whenThrowWithNullInputsThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> when( null, new NullPointerException() ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( NullPointerException.class, () -> when( hasNot( "milk" ), (RuntimeException) null ).apply( meatballShoppingCart ) );
    }

    private Map<String, Object> throwIfApples100( Map<String, Object> map ) throws ClassCastException {
        if ( ((int) map.get( "apples" )) == 100 )
            throw new ClassCastException();
        return map;
    }

    @Test
    void uncheckMeatballThrowsRuntimeExceptionIfNecessary() {
        Assertions.assertThrows( RuntimeException.class, () -> uncheck( this::throwIfApples100 ).apply( meatballShoppingCart ) );
        Assertions.assertEquals( meatballShoppingCartWith99Apples, uncheck( this::throwIfApples100 ).apply( meatballShoppingCartWith99Apples ) );
    }

    @Test
    void uncheckHashmapThrowsRuntimeExceptionIfNecessary() {
        Assertions.assertThrows( RuntimeException.class, () -> uncheck( this::throwIfApples100 ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertEquals( hashmapShoppingCartWith99ApplesSupplier.get(), uncheck( this::throwIfApples100 ).apply( hashmapShoppingCartWith99ApplesSupplier.get() ) );
    }

    @Test
    void uncheckWithNullInputThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> uncheck( null ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void doOnNextFunctionReturnsOriginalInstanceButAlsoAppliesSideEffects() {
        Assertions.assertEquals( meatballKrishna, doOnNext( put( "surname", "Patel" ) ).apply( meatballKrishna ) );
        Assertions.assertEquals( hashmapKrishnaPatelSupplier.get(), doOnNext( put( "surname", "Patel" ) ).apply( hashmapKrishnaSupplier.get() ) );
    }

    @Test
    void doOnNextFunctionWithNullInputThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> doOnNext( (Function<Map<String, Object>, Map<String, Object>>) null ).apply( meatballKrishna ) );
    }

    @Test
    void doOnNextConsumerReturnsOriginalInstanceButAlsoAppliesSideEffects() {
        Assertions.assertEquals( meatballKrishna, doOnNext( map -> { System.err.println( "Hello!" ); } ).apply( meatballKrishna ) );
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), doOnNext( map -> { System.err.println( "World!" ); } ).apply( hashmapKrishnaSupplier.get() ) );
    }

    @Test
    void doOnNextConsumerWithNullInputThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> doOnNext( (Consumer<Map<String, Object>>) null ).apply( meatballKrishna ) );
    }

    @Test
    void asFunctionConvertsPredicateToFunction() {
        Assertions.assertTrue( asFunction( has( "apples" ) ).apply( meatballShoppingCart ) );
        Assertions.assertTrue( asFunction( has( "apples" ) ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void asFunctionWithNullInputThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> asFunction( null ).apply( meatballShoppingCart ) );
    }

    @Test
    void asPredicateConvertsFunctionToPredicate() {
        Assertions.assertTrue( asPredicate( map -> ((Meatball) map).containsKey( "apples" ) ).test( meatballShoppingCart ) );
        Assertions.assertTrue( asPredicate( map -> ((HashMap<String, Object>) map).containsKey( "apples" ) ).test( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void asPredicateWithNullInputThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> asPredicate( null ).test( meatballShoppingCart ) );
    }

}
