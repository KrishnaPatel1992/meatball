package map.configuration;

import map.datastructures.Meatball;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.Map;

public class MapToMeatballConverter extends StdConverter<Map<String, Object>, Meatball> {

    @Override
    public Meatball convert( Map<String, Object> map ) {
        return new Meatball( map );
    }
}
