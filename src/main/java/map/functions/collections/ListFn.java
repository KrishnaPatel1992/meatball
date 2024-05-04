package map.functions.collections;

import util.collections.ListUtil;

import java.util.*;
import java.util.function.Function;

import static util.collections.ListUtil.createNewList;

public class ListFn {

    public static <T> Function<Map<String, Object>, Integer> indexOfElement( String listKey, T element ) {
        return map -> ((List<T>) map.get( listKey )).indexOf( element );
    }

    public static <T> Function<Map<String, Object>, Integer> indexOfElement( String listKey, Class<T> elementClass, String elementKey ) {
        return map -> indexOfElement( listKey, elementClass.cast( map.get( elementKey ) ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> indexOfElement( String listKey, T element, int fromIndex ) {
        return map -> ListUtil.indexOf( (List<T>) map.get( listKey ), element, fromIndex );
    }

    public static <T> Function<Map<String, Object>, Integer> indexOfElement( String listKey, Class<T> elementClass, String elementKey, int fromIndex ) {
        return map -> indexOfElement( listKey, elementClass.cast( map.get( elementKey ) ), fromIndex ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> indexOfElement( String listKey, T element, String fromIndexKey ) {
        return map -> indexOfElement( listKey, element, (int) map.get( fromIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> indexOfElement( String listKey, Class<T> elementClass, String elementKey, String fromIndexKey ) {
        return map -> indexOfElement( listKey, elementClass, elementKey, (int) map.get( fromIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> lastIndexOfElement( String listKey, T element ) {
        return map -> ((List<T>) map.get( listKey )).lastIndexOf( element );
    }

    public static <T> Function<Map<String, Object>, Integer> lastIndexOfElement( String listKey, Class<T> elementClass, String elementKey ) {
        return map -> lastIndexOfElement( listKey, elementClass.cast( map.get( elementKey ) ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> lastIndexOfElement( String listKey, T element, int fromIndex ) {
        return map -> ListUtil.lastIndexOf( (List<T>) map.get( listKey ), element, fromIndex );
    }

    public static <T> Function<Map<String, Object>, Integer> lastIndexOfElement( String listKey, Class<T> elementClass, String elementKey, int fromIndex ) {
        return map -> lastIndexOfElement( listKey, elementClass.cast( map.get( elementKey ) ), fromIndex ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> lastIndexOfElement( String listKey, T element, String fromIndexKey ) {
        return map -> lastIndexOfElement( listKey, element, (int) map.get( fromIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> lastIndexOfElement( String listKey, Class<T> elementClass, String elementKey, String fromIndexKey ) {
        return map -> lastIndexOfElement( listKey, elementClass, elementKey, (int) map.get( fromIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, Integer> binarySearchList( String listKey, T element ) {
        return map -> {
            final var list = (List<? extends Comparable<? super T>>) map.get( listKey );
            return Collections.binarySearch( list, element );
        };
    }

    public static <T> Function<Map<String, Object>, Integer> binarySearchList( String listKey, Class<T> elementClass, String elementKey ) {
        return map -> binarySearchList( listKey, elementClass.cast( map.get( elementKey ) ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, T> getFromList( String listKey, Class<T> elementClass, int elementIndex ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            return list.get( elementIndex );
        };
    }

    public static <T> Function<Map<String, Object>, T> getFromList( String listKey, Class<T> elementClass, String elementIndexKey ) {
        return map -> getFromList( listKey, elementClass, (int) map.get( elementIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> sublist( String listKey, Class<T> elementClass, int beginIndex ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            return ListUtil.sublist( list, beginIndex, list.size() );
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> sublist( String listKey, Class<T> elementClass, String beginIndexKey ) {
        return map -> sublist( listKey, elementClass, (int) map.get( beginIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> sublist( String listKey, Class<T> elementClass, int beginIndex, int endIndex ) {
        return map -> ListUtil.sublist( (List<T>) map.get( listKey ), beginIndex, endIndex );
    }

    public static <T> Function<Map<String, Object>, List<T>> sublist( String listKey, Class<T> elementClass, String beginIndexKey, int endIndex ) {
        return map -> sublist( listKey, elementClass, (int) map.get( beginIndexKey ), endIndex ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> sublist( String listKey, Class<T> elementClass, int beginIndex, String endIndexKey ) {
        return map -> sublist( listKey, elementClass, beginIndex, (int) map.get( endIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> sublist( String listKey, Class<T> elementClass, String beginIndexKey, String endIndexKey ) {
        return map -> sublist( listKey, elementClass, beginIndexKey, (int) map.get( endIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addToList( String listKey, T element ) {
        final var elements = new ArrayList<T>();
        elements.add( element );
        return addAllToList( listKey, elements );
    }

    public static <T> Function<Map<String, Object>, List<T>> addToList( String listKey, Class<T> elementClass, String elementKey ) {
        return map -> addToList( listKey, elementClass.cast( map.get( elementKey ) ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addToList( String listKey, T element, int insertionIndex ) {
        final var elements = new ArrayList<T>();
        elements.add( element );
        return addAllToList( listKey, elements, insertionIndex );
    }

    public static <T> Function<Map<String, Object>, List<T>> addToList( String listKey, Class<T> elementClass, String elementKey, int insertionIndex ) {
        return map -> addToList( listKey, elementClass.cast( map.get( elementKey ) ), insertionIndex ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addToList( String listKey, T element, String insertionIndexKey ) {
        return map -> addToList( listKey, element, (int) map.get( insertionIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addToList( String listKey, Class<T> elementClass, String elementKey, String insertionIndexKey ) {
        return map -> addToList( listKey, elementClass, elementKey, (int) map.get( insertionIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addAllToList( String listKey, Collection<T> elements ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            list.addAll( elements );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> addAllToList( String listKey, Class<T> elementClass, String elementsKey ) {
        return map -> addAllToList( listKey, (Collection<T>) map.get( elementsKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addAllToList( String listKey, Collection<T> elements, int insertionIndex ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            list.addAll( insertionIndex, elements );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> addAllToList( String listKey, Class<T> elementClass, String elementsKey, int insertionIndex ) {
        return map -> addAllToList( listKey, (Collection<T>) map.get( elementsKey ), insertionIndex ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addAllToList( String listKey, Collection<T> elements, String insertionIndexKey ) {
        return map -> addAllToList( listKey, elements, (int) map.get( insertionIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> addAllToList( String listKey, Class<T> elementClass, String elementsKey, String insertionIndexKey ) {
        return map -> addAllToList( listKey, elementClass, elementsKey, (int) map.get( insertionIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> setListIndex( String listKey, T element, int insertionIndex ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            list.set( insertionIndex, element );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> setListIndex( String listKey, Class<T> elementClass, String elementKey, int insertionIndex ) {
        return map -> setListIndex( listKey, elementClass.cast( map.get( elementKey ) ), insertionIndex ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> setListIndex( String listKey, T element, String insertionIndexKey ) {
        return map -> setListIndex( listKey, element, (int) map.get( insertionIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> setListIndex( String listKey, Class<T> elementClass, String elementKey, String insertionIndexKey ) {
        return map -> setListIndex( listKey, elementClass, elementKey, (int) map.get( insertionIndexKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> removeFromList( String listKey, T element ) {
        final var elements = new ArrayList<T>();
        elements.add( element );
        return removeAllFromList( listKey, elements );
    }

    public static <T> Function<Map<String, Object>, List<T>> removeFromList( String listKey, Class<T> elementClass, String elementKey ) {
        return map -> removeFromList( listKey, elementClass.cast( map.get( elementKey ) ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> removeAllFromList( String listKey, Collection<T> elements ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            list.removeAll( elements );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> removeAllFromList( String listKey, Class<T> elementClass, String elementsKey ) {
        return map -> removeAllFromList( listKey, (Collection<T>) map.get( elementsKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> retainAllInList( String listKey, Collection<T> elements ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            list.retainAll( elements );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> retainAllInList( String listKey, Class<T> elementClass, String elementsKey ) {
        return map -> retainAllInList( listKey, (Collection<T>) map.get( elementsKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> clearList( String listKey, Class<T> elementClass ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            list.clear();
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> sortList( String listKey, Comparator<T> orderBy ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            list.sort( orderBy );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> reverseList( String listKey, Class<T> elementClass ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            Collections.reverse( list );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> shuffleList( String listKey, Class<T> elementClass ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            Collections.shuffle( list );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> intersectionWithList( String firstListKey, List<T> secondList ) {
        return map -> {
            final var firstList = (List<T>) map.get( firstListKey );
            return ListUtil.intersection( firstList, secondList );
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> intersectionWithList( String firstListKey, Class<T> elementClass, String secondListKey ) {
        return map -> intersectionWithList( firstListKey, (List<T>) map.get( secondListKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> complementWithList( String firstListKey, List<T> secondList ) {
        return map -> {
            final var firstList = (List<T>) map.get( firstListKey );
            return ListUtil.complement( firstList, secondList );
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> complementWithList( String firstListKey, Class<T> elementClass, String secondListKey ) {
        return map -> complementWithList( firstListKey, (List<T>) map.get( secondListKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, List<T>> differenceBetweenLists( String firstListKey, List<T> secondList ) {
        return map -> {
            final var firstList = (List<T>) map.get( firstListKey );
            return ListUtil.difference( firstList, secondList );
        };
    }

    public static <T> Function<Map<String, Object>, List<T>> differenceBetweenLists( String firstListKey, Class<T> elementClass, String secondListKey ) {
        return map -> differenceBetweenLists( firstListKey, (List<T>) map.get( secondListKey ) ).apply( map );
    }

    public static <T> Function<Map<String, Object>, T[]> castListToArray( String listKey, Class<T> elementClass ) {
        return map -> {
            final var list = (List<T>) map.get( listKey );
            return list.toArray( (T[]) java.lang.reflect.Array.newInstance( elementClass, list.size() ) );
        };
    }

    public static <T, U extends List<T>> Function<Map<String, Object>, List<T>> castArrayToList( String arrayKey, Class<T> elementClass, Class<U> listClass ) {
        return map -> {
            final var array = (T[]) map.get( arrayKey );
            final var list = createNewList( listClass );
            list.addAll( Arrays.asList( array ) );
            return list;
        };
    }

    public static <T> Function<Map<String, Object>, Set<T>> castListToSet( String listKey, Class<T> elementClass ) {
        return map -> new HashSet<>( (List<T>) map.get( listKey ) );
    }

    public static <T, U extends List<T>> Function<Map<String, Object>, List<T>> castSetToList( String setKey, Class<T> elementClass, Class<U> listClass ) {
        return map -> {
            final var set = (Set<T>) map.get( setKey );
            final var list = createNewList( listClass );
            list.addAll( set );
            return list;
        };
    }

}
