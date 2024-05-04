package util.primitives;

public class StringUtil {

    public static String concatenate( String... strs ) {
        if ( strs == null )
            return "";

        StringBuilder sb = new StringBuilder();
        for ( String str: strs )
            if ( str != null )
                sb.append( str );

        return sb.toString();
    }

}
