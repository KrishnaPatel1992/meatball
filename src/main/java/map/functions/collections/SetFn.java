package map.functions.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class SetFn {

    public static <T> Function<Map<String, Object>, Set<T>> addToSet( String setKey, T element ) {
        return map -> {
            final var set = (Set<T>) map.get( setKey );
            set.add( element );
            return set;
        };
    }

    public static <T> Function<Map<String, Object>, Set<T>> addToSet( String setKey, Class<T> elementClass, String elementKey ) {
        return map -> addToSet( setKey, elementClass.cast( map.get( elementKey ) ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Set<T>> addAllToSet( String setKey, Collection<T> elements ) {
        return map -> {
            final var set = (Set<T>) map.get( setKey );
            set.addAll( elements );
            return set;
        };
    }

    public static <T> Function<Map<String, Object>, Set<T>> addAllToSet( String setKey, Class<T> elementClass, String elementsKey ) {
        return map -> addAllToSet( setKey, (Collection<T>) map.get( elementsKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Set<T>> removeFromSet( String setKey, T element ) {
        return map -> {
            final var set = (Set<T>) map.get( setKey );
            set.remove( element );
            return set;
        };
    }

    public static <T> Function<Map<String, Object>, Set<T>> removeFromSet( String setKey, Class<T> elementClass, String elementKey ) {
        return map -> removeFromSet( setKey, elementClass.cast( map.get( elementKey ) ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Set<T>> removeAllFromSet( String setKey, Collection<T> elements ) {
        return map -> {
            final var set = (Set<T>) map.get( setKey );
            set.removeAll( elements );
            return set;
        };
    }

    public static <T> Function<Map<String, Object>, Set<T>> removeAllFromSet( String setKey, Class<T> elementClass, String elementsKey ) {
        return map -> removeAllFromSet( setKey, (Collection<T>) map.get( elementsKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Set<T>> retainAllInSet( String setKey, Collection<T> elements ) {
        return map -> {
            final var set = (Set<T>) map.get( setKey );
            set.retainAll( elements );
            return set;
        };
    }

    public static <T> Function<Map<String, Object>, Set<T>> retainAllInSet( String setKey, Class<T> elementClass, String elementsKey ) {
        return map -> retainAllInSet( setKey, (Collection<T>) map.get( elementsKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Set<T>> clearSet( String setKey, Class<T> elementClass ) {
        return map -> {
            final var set = (Set<T>) map.get( setKey );
            set.clear();
            return set;
        };
    }

}
