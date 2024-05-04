package util.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static util.primitives.BooleanUtil.not;

public class BooleanUtilTest {

    @Test
    void trueShouldMapToFalse() {
        Assertions.assertFalse( not.apply( true ) );
    }

    @Test
    void falseShouldMapToTrue() {
        Assertions.assertTrue( not.apply( false ) );
    }

    @Test
    void shouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> not.apply( null ) );
    }


}
