package util;

import java.util.function.BiConsumer;

public class Util {

    public static <T, U> void doForAllPairs( BiConsumer<T, U> fn, Object... pairs ) {
        if ( pairs.length % 2 != 0 )
            throw new IllegalArgumentException( "Incomplete pair supplied." );

        for ( int fromIndex = 0; fromIndex < pairs.length; fromIndex += 2 ){
            final var firstMember = (T) pairs[fromIndex];
            final var secondMember = (U) pairs[fromIndex + 1];
            fn.accept( firstMember, secondMember );
        }
    }

}
