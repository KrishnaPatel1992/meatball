package util.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;

import static util.collections.MapUtil.*;
import static util.collections.MapUtil.createNewHashMapWithoutNulls;

public class MapUtilTest {

    private final Supplier<Map<String, Object>> year1992MapSupplier = () -> {
        final var year1992Map = new HashMap<String, Object>();
        year1992Map.put( "year", 1992 );
        return year1992Map;
    };

    private final Supplier<Map<String, Object>> nameKrishnaYear1992MapSupplier = () -> {
        final var nameKrishnaYear1992Map = new HashMap<String, Object>();
        nameKrishnaYear1992Map.put( "year", 1992 );
        nameKrishnaYear1992Map.put( "name", "Krishna" );
        return nameKrishnaYear1992Map;
    };

    private final Supplier<Map<String, Object>> year1992FoodCheeseDrinkTeaMapSupplier = () -> {
        final var year1992FoodCheeseDrinkTeaMap = new HashMap<String, Object>();
        year1992FoodCheeseDrinkTeaMap.put( "year", 1992 );
        year1992FoodCheeseDrinkTeaMap.put( "food", "Cheese" );
        year1992FoodCheeseDrinkTeaMap.put( "drink", "Tea" );
        return year1992FoodCheeseDrinkTeaMap;
    };

    private final Supplier<Map<String, Object>> year1992DanceNullMapSupplier = () -> {
        final var year1992DanceNullMap = new HashMap<String, Object>();
        year1992DanceNullMap.put( "year", 1992 );
        year1992DanceNullMap.put( "dance", null );
        return year1992DanceNullMap;
    };

    private final Supplier<Map<String, Object>> nullDanceMapSupplier = () -> {
        final var nullDanceMap = new HashMap<String, Object>();
        nullDanceMap.put( null, "dance" );
        return nullDanceMap;
    };

    private final Supplier<Map<String, Object>> nameNullMapSupplier = () -> {
        final var nameNullMap = new HashMap<String, Object>();
        nameNullMap.put( "name", null );
        return nameNullMap;
    };

    private final Supplier<Map<String, Object>> nameKrishnaMapSupplier = () -> new HashMap<>( Map.of( "name", "Krishna" ) );

    private final Supplier<Map<String, Object>> year1992DanceNullNullDanceMapSupplier = () -> {
        final var year1992DanceNullNullDanceMap = new HashMap<String, Object>();
        year1992DanceNullNullDanceMap.put( "year", 1992 );
        year1992DanceNullNullDanceMap.put( "dance", null );
        year1992DanceNullNullDanceMap.put( null, "dance" );
        return year1992DanceNullNullDanceMap;
    };

    @Test
    void createNewMapReturnsNewMapOfSpecifiedType() {
        final var map = createNewMap( HashMap.class );
        Assertions.assertEquals( HashMap.class, map.getClass() );
        Assertions.assertEquals( 0, map.size() );
    }

    @Test
    void createNewMapWithNullValueShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> createNewMap( null ) );
    }

    @Test
    void createNewMapWithClassAndComparatorReturnMapOfSpecifiedType() {
        final var map = (TreeMap<Integer, String>) createNewMap( TreeMap.class, ( a, b ) -> (int) b - (int) a );

        Assertions.assertEquals( TreeMap.class, map.getClass() );
        Assertions.assertEquals( 0, map.size() );

        map.put( 1, "a" );
        map.put( 4, "d" );
        map.put( 2, "b" );
        Assertions.assertEquals( Set.of( 4, 2, 1 ), map.keySet() );
    }

    @Test
    void createNewMapWithClassAndNullComparatorReturnMapOfSpecifiedType() {
        final var map = (TreeMap<Integer, String>) createNewMap( TreeMap.class, null );

        Assertions.assertEquals( TreeMap.class, map.getClass() );
        Assertions.assertEquals( 0, map.size() );

        map.put( 1, "a" );
        map.put( 4, "d" );
        map.put( 2, "b" );
        Assertions.assertEquals( Set.of( 1, 2, 4 ), map.keySet() );
    }

    @Test
    void createNewMapWithNullValueAndComparatorShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> createNewMap( null, ( a, b ) -> (int) b - (int) a ) );
        Assertions.assertThrows( RuntimeException.class, () -> createNewMap( null, null ) );
    }

    @Test
    void createNewMapLikeWithHashMapShouldReturnNewMapOfSameTypeAsInput() {
        final var referenceHashMap = new HashMap<Integer, String>();
        referenceHashMap.put( 1, "a" );
        referenceHashMap.put( 4, "d" );
        referenceHashMap.put( 2, "b" );

        final var map = createNewMapLike( referenceHashMap );

        Assertions.assertEquals( HashMap.class, map.getClass() );
        Assertions.assertEquals( 0, map.size() );
    }

    @Test
    void createNewMapLikeWithTreeMapShouldReturnNewMapOfSameTypeAsInput() {
        final var referenceTreeMap = new TreeMap<Integer, String>( ( a, b ) -> b - a );
        referenceTreeMap.put( 1, "a" );
        referenceTreeMap.put( 4, "d" );
        referenceTreeMap.put( 2, "b" );

        final var map = createNewMapLike( referenceTreeMap );

        Assertions.assertEquals( TreeMap.class, map.getClass() );
        Assertions.assertEquals( 0, map.size() );

        map.put( 9, "a" );
        map.put( 4, "d" );
        map.put( 7, "b" );
        Assertions.assertEquals( Set.of( 9, 7, 4 ), map.keySet() );
    }

    @Test
    void createNewMapLikeWithNullValueShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> createNewMapLike( null ) );
    }

    @Test
    void enrichMapShouldAddAllPairsToMap() {
        final var year1992NullDanceMap = new HashMap<String, Object>();
        year1992NullDanceMap.put( "year", 1992 );
        year1992NullDanceMap.put( null, "dance" );

        Assertions.assertEquals( nameKrishnaYear1992MapSupplier.get(), enrichMap( year1992MapSupplier.get(), "name", "Krishna" ) );
        Assertions.assertEquals( year1992FoodCheeseDrinkTeaMapSupplier.get(), enrichMap( year1992MapSupplier.get(), "food", "Cheese", "drink", "Tea" ) );
        Assertions.assertEquals( year1992DanceNullMapSupplier.get(), enrichMap( year1992MapSupplier.get(), "dance", null ) );
        Assertions.assertEquals( year1992NullDanceMap, enrichMap( year1992MapSupplier.get(), null, "dance" ) );
    }

    @Test
    void enrichMapShouldOverwriteExistingPairs() {
        Assertions.assertEquals( 1980, enrichMap( year1992MapSupplier.get(), "year", 1980 ).get( "year" ) );
    }

    @Test
    void enrichMapWithNullMapShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> enrichMap( null, "hello", "world" ) );
    }

    @Test
    void enrichMapWithIncompletePairShouldThrowIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> enrichMap( year1992MapSupplier.get(), "hello" ) );
    }

    @Test
    void enrichMapWithPairWhereFirstArgumentIsNotStringShouldThrowClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> enrichMap( year1992MapSupplier.get(), 999, "world" ) );
    }

    @Test
    void enrichMapButSkipNullsShouldAddAllPairsToMap() {
        Assertions.assertEquals( nameKrishnaYear1992MapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), "name", "Krishna" ) );
        Assertions.assertEquals( year1992FoodCheeseDrinkTeaMapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), "food", "Cheese", "drink", "Tea" ) );
        Assertions.assertEquals( year1992MapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( nameKrishnaYear1992MapSupplier.get(), "name", null ) );
        Assertions.assertEquals( year1992MapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), null, "dance" ) );
    }

    @Test
    void enrichMapButSkipNullsShouldOverwriteExistingPairs() {
        Assertions.assertEquals( 1980, enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), "year", 1980 ).get( "year" ) );
    }

    @Test
    void enrichMapButSkipNullsWithNullMapShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> enrichMapButSkipNullKeysAndFilterNewNulls( null, "hello", "world" ) );
    }

    @Test
    void enrichMapButSkipNullsWithIncompletePairShouldThrowIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), "hello" ) );
    }

    @Test
    void enrichMapButSkipNullsWithPairWhereFirstArgumentIsNotStringShouldThrowClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), 999, "world" ) );
    }

    @Test
    void enrichMapButSkipNullsShouldDoSo() {
        Assertions.assertEquals( nameKrishnaYear1992MapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), nameKrishnaMapSupplier.get() ) );
        Assertions.assertEquals( year1992FoodCheeseDrinkTeaMapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), Map.of( "food", "Cheese", "drink", "Tea" ) ) );
        Assertions.assertEquals( year1992MapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( nameKrishnaYear1992MapSupplier.get(), nameNullMapSupplier.get() ) );
        Assertions.assertEquals( year1992MapSupplier.get(), enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), nullDanceMapSupplier.get() ) );
    }

    @Test
    void enrichMapButSkipNullsWithNullMapsOrPairsShouldThrowNullPointerExceptions() {
        Assertions.assertThrows( NullPointerException.class, () -> enrichMapButSkipNullKeysAndFilterNewNulls( null, nameKrishnaMapSupplier.get() ) );
        Assertions.assertThrows( NullPointerException.class, () -> enrichMapButSkipNullKeysAndFilterNewNulls( year1992MapSupplier.get(), (HashMap<String, Object>) null ) );
    }

    @Test
    void copyAllShouldCopyFromFirstMemberToSecondMember() {
        final var expectedNameNullFirstNameNullMap = new HashMap<String, Object>();
        expectedNameNullFirstNameNullMap.put( "name", null );
        expectedNameNullFirstNameNullMap.put( "firstName", null );

        final var expectedYear1992Null1992Map = new HashMap<String, Object>();
        expectedYear1992Null1992Map.put( "year", 1992 );
        expectedYear1992Null1992Map.put( null, 1992 );

        final var expectedNullDanceActivityDanceMap = new HashMap<String, Object>();
        expectedNullDanceActivityDanceMap.put( null, "dance" );
        expectedNullDanceActivityDanceMap.put( "activity", "dance" );

        Assertions.assertEquals( Map.of( "year", 1992, "date", 1992 ), copyAll( year1992MapSupplier.get(), "year", "date" ) );
        Assertions.assertEquals( Map.of( "year", 1992, "date", 1992, "age", 1992 ), copyAll( year1992MapSupplier.get(), "year", "date", "date", "age", "age", "year" ) );
        Assertions.assertEquals( expectedNameNullFirstNameNullMap, copyAll( nameNullMapSupplier.get(), "name", "firstName" ) );
        Assertions.assertEquals( expectedYear1992Null1992Map, copyAll( year1992MapSupplier.get(), "year", null ) );
        Assertions.assertEquals( expectedNullDanceActivityDanceMap, copyAll( nullDanceMapSupplier.get(), null, "activity" ) );
    }

    @Test
    void copyAllWhereFirstMemberDoesNotExistShouldTreatValueAsNull() {
        final var year1992NameNullMap = new HashMap<String, Object>();
        year1992NameNullMap.put( "year", 1992 );
        year1992NameNullMap.put( "name", null );

        Assertions.assertEquals( year1992NameNullMap, copyAll( nameKrishnaYear1992MapSupplier.get(), "food", "name" ) );
    }

    @Test
    void copyAllWithNullMapShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> copyAll( null, "year", "date" ) );
    }

    @Test
    void copyAllWithIncompletePairShouldThrowIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> copyAll( year1992MapSupplier.get(), "year" ) );
    }

    @Test
    void copyAllWhereFirstAndSecondKeyAreSameShouldHaveNoEffect() {
        Assertions.assertEquals( year1992MapSupplier.get(), copyAll( year1992MapSupplier.get(), "year", "year" ) );
    }

    @Test
    void renameAllShouldRenameAllSpecifiedKeys() {
        final var null1992Map = new HashMap<>();
        null1992Map.put( null, 1992 );

        Assertions.assertEquals( Map.of( "date", 1992 ), renameAll( year1992MapSupplier.get(), "year", "date" ) );
        Assertions.assertEquals( Map.of( "date", 1992, "firstName", "Krishna" ), renameAll( nameKrishnaYear1992MapSupplier.get(), "year", "date", "name", "firstName" ) );
        Assertions.assertEquals( null1992Map, renameAll( year1992MapSupplier.get(), "year", null ) );
        Assertions.assertEquals( Map.of( "activity", "dance" ), renameAll( nullDanceMapSupplier.get(), null, "activity" ) );
    }

    @Test
    void renameAllWhereFirstMemberDoesNotExistShouldTreatValueAsNull() {
        Assertions.assertEquals( year1992DanceNullMapSupplier.get(), renameAll( year1992MapSupplier.get(), "age", "dance" ) );
    }

    @Test
    void renameAllWithNullMapShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> renameAll( null, "year", "date" ) );
    }

    @Test
    void renameAllWithIncompletePairShouldThrowIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> renameAll( year1992MapSupplier.get(), "year" ) );
    }

    @Test
    void renameAllWhereFirstAndSecondKeyAreSameShouldHaveNoEffect() {
        Assertions.assertEquals( year1992MapSupplier.get(), renameAll( year1992MapSupplier.get(), "year", "year" ) );
    }

    @Test
    void createNewMapWithoutNullsShouldDoSo() {
        final var map = year1992DanceNullNullDanceMapSupplier.get();
        Assertions.assertEquals( year1992MapSupplier.get(), createNewHashMapWithoutNulls( map ) );
        Assertions.assertEquals( year1992DanceNullNullDanceMapSupplier.get(), map );
    }

    @Test
    void createNewMapWithoutNullsAppliedToEmptyMapShouldReturnEmpty() {
        Assertions.assertTrue( createNewHashMapWithoutNulls( new HashMap<String, Integer>() ).isEmpty() );
    }

    @Test
    void createNewMapWithoutNullsAppliedToNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> createNewHashMapWithoutNulls( null ) );
    }

    @Test
    void removeNullKeysAndValuesShouldDoSo() {
        final var map = year1992DanceNullNullDanceMapSupplier.get();
        removeNullKeysAndValues( map );
        Assertions.assertEquals( year1992MapSupplier.get(), map );
    }

    @Test
    void removeNullKeysAndValuesAppliedToEmptyMapShouldReturnEmpty() {
        Assertions.assertEquals( 0, removeNullKeysAndValues( new HashMap<String, Integer>() ).size() );
    }

    @Test
    void removeNullKeysAndValuesAppliedToNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> removeNullKeysAndValues( null ) );
    }

    @Test
    void classesAreWithNullMapOrPairsOrClassOrNonexistentKeyThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> classesAre( null, "year", Integer.class ) );
        Assertions.assertThrows( NullPointerException.class, () -> classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), null ) );
        Assertions.assertThrows( NullPointerException.class, () -> classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "year", null ) );
        Assertions.assertThrows( NullPointerException.class, () -> classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "date", Integer.class ) );
    }

    @Test
    void classesAreWithIncompletePairThrowsIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "year" ) );
    }

    @Test
    void classesAreWithIncorrectKeyOrClassTypeThrowsClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), 5, String.class ) );
        Assertions.assertThrows( ClassCastException.class, () -> classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "year", 42 ) );
    }

    @Test
    void classesAreReturnsTrueWhenAllMatchOtherwiseFalse() {
        Assertions.assertTrue( classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get() ) );
        Assertions.assertTrue( classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "year", Integer.class ) );
        Assertions.assertTrue( classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "year", Integer.class, "food", String.class ) );
        Assertions.assertFalse( classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "year", String.class ) );
        Assertions.assertFalse( classesAre( year1992FoodCheeseDrinkTeaMapSupplier.get(), "year", Integer.class, "food", Integer.class ) );
        Assertions.assertTrue( classesAre( nullDanceMapSupplier.get(), null, String.class ) );
    }

}
