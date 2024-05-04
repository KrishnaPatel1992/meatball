package map.datastructures;

import map.configuration.MapToMeatballConverter;
import util.collections.MapUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static util.cloning.CloningUtil.deepClone;
import static util.collections.MapUtil.*;
import static com.fasterxml.jackson.databind.DeserializationFeature.USE_LONG_FOR_INTS;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

@JsonDeserialize( converter = MapToMeatballConverter.class )
public final class Meatball implements Map<String, Object>, Serializable {

    private final Map<String, Object> map;

    @Serial
    private static final long serialVersionUID = 19920501L;

    public Meatball() {
        map = new ConcurrentHashMap<>();
    }

    public Meatball( Map<String, ?> map ) {
        this.map = map == null ? new ConcurrentHashMap<>() : new ConcurrentHashMap<>( deepClone( createNewHashMapWithoutNulls( map ) ) );
    }

    public Meatball( Object... keyValuePairs ) {
        final var clonedPairs = deepClone( keyValuePairs );
        this.map = enrichMapButSkipNullKeysAndFilterNewNulls( new ConcurrentHashMap<>(), clonedPairs );
    }

    @Override
    public Object put( String key, Object value ) {
        throw new UnsupportedOperationException( "Use enrich instead." );
    }

    public Meatball enrich( String key, Object value ) {
        return enrichAll( key, value );
    }

    @Override
    public void putAll( Map<? extends String, ?> map ) {
        throw new UnsupportedOperationException( "Use enrichAll instead." );
    }

    public Meatball enrichAll( Object... keyValuePairs ) {
        return new Meatball( enrichMapButSkipNullKeysAndFilterNewNulls( new ConcurrentHashMap<>( map ), keyValuePairs ) );
    }

    public Meatball enrichAll( Map<String, Object> keyValuePairs ) {
        final var map = new ConcurrentHashMap<>( this.map );
        enrichMapButSkipNullKeysAndFilterNewNulls( map, keyValuePairs );
        return new Meatball( map );
    }

    public Meatball copy( String keyFrom, String keyTo ) {
        return copyAll( keyFrom, keyTo );
    }

    public Meatball copyAll( String... keyPairs ) {
        return new Meatball( MapUtil.copyAll( new HashMap<>( this.map ), keyPairs ) );
    }

    public Meatball rename( String keyFrom, String keyTo ) {
        return renameAll( keyFrom, keyTo );
    }

    public Meatball renameAll( String... keyPairs ) {
        return new Meatball( MapUtil.renameAll( new HashMap<>( this.map ), keyPairs ) );
    }

    @Override
    public Object remove( Object key ) {
        throw new UnsupportedOperationException( "Use discard instead." );
    }

    public Meatball discard( String key ) {
        return discardAll( key );
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException( "Use discard all instead." );
    }

    public Meatball discardAll() {
        return new Meatball();
    }

    public Meatball discardAll( String... keys ) {
        final var map = new HashMap<>( this.map );
        for ( String key: keys )
            map.remove( key );
        return new Meatball( map );
    }

    public Meatball keep( String key ) {
        return keepAll( key );
    }

    public Meatball keepAll( String... keys ) {
        final var map = new HashMap<String, Object>();
        for ( final String key: keys ){
            if ( key == null )
                continue;
            final var value = this.map.get( key );
            map.put( key, value );
        }
        return new Meatball( map );
    }

    @Override
    public Object get( Object key ) {
        return key == null ? null : deepClone( map.get( key ) );
    }

    public <T> T get( String key, Class<T> clazz ) {
        return clazz.cast( get( key ) );
    }

    public <T> T get( String key, T defaultValue ) {
        if ( key == null )
            return defaultValue;

        return map.containsKey( key ) ? (T) get( key ) : defaultValue;
    }

    public Short getShort( String key ) {
        return (Short) get( key );
    }

    public Integer getInteger( String key ) {
        return (Integer) get( key );
    }

    public Long getLong( String key ) {
        return (Long) get( key );
    }

    public Float getFloat( String key ) {
        return (Float) get( key );
    }

    public Double getDouble( String key ) {
        return (Double) get( key );
    }

    public Boolean getBoolean( String key ) {
        return (Boolean) get( key );
    }

    public Character getCharacter( String key ) {
        return (Character) get( key );
    }

    public String getString( String key ) {
        return (String) get( key );
    }

    public Byte getByte( String key ) {
        return (Byte) get( key );
    }

    public BigInteger getBigInteger( String key ) {
        return (BigInteger) get( key );
    }

    public BigDecimal getBigDecimal( String key ) {
        return (BigDecimal) get( key );
    }

    public <T> List<T> getList( String key, Class<T> elementClass ) {
        if ( elementClass == null )
            throw new NullPointerException( "elementClass cannot be null" );
        return (List<T>) get( key );
    }

    public <T> Set<T> getSet( String key, Class<T> elementClass ) {
        if ( elementClass == null )
            throw new NullPointerException( "elementClass cannot be null" );
        return (Set<T>) get( key );
    }

    public <T, U> Map<T, U> getMap( String key, Class<T> keyClass, Class<U> valueClass ) {
        if ( keyClass == null || valueClass == null )
            throw new NullPointerException( "keyClass and valueClass cannot be null" );
        return (Map<T, U>) get( key );
    }

    public <T> Map<T, T> getMap( String key, Class<T> keyAndValueClass ) {
        if ( keyAndValueClass == null )
            throw new NullPointerException( "keyAndValueClass cannot be null" );
        return (Map<T, T>) get( key );
    }

    public <T> PriorityQueue<T> getPriorityQueue( String key, Class<T> elementClass ) {
        if ( elementClass == null )
            throw new NullPointerException( "elementClass cannot be null" );
        return (PriorityQueue<T>) get( key );
    }

    public <T> T[] getArray( String key, Class<T> elementClass ) {
        if ( elementClass == null )
            throw new NullPointerException( "elementClass cannot be null" );
        return (T[]) get( key );
    }

    public Class<?> getClass( String key ) {
        return map.get( key ).getClass();
    }

    @Override
    public Set<String> keySet() {
        return new HashSet<>( map.keySet() );
    }

    @Override
    public Collection<Object> values() {
        return deepClone( new LinkedList<>( map.values() ) );
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return deepClone( map ).entrySet();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey( Object key ) {
        return key != null && map.containsKey( key );
    }

    public boolean containsKeys( String... keys ) {
        return new HashSet<>( map.keySet() ).containsAll( Arrays.stream( keys ).toList() );
    }

    @Override
    public boolean containsValue( Object value ) {
        return value != null && map.containsValue( value );
    }

    public boolean is( String key, Object value ) {
        if ( key == null || !map.containsKey( key ) )
            return value == null;

        return map.get( key ).equals( value );
    }

    public boolean classesAre( Object... keyClassPairs ) {
        return MapUtil.classesAre( map, keyClassPairs );
    }

    public <T> boolean classIs( String key, Class<T> clazz ) {
        return classesAre( key, clazz );
    }

    public boolean in( String key, Collection<?> values ) {
        if ( key == null || !map.containsKey( key ) )
            return values.contains( null );

        return values.contains( map.get( key ) );
    }

    public boolean valuesEqual( String firstKey, String secondKey ) {
        final var firstIsNull = (firstKey == null || !map.containsKey( firstKey ));
        final var secondIsNull = (secondKey == null || !map.containsKey( secondKey ));

        if ( firstIsNull && secondIsNull )
            return true;

        if ( !firstIsNull && !secondIsNull )
            return map.get( firstKey ).equals( map.get( secondKey ) );

        return false;
    }

    public int hashCode() {
        return map.hashCode();
    }

    public String toString() {
        return map.toString();
    }

    public boolean equals( Object o ) {

        if ( o == null )
            return false;

        if ( o == this )
            return true;

        if ( o.getClass() == this.getClass() )
            return ((Meatball) o).map.equals( map );

        return false;
    }

    public static ObjectMapper getObjectMapper() {
        final var module = new SimpleModule( "meatball", Version.unknownVersion() );
        module.addAbstractTypeMapping( Map.class, Meatball.class );

        final var objectMapper = new ObjectMapper();
        objectMapper.configure( USE_LONG_FOR_INTS, true );
        objectMapper.configure( FAIL_ON_EMPTY_BEANS, false );
        objectMapper.registerModule( module );

        return objectMapper;
    }

    public String toJson() {
        try {
            return getObjectMapper().writeValueAsString( this );
        } catch ( JsonProcessingException e ){
            throw new RuntimeException( e );
        }
    }

    public static Meatball fromJson( String json ) {
        try {
            return getObjectMapper().readValue( json, Meatball.class );
        } catch ( JsonProcessingException e ){
            throw new RuntimeException( e );
        }
    }

}