package map.functions.primitives;

import java.util.Map;
import java.util.function.Predicate;

public class BooleanFn {

    public static Predicate<Map<String, Object>> and( String boolKey, Boolean bool ) {
        return map -> (boolean) map.get( boolKey ) && bool;
    }

    public static Predicate<Map<String, Object>> and( String firstBoolKey, String secondBoolKey ) {
        return map -> and( firstBoolKey, (boolean) map.get( secondBoolKey ) ).test( map );
    }

    public static Predicate<Map<String, Object>> or( String boolKey, Boolean bool ) {
        return map -> (boolean) map.get( boolKey ) || bool;
    }

    public static Predicate<Map<String, Object>> or( String firstBoolKey, String secondBoolKey ) {
        return map -> or( firstBoolKey, (boolean) map.get( secondBoolKey ) ).test( map );
    }

    public static Predicate<Map<String, Object>> xor( String boolKey, Boolean bool ) {
        return map -> {
            final var firstTrueSecondFalse = (boolean) map.get( boolKey ) && !bool;
            final var firstFalseSecondTrue = !(boolean) map.get( boolKey ) && bool;
            return firstTrueSecondFalse || firstFalseSecondTrue;
        };
    }

    public static Predicate<Map<String, Object>> xor( String firstBoolKey, String secondBoolKey ) {
        return map -> xor( firstBoolKey, (boolean) map.get( secondBoolKey ) ).test( map );
    }

    public static Predicate<Map<String, Object>> not( String boolKey ) {
        return map -> !(boolean) map.get( boolKey );
    }

}
