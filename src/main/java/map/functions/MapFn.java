package map.functions;

import map.datastructures.Meatball;
import util.collections.MapUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static util.collections.ListUtil.createNewList;
import static util.collections.MapUtil.*;

public class MapFn {

    public static <T> Function<T, Meatball> toMeatballWith( String key ) {
        return value -> new Meatball( key, value );
    }

    public static <T> Function<Map<String, Object>, Map<String, Object>> put( String key, T value ) {
        return putAll( key, value );
    }

    public static Function<Map<String, Object>, Map<String, Object>> putAll( Object... keyValuePairs ) {
        return map -> map.getClass() == Meatball.class ? ((Meatball) map).enrichAll( keyValuePairs ) : enrichMap( map, keyValuePairs );
    }

    public static Function<Map<String, Object>, Map<String, Object>> putAll( Map<String, Object> pairs ) {
        return map -> {
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).enrichAll( pairs );
            map.putAll( pairs );
            return map;
        };
    }

    public static Function<Map<String, Object>, Map<String, Object>> compute( String key, Function<Map<String, Object>, ?> fn ) {
        return map -> {
            final var value = fn.apply( map );
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).enrich( key, value );
            map.put( key, value );
            return map;
        };
    }

    public static Function<Map<String, Object>, Map<String, Object>> copy( String keyFrom, String keyTo ) {
        return copyAll( keyFrom, keyTo );
    }

    public static Function<Map<String, Object>, Map<String, Object>> copyAll( String... keyPairs ) {
        return map -> map.getClass() == Meatball.class ? ((Meatball) map).copyAll( keyPairs ) : MapUtil.copyAll( map, keyPairs );
    }

    public static Function<Map<String, Object>, Map<String, Object>> rename( String keyFrom, String keyTo ) {
        return renameAll( keyFrom, keyTo );
    }

    public static Function<Map<String, Object>, Map<String, Object>> renameAll( String... keyPairs ) {
        return map -> map.getClass() == Meatball.class ? ((Meatball) map).renameAll( keyPairs ) : MapUtil.renameAll( map, keyPairs );
    }

    public static Function<Map<String, Object>, Map<String, Object>> remove( String key ) {
        return removeAll( key );
    }

    public static Function<Map<String, Object>, Map<String, Object>> removeAll( String... keys ) {
        return map -> {
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).discardAll( keys );
            for ( String key: keys )
                map.remove( key );
            return map;
        };
    }

    public static Function<Map<String, Object>, Map<String, Object>> removeNulls = map -> map.getClass() == Meatball.class ? map : removeNullKeysAndValues( map );

    public static Function<Map<String, Object>, Map<String, Object>> clear = map -> {
        if ( map.getClass() == Meatball.class )
            return ((Meatball) map).discardAll();
        map.clear();
        return map;
    };

    public static Function<Map<String, Object>, Map<String, Object>> keep( String key ) {
        return keepAll( key );
    }

    public static Function<Map<String, Object>, Map<String, Object>> keepAll( String... keys ) {
        return map -> {
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).keepAll( keys );
            final var newMap = createNewMapLike( map );
            for ( String key: keys )
                if ( map.containsKey( key ) )
                    newMap.put( key, map.get( key ) );
            map = newMap;
            return map;
        };
    }

    public static Function<Map<String, Object>, Object> get( String key ) {
        return map -> map.getOrDefault( key, null );
    }

    public static <T> Function<Map<String, Object>, T> get( String key, Class<T> clazz ) {
        return map -> map.getClass() == Meatball.class ? ((Meatball) map).get( key, clazz ) : clazz.cast( get( key ).apply( map ) );
    }

    public static <T> Function<Map<String, Object>, T> get( String key, T defaultValue ) {
        return map -> map.getClass() == Meatball.class ? ((Meatball) map).get( key, defaultValue ) : (T) map.getOrDefault( key, defaultValue );
    }

    public static <T> Function<Map<String, Object>, T> get( String key, String defaultValueKey, Class<T> clazz ) {
        return map -> {
            final var defaultValue = get( defaultValueKey, clazz ).apply( map );
            return map.getClass() == Meatball.class ? ((Meatball) map).get( key, defaultValue ) : get( key, defaultValue ).apply( map );
        };
    }

    public static Function<Map<String, Object>, Short> getShort( String key ) {
        return get( key, Short.class );
    }

    public static Function<Map<String, Object>, Integer> getInteger( String key ) {
        return get( key, Integer.class );
    }

    public static Function<Map<String, Object>, Long> getLong( String key ) {
        return get( key, Long.class );
    }

    public static Function<Map<String, Object>, Float> getFloat( String key ) {
        return get( key, Float.class );
    }

    public static Function<Map<String, Object>, Double> getDouble( String key ) {
        return get( key, Double.class );
    }

    public static Function<Map<String, Object>, Boolean> getBoolean( String key ) {
        return get( key, Boolean.class );
    }

    public static Function<Map<String, Object>, Character> getCharacter( String key ) {
        return get( key, Character.class );
    }

    public static Function<Map<String, Object>, String> getString( String key ) {
        return get( key, String.class );
    }

    public static Function<Map<String, Object>, Byte> getByte( String key ) {
        return get( key, Byte.class );
    }

    public static Function<Map<String, Object>, BigInteger> getBigInteger( String key ) {
        return get( key, BigInteger.class );
    }

    public static Function<Map<String, Object>, BigDecimal> getBigDecimal( String key ) {
        return get( key, BigDecimal.class );
    }

    public static <T> Function<Map<String, Object>, List<T>> getList( String key, Class<T> elementClass ) {
        return map -> (List<T>) get( key ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Set<T>> getSet( String key, Class<T> elementClass ) {
        return map -> (Set<T>) get( key ).apply( map );
    }

    public static <T, U> Function<Map<String, Object>, Map<T, U>> getMap( String key, Class<T> keyClass, Class<U> valueClass ) {
        return map -> (Map<T, U>) get( key ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Map<T, T>> getMap( String key, Class<T> keyAndValueClass ) {
        return map -> (Map<T, T>) get( key ).apply( map );
    }

    public static <T> Function<Map<String, Object>, PriorityQueue<T>> getPriorityQueue( String key, Class<T> elementClass ) {
        return map -> (PriorityQueue<T>) get( key ).apply( map );
    }

    public static <T> Function<Map<String, Object>, T[]> getArray( String key, Class<T> elementClass ) {
        return map -> (T[]) get( key ).apply( map );
    }

    public static Function<Map<String, Object>, Class<?>> getClass( String key ) {
        return map -> {
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).getClass( key );
            return map.get( key ).getClass();
        };
    }

    public static Function<Map<String, Object>, Set<String>> keySet = Map::keySet;

    public static Function<Map<String, Object>, Collection<Object>> values = Map::values;

    public static Function<Map<String, Object>, Set<Map.Entry<String, Object>>> entrySet = Map::entrySet;

    public static Function<Map<String, Object>, Integer> size = Map::size;

    public static Predicate<Map<String, Object>> isEmpty = Map::isEmpty;

    public static Predicate<Map<String, Object>> has( String key ) {
        return map -> map.containsKey( key );
    }

    public static Predicate<Map<String, Object>> hasNot( String key ) {
        return map -> !has( key ).test( map );
    }

    public static Predicate<Map<String, Object>> hasAll( String... keys ) {
        return map -> new HashSet<>( map.keySet() ).containsAll( Arrays.stream( keys ).toList() );
    }

    public static Predicate<Map<String,Object>> hasNotAll( String... keys ) {
        return map -> !hasAll( keys ).test( map );
    }

    public static <T> Predicate<Map<String, Object>> containsValue( T value ) {
        return map -> map.containsValue( value );
    }

    public static <T> Predicate<Map<String, Object>> is( String key, T value ) {
        return map -> {
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).is( key, value );
            return !map.containsKey( key ) ? value == null : map.get( key ).equals( value );
        };
    }

    public static <T> Predicate<Map<String, Object>> isNot( String key, T value ) {
        return map -> !is( key, value ).test( map );
    }

    public static Predicate<Map<String, Object>> valuesEqual( String firstKey, String secondKey ) {
        return map -> hasAll( firstKey, secondKey ).test( map ) && map.getClass() == Meatball.class ? ((Meatball) map).valuesEqual( firstKey, secondKey ) : is( firstKey, map.get( secondKey ) ).test( map );
    }

    public static Predicate<Map<String, Object>> valuesNotEqual( String firstKey, String secondKey ) {
        return map -> !valuesEqual( firstKey, secondKey ).test( map );
    }

    public static Predicate<Map<String, Object>> classesAre( Object... keyClassPairs ) {
        return map -> {
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).classesAre( keyClassPairs );
            return MapUtil.classesAre( map, keyClassPairs );
        };
    }

    public static <T> Predicate<Map<String, Object>> classIs( String key, Class<T> clazz ) {
        return classesAre( key, clazz );
    }

    public static <T extends Collection<?>> Predicate<Map<String, Object>> in( String key, T values ) {
        return map -> {
            if ( map.getClass() == Meatball.class )
                return ((Meatball) map).in( key, values );
            return values.contains( map.get( key ) );
        };
    }

    public static <T extends Collection<?>> Predicate<Map<String, Object>> notIn( String key, T values ) {
        return map -> !in( key, values ).test( map );
    }

    public static Predicate<Map<String, Object>> in( String key, String valuesKey ) {
        return map -> in( key, (Collection<?>) map.get( valuesKey ) ).test( map );
    }

    public static Predicate<Map<String, Object>> notIn( String key, String valuesKey ) {
        return map -> !in( key, valuesKey ).test( map );
    }

    public static Function<Meatball, String> meatballToJson = Meatball::toJson;

    public static Function<String, Meatball> jsonToMeatball = Meatball::fromJson;

    public static <T extends List<?>, U> Function<Map<String, Object>, List<U>> toList( Class<T> listClass, Class<U> elementClass, String... keys ) {
        return map -> {
            final var list = (List<U>) createNewList( listClass );
            for ( String key: keys )
                list.add( elementClass.cast( map.get( key ) ) );
            return list;
        };
    }

}
