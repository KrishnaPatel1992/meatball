package util.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ListUtil {

    public static <T extends List<?>> T createNewList( Class<T> listClass ) {
        try {
            return listClass.getConstructor().newInstance();
        } catch ( Exception e ){
            throw new RuntimeException( e );
        }
    }

    private static <T> int linkedListIndexOf( List<T> list, T element, int fromIndex ) {
        var elementIndex = 0;
        for ( T anotherElement: list ){
            final var indexInRange = elementIndex >= fromIndex;
            final var foundElement = anotherElement.equals( element );
            if ( indexInRange && foundElement )
                return elementIndex;
            elementIndex++;
        }
        return -1;
    }

    private static <T> int arrayListIndexOf( List<T> list, T element, int fromIndex ) {
        for ( int elementIndex = fromIndex; elementIndex < list.size(); elementIndex++ ){
            final var foundElement = list.get( elementIndex ).equals( element );
            if ( foundElement )
                return elementIndex;
        }
        return -1;
    }

    public static <T> int indexOf( List<T> list, T element, int fromIndex ) {
        if ( LinkedList.class.isAssignableFrom( list.getClass() ) )
            return linkedListIndexOf( list, element, Math.max( fromIndex, 0 ) );
        return arrayListIndexOf( list, element, Math.max( fromIndex, 0 ) );
    }

    private static <T> int linkedListLastIndexOf( List<T> list, T element, int fromIndex ) {
        final var iterator = list.iterator();
        var elementIndex = 0;
        var lastIndex = -1;
        while ( elementIndex <= fromIndex ){
            final var foundElement = iterator.next().equals( element );
            if ( foundElement )
                lastIndex = elementIndex;
            elementIndex++;
        }
        return lastIndex;
    }

    private static <T> int arrayListLastIndexOf( List<T> list, T element, int fromIndex ) {
        for ( int elementIndex = fromIndex; elementIndex >= 0; elementIndex-- ){
            final var foundElement = list.get( elementIndex ).equals( element );
            if ( foundElement )
                return elementIndex;
        }
        return -1;
    }

    public static <T> int lastIndexOf( List<T> list, T element, int fromIndex ) {
        if ( LinkedList.class.isAssignableFrom( list.getClass() ) )
            return linkedListLastIndexOf( list, element, Math.min( fromIndex, list.size() - 1 ) );
        return arrayListLastIndexOf( list, element, Math.min( fromIndex, list.size() - 1 ) );
    }

    private static <T> List<T> arrayListSublist( List<T> list, int beginIndex, int endIndex ) {
        final var newList = (List<T>) createNewList( list.getClass() );
        for ( int elementIndex = beginIndex; elementIndex < endIndex; elementIndex++ )
            newList.add( list.get( elementIndex ) );
        return newList;
    }

    private static <T> List<T> linkedListSublist( List<T> list, int beginIndex, int endIndex ) {
        final var newList = (List<T>) createNewList( list.getClass() );
        final var iterator = list.iterator();
        var elementIndex = 0;
        while ( elementIndex < endIndex ){
            final var element = iterator.next();
            if ( elementIndex >= beginIndex )
                newList.add( element );
            elementIndex++;
        }
        return newList;
    }

    public static <T> List<T> sublist( List<T> list, int beginIndex, int endIndex ) {
        if ( list.size() == 0 )
            return (List<T>) createNewList( list.getClass() );
        if ( beginIndex > endIndex )
            throw new IllegalArgumentException( "beginIndex cannot be greater than endIndex" );

        if ( LinkedList.class.isAssignableFrom( list.getClass() ) )
            return linkedListSublist( list, Math.max( beginIndex, 0 ), Math.min( endIndex, list.size() ) );
        return arrayListSublist( list, Math.max( beginIndex, 0 ), Math.min( endIndex, list.size() ) );
    }

    public static <T> List<T> intersection( List<T> firstList, List<T> secondList ) {
        final var unintersectedElementsInFirstList = new HashMap<T, Integer>();
        for ( T element: firstList ){
            final var count = unintersectedElementsInFirstList.getOrDefault( element, 0 );
            unintersectedElementsInFirstList.put( element, count + 1 );
        }

        final var intersection = new LinkedList<T>();
        for ( T element: secondList ){
            final var availableAmount = unintersectedElementsInFirstList.getOrDefault( element, 0 );
            if ( availableAmount > 0 ){
                intersection.add( element );
                unintersectedElementsInFirstList.put( element, availableAmount - 1 );
            }
        }

        return intersection;
    }

    public static <T> List<T> complement( List<T> firstList, List<T> secondList ) {
        final var uncomplementedElementsInSecondList = new HashMap<T, Integer>();
        for ( T element: secondList ){
            final var count = uncomplementedElementsInSecondList.getOrDefault( element, 0 );
            uncomplementedElementsInSecondList.put( element, count + 1 );
        }

        final var complement = new LinkedList<T>();
        for ( T element: firstList ){
            final var availableAmount = uncomplementedElementsInSecondList.getOrDefault( element, 0 );
            if ( availableAmount > 0 )
                uncomplementedElementsInSecondList.put( element, availableAmount - 1 );
            else if ( availableAmount == 0 )
                complement.add( element );
        }

        return complement;
    }

    public static <T> List<T> difference( List<T> firstList, List<T> secondList ) {
        final var firstComplement = complement( firstList, secondList );
        final var secondComplement = complement( secondList, firstList );
        firstComplement.addAll( secondComplement );
        return firstComplement;
    }

    @SafeVarargs
    public static <T, U extends List<T>> U combineLists( Class<U> listClass, U... lists ) {
        final var newList = createNewList( listClass );
        for ( U list: lists )
            newList.addAll( list );
        return newList;
    }

}
