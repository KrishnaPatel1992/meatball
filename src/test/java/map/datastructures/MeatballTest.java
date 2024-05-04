package map.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class MeatballTest {

    private final Meatball lettuceBaconMeatball = new Meatball( "numLettuce", 4, "numBacon", 8 );
    private final Meatball lettuceBaconTomatoCheeseMeatball = new Meatball( "numLettuce", 4, "numBacon", 8, "numTomato", 16, "numCheese", 32 );
    private final Meatball temperaturesMeatball = new Meatball( "temperatures", new ArrayList<>( List.of( 1, 2, 3 ) ) );
    private final Meatball helloWorldMeatball = new Meatball( "hello", "world" );

    @Test
    void emptyConstructorCreatesEmptyMeatball() {
        Assertions.assertEquals( 0, new Meatball().size() );
    }

    @Test
    void constructorWithEmptyMapShouldCreateEmptyMeatball() {
        final var map = new HashMap<String, Object>();
        Assertions.assertEquals( 0, new Meatball( map ).size() );
    }

    @Test
    void constructorWithMapOfSupportedTypesShouldCreateNewMeatballAndSkipNulls() {
        final var map = new HashMap<String, ArrayList<Integer>>();
        map.put( "x", new ArrayList<>( List.of( 1, 2, 3 ) ) );
        map.put( "y", null );
        map.put( null, new ArrayList<>( List.of( 4, 5, 6 ) ) );

        final var meatball = new Meatball( map );
        map.get( "x" ).set( 2, 4 );

        Assertions.assertEquals( 3, map.size() );
        Assertions.assertEquals( List.of( 1, 2, 4 ), map.get( "x" ) );
        Assertions.assertNull( map.get( "y" ) );
        Assertions.assertEquals( List.of( 4, 5, 6 ), map.get( null ) );

        Assertions.assertEquals( 1, meatball.size() );
        Assertions.assertEquals( List.of( 1, 2, 3 ), meatball.get( "x" ) );
    }

    @Test
    void constructorWithMapShouldSupportImmutableMaps() {
        Assertions.assertEquals( 1, new Meatball( Map.of( "hello", 1 ) ).get( "hello" ) );
        Assertions.assertEquals( 1, new Meatball( new Meatball( Map.of( "hello", 1 ) ) ).get( "hello" ) );
    }

    @Test
    void constructorWithMapAppliedToUnsupportedTypesShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> new Meatball( Map.of( "test", new Random() ) ) );
    }

    @Test
    void constructorWithMapAppliedToNullShouldCreateEmptyMeatball() {
        final HashMap<String, Object> test = null;
        Assertions.assertEquals( 0, new Meatball( test ).size() );
    }

    @Test
    void constructorWithKeyValuePairsCreatesMeatballAndSkipsNulls() {
        final var twoPairs = new Meatball( "hello", "world", "HELLO", 1 );
        final var withNulls = new Meatball( "hello", "world", "HELLO", "WORLD", "HELLO", null, null, "WORLD" );

        Assertions.assertEquals( 1, helloWorldMeatball.size() );
        Assertions.assertEquals( "world", helloWorldMeatball.get( "hello" ) );

        Assertions.assertEquals( 2, twoPairs.size() );
        Assertions.assertEquals( "world", twoPairs.get( "hello" ) );
        Assertions.assertEquals( 1, twoPairs.get( "HELLO" ) );

        Assertions.assertEquals( 1, withNulls.size() );
        Assertions.assertEquals( "world", withNulls.get( "hello" ) );
    }

    @Test
    void constructorWithKeyValuePairsAppliedToBrokenPairThrowsIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> new Meatball( "hello" ) );
    }

    @Test
    void constructorWithKeyValuePairsAppliedToNonStringKeyThrowsClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> new Meatball( 1, "hello" ) );
    }

    @Test
    void constructorWithKeyValuePairsAppliedToUnsupportedValueTypeThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> new Meatball( "hello", new Random() ) );
    }

    @Test
    void enrichAllWithKeyValuePairsShouldEnrichMeatballAndSkipNulls() {

        final var meatball = new Meatball( "food", "Onions" );
        final var meatballEnrichedWithOnePair = meatball.enrichAll( "drink", "Milkshake" );
        final var meatballEnrichedWithMultiplePairs = meatball.enrichAll( "drink", "Juice", "shoes", "Trainers" );
        final var meatballEnrichedWithNulls = meatball.enrichAll( "food", null, null, "Chicken", "drink", "Tea" );

        Assertions.assertEquals( 1, meatball.enrichAll().size() );
        Assertions.assertEquals( "Onions", meatball.enrichAll().getString( "food" ) );

        Assertions.assertEquals( 1, meatball.size() );
        Assertions.assertEquals( "Onions", meatball.getString( "food" ) );

        Assertions.assertEquals( 2, meatballEnrichedWithOnePair.size() );
        Assertions.assertEquals( "Onions", meatballEnrichedWithOnePair.getString( "food" ) );
        Assertions.assertEquals( "Milkshake", meatballEnrichedWithOnePair.getString( "drink" ) );

        Assertions.assertEquals( 3, meatballEnrichedWithMultiplePairs.size() );
        Assertions.assertEquals( "Onions", meatballEnrichedWithMultiplePairs.getString( "food" ) );
        Assertions.assertEquals( "Juice", meatballEnrichedWithMultiplePairs.getString( "drink" ) );
        Assertions.assertEquals( "Trainers", meatballEnrichedWithMultiplePairs.getString( "shoes" ) );

        Assertions.assertEquals( 1, meatballEnrichedWithNulls.size() );
        Assertions.assertEquals( "Tea", meatballEnrichedWithNulls.getString( "drink" ) );
    }

    @Test
    void enrichAllWithKeyValuePairsAppliedToBrokenPairThrowsIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> new Meatball().enrichAll( "hello" ) );
    }

    @Test
    void enrichAllWithKeyValuePairsAppliedToNonStringKeyThrowsClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> new Meatball().enrichAll( 1, "hello" ) );
    }

    @Test
    void enrichAllWithKeyValuePairsAppliedToUnsupportedValueTypeThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> new Meatball().enrichAll( "hello", new Random() ) );
    }

    @Test
    void enrichAllWithMapShouldReturnEnrichedMeatballAndSkippedNulls() {

        final var meatball = new Meatball( "food", "Onions" );

        final var hashMapWithNulls = new HashMap<String, Object>();
        hashMapWithNulls.put( "food", null );
        hashMapWithNulls.put( null, "Chicken" );
        hashMapWithNulls.put( "drink", "Tea" );

        final var meatballEnrichedWithOnePair = meatball.enrichAll( Map.of( "drink", "Milkshake" ) );
        final var meatballEnrichedWithMultiplePairs = meatball.enrichAll( Map.of( "drink", "Juice", "shoes", "Trainers" ) );
        final var meatballEnrichedWithNulls = meatball.enrichAll( hashMapWithNulls );

        Assertions.assertEquals( 1, meatball.enrichAll( new HashMap<>() ).size() );
        Assertions.assertEquals( "Onions", meatball.enrichAll( new HashMap<>() ).getString( "food" ) );

        Assertions.assertEquals( 1, meatball.size() );
        Assertions.assertEquals( "Onions", meatball.getString( "food" ) );

        Assertions.assertEquals( 2, meatballEnrichedWithOnePair.size() );
        Assertions.assertEquals( "Onions", meatballEnrichedWithOnePair.getString( "food" ) );
        Assertions.assertEquals( "Milkshake", meatballEnrichedWithOnePair.getString( "drink" ) );

        Assertions.assertEquals( 3, meatballEnrichedWithMultiplePairs.size() );
        Assertions.assertEquals( "Onions", meatballEnrichedWithMultiplePairs.getString( "food" ) );
        Assertions.assertEquals( "Juice", meatballEnrichedWithMultiplePairs.getString( "drink" ) );
        Assertions.assertEquals( "Trainers", meatballEnrichedWithMultiplePairs.getString( "shoes" ) );

        Assertions.assertEquals( 1, meatballEnrichedWithNulls.size() );
        Assertions.assertEquals( "Tea", meatballEnrichedWithNulls.getString( "drink" ) );
    }

    @Test
    void enrichAllWithNullMapShouldThrowNullPointerException() {
        final HashMap<String, Object> nullMap = null;
        Assertions.assertThrows( NullPointerException.class, () -> new Meatball().enrichAll( nullMap ) );
    }

    @Test
    void enrichAllWithMapAppliedToUnsupportedTypeShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> new Meatball().enrichAll( Map.of( "hello", new Random() ) ) );
    }

    @Test
    void copyAllShouldReturnEnrichedMeatballWithSecondKeyAssociatedWithFirstKeysValue() {

        final var meatBallWithOnePairCopied = lettuceBaconMeatball.copyAll( "numBacon", "numTomato" );
        final var meatBallWithMultiplePairCopied = lettuceBaconMeatball.copyAll( "numBacon", "numCheese", "numLettuce", "numBread" );
        final var meatballWithCopyOverwrite = lettuceBaconMeatball.copyAll( "numLettuce", "numBacon" );
        final var meatballWhereFirstKeyDoesNotExist = lettuceBaconMeatball.copyAll( "numChicken", "numLettuce" );
        final var meatballWhereKeysAreSame = lettuceBaconMeatball.copyAll( "numLettuce", "numLettuce" );
        final var meatballWhereFirstKeyIsNull = lettuceBaconMeatball.copyAll( null, "numLettuce" );
        final var meatballWhereSecondKeyIsNull = lettuceBaconMeatball.copyAll( "numLettuce", null );

        Assertions.assertEquals( 2, lettuceBaconMeatball.size() );
        Assertions.assertEquals( 4, lettuceBaconMeatball.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, lettuceBaconMeatball.getInteger( "numBacon" ) );

        Assertions.assertEquals( 3, meatBallWithOnePairCopied.size() );
        Assertions.assertEquals( 4, meatBallWithOnePairCopied.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatBallWithOnePairCopied.getInteger( "numBacon" ) );
        Assertions.assertEquals( 8, meatBallWithOnePairCopied.getInteger( "numTomato" ) );

        Assertions.assertEquals( 4, meatBallWithMultiplePairCopied.size() );
        Assertions.assertEquals( 4, meatBallWithMultiplePairCopied.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatBallWithMultiplePairCopied.getInteger( "numBacon" ) );
        Assertions.assertEquals( 8, meatBallWithMultiplePairCopied.getInteger( "numCheese" ) );
        Assertions.assertEquals( 4, meatBallWithMultiplePairCopied.getInteger( "numBread" ) );

        Assertions.assertEquals( 2, meatballWithCopyOverwrite.size() );
        Assertions.assertEquals( 4, meatballWithCopyOverwrite.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 4, meatballWithCopyOverwrite.getInteger( "numBacon" ) );

        Assertions.assertEquals( 2, meatballWhereKeysAreSame.size() );
        Assertions.assertEquals( 4, meatballWhereKeysAreSame.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatballWhereKeysAreSame.getInteger( "numBacon" ) );

        Assertions.assertEquals( 1, meatballWhereFirstKeyDoesNotExist.size() );
        Assertions.assertEquals( 8, meatballWhereFirstKeyDoesNotExist.getInteger( "numBacon" ) );

        Assertions.assertEquals( 1, meatballWhereFirstKeyIsNull.size() );
        Assertions.assertEquals( 8, meatballWhereFirstKeyIsNull.getInteger( "numBacon" ) );

        Assertions.assertEquals( 2, meatballWhereSecondKeyIsNull.size() );
        Assertions.assertEquals( 4, meatballWhereSecondKeyIsNull.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatballWhereSecondKeyIsNull.getInteger( "numBacon" ) );
    }

    @Test
    void copyAllWithNoInputShouldReturnEquivalentMeatball() {
        final var copiedAll = lettuceBaconMeatball.copyAll();

        Assertions.assertEquals( 2, copiedAll.size() );
        Assertions.assertEquals( 4, copiedAll.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, copiedAll.getInteger( "numBacon" ) );
    }

    @Test
    void copyAllWithBrokenPairShouldReturnIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> lettuceBaconMeatball.copyAll( "numLettuce" ) );
    }

    @Test
    void renameAllShouldReturnAMeatballWithRenamedKeys() {

        final var meatballWithOnePair = lettuceBaconMeatball.renameAll( "numLettuce", "numTomato" );
        final var meatballWithMultiplePairs = lettuceBaconMeatball.renameAll( "numLettuce", "numTomato", "numBacon", "numCheese" );
        final var meatballWithOverwrite = lettuceBaconMeatball.renameAll( "numLettuce", "numBacon" );
        final var meatballWhereFirstKeyDoesNotExist = lettuceBaconMeatball.renameAll( "numFruit", "numLemons" );
        final var meatballWhereKeysAreSame = lettuceBaconMeatball.renameAll( "numBacon", "numBacon" );
        final var meatballWhereFirstKeyIsNull = lettuceBaconMeatball.renameAll( null, "numBacon" );
        final var meatballWhereSecondKeyIsNull = lettuceBaconMeatball.renameAll( "numBacon", null );

        Assertions.assertEquals( 2, lettuceBaconMeatball.size() );
        Assertions.assertEquals( 4, lettuceBaconMeatball.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, lettuceBaconMeatball.getInteger( "numBacon" ) );

        Assertions.assertEquals( 2, meatballWithOnePair.size() );
        Assertions.assertEquals( 4, meatballWithOnePair.getInteger( "numTomato" ) );
        Assertions.assertEquals( 8, meatballWithOnePair.getInteger( "numBacon" ) );

        Assertions.assertEquals( 2, meatballWithMultiplePairs.size() );
        Assertions.assertEquals( 4, meatballWithMultiplePairs.getInteger( "numTomato" ) );
        Assertions.assertEquals( 8, meatballWithMultiplePairs.getInteger( "numCheese" ) );

        Assertions.assertEquals( 1, meatballWithOverwrite.size() );
        Assertions.assertEquals( 4, meatballWithOverwrite.getInteger( "numBacon" ) );

        Assertions.assertEquals( 2, meatballWhereFirstKeyDoesNotExist.size() );
        Assertions.assertEquals( 4, meatballWhereFirstKeyDoesNotExist.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatballWhereFirstKeyDoesNotExist.getInteger( "numBacon" ) );

        Assertions.assertEquals( 2, meatballWhereKeysAreSame.size() );
        Assertions.assertEquals( 4, meatballWhereKeysAreSame.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatballWhereKeysAreSame.getInteger( "numBacon" ) );

        Assertions.assertEquals( 1, meatballWhereFirstKeyIsNull.size() );
        Assertions.assertEquals( 4, meatballWhereFirstKeyIsNull.getInteger( "numLettuce" ) );

        Assertions.assertEquals( 1, meatballWhereSecondKeyIsNull.size() );
        Assertions.assertEquals( 4, meatballWhereSecondKeyIsNull.getInteger( "numLettuce" ) );
    }

    @Test
    void renameAllAppliedToNoInputReturnsEquivalentMeatball() {
        final var renameAll = lettuceBaconMeatball.renameAll();

        Assertions.assertEquals( 2, renameAll.size() );
        Assertions.assertEquals( 4, renameAll.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, renameAll.getInteger( "numBacon" ) );
    }

    @Test
    void renameAllAppliedToBrokenPairShouldThrowIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> helloWorldMeatball.renameAll( "hello" ) );
    }

    @Test
    void discardAllShouldDiscardSelectedKeys() {

        final var meatballWithDiscardOne = lettuceBaconTomatoCheeseMeatball.discardAll( "numLettuce" );
        final var meatballWithDiscardMultiple = lettuceBaconTomatoCheeseMeatball.discardAll( "numLettuce", "numBacon" );
        final var meatballWithKeyThatDoesNotExist = lettuceBaconTomatoCheeseMeatball.discardAll( "numCucumber" );
        final var meatballWithNullKey = lettuceBaconTomatoCheeseMeatball.discardAll( (String) null );

        Assertions.assertEquals( 4, lettuceBaconTomatoCheeseMeatball.size() );
        Assertions.assertEquals( 4, lettuceBaconTomatoCheeseMeatball.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, lettuceBaconTomatoCheeseMeatball.getInteger( "numBacon" ) );
        Assertions.assertEquals( 16, lettuceBaconTomatoCheeseMeatball.getInteger( "numTomato" ) );
        Assertions.assertEquals( 32, lettuceBaconTomatoCheeseMeatball.getInteger( "numCheese" ) );

        Assertions.assertEquals( 3, meatballWithDiscardOne.size() );
        Assertions.assertEquals( 8, meatballWithDiscardOne.getInteger( "numBacon" ) );
        Assertions.assertEquals( 16, meatballWithDiscardOne.getInteger( "numTomato" ) );
        Assertions.assertEquals( 32, meatballWithDiscardOne.getInteger( "numCheese" ) );

        Assertions.assertEquals( 2, meatballWithDiscardMultiple.size() );
        Assertions.assertEquals( 16, meatballWithDiscardMultiple.getInteger( "numTomato" ) );
        Assertions.assertEquals( 32, meatballWithDiscardMultiple.getInteger( "numCheese" ) );

        Assertions.assertEquals( 4, meatballWithKeyThatDoesNotExist.size() );
        Assertions.assertEquals( 4, meatballWithKeyThatDoesNotExist.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatballWithKeyThatDoesNotExist.getInteger( "numBacon" ) );
        Assertions.assertEquals( 16, meatballWithKeyThatDoesNotExist.getInteger( "numTomato" ) );
        Assertions.assertEquals( 32, meatballWithKeyThatDoesNotExist.getInteger( "numCheese" ) );

        Assertions.assertEquals( 4, meatballWithNullKey.size() );
        Assertions.assertEquals( 4, meatballWithNullKey.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatballWithNullKey.getInteger( "numBacon" ) );
        Assertions.assertEquals( 16, meatballWithNullKey.getInteger( "numTomato" ) );
        Assertions.assertEquals( 32, meatballWithNullKey.getInteger( "numCheese" ) );
    }

    @Test
    void discardAllWithNoInputShouldReturnEmptyMap() {
        final var discardedMeatball = lettuceBaconMeatball.discardAll();

        Assertions.assertEquals( 2, lettuceBaconMeatball.size() );
        Assertions.assertEquals( 4, lettuceBaconMeatball.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, lettuceBaconMeatball.getInteger( "numBacon" ) );

        Assertions.assertEquals( 0, discardedMeatball.size() );
    }

    @Test
    void keepAllShouldKeepSelectedKeys() {
        final var meatballWithKeepOne = lettuceBaconTomatoCheeseMeatball.keepAll( "numLettuce" );
        final var meatballWithKeepMultiple = lettuceBaconTomatoCheeseMeatball.keepAll( "numLettuce", "numBacon" );
        final var meatballWithKeyThatDoesNotExist = lettuceBaconTomatoCheeseMeatball.keepAll( "numLettuce", "numCucumber" );
        final var meatballWithNullKey = lettuceBaconTomatoCheeseMeatball.keepAll( "numLettuce", null );

        Assertions.assertEquals( 4, lettuceBaconTomatoCheeseMeatball.size() );
        Assertions.assertEquals( 4, lettuceBaconTomatoCheeseMeatball.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, lettuceBaconTomatoCheeseMeatball.getInteger( "numBacon" ) );
        Assertions.assertEquals( 16, lettuceBaconTomatoCheeseMeatball.getInteger( "numTomato" ) );
        Assertions.assertEquals( 32, lettuceBaconTomatoCheeseMeatball.getInteger( "numCheese" ) );

        Assertions.assertEquals( 1, meatballWithKeepOne.size() );
        Assertions.assertEquals( 4, meatballWithKeepOne.getInteger( "numLettuce" ) );

        Assertions.assertEquals( 2, meatballWithKeepMultiple.size() );
        Assertions.assertEquals( 4, meatballWithKeepMultiple.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, meatballWithKeepMultiple.getInteger( "numBacon" ) );

        Assertions.assertEquals( 1, meatballWithKeyThatDoesNotExist.size() );
        Assertions.assertEquals( 4, meatballWithKeyThatDoesNotExist.getInteger( "numLettuce" ) );

        Assertions.assertEquals( 1, meatballWithNullKey.size() );
        Assertions.assertEquals( 4, meatballWithNullKey.getInteger( "numLettuce" ) );
    }

    @Test
    void keepAllWithNoInputShouldReturnEmptyMap() {
        final var keptMeatball = lettuceBaconMeatball.keepAll();

        Assertions.assertEquals( 2, lettuceBaconMeatball.size() );
        Assertions.assertEquals( 4, lettuceBaconMeatball.getInteger( "numLettuce" ) );
        Assertions.assertEquals( 8, lettuceBaconMeatball.getInteger( "numBacon" ) );

        Assertions.assertEquals( 0, keptMeatball.size() );
    }

    @Test
    void getShouldRetrieveValueForKey() {
        ((ArrayList<Integer>) temperaturesMeatball.get( "temperatures" )).add( 4 );

        Assertions.assertEquals( List.of( 1, 2, 3 ), temperaturesMeatball.get( "temperatures" ) );
        Assertions.assertNull( temperaturesMeatball.get( "measurements" ) );
        Assertions.assertNull( temperaturesMeatball.get( null ) );
        Assertions.assertNull( temperaturesMeatball.get( 42 ) );
    }

    @Test
    void getWithClazzShouldRetrieveValueForKey() {
        temperaturesMeatball.get( "temperatures", ArrayList.class ).add( 4 );

        Assertions.assertEquals( List.of( 1, 2, 3 ), temperaturesMeatball.get( "temperatures", ArrayList.class ) );
        Assertions.assertNull( temperaturesMeatball.get( "measurements", ArrayList.class ) );
        Assertions.assertNull( temperaturesMeatball.get( null, ArrayList.class ) );
    }

    @Test
    void getWithNullClazzShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> temperaturesMeatball.get( "temperatures", null ) );
    }

    @Test
    void getWithMismatchClazzShouldThrowClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> temperaturesMeatball.get( "temperatures", Long.class ) );
    }

    @Test
    void getWithDefaultShouldRetrieveValueForKeyIfPresentOtherwiseDefaultValue() {
        ArrayList<Integer> nullValue = null;

        temperaturesMeatball.get( "temperatures", new ArrayList<>() ).add( 4 );

        Assertions.assertEquals( List.of( 1, 2, 3 ), temperaturesMeatball.get( "temperatures", new ArrayList<>() ) );
        Assertions.assertEquals( List.of(), temperaturesMeatball.get( "measurements", new ArrayList<>() ) );
        Assertions.assertEquals( List.of(), temperaturesMeatball.get( null, new ArrayList<>() ) );

        Assertions.assertEquals( List.of( 1, 2, 3 ), temperaturesMeatball.get( "temperatures", nullValue ) );
        Assertions.assertNull( temperaturesMeatball.get( "measurements", nullValue ) );
        Assertions.assertNull( temperaturesMeatball.get( null, nullValue ) );
    }

    @Test
    void getWithDefaultShouldThrowClassCastExceptionIfDefaultValueTypeDoesNotMatchKeyType() {
        Assertions.assertThrows( ClassCastException.class, () -> { final var temperatures = temperaturesMeatball.get( "temperatures", 42 ); } );
    }

    @Test
    void getShortShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", (short) 42 );

        Assertions.assertEquals( (short) 42, meatball.getShort( "numBurgers" ) );
        Assertions.assertNull( meatball.getShort( "numPizzas" ) );
        Assertions.assertNull( meatball.getShort( null ) );
    }

    @Test
    void getIntegerShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", 42 );

        Assertions.assertEquals( 42, meatball.getInteger( "numBurgers" ) );
        Assertions.assertNull( meatball.getInteger( "numPizzas" ) );
        Assertions.assertNull( meatball.getInteger( null ) );
    }

    @Test
    void getLongShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", 42L );

        Assertions.assertEquals( 42L, meatball.getLong( "numBurgers" ) );
        Assertions.assertNull( meatball.getLong( "numPizzas" ) );
        Assertions.assertNull( meatball.getLong( null ) );
    }

    @Test
    void getFloatShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", 42.0F );

        Assertions.assertEquals( 42.0F, meatball.getFloat( "numBurgers" ) );
        Assertions.assertNull( meatball.getFloat( "numPizzas" ) );
        Assertions.assertNull( meatball.getFloat( null ) );
    }

    @Test
    void getDoubleShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", 42.0 );

        Assertions.assertEquals( 42.0, meatball.getDouble( "numBurgers" ) );
        Assertions.assertNull( meatball.getDouble( "numPizzas" ) );
        Assertions.assertNull( meatball.getDouble( null ) );
    }

    @Test
    void getBooleanShouldReturnValue() {
        final var meatball = new Meatball( "hasBurgers", true );

        Assertions.assertEquals( true, meatball.getBoolean( "hasBurgers" ) );
        Assertions.assertNull( meatball.getBoolean( "numPizzas" ) );
        Assertions.assertNull( meatball.getBoolean( null ) );
    }

    @Test
    void getCharacterShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", '4' );

        Assertions.assertEquals( '4', meatball.getCharacter( "numBurgers" ) );
        Assertions.assertNull( meatball.getCharacter( "numPizzas" ) );
        Assertions.assertNull( meatball.getCharacter( null ) );
    }

    @Test
    void getStringShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", "42" );

        Assertions.assertEquals( "42", meatball.getString( "numBurgers" ) );
        Assertions.assertNull( meatball.getString( "numPizzas" ) );
        Assertions.assertNull( meatball.getString( null ) );
    }

    @Test
    void getByteShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", Byte.parseByte( "4" ) );

        Assertions.assertEquals( Byte.parseByte( "4" ), meatball.getByte( "numBurgers" ) );
        Assertions.assertNull( meatball.getByte( "numPizzas" ) );
        Assertions.assertNull( meatball.getByte( null ) );
    }

    @Test
    void getBigIntegerShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", new BigInteger( "42" ) );

        Assertions.assertEquals( new BigInteger( "42" ), meatball.getBigInteger( "numBurgers" ) );
        Assertions.assertNull( meatball.getBigInteger( "numPizzas" ) );
        Assertions.assertNull( meatball.getBigInteger( null ) );
    }

    @Test
    void getBigDecimalShouldReturnValue() {
        final var meatball = new Meatball( "numBurgers", new BigDecimal( "42" ) );

        Assertions.assertEquals( new BigDecimal( "42" ), meatball.getBigDecimal( "numBurgers" ) );
        Assertions.assertNull( meatball.getBigDecimal( "numPizzas" ) );
        Assertions.assertNull( meatball.getBigDecimal( null ) );
    }

    @Test
    void getListShouldReturnList() {
        Assertions.assertEquals( List.of( 1, 2, 3 ), temperaturesMeatball.getList( "temperatures", Integer.class ) );
        Assertions.assertNull( temperaturesMeatball.getList( "pizzas", Integer.class ) );
        Assertions.assertNull( temperaturesMeatball.getList( null, Integer.class ) );
    }

    @Test
    void getListWithNullClassThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> temperaturesMeatball.getList( "temperatures", null ) );
    }

    @Test
    void getListWithNonMatchingClassThrowsClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> {
            final var x = temperaturesMeatball.getList( "temperatures", Boolean.class ).get( 0 ) && false;
        } );
    }

    @Test
    void getSetShouldReturnSet() {
        final var meatball = new Meatball( "burgers", new HashSet<>( List.of( 4, 5, 6 ) ) );

        Assertions.assertEquals( Set.of( 4, 5, 6 ), meatball.getSet( "burgers", Integer.class ) );
        Assertions.assertNull( meatball.getSet( "pizzas", Integer.class ) );
        Assertions.assertNull( meatball.getSet( null, Integer.class ) );
    }

    @Test
    void getSetWithNullClassThrowsNullPointerException() {
        final var meatball = new Meatball( "burgers", new HashSet<>( List.of( 4, 5, 6 ) ) );
        Assertions.assertThrows( NullPointerException.class, () -> meatball.getSet( "burgers", null ) );
    }

    @Test
    void getSetWithNonMatchingClassThrowsClassCastException() {
        final var meatball = new Meatball( "burgers", new HashSet<>( List.of( 4, 5, 6 ) ) );
        Assertions.assertThrows( ClassCastException.class, () -> { final var x = meatball.getSet( "burgers", Boolean.class ).iterator().next(); } );
    }

    @Test
    void getMapShouldReturnMap() {
        final var meatball = new Meatball( "burgers", new HashMap<>( Map.of( "lettuce", 5, "tomato", 7 ) ) );

        Assertions.assertEquals( Map.of( "lettuce", 5, "tomato", 7 ), meatball.getMap( "burgers", String.class, Integer.class ) );
        Assertions.assertNull( meatball.getMap( "pizzas", String.class, Integer.class ) );
        Assertions.assertNull( meatball.getMap( null, String.class, Integer.class ) );
    }

    @Test
    void getMapWithNullClassThrowsNullPointerException() {
        final var meatball = new Meatball( "burgers", new HashMap<>( Map.of( "lettuce", 5, "tomato", 7 ) ) );

        Assertions.assertThrows( NullPointerException.class, () -> meatball.getMap( "burgers", null, Integer.class ) );
        Assertions.assertThrows( NullPointerException.class, () -> meatball.getMap( "burgers", String.class, null ) );
    }

    @Test
    void getMapWithNonMatchingClassThrowsClassCastException() {
        final var meatball = new Meatball( "burgers", new HashMap<>( Map.of( "lettuce", 5, "tomato", 7 ) ) );

        Assertions.assertThrows( ClassCastException.class, () -> { final var x = meatball.getMap( "burgers", String.class, Boolean.class ).values().iterator().next(); } );
        Assertions.assertThrows( ClassCastException.class, () -> { final var x = meatball.getMap( "burgers", Boolean.class, Integer.class ).keySet().iterator().next(); } );
    }

    @Test
    void getMapWithOneClassShouldReturnMap() {
        final var meatball = new Meatball( "burgers", new HashMap<>( Map.of( 4, 5, 6, 7 ) ) );

        Assertions.assertEquals( Map.of( 4, 5, 6, 7 ), meatball.getMap( "burgers", Integer.class ) );
        Assertions.assertNull( meatball.getMap( "pizzas", Integer.class ) );
        Assertions.assertNull( meatball.getMap( null, Integer.class ) );
    }

    @Test
    void getMapWithOneNullClassThrowsNullPointerException() {
        final var meatball = new Meatball( "burgers", new HashMap<>( Map.of( 4, 5, 6, 7 ) ) );
        Assertions.assertThrows( NullPointerException.class, () -> meatball.getMap( "burgers", null ) );
    }

    @Test
    void getMapWithOneNonMatchingClassThrowsClassCastException() {
        final var meatballKeys = new Meatball( "burgers", new HashMap<>( Map.of( "4", 5, "6", 7 ) ) );
        final var meatballValues = new Meatball( "burgers", new HashMap<>( Map.of( 4, "5", 6, "7" ) ) );

        Assertions.assertThrows( ClassCastException.class, () -> { final var x = meatballKeys.getMap( "burgers", Integer.class ).keySet().iterator().next(); } );
        Assertions.assertThrows( ClassCastException.class, () -> { final var x = meatballValues.getMap( "burgers", Integer.class ).values().iterator().next(); } );
    }

    @Test
    void getPriorityQueueShouldReturnPriorityQueue() {
        final var meatball = new Meatball( "burgers", new PriorityQueue<>( List.of( 4, 5, 6 ) ) );

        Assertions.assertEquals( List.of( 4, 5, 6 ), meatball.getPriorityQueue( "burgers", Integer.class ).stream().toList() );
        Assertions.assertNull( meatball.getPriorityQueue( "pizzas", Integer.class ) );
        Assertions.assertNull( meatball.getPriorityQueue( null, Integer.class ) );
    }

    @Test
    void getPriorityQueueWithNullClassThrowsNullPointerException() {
        final var meatball = new Meatball( "burgers", new PriorityQueue<>( List.of( 4, 5, 6 ) ) );
        Assertions.assertThrows( NullPointerException.class, () -> meatball.getPriorityQueue( "burgers", null ) );
    }

    @Test
    void getPriorityQueueWithNonMatchingClassThrowsClassCastException() {
        final var meatball = new Meatball( "burgers", new PriorityQueue<>( List.of( 4, 5, 6 ) ) );
        Assertions.assertThrows( ClassCastException.class, () -> { final var x = meatball.getPriorityQueue( "burgers", Boolean.class ).iterator().next(); } );
    }

    @Test
    void getArrayShouldReturnArray() {
        final var meatball = new Meatball( "burgers", new Integer[]{ 4, 5, 6 } );

        Assertions.assertEquals( List.of( 4, 5, 6 ), Arrays.stream( meatball.getArray( "burgers", Integer.class ) ).toList() );
        Assertions.assertNull( meatball.getArray( "pizzas", Integer.class ) );
        Assertions.assertNull( meatball.getArray( null, Integer.class ) );
    }

    @Test
    void getArrayWithNullClassThrowsNullPointerException() {
        final var meatball = new Meatball( "burgers", new int[]{ 4, 5, 6 } );
        Assertions.assertThrows( NullPointerException.class, () -> meatball.getArray( "burgers", null ) );
    }

    @Test
    void getArrayWithNonMatchingClassThrowsClassCastException() {
        final var meatball = new Meatball( "burgers", new int[]{ 4, 5, 6 } );
        Assertions.assertThrows( ClassCastException.class, () -> { final var x = meatball.getArray( "burgers", Boolean.class )[0]; } );
    }

    @Test
    void getClassWithNullOrNonexistentKeyThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> lettuceBaconMeatball.getClass( null ) );
        Assertions.assertThrows( NullPointerException.class, () -> lettuceBaconMeatball.getClass( "numTomato" ) );
    }

    @Test
    void getClassRetrievesClass() {
        Assertions.assertEquals( Integer.class, lettuceBaconMeatball.getClass( "numBacon" ) );
    }

    @Test
    void keySetReturnsKeys() {
        lettuceBaconMeatball.keySet().remove( "numBacon" );
        Assertions.assertEquals( Set.of( "numLettuce", "numBacon" ), lettuceBaconMeatball.keySet() );
    }

    @Test
    void valuesReturnsValues() {
        ((ArrayList<Integer>) temperaturesMeatball.values().stream().toList().get( 0 )).add( 7 );
        Assertions.assertEquals( List.of( List.of( 1, 2, 3 ) ), temperaturesMeatball.values() );
    }

    @Test
    void entrySetReturnsEntrySet() {
        ((ArrayList<Integer>) temperaturesMeatball.entrySet().iterator().next().getValue()).add( 7 );
        Assertions.assertEquals( List.of( 1, 2, 3 ), temperaturesMeatball.entrySet().iterator().next().getValue() );
    }

    @Test
    void sizeReturnsSize() {
        Assertions.assertEquals( 2, lettuceBaconMeatball.size() );
    }

    @Test
    void isEmptyReturnsTrueIfEmptyOrOtherwiseFalse() {
        final var emptyMeatball = new Meatball();
        Assertions.assertFalse( lettuceBaconMeatball.isEmpty() );
        Assertions.assertTrue( emptyMeatball.isEmpty() );
    }

    @Test
    void containsKeyReturnsTrueIfHasKeyOtherwiseReturnsFalse() {
        Assertions.assertTrue( lettuceBaconMeatball.containsKey( "numLettuce" ) );
        Assertions.assertFalse( lettuceBaconMeatball.containsKey( "coffee" ) );
        Assertions.assertFalse( lettuceBaconMeatball.containsKey( null ) );
        Assertions.assertFalse( lettuceBaconMeatball.containsKey( 42 ) );
    }

    @Test
    void containsKeysReturnsTrueIfHasAllKeysOtherwiseReturnsFalse() {
        Assertions.assertTrue( lettuceBaconMeatball.containsKeys( "numLettuce" ) );
        Assertions.assertTrue( lettuceBaconMeatball.containsKeys( "numLettuce", "numBacon" ) );
        Assertions.assertFalse( lettuceBaconMeatball.containsKeys( "coffee", "numBacon" ) );
        Assertions.assertFalse( lettuceBaconMeatball.containsKeys( "numLettuce", "numBacon", null ) );
        Assertions.assertTrue( lettuceBaconMeatball.containsKeys() );
    }

    @Test
    void containsValueReturnsTrueIfHasValueOtherwiseReturnsFalse() {
        Assertions.assertTrue( lettuceBaconMeatball.containsValue( 4 ) );
        Assertions.assertFalse( lettuceBaconMeatball.containsValue( 69 ) );
        Assertions.assertFalse( lettuceBaconMeatball.containsValue( null ) );
    }

    @Test
    void isReturnsTrueIfEqualOtherwiseReturnsFalse() {
        Assertions.assertTrue( lettuceBaconMeatball.is( "numLettuce", 4 ) );
        Assertions.assertFalse( lettuceBaconMeatball.is( "numLettuce", 69 ) );
        Assertions.assertFalse( lettuceBaconMeatball.is( "numLettuce", null ) );

        Assertions.assertFalse( lettuceBaconMeatball.is( "coffee", 4 ) );
        Assertions.assertTrue( lettuceBaconMeatball.is( "coffee", null ) );

        Assertions.assertFalse( lettuceBaconMeatball.is( null, 4 ) );
        Assertions.assertTrue( lettuceBaconMeatball.is( null, null ) );

        Assertions.assertFalse( lettuceBaconMeatball.is( "numLettuce", "onions" ) );
    }

    @Test
    void classesAreWithNullPairsOrClassOrNonexistentKeyThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> lettuceBaconMeatball.classesAre( null ) );
        Assertions.assertThrows( NullPointerException.class, () -> lettuceBaconMeatball.classesAre( "numLettuce", null ) );
        Assertions.assertThrows( NullPointerException.class, () -> lettuceBaconMeatball.classesAre( "numTomato", Integer.class ) );
    }

    @Test
    void classesAreWithIncompletePairThrowsIllegalArgumentException() {
        Assertions.assertThrows( IllegalArgumentException.class, () -> lettuceBaconMeatball.classesAre( "numBacon" ) );
    }

    @Test
    void classesAreWithIncorrectKeyOrClassTypeThrowsClassCastException() {
        Assertions.assertThrows( ClassCastException.class, () -> lettuceBaconMeatball.classesAre( 5, Integer.class ) );
        Assertions.assertThrows( ClassCastException.class, () -> lettuceBaconMeatball.classesAre( "numBacon", 42 ) );
    }

    @Test
    void classesAreReturnsTrueWhenAllMatchOtherwiseFalse() {
        Assertions.assertTrue( lettuceBaconMeatball.classesAre() );
        Assertions.assertTrue( lettuceBaconMeatball.classesAre( "numLettuce", Integer.class ) );
        Assertions.assertTrue( lettuceBaconMeatball.classesAre( "numLettuce", Integer.class, "numBacon", Integer.class ) );
        Assertions.assertFalse( lettuceBaconMeatball.classesAre( "numLettuce", String.class ) );
        Assertions.assertFalse( lettuceBaconMeatball.classesAre( "numLettuce", Integer.class, "numBacon", String.class ) );
    }

    @Test
    void classIsWithNullClassOrNonexistentKeyThrowsNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> lettuceBaconMeatball.classIs( "numLettuce", null ) );
        Assertions.assertThrows( NullPointerException.class, () -> lettuceBaconMeatball.classIs( "numTomato", Integer.class ) );
    }

    @Test
    void classIsReturnsTrueWhenMatchesOtherwiseFalse() {
        Assertions.assertTrue( lettuceBaconMeatball.classIs( "numLettuce", Integer.class ) );
        Assertions.assertFalse( lettuceBaconMeatball.classIs( "numLettuce", String.class ) );
    }

    @Test
    void inReturnsTrueIfKeyIsInValuesOtherwiseReturnsFalse() {
        final var meatball = new Meatball( "colour", "red" );
        final var collectionWithNull = new ArrayList<Integer>();
        collectionWithNull.add( null );

        Assertions.assertTrue( meatball.in( "colour", List.of( "blue", "green", "red" ) ) );
        Assertions.assertFalse( meatball.in( "colour", List.of( "blue", "green" ) ) );

        Assertions.assertTrue( meatball.in( "car", collectionWithNull ) );
        Assertions.assertFalse( meatball.in( "car", new ArrayList<>( List.of( "blue", "green" ) ) ) );

        Assertions.assertTrue( meatball.in( null, collectionWithNull ) );
        Assertions.assertFalse( meatball.in( null, new ArrayList<>( List.of( "blue", "green" ) ) ) );

        Assertions.assertFalse( meatball.in( "colour", List.of( 1, 2, 3 ) ) );
    }

    @Test
    void inWithNullCollectionThrowsNullPointerException() {
        final var meatball = new Meatball( "colour", "red" );
        Assertions.assertThrows( NullPointerException.class, () -> meatball.in( "colour", null ) );
    }

    @Test
    void valuesEqualReturnsTrueWhenValuesEqualOrOtherwiseFalse() {
        final var meatball = new Meatball( "numBurgers", 1, "numFries", 1, "numDrinks", 2, "chocolates", true );

        Assertions.assertTrue( meatball.valuesEqual( "numBurgers", "numFries" ) );
        Assertions.assertFalse( meatball.valuesEqual( "numBurgers", "numDrinks" ) );

        Assertions.assertFalse( meatball.valuesEqual( "numCookies", "numFries" ) );
        Assertions.assertFalse( meatball.valuesEqual( "numFries", "numCookies" ) );

        Assertions.assertFalse( meatball.valuesEqual( null, "numFries" ) );
        Assertions.assertTrue( meatball.valuesEqual( null, "numCookies" ) );
        Assertions.assertFalse( meatball.valuesEqual( "numFries", null ) );
        Assertions.assertTrue( meatball.valuesEqual( "numCookies", null ) );
        Assertions.assertTrue( meatball.valuesEqual( null, null ) );

        Assertions.assertFalse( meatball.valuesEqual( "numFries", "chocolates" ) );
    }

    @Test
    void toStringReturnsStringRepresentation() {
        Assertions.assertEquals( "{pies=1980}", new Meatball( "pies", 1980 ).toString() );
    }

    @Test
    void equalsReturnsTrueIfEqualsOtherwiseFalse() {
        final var matchingMeatball = new Meatball( "hello", "world" );
        final var nonMatchingMeatball = new Meatball( "bye", "planet" );

        Assertions.assertFalse( helloWorldMeatball.equals( null ) );
        Assertions.assertTrue( helloWorldMeatball.equals( helloWorldMeatball ) );

        Assertions.assertTrue( helloWorldMeatball.equals( matchingMeatball ) );
        Assertions.assertFalse( helloWorldMeatball.equals( nonMatchingMeatball ) );

        Assertions.assertFalse( helloWorldMeatball.equals( new Random() ) );
    }

    @Test
    void toJsonReturnsJsonRepresentation() {
        Assertions.assertEquals( "{\"hello\":\"world\"}", helloWorldMeatball.toJson() );
    }

    @Test
    void fromJsonCreatesMeatballBasedOnJson() {
        Assertions.assertEquals( helloWorldMeatball, Meatball.fromJson( "{\"hello\":\"world\"}" ) );
    }

    @Test
    void fromJsonThrowsRuntimeExceptionWhenProvidedJsonIsNotSuitableForMeatball() {
        Assertions.assertThrows( RuntimeException.class, () -> Meatball.fromJson( null ) );
        Assertions.assertThrows( RuntimeException.class, () -> Meatball.fromJson( "{42" ) );
        Assertions.assertThrows( RuntimeException.class, () -> Meatball.fromJson( "[42]" ) );
    }

}
