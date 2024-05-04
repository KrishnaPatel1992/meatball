package util.primitives;

import java.util.function.Function;

public class BooleanUtil {

    public static Function<Boolean, Boolean> not = bool -> !bool;

}
