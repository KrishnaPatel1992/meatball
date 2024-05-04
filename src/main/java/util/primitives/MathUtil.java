package util.primitives;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathUtil {

    public static <T extends Number> int compareToZero( T value, Class<T> clazz ) {
        if ( clazz == Short.class ) return Integer.compare( value.shortValue(), 0 );
        if ( clazz == Integer.class ) return Integer.compare( value.intValue(), 0 );
        if ( clazz == Long.class ) return Long.compare( value.longValue(), 0L );
        if ( clazz == Float.class ) return Float.compare( value.floatValue(), 0.0F );
        if ( clazz == Double.class ) return Double.compare( value.doubleValue(), 0.0 );
        if ( clazz == BigInteger.class ) return ((BigInteger) value).compareTo( BigInteger.ZERO );
        if ( clazz == BigDecimal.class ) return ((BigDecimal) value).compareTo( BigDecimal.ZERO );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> Boolean isGreaterThan( T firstValue, T secondValue, Class<T> clazz ) {
        final var result = subtract( firstValue, secondValue, clazz );
        return compareToZero( result, clazz ) > 0;
    }

    public static <T extends Number> Boolean isGreaterThanOrEqualTo( T firstValue, T secondValue, Class<T> clazz ) {
        final var result = subtract( firstValue, secondValue, clazz );
        return compareToZero( result, clazz ) >= 0;
    }

    public static <T extends Number> Boolean isLessThan( T firstValue, T secondValue, Class<T> clazz ) {
        final var result = subtract( firstValue, secondValue, clazz );
        return compareToZero( result, clazz ) < 0;
    }

    public static <T extends Number> Boolean isLessThanOrEqualTo( T firstValue, T secondValue, Class<T> clazz ) {
        final var result = subtract( firstValue, secondValue, clazz );
        return compareToZero( result, clazz ) <= 0;
    }

    public static <T extends Number> T add( T firstValue, T secondValue, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) (firstValue.shortValue() + secondValue.shortValue()) );
        if ( clazz == Integer.class ) return clazz.cast( firstValue.intValue() + secondValue.intValue() );
        if ( clazz == Long.class ) return clazz.cast( firstValue.longValue() + secondValue.longValue() );
        if ( clazz == Float.class ) return clazz.cast( firstValue.floatValue() + secondValue.floatValue() );
        if ( clazz == Double.class ) return clazz.cast( (firstValue.doubleValue() + secondValue.doubleValue()) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) firstValue).add( (BigInteger) secondValue ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) firstValue).add( (BigDecimal) secondValue ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T subtract( T firstValue, T secondValue, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) (firstValue.shortValue() - secondValue.shortValue()) );
        if ( clazz == Integer.class ) return clazz.cast( firstValue.intValue() - secondValue.intValue() );
        if ( clazz == Long.class ) return clazz.cast( firstValue.longValue() - secondValue.longValue() );
        if ( clazz == Float.class ) return clazz.cast( firstValue.floatValue() - secondValue.floatValue() );
        if ( clazz == Double.class ) return clazz.cast( (firstValue.doubleValue() - secondValue.doubleValue()) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) firstValue).subtract( (BigInteger) secondValue ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) firstValue).subtract( (BigDecimal) secondValue ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T multiply( T firstValue, T secondValue, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) (firstValue.shortValue() * secondValue.shortValue()) );
        if ( clazz == Integer.class ) return clazz.cast( firstValue.intValue() * secondValue.intValue() );
        if ( clazz == Long.class ) return clazz.cast( firstValue.longValue() * secondValue.longValue() );
        if ( clazz == Float.class ) return clazz.cast( firstValue.floatValue() * secondValue.floatValue() );
        if ( clazz == Double.class ) return clazz.cast( (firstValue.doubleValue() * secondValue.doubleValue()) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) firstValue).multiply( (BigInteger) secondValue ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) firstValue).multiply( (BigDecimal) secondValue ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T divide( T firstValue, T secondValue, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) (firstValue.shortValue() / secondValue.shortValue()) );
        if ( clazz == Integer.class ) return clazz.cast( firstValue.intValue() / secondValue.intValue() );
        if ( clazz == Long.class ) return clazz.cast( firstValue.longValue() / secondValue.longValue() );
        if ( clazz == Float.class ) return clazz.cast( firstValue.floatValue() / secondValue.floatValue() );
        if ( clazz == Double.class ) return clazz.cast( (firstValue.doubleValue() / secondValue.doubleValue()) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) firstValue).divide( (BigInteger) secondValue ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) firstValue).divide( (BigDecimal) secondValue, ((BigDecimal) firstValue).scale(), RoundingMode.HALF_UP ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T mod( T firstValue, T secondValue, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) (firstValue.shortValue() % secondValue.shortValue()) );
        if ( clazz == Integer.class ) return clazz.cast( firstValue.intValue() % secondValue.intValue() );
        if ( clazz == Long.class ) return clazz.cast( firstValue.longValue() % secondValue.longValue() );
        if ( clazz == Float.class ) return clazz.cast( firstValue.floatValue() % secondValue.floatValue() );
        if ( clazz == Double.class ) return clazz.cast( (firstValue.doubleValue() % secondValue.doubleValue()) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) firstValue).mod( (BigInteger) secondValue ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) firstValue).remainder( (BigDecimal) secondValue ).abs() );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number & Comparable<T>> T min( T firstValue, T secondValue ) {
        return firstValue.compareTo( secondValue ) < 0 ? firstValue : secondValue;
    }

    public static <T extends Number & Comparable<T>> T max( T firstValue, T secondValue ) {
        return firstValue.compareTo( secondValue ) > 0 ? firstValue : secondValue;
    }

    public static <T extends Number> T pow( T firstValue, T secondValue, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) Math.pow( firstValue.shortValue(), secondValue.shortValue() ) );
        if ( clazz == Integer.class ) return clazz.cast( (int) Math.pow( firstValue.intValue(), secondValue.intValue() ) );
        if ( clazz == Long.class ) return clazz.cast( (long) Math.pow( firstValue.longValue(), secondValue.longValue() ) );
        if ( clazz == Float.class ) return clazz.cast( (float) Math.pow( firstValue.floatValue(), secondValue.floatValue() ) );
        if ( clazz == Double.class ) return clazz.cast( Math.pow( firstValue.doubleValue(), secondValue.doubleValue() ) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) firstValue).pow( secondValue.intValue() ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) firstValue).pow( secondValue.intValue() ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> double log( T value, Class<T> clazz ) {
        if ( clazz == Short.class ) return Math.log( value.shortValue() );
        if ( clazz == Integer.class ) return Math.log( value.intValue() );
        if ( clazz == Long.class ) return Math.log( value.longValue() );
        if ( clazz == Float.class ) return Math.log( value.floatValue() );
        if ( clazz == Double.class ) return Math.log( value.doubleValue() );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T sqrt( T value, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) Math.sqrt( value.shortValue() ) );
        if ( clazz == Integer.class ) return clazz.cast( (int) Math.sqrt( value.intValue() ) );
        if ( clazz == Long.class ) return clazz.cast( (long) Math.sqrt( value.longValue() ) );
        if ( clazz == Float.class ) return clazz.cast( (float) Math.sqrt( value.floatValue() ) );
        if ( clazz == Double.class ) return clazz.cast( Math.sqrt( value.doubleValue() ) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) value).sqrt() );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) value).sqrt( MathContext.UNLIMITED ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T abs( T value, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) Math.abs( value.shortValue() ) );
        if ( clazz == Integer.class ) return clazz.cast( Math.abs( value.intValue() ) );
        if ( clazz == Long.class ) return clazz.cast( Math.abs( value.longValue() ) );
        if ( clazz == Float.class ) return clazz.cast( Math.abs( value.floatValue() ) );
        if ( clazz == Double.class ) return clazz.cast( Math.abs( value.doubleValue() ) );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) value).abs() );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) value).abs() );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T negate( T value, Class<T> clazz ) {
        if ( clazz == Short.class ) return clazz.cast( (short) -value.shortValue() );
        if ( clazz == Integer.class ) return clazz.cast( -value.intValue() );
        if ( clazz == Long.class ) return clazz.cast( -value.longValue() );
        if ( clazz == Float.class ) return clazz.cast( -value.floatValue() );
        if ( clazz == Double.class ) return clazz.cast( -value.doubleValue() );
        if ( clazz == BigInteger.class ) return clazz.cast( ((BigInteger) value).negate() );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) value).negate() );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T ceil( T value, Class<T> clazz ) {
        if ( value == null ) throw new NullPointerException( "value cannot be null." );

        if ( clazz == Short.class || clazz == Integer.class || clazz == Long.class || clazz == BigInteger.class ) return value;
        if ( clazz == Float.class ) return clazz.cast( (float) Math.ceil( value.floatValue() ) );
        if ( clazz == Double.class ) return clazz.cast( Math.ceil( value.doubleValue() ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) value).setScale( 0, RoundingMode.CEILING ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T floor( T value, Class<T> clazz ) {
        if ( value == null ) throw new NullPointerException( "value cannot be null." );

        if ( clazz == Short.class || clazz == Integer.class || clazz == Long.class || clazz == BigInteger.class ) return value;
        if ( clazz == Float.class ) return clazz.cast( (float) Math.floor( value.floatValue() ) );
        if ( clazz == Double.class ) return clazz.cast( Math.floor( value.doubleValue() ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) value).setScale( 0, RoundingMode.FLOOR ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

    public static <T extends Number> T round( T value, Class<T> clazz ) {
        if ( value == null ) throw new NullPointerException( "value cannot be null." );

        if ( clazz == Short.class || clazz == Integer.class || clazz == Long.class || clazz == BigInteger.class ) return value;
        if ( clazz == Float.class ) return clazz.cast( (float) Math.round( value.floatValue() ) );
        if ( clazz == Double.class ) return clazz.cast( (double) Math.round( value.doubleValue() ) );
        if ( clazz == BigDecimal.class ) return clazz.cast( ((BigDecimal) value).setScale( 0, RoundingMode.HALF_UP ) );
        throw new UnsupportedOperationException( "Unsupported type." );
    }

}
