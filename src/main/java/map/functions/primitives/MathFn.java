package map.functions.primitives;

import util.primitives.MathUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class MathFn {

    public static <T extends Number> Predicate<Map<String, Object>> isGreaterThan( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.isGreaterThan( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Predicate<Map<String, Object>> isGreaterThan( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> isGreaterThan( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).test( map );
    }

    public static <T extends Number> Predicate<Map<String, Object>> isGreaterThanOrEqualTo( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.isGreaterThanOrEqualTo( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Predicate<Map<String, Object>> isGreaterThanOrEqualTo( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> isGreaterThanOrEqualTo( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).test( map );
    }

    public static <T extends Number> Predicate<Map<String, Object>> isLessThan( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.isLessThan( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Predicate<Map<String, Object>> isLessThan( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> isLessThan( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).test( map );
    }

    public static <T extends Number> Predicate<Map<String, Object>> isLessThanOrEqualTo( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.isLessThanOrEqualTo( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Predicate<Map<String, Object>> isLessThanOrEqualTo( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> isLessThanOrEqualTo( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).test( map );
    }

    public static <T extends Number> Function<Map<String, Object>, T> add( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.add( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> add( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> add( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number> Function<Map<String, Object>, T> subtract( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.subtract( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> subtract( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> subtract( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number> Function<Map<String, Object>, T> multiply( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.multiply( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> multiply( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> multiply( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number> Function<Map<String, Object>, T> divide( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.divide( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> divide( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> divide( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number> Function<Map<String, Object>, T> mod( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.mod( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> mod( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> mod( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number & Comparable<T>> Function<Map<String, Object>, T> min( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.min( clazz.cast( map.get( numKey ) ), value );
    }

    public static <T extends Number & Comparable<T>> Function<Map<String, Object>, T> min( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> min( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number & Comparable<T>> Function<Map<String, Object>, T> max( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.max( clazz.cast( map.get( numKey ) ), value );
    }

    public static <T extends Number & Comparable<T>> Function<Map<String, Object>, T> max( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> max( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number> Function<Map<String, Object>, T> pow( String numKey, T value, Class<T> clazz ) {
        return map -> MathUtil.pow( clazz.cast( map.get( numKey ) ), value, clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> pow( String firstNumKey, String secondNumKey, Class<T> clazz ) {
        return map -> pow( firstNumKey, clazz.cast( map.get( secondNumKey ) ), clazz ).apply( map );
    }

    public static <T extends Number> Function<Map<String, Object>, Double> log( String numKey, Class<T> clazz ) {
        return map -> MathUtil.log( clazz.cast( map.get( numKey ) ), clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> sqrt( String numKey, Class<T> clazz ) {
        return map -> MathUtil.sqrt( clazz.cast( map.get( numKey ) ), clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> abs( String numKey, Class<T> clazz ) {
        return map -> MathUtil.abs( clazz.cast( map.get( numKey ) ), clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> negate( String numKey, Class<T> clazz ) {
        return map -> MathUtil.negate( clazz.cast( map.get( numKey ) ), clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> ceil( String numKey, Class<T> clazz ) {
        return map -> MathUtil.ceil( clazz.cast( map.get( numKey ) ), clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> floor( String numKey, Class<T> clazz ) {
        return map -> MathUtil.floor( clazz.cast( map.get( numKey ) ), clazz );
    }

    public static <T extends Number> Function<Map<String, Object>, T> round( String numKey, Class<T> clazz ) {
        return map -> MathUtil.round( clazz.cast( map.get( numKey ) ), clazz );
    }

    public static <T> Function<Map<String, Object>, T> castNumberTo( String numKey, Class<T> clazz ) {
        final var converters = new HashMap<Class<?>, Function<Map<String, Object>, T>>();
        converters.put( Short.class, map -> clazz.cast( (((Number) map.get( numKey )).shortValue()) ) );
        converters.put( Integer.class, map -> clazz.cast( (((Number) map.get( numKey )).intValue()) ) );
        converters.put( Long.class, map -> clazz.cast( (((Number) map.get( numKey )).longValue()) ) );
        converters.put( Float.class, map -> clazz.cast( (((Number) map.get( numKey )).floatValue()) ) );
        converters.put( Double.class, map -> clazz.cast( (((Number) map.get( numKey )).doubleValue()) ) );
        converters.put( BigInteger.class, map -> clazz.cast( new BigInteger( (map.get( numKey )).toString() ) ) );
        converters.put( BigDecimal.class, map -> clazz.cast( new BigDecimal( (map.get( numKey )).toString() ) ) );
        converters.put( String.class, map -> clazz.cast( (map.get( numKey )).toString() ) );
        final var converter = converters.getOrDefault( clazz, null );
        if ( converter == null )
            throw new UnsupportedOperationException( "Unsupported Type." );
        return converter;
    }

}
