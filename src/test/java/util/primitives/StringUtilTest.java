package util.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static util.primitives.StringUtil.concatenate;

public class StringUtilTest {

    @Test
    void concatenatingNoStringsShouldReturnEmptyString() {
        Assertions.assertEquals( "", concatenate() );
    }

    @Test
    void concatenatingOneStringShouldReturnOriginalString() {
        Assertions.assertEquals( "hello", concatenate( "hello" ) );
    }

    @Test
    void concatenatingMultipleStringsShouldReturnConcatenatedString() {
        Assertions.assertEquals( "hello world", concatenate( "hello", " ", "world" ) );
    }

    @Test
    void concatenatingOneEmptyStringShouldReturnEmptyString() {
        Assertions.assertEquals( "", concatenate( "" ) );
    }

    @Test
    void concatenatingNullShouldReturnEmptyString() {
        Assertions.assertEquals( "", concatenate( null ) );
    }

    @Test
    void concatenatingMultipleStringsWithNullShouldResultInConcatenatedStringWithoutNull() {
        Assertions.assertEquals( "hello world", concatenate( "hello", null, " ", "world" ) );
    }

}
