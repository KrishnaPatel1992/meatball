package util.cloning;

import map.datastructures.Meatball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static util.cloning.CloningUtil.deepClone;

public class CloningUtilTest {

    @Test
    void deepCloneWithShortReturnsDeepClone() {
        short shortPrimitiveVal = 1;
        short shortPrimitiveClone = deepClone( shortPrimitiveVal );
        shortPrimitiveVal = 2;
        Assertions.assertNotEquals( shortPrimitiveVal, shortPrimitiveClone );

        Short shortVal = 1;
        Short shortClone = deepClone( shortVal );
        shortVal = 2;
        Assertions.assertNotEquals( shortVal, shortClone );
    }

    @Test
    void deepCloneWithIntegerReturnsDeepClone() {
        int intVal = 1;
        int intClone = deepClone( intVal );
        intVal = 2;
        Assertions.assertNotEquals( intVal, intClone );

        Integer integerVal = 1;
        Integer integerClone = deepClone( integerVal );
        integerVal = 2;
        Assertions.assertNotEquals( integerVal, integerClone );
    }

    @Test
    void deepCloneWithLongReturnsDeepClone() {
        long longPrimitiveVal = 1L;
        long longPrimitiveClone = deepClone( longPrimitiveVal );
        longPrimitiveVal = 2L;
        Assertions.assertNotEquals( longPrimitiveVal, longPrimitiveClone );

        Long longVal = 1L;
        Long longClone = deepClone( longVal );
        longVal = 2L;
        Assertions.assertNotEquals( longVal, longClone );
    }

    @Test
    void deepCloneWithFloatReturnsDeepClone() {
        float floatPrimitiveVal = 1f;
        float floatPrimitiveClone = deepClone( floatPrimitiveVal );
        floatPrimitiveVal = 2f;
        Assertions.assertNotEquals( floatPrimitiveVal, floatPrimitiveClone );

        Float floatVal = 1f;
        Float floatClone = deepClone( floatVal );
        floatVal = 2f;
        Assertions.assertNotEquals( floatVal, floatClone );
    }

    @Test
    void deepCloneWithDoubleReturnsDeepClone() {
        double doublePrimitiveVal = 1.0;
        double doublePrimitiveClone = deepClone( doublePrimitiveVal );
        doublePrimitiveVal = 2.0;
        Assertions.assertNotEquals( doublePrimitiveVal, doublePrimitiveClone );

        Double doubleVal = 1.0;
        Double doubleClone = deepClone( doubleVal );
        doubleVal = 2.0;
        Assertions.assertNotEquals( doubleVal, doubleClone );
    }

    @Test
    void deepCloneWithBooleanReturnsDeepClone() {
        boolean booleanPrimitiveVal = true;
        boolean booleanPrimitiveClone = deepClone( booleanPrimitiveVal );
        booleanPrimitiveVal = false;
        Assertions.assertNotEquals( booleanPrimitiveVal, booleanPrimitiveClone );

        Boolean booleanVal = true;
        Boolean booleanClone = deepClone( booleanVal );
        booleanVal = false;
        Assertions.assertNotEquals( booleanVal, booleanClone );
    }

    @Test
    void deepCloneWithCharacterReturnsDeepClone() {
        char charVal = 'x';
        char charClone = deepClone( charVal );
        charVal = 'y';
        Assertions.assertNotEquals( charVal, charClone );

        Character characterVal = 'x';
        Character characterClone = deepClone( characterVal );
        characterVal = 'y';
        Assertions.assertNotEquals( characterVal, characterClone );
    }

    @Test
    void deepCloneWithStringReturnsDeepClone() {
        String stringVal = "chicken";
        String stringClone = deepClone( stringVal );
        stringVal = "lamb";
        Assertions.assertNotEquals( stringVal, stringClone );
    }

    @Test
    void deepCloneWithByteReturnsDeepClone() {
        byte bytePrimitiveVal = Byte.parseByte( "1" );
        byte bytePrimitiveClone = deepClone( bytePrimitiveVal );
        bytePrimitiveVal = Byte.parseByte( "2" );
        Assertions.assertNotEquals( bytePrimitiveVal, bytePrimitiveClone );

        Byte byteVal = Byte.parseByte( "1" );
        Byte byteClone = deepClone( byteVal );
        byteVal = Byte.parseByte( "2" );
        Assertions.assertNotEquals( byteVal, byteClone );
    }

    @Test
    void deepCloneWithBigIntegerReturnsDeepClone() {
        BigInteger bigIntegerVal = new BigInteger( "1992" );
        BigInteger bigIntegerClone = deepClone( bigIntegerVal );
        bigIntegerVal = bigIntegerVal.add( new BigInteger( "8" ) );
        Assertions.assertNotEquals( bigIntegerVal, bigIntegerClone );
    }

    @Test
    void deepCloneWithBigDecimalReturnsDeepClone() {
        BigDecimal bigDecimalVal = new BigDecimal( "1992" );
        BigDecimal bigDecimalClone = deepClone( bigDecimalVal );
        bigDecimalVal = bigDecimalVal.add( new BigDecimal( "8" ) );
        Assertions.assertNotEquals( bigDecimalVal, bigDecimalClone );
    }

    @Test
    void deepCloneWithListReturnsDeepClone() {
        ArrayList<Integer> arrayListVal = new ArrayList<>( List.of( 1, 2, 3 ) );
        ArrayList<Integer> arrayListClone = deepClone( arrayListVal );
        arrayListVal.remove( 0 );
        Assertions.assertNotEquals( arrayListVal, arrayListClone );
    }

    @Test
    void deepCloneWithSetReturnsDeepClone() {
        TreeSet<Integer> treeSetVal = new TreeSet<>( ( a, b ) -> b - a );
        treeSetVal.addAll( Set.of( 1, 2, 3 ) );
        TreeSet<Integer> treeSetClone = deepClone( treeSetVal );
        treeSetVal.remove( 2 );
        Assertions.assertNotEquals( treeSetVal, treeSetClone );
    }

    @Test
    void deepCloneWithPriorityQueueReturnsDeepClone() {
        PriorityQueue<Integer> priorityQueueVal = new PriorityQueue<>( ( a, b ) -> b - a );
        priorityQueueVal.addAll( List.of( 1, 2, 3 ) );
        PriorityQueue<Integer> priorityQueueClone = deepClone( priorityQueueVal );
        priorityQueueVal.remove( 2 );
        Assertions.assertNotEquals( priorityQueueVal, priorityQueueClone );
    }

    @Test
    void deepCloneWithMapReturnsDeepClone() {
        TreeMap<Integer, String> mapVal = new TreeMap<>( ( a, b ) -> b - a );
        mapVal.put( 2, "b" );
        mapVal.put( 1, "a" );
        mapVal.put( 3, "c" );
        TreeMap<Integer, String> mapClone = deepClone( mapVal );
        mapVal.put( 1, "x" );

        Assertions.assertNotEquals( mapVal, mapClone );
    }

    @Test
    void deepCloneWithShortArrayReturnsDeepClone() {
        short[] shortPrimitiveArrayVal = new short[]{ 1, 2, 3 };
        short[] shortPrimitiveArrayClone = deepClone( shortPrimitiveArrayVal );
        shortPrimitiveArrayVal[1] = 6;
        Assertions.assertNotEquals( shortPrimitiveArrayVal[1], shortPrimitiveArrayClone[1] );

        Short[] shortArrayVal = new Short[]{ 1, 2, 3 };
        Short[] shortArrayClone = deepClone( shortArrayVal );
        shortArrayVal[1] = 6;
        Assertions.assertNotEquals( shortArrayVal[1], shortArrayClone[1] );
    }

    @Test
    void deepCloneWithIntegerArrayReturnsDeepClone() {
        int[] intArrayVal = new int[]{ 1, 2, 3 };
        int[] intArrayClone = deepClone( intArrayVal );
        intArrayVal[1] = 6;
        Assertions.assertNotEquals( intArrayVal[1], intArrayClone[1] );

        Integer[] integerArrayVal = new Integer[]{ 1, 2, 3 };
        Integer[] integerArrayClone = deepClone( integerArrayVal );
        integerArrayVal[1] = 6;
        Assertions.assertNotEquals( integerArrayVal[1], integerArrayClone[1] );
    }

    @Test
    void deepCloneWithLongArrayReturnsDeepClone() {
        long[] longPrimitiveArrayVal = new long[]{ 1L, 2L, 3L };
        long[] longPrimitiveArrayClone = deepClone( longPrimitiveArrayVal );
        longPrimitiveArrayVal[1] = 6L;
        Assertions.assertNotEquals( longPrimitiveArrayVal[1], longPrimitiveArrayClone[1] );

        Long[] longArrayVal = new Long[]{ 1L, 2L, 3L };
        Long[] longArrayClone = deepClone( longArrayVal );
        longArrayVal[1] = 6L;
        Assertions.assertNotEquals( longArrayVal[1], longArrayClone[1] );
    }

    @Test
    void deepCloneWithFloatArrayReturnsDeepClone() {
        float[] floatPrimitiveArrayVal = new float[]{ 1.0F, 2.0F, 3.0F };
        float[] floatPrimitiveArrayClone = deepClone( floatPrimitiveArrayVal );
        floatPrimitiveArrayVal[1] = 6.0F;
        Assertions.assertNotEquals( floatPrimitiveArrayVal[1], floatPrimitiveArrayClone[1] );

        Float[] floatArrayVal = new Float[]{ 1.0F, 2.0F, 3.0F };
        Float[] floatArrayClone = deepClone( floatArrayVal );
        floatArrayVal[1] = 6.0F;
        Assertions.assertNotEquals( floatArrayVal[1], floatArrayClone[1] );
    }

    @Test
    void deepCloneWithDoubleArrayReturnsDeepClone() {
        double[] doublePrimitiveArrayVal = new double[]{ 1.0, 2.0, 3.0 };
        double[] doublePrimitiveArrayClone = deepClone( doublePrimitiveArrayVal );
        doublePrimitiveArrayVal[1] = 6.0;
        Assertions.assertNotEquals( doublePrimitiveArrayVal[1], doublePrimitiveArrayClone[1] );

        Double[] doubleArrayVal = new Double[]{ 1.0, 2.0, 3.0 };
        Double[] doubleArrayClone = deepClone( doubleArrayVal );
        doubleArrayVal[1] = 6.0;
        Assertions.assertNotEquals( doubleArrayVal[1], doubleArrayClone[1] );
    }

    @Test
    void deepCloneWithBooleanArrayReturnsDeepClone() {
        boolean[] booleanPrimitiveArrayVal = new boolean[]{ true, true, true };
        boolean[] booleanPrimitiveArrayClone = deepClone( booleanPrimitiveArrayVal );
        booleanPrimitiveArrayVal[1] = false;
        Assertions.assertNotEquals( booleanPrimitiveArrayVal[1], booleanPrimitiveArrayClone[1] );

        Boolean[] booleanArrayVal = new Boolean[]{ true, true, true };
        Boolean[] booleanArrayClone = deepClone( booleanArrayVal );
        booleanArrayVal[1] = false;
        Assertions.assertNotEquals( booleanArrayVal[1], booleanArrayClone[1] );
    }

    @Test
    void deepCloneWithCharacterArrayReturnsDeepClone() {
        char[] charPrimitiveArrayVal = new char[]{ 'x', 'y', 'z' };
        char[] charPrimitiveArrayClone = deepClone( charPrimitiveArrayVal );
        charPrimitiveArrayVal[1] = 'p';
        Assertions.assertNotEquals( charPrimitiveArrayVal[1], charPrimitiveArrayClone[1] );

        Character[] charArrayVal = new Character[]{ 'x', 'y', 'z' };
        Character[] charArrayClone = deepClone( charArrayVal );
        charArrayVal[1] = 'p';
        Assertions.assertNotEquals( charArrayVal[1], charArrayClone[1] );
    }

    @Test
    void deepCloneWithByteArrayReturnsDeepClone() {
        byte[] bytePrimitiveArrayVal = new byte[]{ Byte.parseByte( "1" ), Byte.parseByte( "2" ), Byte.parseByte( "3" ) };
        byte[] bytePrimitiveArrayClone = deepClone( bytePrimitiveArrayVal );
        bytePrimitiveArrayVal[1] = Byte.parseByte( "6" );
        Assertions.assertNotEquals( bytePrimitiveArrayVal[1], bytePrimitiveArrayClone[1] );

        Byte[] byteArrayVal = new Byte[]{ Byte.parseByte( "1" ), Byte.parseByte( "2" ), Byte.parseByte( "3" ) };
        Byte[] byteArrayClone = deepClone( byteArrayVal );
        byteArrayVal[1] = Byte.parseByte( "6" );
        Assertions.assertNotEquals( byteArrayVal[1], byteArrayClone[1] );
    }

    @Test
    void deepCloneToleratesThePresenceOfNulls() {
        Assertions.assertNull( deepClone( null ) );

        final var listVal = new ArrayList<>( List.of( 1, 2 ) );
        listVal.add( null );
        Assertions.assertEquals( listVal, deepClone( listVal ) );

        final var setVal = new HashSet<>( Set.of( 1, 2 ) );
        setVal.add( null );
        Assertions.assertEquals( setVal, deepClone( setVal ) );

        final var mapVal = new HashMap<>( Map.of( 1, 1, 3, 3 ) );
        mapVal.put( null, null );
        Assertions.assertEquals( mapVal, deepClone( mapVal ) );

        final var arrayVal = new Integer[]{ 1, null, 3 };
        final var arrayClone = deepClone( arrayVal );
        Assertions.assertTrue( arrayClone[0] == 1 && arrayClone[1] == null && arrayClone[2] == 3 );
    }

    @Test
    void deepCloneSupportsRecursion() {
        final var priorityQueueVal = new PriorityQueue<HashSet<String>>( Comparator.comparingInt( Set::size ) );
        priorityQueueVal.offer( new HashSet<>( Set.of( "a", "b" ) ) );
        final var listVal = new ArrayList<>( List.of( new HashMap<>( Map.of( 1, priorityQueueVal ) ) ) );
        final var listClone = deepClone( listVal );
        Assertions.assertTrue( Objects.requireNonNull( listClone.get( 0 ).get( 1 ).poll() ).contains( "a" ) );

        final var arrayVal = new HashSet[]{ new HashSet<>( Set.of( "c", "d" ) ) };
        final var arrayClone = deepClone( arrayVal );
        Assertions.assertTrue( arrayClone[0].contains( "d" ) );
    }

    @Test
    void deepCloneOfUnsupportedTypeThrowsRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> deepClone( new Random() ) );
    }

    @Test
    void deepCloneSupportsUnmodifiableCollections() {
        Assertions.assertEquals( List.of( 1, 2, 3 ), deepClone( List.of( 1, 2, 3 ) ) );
        Assertions.assertEquals( Set.of( 1, 2, 3 ), deepClone( Set.of( 1, 2, 3 ) ) );
        Assertions.assertEquals( Map.of( 1, 2, 3, 4 ), deepClone( Map.of( 1, 2, 3, 4 ) ) );
    }

    @Test
    void deepCloneSupportsMeatball() {
        final var meatballVal = new Meatball( Map.of( "test", new ArrayList<>( List.of( 1, 2, 3 ) ) ) );
        final var clonedMeatball = deepClone( meatballVal );
        meatballVal.getList( "test", Integer.class ).set( 2, 4 );
        Assertions.assertEquals( List.of( 1, 2, 3 ), clonedMeatball.getList( "test", Integer.class ) );
        Assertions.assertEquals( List.of( 1, 2, 3 ), meatballVal.getList( "test", Integer.class ) );
    }

}
