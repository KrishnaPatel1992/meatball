package util.cloning;

import map.datastructures.Meatball;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static util.collections.ListUtil.createNewList;
import static util.collections.MapUtil.createNewMapLike;
import static util.collections.SetUtil.createNewSetLike;

public class CloningUtil {

    private final static HashSet<Class<?>> supportedValueTypes = new HashSet<>( Set.of( Short.class, Integer.class, Long.class, Float.class, Double.class, Boolean.class, Character.class, String.class, Byte.class, BigInteger.class, BigDecimal.class ) );

    private static <T> T deepCloneValue( T value, Class<? extends T> objectClass ) {
        if ( value instanceof Short || value instanceof Integer || value instanceof Long || value instanceof Float || value instanceof Double || value instanceof Boolean || value instanceof Character || value instanceof String || value instanceof Byte )
            return objectClass.cast( value );
        else if ( value instanceof BigInteger )
            return objectClass.cast( new BigInteger( value.toString() ) );
        else if ( value instanceof BigDecimal )
            return objectClass.cast( new BigDecimal( value.toString() ) );
        else
            throw new UnsupportedOperationException( "Unsupported Type." );
    }

    private static <T> T deepClone( T object, Class<? extends T> objectClass ) throws Exception {
        if ( supportedValueTypes.contains( objectClass ) )
            return deepCloneValue( object, objectClass );
        else if ( List.class.isAssignableFrom( objectClass ) )
            return objectClass.cast( deepCloneList( (List<?>) object ) );
        else if ( Set.class.isAssignableFrom( objectClass ) )
            return objectClass.cast( deepCloneSet( (Set<?>) object ) );
        else if ( Map.class.isAssignableFrom( objectClass ) )
            return objectClass.cast( deepCloneMap( (Map<?, ?>) object ) );
        else if ( PriorityQueue.class.isAssignableFrom( objectClass ) )
            return objectClass.cast( deepClonePriorityQueue( (PriorityQueue<?>) object ) );
        else if ( objectClass.isArray() )
            return objectClass.cast( deepCloneArray( object, objectClass ) );
        else
            throw new UnsupportedOperationException( "Unsupported Type." );
    }

    private static <T> List<T> deepCloneList( List<T> list ) throws Exception {
        boolean isMutable;
        try {
            list.addAll( Collections.emptyList() );
            isMutable = true;
        } catch ( Exception e ){
            isMutable = false;
        }

        return isMutable ? deepCloneModifiableList( list ) : List.copyOf( deepCloneModifiableList( new LinkedList<>( list ) ) );
    }

    private static <T> List<T> deepCloneModifiableList( List<T> list ) throws Exception {
        final var clonedList = (List<T>) createNewList( list.getClass() );
        for ( T element: list )
            if ( element == null )
                clonedList.add( null );
            else
                clonedList.add( (T) deepClone( element, element.getClass() ) );
        return clonedList;
    }

    private static <T> Set<T> deepCloneSet( Set<T> set ) throws Exception {
        boolean isMutable;
        try {
            set.addAll( Collections.emptySet() );
            isMutable = true;
        } catch ( Exception e ){
            isMutable = false;
        }

        return isMutable ? deepCloneModifiableSet( set ) : Set.copyOf( deepCloneModifiableSet( new HashSet<>( set ) ) );
    }

    private static <T> Set<T> deepCloneModifiableSet( Set<T> set ) throws Exception {
        final var clonedSet = createNewSetLike( set );
        for ( T element: set )
            if ( element == null )
                clonedSet.add( null );
            else
                clonedSet.add( (T) deepClone( element, element.getClass() ) );
        return clonedSet;
    }

    private static <T> PriorityQueue<T> deepClonePriorityQueue( PriorityQueue<T> queue ) throws Exception {
        final var clonedQueue = new PriorityQueue<T>( queue.comparator() );
        for ( T element: queue )
            if ( element == null )
                clonedQueue.add( null );
            else
                clonedQueue.add( (T) deepClone( element, element.getClass() ) );
        return clonedQueue;
    }

    private static <T, U> Map<T, U> deepCloneMap( Map<T, U> map ) throws Exception {
        if ( map instanceof Meatball )
            return map;

        boolean isMutable;
        try {
            map.putAll( Collections.emptyMap() );
            isMutable = true;
        } catch ( Exception e ){
            isMutable = false;
        }

        return isMutable ? deepCloneModifiableMap( map ) : Map.copyOf( deepCloneModifiableMap( new HashMap<>( map ) ) );
    }

    private static <T, U> Map<T, U> deepCloneModifiableMap( Map<T, U> map ) throws Exception {
        final var clonedMap = createNewMapLike( map );

        for ( Map.Entry<T, U> entry: map.entrySet() ){
            final var key = entry.getKey();
            final var value = entry.getValue();

            final var clonedKey = key == null ? null : (T) deepClone( key, key.getClass() );
            final var clonedValue = value == null ? null : (U) deepClone( value, value.getClass() );

            clonedMap.put( clonedKey, clonedValue );
        }

        return clonedMap;
    }

    private static <T> T deepCloneArray( Object array, Class<? extends T> objectClass ) throws Exception {
        if ( array instanceof short[] shortArray ){
            final var clonedArray = Arrays.copyOf( shortArray, shortArray.length );
            for ( int elementIndex = 0; elementIndex < shortArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Short.class );
            return objectClass.cast( clonedArray );
        } else if ( array instanceof int[] intArray ){
            final var clonedArray = Arrays.copyOf( intArray, intArray.length );
            for ( int elementIndex = 0; elementIndex < intArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Integer.class );
            return objectClass.cast( clonedArray );
        } else if ( array instanceof long[] longArray ){
            final var clonedArray = Arrays.copyOf( longArray, longArray.length );
            for ( int elementIndex = 0; elementIndex < longArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Long.class );
            return objectClass.cast( clonedArray );
        } else if ( array instanceof float[] floatArray ){
            final var clonedArray = Arrays.copyOf( floatArray, floatArray.length );
            for ( int elementIndex = 0; elementIndex < floatArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Float.class );
            return objectClass.cast( clonedArray );
        } else if ( array instanceof double[] doubleArray ){
            final var clonedArray = Arrays.copyOf( doubleArray, doubleArray.length );
            for ( int elementIndex = 0; elementIndex < doubleArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Double.class );
            return objectClass.cast( clonedArray );
        } else if ( array instanceof boolean[] booleanArray ){
            final var clonedArray = Arrays.copyOf( booleanArray, booleanArray.length );
            for ( int elementIndex = 0; elementIndex < booleanArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Boolean.class );
            return objectClass.cast( clonedArray );
        } else if ( array instanceof char[] charArray ){
            final var clonedArray = Arrays.copyOf( charArray, charArray.length );
            for ( int elementIndex = 0; elementIndex < charArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Character.class );
            return objectClass.cast( clonedArray );
        } else if ( array instanceof byte[] byteArray ){
            final var clonedArray = Arrays.copyOf( byteArray, byteArray.length );
            for ( int elementIndex = 0; elementIndex < byteArray.length; elementIndex++ )
                clonedArray[elementIndex] = deepClone( clonedArray[elementIndex], Byte.class );
            return objectClass.cast( clonedArray );
        } else {
            final var objectArray = (Object[]) array;
            final var clonedArray = Arrays.copyOf( objectArray, objectArray.length );
            for ( int elementIndex = 0; elementIndex < objectArray.length; elementIndex++ ){
                final var element = objectArray[elementIndex];
                if ( element == null )
                    clonedArray[elementIndex] = null;
                else
                    clonedArray[elementIndex] = deepClone( element, element.getClass() );
            }
            return objectClass.cast( clonedArray );
        }
    }

    public static <T> T deepClone( T object ) {
        if ( object == null )
            return null;

        try {
            return (T) deepClone( object, object.getClass() );
        } catch ( Exception e ){
            throw new RuntimeException( e );
        }
    }

}
