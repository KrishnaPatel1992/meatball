package map.functions.primitives;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static util.primitives.StringUtil.concatenate;

public class StringFn {

    public static Function<Map<String, Object>, Integer> indexOfSubstr( String strKey, String substr ) {
        return map -> ((String) map.get( strKey )).indexOf( substr );
    }

    public static Function<Map<String, Object>, Integer> indexOfAssociatedSubstr( String strKey, String substrKey ) {
        return map -> indexOfSubstr( strKey, (String) map.get( substrKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> indexOfSubstr( String strKey, String substr, int fromIndex ) {
        return map -> ((String) map.get( strKey )).indexOf( substr, fromIndex );
    }

    public static Function<Map<String, Object>, Integer> indexOfAssociatedSubstr( String strKey, String substrKey, int fromIndex ) {
        return map -> indexOfSubstr( strKey, (String) map.get( substrKey ), fromIndex ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> indexOfSubstr( String strKey, String substr, String fromIndexKey ) {
        return map -> indexOfSubstr( strKey, substr, (Integer) map.get( fromIndexKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> indexOfAssociatedSubstr( String strKey, String substrKey, String fromIndexKey ) {
        return map -> indexOfSubstr( strKey, (String) map.get( substrKey ), (Integer) map.get( fromIndexKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> lastIndexOfSubstr( String strKey, String substr ) {
        return map -> ((String) map.get( strKey )).lastIndexOf( substr );
    }

    public static Function<Map<String, Object>, Integer> lastIndexOfAssociatedSubstr( String strKey, String substrKey ) {
        return map -> lastIndexOfSubstr( strKey, (String) map.get( substrKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> lastIndexOfSubstr( String strKey, String substr, int fromIndex ) {
        return map -> ((String) map.get( strKey )).lastIndexOf( substr, fromIndex );
    }

    public static Function<Map<String, Object>, Integer> lastIndexOfAssociatedSubstr( String strKey, String substrKey, int fromIndex ) {
        return map -> lastIndexOfSubstr( strKey, (String) map.get( substrKey ), fromIndex ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> lastIndexOfSubstr( String strKey, String substr, String fromIndexKey ) {
        return map -> lastIndexOfSubstr( strKey, substr, (Integer) map.get( fromIndexKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> lastIndexOfAssociatedSubstr( String strKey, String substrKey, String fromIndexKey ) {
        return map -> lastIndexOfSubstr( strKey, (String) map.get( substrKey ), (Integer) map.get( fromIndexKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, Integer> lengthOfString( String strKey ) {
        return map -> ((String) map.get( strKey )).length();
    }

    public static Function<Map<String, Object>, String> substring( String strKey, int beginIndex ) {
        return map -> ((String) map.get( strKey )).substring( beginIndex );
    }

    public static Function<Map<String, Object>, String> substring( String strKey, String beginIndexKey ) {
        return map -> substring( strKey, (Integer) map.get( beginIndexKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, String> substring( String strKey, int beginIndex, int endIndex ) {
        return map -> ((String) map.get( strKey )).substring( beginIndex, endIndex );
    }

    public static Function<Map<String, Object>, String> substring( String strKey, String beginIndexKey, int endIndex ) {
        return map -> substring( strKey, (Integer) map.get( beginIndexKey ), endIndex ).apply( map );
    }

    public static Function<Map<String, Object>, String> substring( String strKey, int beginIndex, String endIndexKey ) {
        return map -> substring( strKey, beginIndex, (Integer) map.get( endIndexKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, String> substring( String strKey, String beginIndexKey, String endIndexKey ) {
        return map -> substring( strKey, (Integer) map.get( beginIndexKey ), (Integer) map.get( endIndexKey ) ).apply( map );
    }

    public static Function<Map<String, Object>, String> prefixUntilFirstIndexOfSubstr( String strKey, Function<Map<String, Object>, String> toSubstr ) {
        return map -> {
            final var str = ((String) map.get( strKey ));
            final var index = str.indexOf( toSubstr.apply( map ) );
            return index == -1 ? "" : str.substring( 0, index );
        };
    }

    public static Function<Map<String, Object>, String> prefixUntilFirstIndexOfSubstr( String strKey, String substr ) {
        return prefixUntilFirstIndexOfSubstr( strKey, map -> substr );
    }

    public static Function<Map<String, Object>, String> prefixUntilFirstIndexOfAssociatedSubstr( String strKey, String substrKey ) {
        return prefixUntilFirstIndexOfSubstr( strKey, map -> (String) map.get( substrKey ) );
    }

    public static Function<Map<String, Object>, String> prefixUntilLastIndexOfSubstr( String strKey, Function<Map<String, Object>, String> toSubstr ) {
        return map -> {
            final var str = ((String) map.get( strKey ));
            final var index = str.lastIndexOf( toSubstr.apply( map ) );
            return index == -1 ? "" : str.substring( 0, index );
        };
    }

    public static Function<Map<String, Object>, String> prefixUntilLastIndexOfSubstr( String strKey, String substr ) {
        return prefixUntilLastIndexOfSubstr( strKey, map -> substr );
    }

    public static Function<Map<String, Object>, String> prefixUntilLastIndexOfAssociatedSubstr( String strKey, String substrKey ) {
        return prefixUntilLastIndexOfSubstr( strKey, map -> (String) map.get( substrKey ) );
    }

    public static Function<Map<String, Object>, String> suffixUntilFirstIndexOfSubstr( String strKey, Function<Map<String, Object>, String> toSubstr ) {
        return map -> {
            final var str = ((String) map.get( strKey ));
            final var index = str.indexOf( toSubstr.apply( map ) );
            return index == -1 ? "" : str.substring( index );
        };
    }

    public static Function<Map<String, Object>, String> suffixUntilFirstIndexOfSubstr( String strKey, String substr ) {
        return suffixUntilFirstIndexOfSubstr( strKey, map -> substr );
    }

    public static Function<Map<String, Object>, String> suffixUntilFirstIndexOfAssociatedSubstr( String strKey, String substrKey ) {
        return suffixUntilFirstIndexOfSubstr( strKey, map -> (String) map.get( substrKey ) );
    }

    public static Function<Map<String, Object>, String> suffixUntilLastIndexOfSubstr( String strKey, Function<Map<String, Object>, String> toSubstr ) {
        return map -> {
            final var str = ((String) map.get( strKey ));
            final var index = str.lastIndexOf( toSubstr.apply( map ) );
            return index == -1 ? "" : str.substring( index );
        };
    }

    public static Function<Map<String, Object>, String> suffixUntilLastIndexOfSubstr( String strKey, String substr ) {
        return suffixUntilLastIndexOfSubstr( strKey, map -> substr );
    }

    public static Function<Map<String, Object>, String> suffixUntilLastIndexOfAssociatedSubstr( String strKey, String substrKey ) {
        return suffixUntilLastIndexOfSubstr( strKey, map -> (String) map.get( substrKey ) );
    }

    public static Predicate<Map<String, Object>> startsWithSubstr( String strKey, String substr ) {
        return map -> ((String) map.get( strKey )).startsWith( substr );
    }

    public static Predicate<Map<String, Object>> startsWithAssociatedSubstr( String strKey, String substrKey ) {
        return map -> startsWithSubstr( strKey, (String) map.get( substrKey ) ).test( map );
    }

    public static Predicate<Map<String, Object>> endsWithSubstr( String strKey, String substr ) {
        return map -> ((String) map.get( strKey )).endsWith( substr );
    }

    public static Predicate<Map<String, Object>> endsWithAssociatedSubstr( String strKey, String substrKey ) {
        return map -> endsWithSubstr( strKey, (String) map.get( substrKey ) ).test( map );
    }

    public static Predicate<Map<String, Object>> containsSubstr( String strKey, String substr ) {
        return map -> ((String) map.get( strKey )).contains( substr );
    }

    public static Predicate<Map<String, Object>> containsAssociatedSubstr( String strKey, String substrKey ) {
        return map -> containsSubstr( strKey, (String) map.get( substrKey ) ).test( map );
    }

    public static Function<Map<String, Object>, Integer> compareToSubstr( String strKey, String substr ) {
        return map -> ((String) map.get( strKey )).compareTo( substr );
    }

    public static Function<Map<String, Object>, Integer> compareToAssociatedSubstr( String strKey, String substrKey ) {
        return map -> compareToSubstr( strKey, (String) map.get( substrKey ) ).apply( map );
    }

    public static Predicate<Map<String, Object>> matchesRegex( String strKey, String regex ) {
        return map -> ((String) map.get( strKey )).matches( regex );
    }

    public static Function<Map<String, Object>, String> concatenateWith( String strKey, String substr ) {
        return map -> concatenate( (String) map.get( strKey ), substr );
    }

    public static Function<Map<String, Object>, String> concatenateWith( String strKey, String substr, String delimiter ) {
        return map -> concatenate( (String) map.get( strKey ), delimiter, substr );
    }

    public static Function<Map<String, Object>, String> concatenateWithAssociated( String strKey, String substrKey ) {
        return map -> concatenate( (String) map.get( strKey ), (String) map.get( substrKey ) );
    }

    public static Function<Map<String, Object>, String> concatenateWithAssociated( String strKey, String substrKey, String delimiter ) {
        return map -> concatenate( (String) map.get( strKey ), delimiter, (String) map.get( substrKey ) );
    }

    public static Function<Map<String, Object>, List<String>> split( String strKey, String regexDelimiter ) {
        return map -> Arrays.stream( ((String) map.get( strKey )).split( regexDelimiter ) ).toList();
    }

    public static Function<Map<String, Object>, List<String>> tokenize( String strKey, String delimiter ) {
        return map -> {
            StringTokenizer st = new StringTokenizer( ((String) map.get( strKey )), delimiter );
            final var tokens = new LinkedList<String>();
            while ( st.hasMoreTokens() )
                tokens.add( st.nextToken() );
            return tokens;
        };
    }

    public static Function<Map<String, Object>, String> trim( String strKey ) {
        return map -> ((String) map.get( strKey )).trim();
    }

    public static Function<Map<String, Object>, String> strip( String strKey ) {
        return map -> ((String) map.get( strKey )).strip();
    }

    public static Function<Map<String, Object>, String> toLowerCase( String strKey ) {
        return map -> ((String) map.get( strKey )).toLowerCase();
    }

    public static Function<Map<String, Object>, String> toUpperCase( String strKey ) {
        return map -> ((String) map.get( strKey )).toUpperCase();
    }

    public static Function<Map<String, Object>, String> replaceAllWithSubstr( String strKey, String thisRegex, String withSubstr ) {
        return map -> ((String) map.get( strKey )).replaceAll( thisRegex, withSubstr );
    }

    public static Function<Map<String, Object>, String> replaceAllWithAssociatedSubstr( String strKey, String thisRegex, String withSubstrKey ) {
        return map -> replaceAllWithSubstr( strKey, thisRegex, (String) map.get( withSubstrKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, T> castStringTo( String strKey, Class<T> clazz ) {
        final var converters = new HashMap<Class<?>, Function<String, ?>>();
        converters.put( Short.class, Short::valueOf );
        converters.put( Integer.class, Integer::valueOf );
        converters.put( Long.class, Long::valueOf );
        converters.put( Float.class, Float::valueOf );
        converters.put( Double.class, Double::valueOf );
        converters.put( Boolean.class, Boolean::valueOf );
        converters.put( BigInteger.class, BigInteger::new );
        converters.put( BigDecimal.class, BigDecimal::new );
        converters.put( String.class, String::valueOf );
        converters.put( char[].class, String::toCharArray );
        converters.put( byte[].class, String::getBytes );

        return map -> {
            if ( converters.containsKey( clazz ) )
                return clazz.cast( converters.get( clazz ).apply( (String) map.get( strKey ) ) );
            else
                throw new UnsupportedOperationException( "Unsupported Type." );
        };
    }

}
