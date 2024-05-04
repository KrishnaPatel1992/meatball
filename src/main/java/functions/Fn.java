package functions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Fn {

    public static <T, U> Function<T, U> when( Predicate<T> when, Function<T, U> then, Function<T, U> otherwise ) {
        return object -> when.test( object ) ? then.apply( object ) : otherwise.apply( object );
    }

    public static <T> Function<T, T> when( Predicate<T> when, Function<T, T> then ) {
        return when( when, then, object -> object );
    }

    public static <T> Consumer<T> when( Predicate<T> when, Consumer<T> then, Consumer<T> otherwise ) {
        return object -> {
            if ( when.test( object ) )
                then.accept( object );
            else
                otherwise.accept( object );
        };
    }

    public static <T> Consumer<T> when( Predicate<T> when, Consumer<T> then ) {
        return when( when, then, object -> {} );
    }

    public static <T, U extends RuntimeException> Function<T, T> when( Predicate<T> when, U exception ) {
        return object -> {
            if ( when.test( object ) )
                throw exception;
            return object;
        };
    }

    @FunctionalInterface
    interface ThrowingFunction<T, U> {
        U apply( T object ) throws Exception;
    }

    public static <T, U> Function<T, U> uncheck( ThrowingFunction<T, U> fn ) {
        return object -> {
            try {
                return fn.apply( object );
            } catch ( Exception exception ){
                throw new RuntimeException( "Unchecked exception thrown." );
            }
        };
    }

    public static <T, U> Function<T, T> doOnNext( Function<T, U> fn ) {
        return map -> {
            fn.apply( map );
            return map;
        };
    }

    public static <T> Function<T, T> doOnNext( Consumer<T> fn ) {
        return map -> {
            fn.accept( map );
            return map;
        };
    }

    public static <T> Function<T, Boolean> asFunction( Predicate<T> predicate ) {
        return predicate::test;
    }

    public static <T> Predicate<T> asPredicate( Function<T, Boolean> fn ) {
        return fn::apply;
    }

    public static <T> Consumer<T> print(){
        return System.out::println;
    }

    public static <T> Consumer<T> print( String prefix ) {
        return object -> System.out.println( prefix + ": " + object );
    }

    public static <T> Consumer<T> printErr(){
        return System.err::println;
    }

    public static <T> Consumer<T> printErr( String prefix ) {
        return object -> System.err.println( prefix + ": " + object );
    }

}
