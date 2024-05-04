package map.functions.collections;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionFn {

    public static Function<Map<String, Object>, Integer> size( String collectionKey ) {
        return map -> ((Collection<?>) map.get( collectionKey )).size();
    }

    public static <T> Predicate<Map<String, Object>> contains( String collectionKey, T element ) {
        return map -> {
            final var collection = (Collection<T>) map.get( collectionKey );
            return collection.contains( element );
        };
    }

    public static <T> Predicate<Map<String, Object>> contains( String collectionKey, Class<T> elementClass, String elementKey ) {
        return map -> contains( collectionKey, elementClass.cast( map.get( elementKey ) ) ).test( map );
    }

    public static Predicate<Map<String, Object>> isEmpty( String collectionKey ) {
        return map -> ((Collection<?>) map.get( collectionKey )).isEmpty();
    }

    public static <T> Predicate<Map<String, Object>> containsAll( String collectionKey, Collection<T> elements ) {
        return map -> new HashSet<>( (Collection<T>) map.get( collectionKey ) ).containsAll( elements );
    }

    public static <T> Predicate<Map<String, Object>> containsAll( String collectionKey, Class<T> elementClass, String elementsKey ) {
        return map -> containsAll( collectionKey, (Collection<T>) map.get( elementsKey ) ).test( map );
    }

    public static <T extends Number & Comparable<? super T>> Function<Map<String, Object>, T> min( String collectionKey, Class<T> elementClass ) {
        return map -> Collections.min( (Collection<T>) map.get( collectionKey ), Comparator.naturalOrder() );
    }

    public static <T extends Number & Comparable<? super T>> Function<Map<String, Object>, T> max( String collectionKey, Class<T> elementClass ) {
        return map -> Collections.max( (Collection<T>) map.get( collectionKey ), Comparator.naturalOrder() );
    }

}
