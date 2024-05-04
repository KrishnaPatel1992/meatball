package map.functions;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;

import static map.functions.MapFn.*;
import static map.functions.primitives.MathFn.subtract;

public class MapFnTest {

    private final Meatball meatballKrishna = new Meatball( "firstName", "Krishna" );
    private final Meatball meatballKrishnaPatel = new Meatball( "firstName", "Krishna", "surname", "Patel" );
    private final Meatball meatballBhavesh = new Meatball( "firstName", "Bhavesh" );
    private final Meatball meatballKrishnaPrefKrishna = new Meatball( "firstName", "Krishna", "preferredName", "Krishna" );
    private final Meatball meatballKrishnaPrefLord = new Meatball( "firstName", "Krishna", "preferredName", "Lord" );
    private final Meatball meatballKrishnaPrefKrishnaDisplayKrishna = new Meatball( "firstName", "Krishna", "preferredName", "Krishna", "displayName", "Krishna" );
    private final Meatball meatballDisplayKrishna = new Meatball( "displayName", "Krishna" );
    private final Meatball meatballDataStructures = new Meatball(
            "list", new ArrayList<>( List.of( 1, 2, 3 ) ),
            "set", new HashSet<>( List.of( 1, 2, 3 ) ),
            "mapWithDiffKeyValueClasses", new HashMap<>( Map.of( "a", 1, "b", 2, "c", 3 ) ),
            "mapWithSameKeyValueClasses", new HashMap<>( Map.of( 1, 1, 2, 2, 3, 3 ) ),
            "priorityQueue", new PriorityQueue<>( List.of( 1, 2, 3 ) ),
            "array", new Integer[]{ 1, 2, 3 }
    );
    private final Meatball meatballKrishnaPatelPrefKrishna = new Meatball( "firstName", "Krishna", "preferredName", "Krishna", "surname", "Patel" );
    private final Meatball meatballKrishnaNamesKrishna = new Meatball( "firstName", "Krishna", "names", new ArrayList<>( List.of( "Krishna" ) ) );
    private final Meatball meatballShoppingCart = new Meatball( "apples", 100, "bananas", 200, "peaches", 32 );
    private final Meatball meatballShoppingCartWith99Apples = new Meatball( "apples", 99, "bananas", 200, "peaches", 32 );
    private final Meatball meatballShoppingCartWith99Bagels = new Meatball( "apples", 100, "bananas", 200, "peaches", 32, "bagels", 99 );
    private final Supplier<Map<String, Object>> hashmapKrishnaSupplier = () -> new HashMap<>( meatballKrishna );
    private final Supplier<Map<String, Object>> hashmapKrishnaPatelSupplier = () -> new HashMap<>( meatballKrishnaPatel );
    private final Supplier<Map<String, Object>> hashmapBhaveshSupplier = () -> new HashMap<>( meatballBhavesh );
    private final Supplier<Map<String, Object>> hashmapKrishnaPrefKrishnaSupplier = () -> new HashMap<>( meatballKrishnaPrefKrishna );
    private final Supplier<Map<String, Object>> hashmapKrishnaPrefLordSupplier = () -> new HashMap<>( meatballKrishnaPrefLord );
    private final Supplier<Map<String, Object>> hashmapKrishnaPrefKrishnaDisplayKrishnaSupplier = () -> new HashMap<>( meatballKrishnaPrefKrishnaDisplayKrishna );
    private final Supplier<Map<String, Object>> hashmapDataStructuresSupplier = () -> new HashMap<>( meatballDataStructures );
    private final Supplier<Map<String, Object>> hashmapKrishnaPatelPrefKrishnaSupplier = () -> new HashMap<>( meatballKrishnaPatelPrefKrishna );
    private final Supplier<Map<String, Object>> hashmapKrishnaNamesKrishaSupplier = () -> new HashMap<>( meatballKrishnaNamesKrishna );
    private final Supplier<Map<String, Object>> hashmapShoppingCartSupplier = () -> new HashMap<>( meatballShoppingCart );
    private final Supplier<Map<String, Object>> hashmapShoppingCartWith99ApplesSupplier = () -> new HashMap<>( meatballShoppingCartWith99Apples );
    private final Supplier<Map<String, Object>> hashmapShoppingCartWith99BagelsSupplier = () -> new HashMap<>( meatballShoppingCartWith99Bagels );

    private final Supplier<Map<String, Object>> hashmapShoppingCartWithNull99Supplier = () -> {
        final var map = new HashMap<>( meatballShoppingCart );
        map.put( null, 99 );
        return map;
    };

    private final Supplier<Map<String, Object>> firstNameNullMapSupplier = () -> {
        final var firstNameNullMap = new HashMap<String, Object>();
        firstNameNullMap.put( "firstName", null );
        return firstNameNullMap;
    };

    private final Supplier<Map<String, Object>> firstNameKrishnaNullBhaveshMapSupplier = () -> {
        final var firstNameKrishnaNullBhaveshMap = new HashMap<String, Object>( Map.of( "firstName", "Krishna" ) );
        firstNameKrishnaNullBhaveshMap.put( null, "Bhavesh" );
        return firstNameKrishnaNullBhaveshMap;
    };

    private final Supplier<Map<String, Object>> firstNameKrishnaNullNullMapSupplier = () -> {
        final var firstNameKrishnaNullNullMap = new HashMap<String, Object>( Map.of( "firstName", "Krishna" ) );
        firstNameKrishnaNullNullMap.put( null, null );
        return firstNameKrishnaNullNullMap;
    };

    private final Supplier<Map<String, Object>> nullBhaveshMapSupplier = () -> {
        final var nullBhaveshMap = new HashMap<String, Object>();
        nullBhaveshMap.put( null, "Bhavesh" );
        return nullBhaveshMap;
    };

    private final Supplier<Map<String, Object>> nullNullMapSupplier = () -> {
        final var nullNullMap = new HashMap<String, Object>();
        nullNullMap.put( null, null );
        return nullNullMap;
    };

    private final Supplier<Map<String, Object>> firstNameKrishnaSurnameNullMapSupplier = () -> {
        final var firstNameKrishnaSurnameNullMap = new HashMap<String, Object>( Map.of( "firstName", "Krishna" ) );
        firstNameKrishnaSurnameNullMap.put( "surname", null );
        return firstNameKrishnaSurnameNullMap;
    };

    @Test
    void toMeatballWithCreatesNewMeatballWithSuppliedKeyValuePair() {
        Assertions.assertEquals( meatballKrishna, toMeatballWith( "firstName" ).apply( "Krishna" ) );
        Assertions.assertEquals( new Meatball(), toMeatballWith( null ).apply( "Krishna" ) );
        Assertions.assertEquals( new Meatball(), toMeatballWith( "firstName" ).apply( null ) );
    }

    @Test
    void toMeatballWithUnsupportedTypeThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> toMeatballWith( "firstName" ).apply( new Random() ) );
    }

    @Test
    void putAllMeatballWithKeyValuePairEnrichesMapWithPairs() {
        Assertions.assertEquals( meatballKrishna, putAll().apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishnaPatel, putAll( "surname", "Patel" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishnaPatel, putAll( "firstName", "Krishna", "surname", "Patel" ).apply( new Meatball() ) );

        Assertions.assertEquals( meatballBhavesh, putAll( "firstName", "Bhavesh" ).apply( meatballKrishna ) );
        Assertions.assertEquals( new Meatball(), putAll( "firstName", null ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, putAll( null, "Bhavesh" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, putAll( null, null ).apply( meatballKrishna ) );

        Assertions.assertEquals( meatballBhavesh, putAll( "firstName", "Bhavesh" ).apply( new Meatball() ) );
        Assertions.assertEquals( new Meatball(), putAll( "firstName", null ).apply( new Meatball() ) );
        Assertions.assertEquals( new Meatball(), putAll( null, "Bhavesh" ).apply( new Meatball() ) );
        Assertions.assertEquals( new Meatball(), putAll( null, null ).apply( new Meatball() ) );
    }

    @Test
    void putAllHashMapWithKeyValuePairEnrichesMapWithPairs() {
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), putAll().apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaPatelSupplier.get(), putAll( "surname", "Patel" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaPatelSupplier.get(), putAll( "firstName", "Krishna", "surname", "Patel" ).apply( new HashMap<>() ) );

        Assertions.assertEquals( hashmapBhaveshSupplier.get(), putAll( "firstName", "Bhavesh" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), putAll( "firstName", null ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaNullBhaveshMapSupplier.get(), putAll( null, "Bhavesh" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaNullNullMapSupplier.get(), putAll( null, null ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( hashmapBhaveshSupplier.get(), putAll( "firstName", "Bhavesh" ).apply( new HashMap<>() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), putAll( "firstName", null ).apply( new HashMap<>() ) );
        Assertions.assertEquals( nullBhaveshMapSupplier.get(), putAll( null, "Bhavesh" ).apply( new HashMap<>() ) );
        Assertions.assertEquals( nullNullMapSupplier.get(), putAll( null, null ).apply( new HashMap<>() ) );
    }

    @Test
    void putAllWithBrokenKeyValuePairThrowsIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> putAll( "firstName" ).apply( new Meatball() ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> putAll( "firstName" ).apply( new HashMap<>() ) );
    }

    @Test
    void putAllWithUnsupportedValueThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> putAll( "firstName", new Random() ).apply( new Meatball() ) );
    }

    @Test
    void putAllWithNonStringKeyThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> putAll( 42, "Krishna" ).apply( new Meatball() ) );
        Assertions.assertThrows( RuntimeException.class, () -> putAll( 42, "Krishna" ).apply( new HashMap<>() ) );
    }

    @Test
    void putAllMeatballWithMapEnrichesWithMapsKeysAndValues() {
        final var meatballPatel = new Meatball( "surname", "Patel" );

        Assertions.assertEquals( meatballKrishna, putAll( new Meatball() ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishnaPatel, putAll( meatballPatel ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishnaPatel, putAll( meatballKrishnaPatel ).apply( new Meatball() ) );

        Assertions.assertEquals( meatballKrishna, putAll( meatballKrishna ).apply( meatballBhavesh ) );
        Assertions.assertEquals( new Meatball(), putAll( firstNameNullMapSupplier.get() ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballPatel, putAll( nullBhaveshMapSupplier.get() ).apply( meatballPatel ) );
        Assertions.assertEquals( meatballPatel, putAll( nullNullMapSupplier.get() ).apply( meatballPatel ) );

        Assertions.assertEquals( meatballKrishna, putAll( meatballKrishna ).apply( new Meatball() ) );
        Assertions.assertEquals( new Meatball(), putAll( firstNameNullMapSupplier.get() ).apply( new Meatball() ) );
        Assertions.assertEquals( new Meatball(), putAll( nullBhaveshMapSupplier.get() ).apply( new Meatball() ) );
        Assertions.assertEquals( new Meatball(), putAll( nullNullMapSupplier.get() ).apply( new Meatball() ) );
    }

    @Test
    void putAllHashMapWithMapEnrichesWithMapsKeysAndValues() {
        final var hashmapPatel = new HashMap<String, Object>( Map.of( "surname", "Patel" ) );

        Assertions.assertEquals( hashmapKrishnaSupplier.get(), putAll( new HashMap<>() ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaPatelSupplier.get(), putAll( hashmapPatel ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaPatelSupplier.get(), putAll( hashmapKrishnaPatelSupplier.get() ).apply( new HashMap<>() ) );

        Assertions.assertEquals( hashmapKrishnaSupplier.get(), putAll( hashmapKrishnaSupplier.get() ).apply( hashmapBhaveshSupplier.get() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), putAll( firstNameNullMapSupplier.get() ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaNullBhaveshMapSupplier.get(), putAll( nullBhaveshMapSupplier.get() ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaNullNullMapSupplier.get(), putAll( nullNullMapSupplier.get() ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( hashmapKrishnaSupplier.get(), putAll( hashmapKrishnaSupplier.get() ).apply( new HashMap<>() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), putAll( firstNameNullMapSupplier.get() ).apply( new HashMap<>() ) );
        Assertions.assertEquals( nullBhaveshMapSupplier.get(), putAll( nullBhaveshMapSupplier.get() ).apply( new HashMap<>() ) );
        Assertions.assertEquals( nullNullMapSupplier.get(), putAll( nullNullMapSupplier.get() ).apply( new HashMap<>() ) );
    }

    @Test
    void putAllWithNullPairsThrowsNullPointerException() {
        final Meatball nullMeatball = null;
        Assertions.assertThrows( NullPointerException.class, () -> putAll( nullMeatball ).apply( new Meatball() ) );
        Assertions.assertThrows( NullPointerException.class, () -> putAll( nullMeatball ).apply( new HashMap<>() ) );
    }

    @Test
    void putAllWithMapAndUnsupportedValueThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> putAll( Map.of( "firstName", new Random() ) ).apply( new Meatball() ) );
    }

    @Test
    void computeMeatballEnrichesWithFunctionResult() {
        Assertions.assertEquals( meatballShoppingCartWith99Apples, compute( "apples", subtract( "apples", 1, Integer.class ) ).apply( meatballShoppingCart ) );
        Assertions.assertEquals( meatballShoppingCartWith99Bagels, compute( "bagels", subtract( "apples", 1, Integer.class ) ).apply( meatballShoppingCart ) );
        Assertions.assertEquals( meatballShoppingCart, compute( null, subtract( "apples", 1, Integer.class ) ).apply( meatballShoppingCart ) );
    }

    @Test
    void computeHashmapEnrichesWithFunctionResult() {
        Assertions.assertEquals( hashmapShoppingCartWith99ApplesSupplier.get(), compute( "apples", subtract( "apples", 1, Integer.class ) ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertEquals( hashmapShoppingCartWith99BagelsSupplier.get(), compute( "bagels", subtract( "apples", 1, Integer.class ) ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertEquals( hashmapShoppingCartWithNull99Supplier.get(), compute( null, subtract( "apples", 1, Integer.class ) ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void computeWithNullFunctionThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> compute( "apples", null ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( NullPointerException.class, () -> compute( "apples", null ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void copyAllMeatballShouldCopyFromFirstKeyToSecondKey() {
        Assertions.assertEquals( new Meatball(), copyAll().apply( new Meatball() ) );
        Assertions.assertEquals( meatballKrishnaPrefKrishna, copyAll( "firstName", "preferredName" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishnaPrefKrishnaDisplayKrishna, copyAll( "firstName", "preferredName", "preferredName", "displayName" ).apply( meatballKrishna ) );

        Assertions.assertEquals( meatballKrishna, copyAll( null, null ).apply( meatballKrishna ) );
        Assertions.assertEquals( new Meatball(), copyAll( null, "firstName" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, copyAll( null, "surname" ).apply( meatballKrishna ) );

        Assertions.assertEquals( meatballKrishna, copyAll( "firstName", null ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishnaPrefKrishna, copyAll( "firstName", "preferredName" ).apply( meatballKrishnaPrefLord ) );

        Assertions.assertEquals( meatballKrishna, copyAll( "surname", null ).apply( meatballKrishna ) );
        Assertions.assertEquals( new Meatball(), copyAll( "surname", "firstName" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, copyAll( "surname", "age" ).apply( meatballKrishna ) );

        Assertions.assertEquals( meatballKrishna, copyAll( "firstName", "firstName" ).apply( meatballKrishna ) );
    }

    @Test
    void copyAllHashMapShouldCopyFromFirstKeyToSecondKey() {
        final var firstNameKrishnaNullKrishnaMap = new HashMap<String, Object>( Map.of( "firstName", "Krishna" ) );
        firstNameKrishnaNullKrishnaMap.put( null, "Krishna" );

        Assertions.assertEquals( new HashMap<>(), copyAll().apply( new HashMap<>() ) );
        Assertions.assertEquals( hashmapKrishnaPrefKrishnaSupplier.get(), copyAll( "firstName", "preferredName" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaPrefKrishnaDisplayKrishnaSupplier.get(), copyAll( "firstName", "preferredName", "preferredName", "displayName" ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( hashmapKrishnaSupplier.get(), copyAll( null, null ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), copyAll( null, "firstName" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaSurnameNullMapSupplier.get(), copyAll( null, "surname" ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( firstNameKrishnaNullKrishnaMap, copyAll( "firstName", null ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaPrefKrishnaSupplier.get(), copyAll( "firstName", "preferredName" ).apply( hashmapKrishnaPrefLordSupplier.get() ) );

        Assertions.assertEquals( firstNameKrishnaNullNullMapSupplier.get(), copyAll( "surname", null ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), copyAll( "surname", "firstName" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaSurnameNullMapSupplier.get(), copyAll( "age", "surname" ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( hashmapKrishnaSupplier.get(), copyAll( "firstName", "firstName" ).apply( hashmapKrishnaSupplier.get() ) );
    }

    @Test
    void copyAllWithBrokenPairShouldThrowIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> copyAll( "firstName" ).apply( new Meatball() ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> copyAll( "firstName" ).apply( new HashMap<>() ) );
    }

    @Test
    void renameAllMeatballShouldRenameFromFirstKeyToSecondKey() {
        final var meatballPrefKrishna = new Meatball( "preferredName", "Krishna" );

        Assertions.assertEquals( new Meatball(), renameAll().apply( new Meatball() ) );
        Assertions.assertEquals( meatballPrefKrishna, renameAll( "firstName", "preferredName" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballDisplayKrishna, renameAll( "firstName", "preferredName", "preferredName", "displayName" ).apply( meatballKrishna ) );

        Assertions.assertEquals( meatballKrishna, renameAll( null, null ).apply( meatballKrishna ) );
        Assertions.assertEquals( new Meatball(), renameAll( null, "firstName" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, renameAll( null, "surname" ).apply( meatballKrishna ) );

        Assertions.assertEquals( new Meatball(), renameAll( "firstName", null ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballPrefKrishna, renameAll( "firstName", "preferredName" ).apply( meatballKrishnaPrefLord ) );

        Assertions.assertEquals( meatballKrishna, renameAll( "surname", null ).apply( meatballKrishna ) );
        Assertions.assertEquals( new Meatball(), renameAll( "surname", "firstName" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, renameAll( "surname", "age" ).apply( meatballKrishna ) );

        Assertions.assertEquals( meatballKrishna, renameAll( "firstName", "firstName" ).apply( meatballKrishna ) );
    }

    @Test
    void renameAllHashMapShouldRenameFromFirstKeyToSecondKey() {
        final var hashmapPrefKrishna = new HashMap<String, Object>( Map.of( "preferredName", "Krishna" ) );

        Assertions.assertEquals( new HashMap<>(), renameAll().apply( new HashMap<>() ) );
        Assertions.assertEquals( hashmapPrefKrishna, renameAll( "firstName", "preferredName" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( new HashMap<>( meatballDisplayKrishna ), renameAll( "firstName", "preferredName", "preferredName", "displayName" ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( hashmapKrishnaSupplier.get(), renameAll( null, null ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), renameAll( null, "firstName" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaSurnameNullMapSupplier.get(), renameAll( null, "surname" ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( nullBhaveshMapSupplier.get(), renameAll( "firstName", null ).apply( hashmapBhaveshSupplier.get() ) );
        Assertions.assertEquals( hashmapPrefKrishna, renameAll( "firstName", "preferredName" ).apply( hashmapKrishnaPrefLordSupplier.get() ) );

        Assertions.assertEquals( firstNameKrishnaNullNullMapSupplier.get(), renameAll( "surname", null ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameNullMapSupplier.get(), renameAll( "surname", "firstName" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( firstNameKrishnaSurnameNullMapSupplier.get(), renameAll( "age", "surname" ).apply( hashmapKrishnaSupplier.get() ) );

        Assertions.assertEquals( hashmapKrishnaSupplier.get(), renameAll( "firstName", "firstName" ).apply( hashmapKrishnaSupplier.get() ) );
    }

    @Test
    void renameAllWithBrokenPairShouldThrowIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> renameAll( "firstName" ).apply( new Meatball() ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> renameAll( "firstName" ).apply( new HashMap<>() ) );
    }

    @Test
    void removeAllMeatballShouldRemoveSpecifiedKeys() {
        Assertions.assertEquals( meatballKrishna, removeAll().apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, removeAll( "preferredName" ).apply( meatballKrishnaPrefLord ) );
        Assertions.assertEquals( new Meatball(), removeAll( "preferredName", "firstName" ).apply( meatballKrishnaPrefLord ) );
        Assertions.assertEquals( meatballKrishna, removeAll( "surname" ).apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, removeAll( (String) null ).apply( meatballKrishna ) );
    }

    @Test
    void removeAllHashMapShouldRemoveSpecifiedKeys() {
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), removeAll().apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), removeAll( "preferredName" ).apply( hashmapKrishnaPrefLordSupplier.get() ) );
        Assertions.assertEquals( new HashMap<>(), removeAll( "preferredName", "firstName" ).apply( hashmapKrishnaPrefLordSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), removeAll( "surname" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), removeAll( (String) null ).apply( firstNameKrishnaNullNullMapSupplier.get() ) );
    }

    @Test
    void removeNullsAppliedToMapWithoutNullsDoesNothing() {
        Assertions.assertEquals( meatballKrishna, removeNulls.apply( meatballKrishna ) );
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), removeNulls.apply( hashmapKrishnaSupplier.get() ) );
    }

    @Test
    void removeNullsFiltersNullsIfPresent() {
        Assertions.assertEquals( Map.of(), removeNulls.apply( firstNameNullMapSupplier.get() ) );
        Assertions.assertEquals( Map.of(), removeNulls.apply( nullBhaveshMapSupplier.get() ) );
        Assertions.assertEquals( Map.of(), removeNulls.apply( nullNullMapSupplier.get() ) );
    }

    @Test
    void clearShouldClearMap() {
        Assertions.assertEquals( Map.of(), clear.apply( meatballKrishna ) );
        Assertions.assertEquals( Map.of(), clear.apply( hashmapKrishnaSupplier.get() ) );
    }

    @Test
    void keepAllMeatballShouldRemoveUnspecifiedKeys() {
        Assertions.assertEquals( Map.of(), keepAll().apply( meatballKrishna ) );
        Assertions.assertEquals( meatballKrishna, keepAll( "firstName" ).apply( meatballKrishnaPrefLord ) );
        Assertions.assertEquals( meatballKrishnaPrefKrishna, keepAll( "firstName", "preferredName" ).apply( meatballKrishnaPrefKrishnaDisplayKrishna ) );
        Assertions.assertEquals( Map.of(), keepAll( "surname" ).apply( meatballKrishna ) );
        Assertions.assertEquals( Map.of(), keepAll( (String) null ).apply( meatballKrishna ) );
    }

    @Test
    void keepAllHashmapShouldRemoveUnspecifiedKeys() {
        Assertions.assertEquals( Map.of(), keepAll().apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaSupplier.get(), keepAll( "firstName" ).apply( hashmapKrishnaPrefLordSupplier.get() ) );
        Assertions.assertEquals( hashmapKrishnaPrefKrishnaSupplier.get(), keepAll( "firstName", "preferredName" ).apply( hashmapKrishnaPrefKrishnaDisplayKrishnaSupplier.get() ) );
        Assertions.assertEquals( Map.of(), keepAll( "surname" ).apply( hashmapKrishnaSupplier.get() ) );
        Assertions.assertEquals( nullNullMapSupplier.get(), keepAll( (String) null ).apply( firstNameKrishnaNullNullMapSupplier.get() ) );
    }

    private void getShouldRetrieveValueForKey( Map<String, Object> map ) {
        Assertions.assertEquals( "Krishna", get( "firstName" ).apply( map ) );
        Assertions.assertNull( get( "surname" ).apply( map ) );
        Assertions.assertNull( get( null ).apply( map ) );
    }

    @Test
    void getShouldRetrieveValueForKey() {
        getShouldRetrieveValueForKey( meatballKrishna );
        getShouldRetrieveValueForKey( hashmapKrishnaSupplier.get() );
    }

    private void getWithClassShouldRetrieveValueForKey( Map<String, Object> map ) {
        Assertions.assertEquals( "Krishna", get( "firstName", String.class ).apply( map ) );
        Assertions.assertNull( get( "surname", String.class ).apply( map ) );
        Assertions.assertNull( get( null, String.class ).apply( map ) );
    }

    @Test
    void getWithClassShouldRetrieveValueForKey() {
        getWithClassShouldRetrieveValueForKey( meatballKrishna );
        getWithClassShouldRetrieveValueForKey( hashmapKrishnaSupplier.get() );
    }

    @Test
    void getWithNullClassShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> get( "firstName", null ).apply( meatballKrishna ) );
        Assertions.assertThrows( NullPointerException.class, () -> get( "firstName", null ).apply( hashmapKrishnaSupplier.get() ) );
    }

    @Test
    void getWithMismatchedClassShouldThrowClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> get( "firstName", Integer.class ).apply( meatballKrishna ) );
        Assertions.assertThrows( ClassCastException.class, () -> get( "firstName", Integer.class ).apply( hashmapKrishnaSupplier.get() ) );
    }

    private void getWithDefaultValueShouldRetrieveValueForKeyWhenExistsOtherwiseReturnDefault( Map<String, Object> map ) {
        Assertions.assertEquals( "Krishna", get( "firstName", (String) null ).apply( map ) );
        Assertions.assertEquals( "Krishna", get( "firstName", "Bhavesh" ).apply( map ) );
        Assertions.assertEquals( "Krishna", get( "firstName", 42 ).apply( map ) );
        Assertions.assertNull( get( "surname", (String) null ).apply( map ) );
        Assertions.assertEquals( "Bhavesh", get( "surname", "Bhavesh" ).apply( map ) );
        Assertions.assertEquals( 42, get( "surname", 42 ).apply( map ) );
        Assertions.assertNull( get( null, (String) null ).apply( map ) );
        Assertions.assertEquals( "Bhavesh", get( null, "Bhavesh" ).apply( map ) );
        Assertions.assertEquals( 42, get( null, 42 ).apply( map ) );
    }

    @Test
    void getWithDefaultValueShouldRetrieveValueForKeyWhenExistsOtherwiseReturnDefault() {
        getWithDefaultValueShouldRetrieveValueForKeyWhenExistsOtherwiseReturnDefault( meatballKrishna );
        getWithDefaultValueShouldRetrieveValueForKeyWhenExistsOtherwiseReturnDefault( hashmapKrishnaSupplier.get() );
    }

    private void getWithDefaultKeyShouldRetrieveValueAssociatedWithKeyWhenExistsOtherwiseValueAssociatedWithDefaultKey( Map<String, Object> map ) {
        Assertions.assertEquals( "Krishna", get( "firstName", null, String.class ).apply( map ) );
        Assertions.assertEquals( "Krishna", get( "firstName", "preferredName", String.class ).apply( map ) );
        Assertions.assertEquals( "Krishna", get( "firstName", "anotherName", String.class ).apply( map ) );
        Assertions.assertNull( get( "anotherName", null, String.class ).apply( map ) );
        Assertions.assertEquals( "Lord", get( "anotherName", "preferredName", String.class ).apply( map ) );
        Assertions.assertNull( get( "anotherName", "anotherName", String.class ).apply( map ) );
        Assertions.assertNull( get( null, null, String.class ).apply( map ) );
        Assertions.assertEquals( "Lord", get( null, "preferredName", String.class ).apply( map ) );
        Assertions.assertNull( get( null, "anotherName", String.class ).apply( map ) );
    }

    @Test
    void getWithDefaultKeyShouldRetrieveValueAssociatedWithKeyWhenExistsOtherwiseValueAssociatedWithDefaultKey() {
        getWithDefaultKeyShouldRetrieveValueAssociatedWithKeyWhenExistsOtherwiseValueAssociatedWithDefaultKey( meatballKrishnaPrefLord );
        getWithDefaultKeyShouldRetrieveValueAssociatedWithKeyWhenExistsOtherwiseValueAssociatedWithDefaultKey( hashmapKrishnaPrefLordSupplier.get() );
    }

    @Test
    void getWithDefaultKeyAndNullClassShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> get( "firstName", "defaultName", null ).apply( meatballKrishnaPrefLord ) );
        Assertions.assertThrows( NullPointerException.class, () -> get( "firstName", "defaultName", null ).apply( hashmapKrishnaPrefLordSupplier.get() ) );
    }

    @Test
    void getWithDefaultKeyAndMismatchedClassShouldThrowClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> get( "firstName", "preferredName", Integer.class ).apply( meatballKrishnaPrefLord ) );
        Assertions.assertThrows( ClassCastException.class, () -> get( "firstName", "preferredName", Integer.class ).apply( hashmapKrishnaPrefLordSupplier.get() ) );
        Assertions.assertThrows( ClassCastException.class, () -> get( "anotherName", "preferredName", Integer.class ).apply( meatballKrishnaPrefLord ) );
        Assertions.assertThrows( ClassCastException.class, () -> get( "anotherName", "preferredName", Integer.class ).apply( hashmapKrishnaPrefLordSupplier.get() ) );
    }

    private void getDataStructureMethodsRetrieveDataStructures( Map<String, Object> map ) {
        Assertions.assertEquals( List.of( 1, 2, 3 ), getList( "list", Integer.class ).apply( map ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), getSet( "set", Integer.class ).apply( map ) );
        Assertions.assertEquals( Map.of( "a", 1, "b", 2, "c", 3 ), getMap( "mapWithDiffKeyValueClasses", String.class, Integer.class ).apply( map ) );
        Assertions.assertEquals( Map.of( 1, 1, 2, 2, 3, 3 ), getMap( "mapWithSameKeyValueClasses", Integer.class ).apply( map ) );
        Assertions.assertEquals( List.of( 1, 2, 3 ), getPriorityQueue( "priorityQueue", Integer.class ).apply( map ).stream().toList() );
        Assertions.assertEquals( 1, getArray( "array", Integer.class ).apply( map )[0] );
        Assertions.assertEquals( 2, getArray( "array", Integer.class ).apply( map )[1] );
        Assertions.assertEquals( 3, getArray( "array", Integer.class ).apply( map )[2] );

        Assertions.assertNull( getList( "data", Integer.class ).apply( map ) );
        Assertions.assertNull( getSet( "data", Integer.class ).apply( map ) );
        Assertions.assertNull( getMap( "data", String.class, Integer.class ).apply( map ) );
        Assertions.assertNull( getMap( "data", Integer.class ).apply( map ) );
        Assertions.assertNull( getPriorityQueue( "data", Integer.class ).apply( map ) );
        Assertions.assertNull( getArray( "data", Integer.class ).apply( map ) );
    }

    @Test
    void getDataStructureMethodsRetrieveDataStructures() {
        getDataStructureMethodsRetrieveDataStructures( meatballDataStructures );
        getDataStructureMethodsRetrieveDataStructures( hashmapDataStructuresSupplier.get() );
    }

    private void getClassWithNullOrNonexistentKeyThrowsNullPointerException( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> MapFn.getClass( null ).apply( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> MapFn.getClass( "anotherName" ).apply( map ) );
    }

    @Test
    void getClassWithNullOrNonexistentKeyThrowsNullPointerException() {
        getClassWithNullOrNonexistentKeyThrowsNullPointerException( meatballKrishna );
        getClassWithNullOrNonexistentKeyThrowsNullPointerException( hashmapKrishnaSupplier.get() );
    }

    @Test
    void getClassRetrievesClass() {
        Assertions.assertEquals( String.class, MapFn.getClass( "firstName" ).apply( meatballKrishna ) );
        Assertions.assertEquals( String.class, MapFn.getClass( "firstName" ).apply( hashmapKrishnaSupplier.get() ) );
    }

    private void hasNotReturnsTrueIfKeyDoesNotExist( Map<String, Object> map ) {
        Assertions.assertFalse( hasNot( "firstName" ).test( map ) );
        Assertions.assertTrue( hasNot( "surname" ).test( map ) );
        Assertions.assertTrue( hasNot( null ).test( map ) );
    }

    @Test
    void hasNotReturnsTrueIfKeyDoesNotExist() {
        hasNotReturnsTrueIfKeyDoesNotExist( meatballKrishna );
        hasNotReturnsTrueIfKeyDoesNotExist( hashmapKrishnaSupplier.get() );
    }

    private void hasAllReturnsTrueIfMapHasAllKeys( Map<String, Object> map ) {
        Assertions.assertTrue( hasAll().test( map ) );
        Assertions.assertTrue( hasAll( "firstName" ).test( map ) );
        Assertions.assertTrue( hasAll( "firstName", "preferredName" ).test( map ) );
        Assertions.assertFalse( hasAll( "firstName", "surname", "preferredName" ).test( map ) );
        Assertions.assertFalse( hasAll( (String) null ).test( map ) );
    }

    @Test
    void hasAllReturnsTrueIfMapHasAllKeys() {
        hasAllReturnsTrueIfMapHasAllKeys( meatballKrishnaPrefLord );
        hasAllReturnsTrueIfMapHasAllKeys( hashmapKrishnaPrefLordSupplier.get() );
    }

    private void hasNotAllReturnsFalseIfMapHasAllKeys( Map<String, Object> map ) {
        Assertions.assertFalse( hasNotAll().test( map ) );
        Assertions.assertFalse( hasNotAll( "firstName" ).test( map ) );
        Assertions.assertFalse( hasNotAll( "firstName", "preferredName" ).test( map ) );
        Assertions.assertTrue( hasNotAll( "firstName", "surname", "preferredName" ).test( map ) );
        Assertions.assertTrue( hasNotAll( (String) null ).test( map ) );
    }

    @Test
    void hasNotAllReturnsFalseIfMapHasAllKeys() {
        hasNotAllReturnsFalseIfMapHasAllKeys( meatballKrishnaPrefLord );
        hasNotAllReturnsFalseIfMapHasAllKeys( hashmapKrishnaPrefLordSupplier.get() );
    }

    private void isReturnsTrueIfValueAssociatedWithKeyEqualsValue( Map<String, Object> map ) {
        Assertions.assertFalse( is( "firstName", null ).test( map ) );
        Assertions.assertTrue( is( "firstName", "Krishna" ).test( map ) );
        Assertions.assertFalse( is( "firstName", "Bhavesh" ).test( map ) );
        Assertions.assertFalse( is( "firstName", 42 ).test( map ) );
        Assertions.assertTrue( is( "preferredName", null ).test( map ) );
        Assertions.assertFalse( is( "preferredName", "Krishna" ).test( map ) );
        Assertions.assertFalse( is( "preferredName", 42 ).test( map ) );
        Assertions.assertTrue( is( null, null ).test( map ) );
        Assertions.assertFalse( is( null, "Krishna" ).test( map ) );
        Assertions.assertFalse( is( null, 42 ).test( map ) );
    }

    @Test
    void isReturnsTrueIfValueAssociatedWithKeyEqualsValue() {
        isReturnsTrueIfValueAssociatedWithKeyEqualsValue( meatballKrishna );
        isReturnsTrueIfValueAssociatedWithKeyEqualsValue( hashmapKrishnaSupplier.get() );
    }

    private void isNotReturnsTrueIfValueAssociatedWithKeyDoesNotEqualValue( Map<String, Object> map ) {
        Assertions.assertTrue( isNot( "firstName", null ).test( map ) );
        Assertions.assertFalse( isNot( "firstName", "Krishna" ).test( map ) );
        Assertions.assertTrue( isNot( "firstName", "Bhavesh" ).test( map ) );
        Assertions.assertTrue( isNot( "firstName", 42 ).test( map ) );
        Assertions.assertFalse( isNot( "preferredName", null ).test( map ) );
        Assertions.assertTrue( isNot( "preferredName", "Krishna" ).test( map ) );
        Assertions.assertTrue( isNot( "preferredName", 42 ).test( map ) );
        Assertions.assertFalse( isNot( null, null ).test( map ) );
        Assertions.assertTrue( isNot( null, "Krishna" ).test( map ) );
        Assertions.assertTrue( isNot( null, 42 ).test( map ) );
    }

    @Test
    void isNotReturnsTrueIfValueAssociatedWithKeyDoesNotEqualValue() {
        isNotReturnsTrueIfValueAssociatedWithKeyDoesNotEqualValue( meatballKrishna );
        isNotReturnsTrueIfValueAssociatedWithKeyDoesNotEqualValue( hashmapKrishnaSupplier.get() );
    }

    private void valuesEqualReturnsTrueIfValuesAssociatedWithKeysEqual( Map<String, Object> map ) {
        Assertions.assertFalse( valuesEqual( "firstName", null ).test( map ) );
        Assertions.assertTrue( valuesEqual( "firstName", "preferredName" ).test( map ) );
        Assertions.assertFalse( valuesEqual( "firstName", "surname" ).test( map ) );
        Assertions.assertFalse( valuesEqual( "firstName", "displayName" ).test( map ) );
        Assertions.assertTrue( valuesEqual( "displayName", null ).test( map ) );
        Assertions.assertFalse( valuesEqual( "displayName", "preferredName" ).test( map ) );
        Assertions.assertTrue( valuesEqual( "displayName", "displayName" ).test( map ) );
        Assertions.assertTrue( valuesEqual( null, null ).test( map ) );
        Assertions.assertFalse( valuesEqual( null, "preferredName" ).test( map ) );
        Assertions.assertTrue( valuesEqual( null, "displayName" ).test( map ) );
    }

    @Test
    void valuesEqualReturnsTrueIfValuesAssociatedWithKeysEqual() {
        valuesEqualReturnsTrueIfValuesAssociatedWithKeysEqual( meatballKrishnaPatelPrefKrishna );
        valuesEqualReturnsTrueIfValuesAssociatedWithKeysEqual( hashmapKrishnaPatelPrefKrishnaSupplier.get() );
    }

    private void valuesNotEqualReturnsTrueIfValuesAssociatedWithKeysDoNotEqual( Map<String, Object> map ) {
        Assertions.assertTrue( valuesNotEqual( "firstName", null ).test( map ) );
        Assertions.assertFalse( valuesNotEqual( "firstName", "preferredName" ).test( map ) );
        Assertions.assertTrue( valuesNotEqual( "firstName", "surname" ).test( map ) );
        Assertions.assertTrue( valuesNotEqual( "firstName", "displayName" ).test( map ) );
        Assertions.assertFalse( valuesNotEqual( "displayName", null ).test( map ) );
        Assertions.assertTrue( valuesNotEqual( "displayName", "preferredName" ).test( map ) );
        Assertions.assertFalse( valuesNotEqual( "displayName", "displayName" ).test( map ) );
        Assertions.assertFalse( valuesNotEqual( null, null ).test( map ) );
        Assertions.assertTrue( valuesNotEqual( null, "preferredName" ).test( map ) );
        Assertions.assertFalse( valuesNotEqual( null, "displayName" ).test( map ) );
    }

    @Test
    void valuesNotEqualReturnsTrueIfValuesAssociatedWithKeysDoNotEqual() {
        valuesNotEqualReturnsTrueIfValuesAssociatedWithKeysDoNotEqual( meatballKrishnaPatelPrefKrishna );
        valuesNotEqualReturnsTrueIfValuesAssociatedWithKeysDoNotEqual( hashmapKrishnaPatelPrefKrishnaSupplier.get() );
    }

    private void classesAreWithNullPairsOrClassOrNonexistentKeyThrowsNullPointerException( Map<String, Object> map ) {
        Assertions.assertThrows( NullPointerException.class, () -> classesAre( null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> classesAre( "firstName", null ).test( map ) );
        Assertions.assertThrows( NullPointerException.class, () -> classesAre( "anotherName", String.class ).test( map ) );
    }

    @Test
    void classesAreWithNullPairsOrClassOrNonexistentKeyThrowsNullPointerException() {
        classesAreWithNullPairsOrClassOrNonexistentKeyThrowsNullPointerException( meatballKrishnaPatel );
        classesAreWithNullPairsOrClassOrNonexistentKeyThrowsNullPointerException( hashmapKrishnaPatelSupplier.get() );
    }

    @Test
    void classesAreWithIncompletePairThrowsIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> classesAre( "firstName" ).test( meatballKrishnaPatel ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> classesAre( "firstName" ).test( hashmapKrishnaPatelSupplier.get() ) );
    }

    private void classesAreWithIncorrectKeyOrClassTypeThrowsClassCastException( Map<String, Object> map ) {
        Assertions.assertThrows( ClassCastException.class, () -> classesAre( 5, String.class ).test( map ) );
        Assertions.assertThrows( ClassCastException.class, () -> classesAre( "firstName", 42 ).test( map ) );
    }

    @Test
    void classesAreWithIncorrectKeyOrClassTypeThrowsClassCastException() {
        classesAreWithIncorrectKeyOrClassTypeThrowsClassCastException( meatballKrishnaPatel );
        classesAreWithIncorrectKeyOrClassTypeThrowsClassCastException( hashmapKrishnaPatelSupplier.get() );
    }

    private void classesAreReturnsTrueWhenAllMatchOtherwiseFalse( Map<String, Object> map ) {
        Assertions.assertTrue( classesAre().test( map ) );
        Assertions.assertTrue( classesAre( "firstName", String.class ).test( map ) );
        Assertions.assertTrue( classesAre( "firstName", String.class, "surname", String.class ).test( map ) );
        Assertions.assertFalse( classesAre( "firstName", Integer.class ).test( map ) );
        Assertions.assertFalse( classesAre( "firstName", String.class, "surname", Integer.class ).test( map ) );
    }

    @Test
    void classesAreReturnsTrueWhenAllMatchOtherwiseFalse() {
        classesAreReturnsTrueWhenAllMatchOtherwiseFalse( meatballKrishnaPatel );
        classesAreReturnsTrueWhenAllMatchOtherwiseFalse( hashmapKrishnaPatelSupplier.get() );
    }

    private void inShouldReturnTrueIfValueAssociatedWithKeyIsInValues( Map<String, Object> map ) {
        final var list = new ArrayList<>();
        list.add( null );

        Assertions.assertFalse( in( "firstName", List.of() ).test( map ) );
        Assertions.assertTrue( in( "firstName", List.of( "Krishna" ) ).test( map ) );
        Assertions.assertTrue( in( "firstName", List.of( "Bhavesh", "Krishna" ) ).test( map ) );
        Assertions.assertTrue( in( "firstName", List.of( "Krishna" ) ).test( map ) );
        Assertions.assertFalse( in( "firstName", List.of( "Bhavesh" ) ).test( map ) );
        Assertions.assertTrue( in( "surname", list ).test( map ) );
        Assertions.assertFalse( in( "surname", new ArrayList<>( List.of( "Patel" ) ) ).test( map ) );
        Assertions.assertTrue( in( null, list ).test( map ) );
        Assertions.assertFalse( in( null, new ArrayList<>( List.of( "Patel" ) ) ).test( map ) );
        Assertions.assertFalse( in( "firstName", List.of( 1, 2 ) ).test( map ) );
    }

    @Test
    void inShouldReturnTrueIfValueAssociatedWithKeyIsInValues() {
        inShouldReturnTrueIfValueAssociatedWithKeyIsInValues( meatballKrishna );
        inShouldReturnTrueIfValueAssociatedWithKeyIsInValues( hashmapKrishnaSupplier.get() );
    }

    @Test
    void inWithNullListShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> in( "firstName", (ArrayList<Integer>) null ).test( meatballKrishna ) );
        Assertions.assertThrows( NullPointerException.class, () -> in( "firstName", (ArrayList<Integer>) null ).test( hashmapKrishnaSupplier.get() ) );
    }

    private void notInShouldReturnTrueIfValueAssociatedWithKeyIsNotInValues( Map<String, Object> map ) {
        final var list = new ArrayList<>();
        list.add( null );

        Assertions.assertTrue( notIn( "firstName", List.of() ).test( map ) );
        Assertions.assertFalse( notIn( "firstName", List.of( "Krishna" ) ).test( map ) );
        Assertions.assertFalse( notIn( "firstName", List.of( "Bhavesh", "Krishna" ) ).test( map ) );
        Assertions.assertFalse( notIn( "firstName", List.of( "Krishna" ) ).test( map ) );
        Assertions.assertTrue( notIn( "firstName", List.of( "Bhavesh" ) ).test( map ) );
        Assertions.assertFalse( notIn( "surname", list ).test( map ) );
        Assertions.assertTrue( notIn( "surname", new ArrayList<>( List.of( "Patel" ) ) ).test( map ) );
        Assertions.assertFalse( notIn( null, list ).test( map ) );
        Assertions.assertTrue( notIn( null, new ArrayList<>( List.of( "Patel" ) ) ).test( map ) );
        Assertions.assertTrue( notIn( "firstName", List.of( 1, 2 ) ).test( map ) );
    }

    @Test
    void notInShouldReturnTrueIfValueAssociatedWithKeyIsNotInValues() {
        notInShouldReturnTrueIfValueAssociatedWithKeyIsNotInValues( meatballKrishna );
        notInShouldReturnTrueIfValueAssociatedWithKeyIsNotInValues( hashmapKrishnaSupplier.get() );
    }

    @Test
    void notInWithNullListShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> notIn( "firstName", (ArrayList<Integer>) null ).test( meatballKrishna ) );
        Assertions.assertThrows( NullPointerException.class, () -> notIn( "firstName", (ArrayList<Integer>) null ).test( hashmapKrishnaSupplier.get() ) );
    }

    private void inShouldReturnTrueIfValueAssociatedInKeyIsInCollectionAssociatedWithValuesKey( Map<String, Object> map ) {
        Assertions.assertTrue( in( "firstName", "names" ).test( map ) );
        Assertions.assertFalse( in( "surname", "names" ).test( map ) );
        Assertions.assertFalse( in( null, "names" ).test( map ) );
    }

    @Test
    void inShouldReturnTrueIfValueAssociatedInKeyIsInCollectionAssociatedWithValuesKey() {
        inShouldReturnTrueIfValueAssociatedInKeyIsInCollectionAssociatedWithValuesKey( meatballKrishnaNamesKrishna );
        inShouldReturnTrueIfValueAssociatedInKeyIsInCollectionAssociatedWithValuesKey( hashmapKrishnaNamesKrishaSupplier.get() );
    }

    @Test
    void inWithNonExistentValuesKeyShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> in( "firstName", (String) null ).test( meatballKrishnaNamesKrishna ) );
        Assertions.assertThrows( NullPointerException.class, () -> in( "firstName", "surnames" ).test( meatballKrishnaNamesKrishna ) );
        Assertions.assertThrows( NullPointerException.class, () -> in( "firstName", (String) null ).test( hashmapKrishnaNamesKrishaSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> in( "firstName", "surnames" ).test( hashmapKrishnaNamesKrishaSupplier.get() ) );
    }

    @Test
    void inWithValuesKeyPointingToIncorrectTypeShouldThrowClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> in( "firstName", "firstName" ).test( meatballKrishnaNamesKrishna ) );
        Assertions.assertThrows( ClassCastException.class, () -> in( "firstName", "firstName" ).test( hashmapKrishnaNamesKrishaSupplier.get() ) );
    }

    private void notInShouldReturnTrueIfValueAssociatedInKeyIsNotInCollectionAssociatedWithValuesKey( Map<String, Object> map ) {
        Assertions.assertFalse( notIn( "firstName", "names" ).test( map ) );
        Assertions.assertTrue( notIn( "surname", "names" ).test( map ) );
        Assertions.assertTrue( notIn( null, "names" ).test( map ) );
    }

    @Test
    void notInShouldReturnTrueIfValueAssociatedInKeyIsNotInCollectionAssociatedWithValuesKey() {
        notInShouldReturnTrueIfValueAssociatedInKeyIsNotInCollectionAssociatedWithValuesKey( meatballKrishnaNamesKrishna );
        notInShouldReturnTrueIfValueAssociatedInKeyIsNotInCollectionAssociatedWithValuesKey( hashmapKrishnaNamesKrishaSupplier.get() );
    }

    @Test
    void notInWithNonExistentValuesKeyShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> notIn( "firstName", (String) null ).test( meatballKrishnaNamesKrishna ) );
        Assertions.assertThrows( NullPointerException.class, () -> notIn( "firstName", "surnames" ).test( meatballKrishnaNamesKrishna ) );
        Assertions.assertThrows( NullPointerException.class, () -> notIn( "firstName", (String) null ).test( hashmapKrishnaNamesKrishaSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> notIn( "firstName", "surnames" ).test( hashmapKrishnaNamesKrishaSupplier.get() ) );
    }

    @Test
    void notInWithValuesKeyPointingToIncorrectTypeShouldThrowClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> notIn( "firstName", "firstName" ).test( meatballKrishnaNamesKrishna ) );
        Assertions.assertThrows( ClassCastException.class, () -> notIn( "firstName", "firstName" ).test( hashmapKrishnaNamesKrishaSupplier.get() ) );
    }

    private void toListCreatesListBasedOnMapAndKeys( Map<String, Object> map ) {
        final var list = new ArrayList<Integer>();
        list.add( null );

        Assertions.assertEquals( List.of(), toList( ArrayList.class, Integer.class ).apply( map ) );
        Assertions.assertEquals( List.of( 100 ), toList( ArrayList.class, Integer.class, "apples" ).apply( map ) );
        Assertions.assertEquals( List.of( 100, 200 ), toList( ArrayList.class, Integer.class, "apples", "bananas" ).apply( map ) );
        Assertions.assertEquals( list, toList( ArrayList.class, Integer.class, (String) null ).apply( map ) );
        Assertions.assertEquals( list, toList( ArrayList.class, Integer.class, "oreos" ).apply( map ) );
    }

    @Test
    void toListCreatesListBasedOnMapAndKeys() {
        toListCreatesListBasedOnMapAndKeys( meatballShoppingCart );
        toListCreatesListBasedOnMapAndKeys( hashmapShoppingCartSupplier.get() );
    }

    @Test
    void toListWithNullClassesThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> toList( null, Integer.class, "apples" ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( RuntimeException.class, () -> toList( ArrayList.class, null, "apples" ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( RuntimeException.class, () -> toList( null, Integer.class, "apples" ).apply( hashmapShoppingCartSupplier.get() ) );
        Assertions.assertThrows( RuntimeException.class, () -> toList( ArrayList.class, null, "apples" ).apply( hashmapShoppingCartSupplier.get() ) );
    }

    @Test
    void toListWithMismatchedClassesThrowsClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> toList( ArrayList.class, String.class, "apples" ).apply( meatballShoppingCart ) );
        Assertions.assertThrows( ClassCastException.class, () -> toList( ArrayList.class, String.class, "apples" ).apply( hashmapShoppingCartSupplier.get() ) );
    }

}
