package util.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetUtil {

    public static <T extends Set<?>> T createNewSet( Class<T> setClass ) {
        try {
            return setClass.getConstructor().newInstance();
        } catch ( Exception e ){
            throw new RuntimeException( e );
        }
    }

    public static <T extends Set<?>> T createNewSet( Class<T> setClass, Comparator<?> comparator ) {
        try {
            return setClass.getConstructor( Comparator.class ).newInstance( comparator );
        } catch ( Exception e ){
            throw new RuntimeException( e );
        }
    }

    public static <T extends Set<U>, U> Set<U> createNewSetLike( T set ) {
        final var setClass = set.getClass();
        return TreeSet.class.isAssignableFrom( setClass ) ? (Set<U>) createNewSet( setClass, ((TreeSet<U>) set).comparator() )
                                                              : (Set<U>) createNewSet( setClass );
    }

}
