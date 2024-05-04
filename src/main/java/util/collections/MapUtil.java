package util.collections;

import java.util.*;
import java.util.function.BiConsumer;

import static util.Util.doForAllPairs;

public class MapUtil {

    public static <T extends Map<?, ?>> T createNewMap( Class<T> mapClass ) {
        try {
            return mapClass.getConstructor().newInstance();
        } catch ( Exception e ){
            throw new RuntimeException( e );
        }
    }

    public static <T extends Map<?, ?>> T createNewMap( Class<T> mapClass, Comparator<?> comparator ) {
        try {
            return mapClass.getConstructor( Comparator.class ).newInstance( comparator );
        } catch ( Exception e ){
            throw new RuntimeException( e );
        }
    }

    public static <T extends Map<U, V>, U, V> Map<U, V> createNewMapLike( T map ) {
        final var mapClass = map.getClass();
        return TreeMap.class.isAssignableFrom( mapClass ) ? (Map<U, V>) createNewMap( TreeMap.class, ((TreeMap<U, V>) map).comparator() )
                                                              : (Map<U, V>) createNewMap( mapClass );
    }

    public static Map<String, Object> enrichMap( Map<String, Object> map, Object... pairs ) {
        doForAllPairs( map::put, pairs );
        return map;
    }

    private static BiConsumer<String, Object> enrichMapButSkipNullKeysAndFilterNewNulls( Map<String, Object> map ) {
        return ( key, value ) -> {
            if ( key != null )
                if ( value == null )
                    map.remove( key );
                else
                    map.put( key, value );
        };
    }

    public static Map<String, Object> enrichMapButSkipNullKeysAndFilterNewNulls( Map<String, Object> map, Object... pairs ) {
        doForAllPairs( enrichMapButSkipNullKeysAndFilterNewNulls( map ), pairs );
        return map;
    }

    public static Map<String, Object> enrichMapButSkipNullKeysAndFilterNewNulls( Map<String, Object> map, Map<String, Object> pairs ) {
        final var enrichMapButSkipNullKeysAndFilterNewNulls = enrichMapButSkipNullKeysAndFilterNewNulls( map );
        for ( Map.Entry<String, Object> entry: pairs.entrySet() )
            enrichMapButSkipNullKeysAndFilterNewNulls.accept( entry.getKey(), entry.getValue() );
        return map;
    }

    public static Map<String, Object> copyAll( Map<String, Object> map, String... pairs ) {
        BiConsumer<String, String> copy = ( keyFrom, keyTo ) -> {
            if ( !Objects.equals( keyFrom, keyTo ) )
                map.put( keyTo, map.getOrDefault( keyFrom, null ) );
        };
        doForAllPairs( copy, (Object[]) pairs );
        return map;
    }

    public static Map<String, Object> renameAll( Map<String, Object> map, String... pairs ) {
        BiConsumer<String, String> rename = ( keyFrom, keyTo ) -> {
            if ( !Objects.equals( keyFrom, keyTo ) ){
                map.put( keyTo, map.getOrDefault( keyFrom, null ) );
                map.remove( keyFrom );
            }
        };
        doForAllPairs( rename, (Object[]) pairs );
        return map;
    }

    public static <T, U> HashMap<T, U> createNewHashMapWithoutNulls( Map<T, U> map ) {
        final var submap = new HashMap<T, U>();

        for ( Map.Entry<T, U> entry: map.entrySet() ){
            final var key = entry.getKey();
            final var value = entry.getValue();
            if ( key == null || value == null )
                continue;
            submap.put( key, value );
        }

        return submap;
    }

    public static <T, U> Map<T, U> removeNullKeysAndValues( Map<T, U> map ) {

        final var iterator = map.entrySet().iterator();
        while ( iterator.hasNext() ){
            final var entry = iterator.next();
            final var key = entry.getKey();
            final var value = entry.getValue();
            if ( key == null || value == null )
                iterator.remove();
        }

        return map;
    }

    public static boolean classesAre( Map<String, Object> map, Object... pairs ) {
        if ( pairs.length % 2 != 0 )
            throw new IllegalArgumentException( "Incomplete pair supplied." );

        for ( int pairIndex = 0; pairIndex < pairs.length; pairIndex += 2 ){
            final var firstMember = (String) pairs[pairIndex];
            final var secondMember = (Class<?>) pairs[pairIndex + 1];
            if ( !map.containsKey( firstMember ) || secondMember == null )
                throw new NullPointerException( "Specified key must exist and specified class must not be null." );

            if ( !(map.get( firstMember ).getClass() == secondMember) )
                return false;
        }

        return true;
    }

}
