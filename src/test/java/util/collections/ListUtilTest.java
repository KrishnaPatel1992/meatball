package util.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static util.collections.ListUtil.*;

public class ListUtilTest {

    private final ArrayList<Integer> emptyArrayList = new ArrayList<>( List.of() );
    private final LinkedList<Integer> emptyLinkedList = new LinkedList<>( List.of() );
    private final ArrayList<Integer> arrayListWithOneElement = new ArrayList<>( List.of( 5 ) );
    private final LinkedList<Integer> linkedListWithOneElement = new LinkedList<>( List.of( 5 ) );
    private final ArrayList<Integer> arrayListWithTwoElements = new ArrayList<>( List.of( 4, 5 ) );
    private final LinkedList<Integer> linkedListWithTwoElements = new LinkedList<>( List.of( 4, 5 ) );
    private final ArrayList<Integer> arrayListWithThreeElements = new ArrayList<>( List.of( 4, 5, 6 ) );
    private final LinkedList<Integer> linkedListWithThreeElements = new LinkedList<>( List.of( 4, 5, 6 ) );
    private final ArrayList<Integer> arrayListWithEightElements = new ArrayList<>( List.of( 1, 2, 3, 4, 5, 6, 7, 8 ) );
    private final LinkedList<Integer> linkedListWithEightElements = new LinkedList<>( List.of( 1, 2, 3, 4, 5, 6, 7, 8 ) );
    private final ArrayList<Integer> arrayListWithNineElements = new ArrayList<>( List.of( 1, 2, 3, 4, 5, 6, 7, 8, 9 ) );
    private final LinkedList<Integer> linkedListWithNineElements = new LinkedList<>( List.of( 1, 2, 3, 4, 5, 6, 7, 8, 9 ) );
    private final ArrayList<Integer> arrayListWithDuplicates = new ArrayList<>( List.of( 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 ) );
    private final LinkedList<Integer> linkedListWithDuplicates = new LinkedList<>( List.of( 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 ) );
    private final ArrayList<String> oneMeat = new ArrayList<>( List.of( "Chicken" ) );
    private final ArrayList<String> oneVegetable = new ArrayList<>( List.of( "Potatoes" ) );
    private final ArrayList<String> onePizzaTopping = new ArrayList<>( List.of( "Chicken" ) );
    private final ArrayList<String> twoMeats = new ArrayList<>( List.of( "Chicken", "Lamb" ) );
    private final ArrayList<String> twoVegetables = new ArrayList<>( List.of( "Potatoes", "Onions" ) );
    private final ArrayList<String> twoPizzaToppings = new ArrayList<>( List.of( "Chicken", "Onion" ) );
    private final ArrayList<String> threeMeats = new ArrayList<>( List.of( "Chicken", "Lamb", "Fish" ) );
    private final ArrayList<String> threeVegetables = new ArrayList<>( List.of( "Potatoes", "Onions", "Cauliflower" ) );
    private final ArrayList<String> threePizzaToppings = new ArrayList<>( List.of( "Chicken", "Onion", "Prawns" ) );
    private final ArrayList<String> sixMeats = new ArrayList<>( List.of( "Chicken", "Lamb", "Fish", "Prawns", "Crabs", "Venison" ) );
    private final ArrayList<String> sixVegetables = new ArrayList<>( List.of( "Potatoes", "Onion", "Cauliflower", "Asparagus", "Turnips", "Sweetcorn" ) );
    private final ArrayList<String> sixPizzaToppings = new ArrayList<>( List.of( "Chicken", "Onion", "Prawns", "Tomato", "Cheese", "Olives" ) );
    private final ArrayList<String> sevenMeats = new ArrayList<>( List.of( "Chicken", "Lamb", "Fish", "Prawns", "Crabs", "Venison", "Goat" ) );
    private final ArrayList<String> sevenVegetables = new ArrayList<>( List.of( "Potatoes", "Onion", "Cauliflower", "Asparagus", "Turnips", "Sweetcorn", "Eggplant" ) );
    private final ArrayList<String> sevenPizzaToppings = new ArrayList<>( List.of( "Chicken", "Onion", "Prawns", "Tomato", "Cheese", "Olives", "Pineapple" ) );
    private final List<String> twoCatsTwoDogsOneMouse = List.of( "Cat", "Cat", "Dog", "Dog", "Mouse" );
    private final List<String> threeCatsTwoDogsOneMouse = List.of( "Cat", "Cat", "Cat", "Dog", "Dog", "Mouse" );

    @Test
    void createNewListReturnsNewListOfSpecifiedType() {
        Assertions.assertEquals( ArrayList.class, createNewList( ArrayList.class ).getClass() );
        Assertions.assertEquals( 0, createNewList( ArrayList.class ).size() );
    }

    @Test
    void createNewListWithNullValueShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> createNewList( null ) );
    }

    @Test
    void indexOfAppliedToEmptyListReturnsMinusOne() {
        Assertions.assertEquals( -1, indexOf( emptyArrayList, 5, 0 ) );
        Assertions.assertEquals( -1, indexOf( emptyLinkedList, 5, 0 ) );
    }

    private void indexOfElementInFirstPositionReturnsZero( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, indexOf( listWithOneElement, 5, 0 ) );
        Assertions.assertEquals( 0, indexOf( listWithTwoElements, 4, 0 ) );
        Assertions.assertEquals( 0, indexOf( listWithThreeElements, 4, 0 ) );
        Assertions.assertEquals( 0, indexOf( listWithEightElements, 1, 0 ) );
        Assertions.assertEquals( 0, indexOf( listWithNineElements, 1, 0 ) );
    }

    @Test
    void indexOfElementInFirstPositionReturnsZero() {
        indexOfElementInFirstPositionReturnsZero( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        indexOfElementInFirstPositionReturnsZero( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void indexOfElementInMiddlePositionReturnsCorrectIndex( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, indexOf( listWithOneElement, 5, 0 ) );
        Assertions.assertEquals( 1, indexOf( listWithTwoElements, 5, 0 ) );
        Assertions.assertEquals( 1, indexOf( listWithThreeElements, 5, 0 ) );
        Assertions.assertEquals( 5, indexOf( listWithEightElements, 6, 0 ) );
        Assertions.assertEquals( 4, indexOf( listWithNineElements, 5, 0 ) );
    }

    @Test
    void indexOfElementInMiddlePositionReturnsCorrectIndex() {
        indexOfElementInMiddlePositionReturnsCorrectIndex( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        indexOfElementInMiddlePositionReturnsCorrectIndex( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );

    }

    private void indexOfElementInLastPositionReturnsLastIndex( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, indexOf( listWithOneElement, 5, 0 ) );
        Assertions.assertEquals( 1, indexOf( listWithTwoElements, 5, 0 ) );
        Assertions.assertEquals( 2, indexOf( listWithThreeElements, 6, 0 ) );
        Assertions.assertEquals( 7, indexOf( listWithEightElements, 8, 0 ) );
        Assertions.assertEquals( 8, indexOf( listWithNineElements, 9, 0 ) );
    }

    @Test
    void indexOfElementInLastPositionReturnsLastIndex() {
        indexOfElementInLastPositionReturnsLastIndex( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        indexOfElementInLastPositionReturnsLastIndex( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void indexOfElementThatDoesNotExistIsMinusOne( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( -1, indexOf( listWithOneElement, 20, 0 ) );
        Assertions.assertEquals( -1, indexOf( listWithTwoElements, 20, 0 ) );
        Assertions.assertEquals( -1, indexOf( listWithThreeElements, 20, 0 ) );
        Assertions.assertEquals( -1, indexOf( listWithEightElements, 20, 0 ) );
        Assertions.assertEquals( -1, indexOf( listWithNineElements, 20, 0 ) );
    }

    @Test
    void indexOfElementThatDoesNotExistIsMinusOne() {
        indexOfElementThatDoesNotExistIsMinusOne( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        indexOfElementThatDoesNotExistIsMinusOne( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    @Test
    void indexOfElementThatExistsWhereFromIndexIsFirstIndex() {
        Assertions.assertEquals( 0, indexOf( arrayListWithDuplicates, 1, 0 ) );
        Assertions.assertEquals( 0, indexOf( linkedListWithDuplicates, 1, 0 ) );
        Assertions.assertEquals( 2, indexOf( arrayListWithDuplicates, 3, 0 ) );
        Assertions.assertEquals( 2, indexOf( linkedListWithDuplicates, 3, 0 ) );
    }

    @Test
    void indexOfElementThatExistsWhereFromIndexIsMiddleIndex() {
        Assertions.assertEquals( 7, indexOf( arrayListWithDuplicates, 3, 4 ) );
        Assertions.assertEquals( 7, indexOf( linkedListWithDuplicates, 3, 4 ) );
    }

    @Test
    void indexOfElementThatExistsWhereFromIndexIsLastIndex() {
        Assertions.assertEquals( 9, indexOf( arrayListWithDuplicates, 1, 9 ) );
        Assertions.assertEquals( 9, indexOf( linkedListWithDuplicates, 1, 9 ) );
    }

    @Test
    void indexOfWithNegativeFromIndexShouldCoalesceNegativeIndexToZero() {
        Assertions.assertEquals( 1, indexOf( arrayListWithDuplicates, 2, -1 ) );
        Assertions.assertEquals( 1, indexOf( linkedListWithDuplicates, 2, -1 ) );
    }

    @Test
    void indexOfWithFromIndexThatIsOutOfBoundsShouldReturnMinusOne() {
        Assertions.assertEquals( -1, indexOf( arrayListWithDuplicates, 2, 100 ) );
        Assertions.assertEquals( -1, indexOf( linkedListWithDuplicates, 2, 100 ) );
    }

    @Test
    void indexOfWithNullListShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> indexOf( null, 1, 0 ) );
    }

    @Test
    void indexOfWithNullElementShouldReturnMinusOne() {
        Assertions.assertEquals( -1, indexOf( arrayListWithDuplicates, null, 0 ) );
        Assertions.assertEquals( -1, indexOf( linkedListWithDuplicates, null, 0 ) );
    }

    @Test
    void lastIndexOfOfAppliedToEmptyListReturnsMinusOne() {
        Assertions.assertEquals( -1, lastIndexOf( emptyArrayList, 5, 0 ) );
        Assertions.assertEquals( -1, lastIndexOf( emptyLinkedList, 5, 0 ) );
    }

    private void lastIndexOfElementInFirstPositionReturnsZero( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, lastIndexOf( listWithOneElement, 5, 0 ) );
        Assertions.assertEquals( 0, lastIndexOf( listWithTwoElements, 4, 1 ) );
        Assertions.assertEquals( 0, lastIndexOf( listWithThreeElements, 4, 2 ) );
        Assertions.assertEquals( 0, lastIndexOf( listWithEightElements, 1, 7 ) );
        Assertions.assertEquals( 0, lastIndexOf( listWithNineElements, 1, 8 ) );
    }

    @Test
    void lastIndexOfElementInFirstPositionReturnsZero() {
        lastIndexOfElementInFirstPositionReturnsZero( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        lastIndexOfElementInFirstPositionReturnsZero( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void lastIndexOfElementInMiddlePositionReturnsCorrectIndex( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, lastIndexOf( listWithOneElement, 5, 0 ) );
        Assertions.assertEquals( 1, lastIndexOf( listWithTwoElements, 5, 1 ) );
        Assertions.assertEquals( 1, lastIndexOf( listWithThreeElements, 5, 2 ) );
        Assertions.assertEquals( 5, lastIndexOf( listWithEightElements, 6, 7 ) );
        Assertions.assertEquals( 4, lastIndexOf( listWithNineElements, 5, 8 ) );
    }

    @Test
    void lastIndexOfElementInMiddlePositionReturnsCorrectIndex() {
        lastIndexOfElementInMiddlePositionReturnsCorrectIndex( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        lastIndexOfElementInMiddlePositionReturnsCorrectIndex( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );

    }

    private void lastIndexOfElementInLastPositionReturnsLastIndex( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, lastIndexOf( listWithOneElement, 5, 0 ) );
        Assertions.assertEquals( 1, lastIndexOf( listWithTwoElements, 5, 1 ) );
        Assertions.assertEquals( 2, lastIndexOf( listWithThreeElements, 6, 2 ) );
        Assertions.assertEquals( 7, lastIndexOf( listWithEightElements, 8, 7 ) );
        Assertions.assertEquals( 8, lastIndexOf( listWithNineElements, 9, 8 ) );
    }

    @Test
    void lastIndexOfElementInLastPositionReturnsLastIndex() {
        lastIndexOfElementInLastPositionReturnsLastIndex( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        lastIndexOfElementInLastPositionReturnsLastIndex( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void lastIndexOfElementThatDoesNotExistIsMinusOne( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( -1, lastIndexOf( listWithOneElement, 20, 0 ) );
        Assertions.assertEquals( -1, lastIndexOf( listWithTwoElements, 20, 1 ) );
        Assertions.assertEquals( -1, lastIndexOf( listWithThreeElements, 20, 2 ) );
        Assertions.assertEquals( -1, lastIndexOf( listWithEightElements, 20, 7 ) );
        Assertions.assertEquals( -1, lastIndexOf( listWithNineElements, 20, 8 ) );
    }

    @Test
    void lastIndexOfElementThatDoesNotExistIsMinusOne() {
        lastIndexOfElementThatDoesNotExistIsMinusOne( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        lastIndexOfElementThatDoesNotExistIsMinusOne( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    @Test
    void lastIndexOfElementThatExistsWhereFromIndexIsFirstIndex() {
        Assertions.assertEquals( 0, lastIndexOf( arrayListWithDuplicates, 1, 0 ) );
        Assertions.assertEquals( 0, lastIndexOf( linkedListWithDuplicates, 1, 0 ) );
    }

    @Test
    void lastIndexOfElementThatExistsWhereFromIndexIsMiddleIndex() {
        Assertions.assertEquals( 2, lastIndexOf( arrayListWithDuplicates, 3, 4 ) );
        Assertions.assertEquals( 2, lastIndexOf( linkedListWithDuplicates, 3, 4 ) );
    }

    @Test
    void lastIndexOfElementThatExistsWhereFromIndexIsLastIndex() {
        Assertions.assertEquals( 9, lastIndexOf( arrayListWithDuplicates, 1, 9 ) );
        Assertions.assertEquals( 9, lastIndexOf( linkedListWithDuplicates, 1, 9 ) );
        Assertions.assertEquals( 7, lastIndexOf( arrayListWithDuplicates, 3, 9 ) );
        Assertions.assertEquals( 7, lastIndexOf( linkedListWithDuplicates, 3, 9 ) );
    }

    @Test
    void lastIndexOfWithNegativeFromIndexShouldReturnMinusOne() {
        Assertions.assertEquals( -1, lastIndexOf( arrayListWithDuplicates, 1, -1 ) );
        Assertions.assertEquals( -1, lastIndexOf( linkedListWithDuplicates, 1, -1 ) );
    }

    @Test
    void lastIndexOfWithFromIndexThatIsOutOfBoundsShouldCoalesceFromIndexToEndOfList() {
        Assertions.assertEquals( 8, lastIndexOf( arrayListWithDuplicates, 2, 100 ) );
        Assertions.assertEquals( 8, lastIndexOf( linkedListWithDuplicates, 2, 100 ) );
    }

    @Test
    void lastIndexOfWithNullListShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> lastIndexOf( null, 1, 0 ) );
    }

    @Test
    void lastIndexOfWithNullElementShouldReturnMinusOne() {
        Assertions.assertEquals( -1, lastIndexOf( arrayListWithDuplicates, null, 9 ) );
        Assertions.assertEquals( -1, lastIndexOf( linkedListWithDuplicates, null, 9 ) );
    }

    @Test
    void sublistWithEmptyListShouldReturnEmptyList() {
        Assertions.assertEquals( 0, sublist( emptyArrayList, 0, 1 ).size() );
        Assertions.assertEquals( 0, sublist( emptyLinkedList, 0, 1 ).size() );
    }

    private void sublistWithBeginIndexAtStartAndEndIndexAtStart( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, sublist( listWithOneElement, 0, 0 ).size() );
        Assertions.assertEquals( 0, sublist( listWithTwoElements, 0, 0 ).size() );
        Assertions.assertEquals( 0, sublist( listWithThreeElements, 0, 0 ).size() );
        Assertions.assertEquals( 0, sublist( listWithEightElements, 0, 0 ).size() );
        Assertions.assertEquals( 0, sublist( listWithNineElements, 0, 0 ).size() );
    }

    @Test
    void sublistWithBeginIndexAtStartAndEndIndexAtStart() {
        sublistWithBeginIndexAtStartAndEndIndexAtStart( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtStartAndEndIndexAtStart( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtStartAndEndIndexAtMiddle( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( List.of( 5 ), sublist( listWithOneElement, 0, 1 ) );
        Assertions.assertEquals( List.of( 4 ), sublist( listWithTwoElements, 0, 1 ) );
        Assertions.assertEquals( List.of( 4, 5 ), sublist( listWithThreeElements, 0, 2 ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4 ), sublist( listWithEightElements, 0, 4 ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5 ), sublist( listWithNineElements, 0, 5 ) );
    }

    @Test
    void sublistWithBeginIndexAtStartAndEndIndexAtMiddle() {
        sublistWithBeginIndexAtStartAndEndIndexAtMiddle( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtStartAndEndIndexAtMiddle( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtStartAndEndIndexAtEnd( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( listWithOneElement, sublist( listWithOneElement, 0, listWithOneElement.size() ) );
        Assertions.assertEquals( listWithTwoElements, sublist( listWithTwoElements, 0, listWithTwoElements.size() ) );
        Assertions.assertEquals( listWithThreeElements, sublist( listWithThreeElements, 0, listWithThreeElements.size() ) );
        Assertions.assertEquals( listWithEightElements, sublist( listWithEightElements, 0, listWithEightElements.size() ) );
        Assertions.assertEquals( listWithNineElements, sublist( listWithNineElements, 0, listWithNineElements.size() ) );
    }

    @Test
    void sublistWithBeginIndexAtStartAndEndIndexAtEnd() {
        sublistWithBeginIndexAtStartAndEndIndexAtEnd( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtStartAndEndIndexAtEnd( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtMiddleAndEndIndexAtStart( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( 0, sublist( listWithOneElement, 0, 0 ).size() );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithTwoElements, 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithThreeElements, 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithEightElements, 4, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithNineElements, 5, 0 ) );
    }

    @Test
    void sublistWithBeginIndexAtMiddleAndEndIndexAtStart() {
        sublistWithBeginIndexAtMiddleAndEndIndexAtStart( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtMiddleAndEndIndexAtStart( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtMiddleAndEndIndexAtMiddle( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( List.of( 5 ), sublist( listWithOneElement, 0, 1 ) );
        Assertions.assertEquals( List.of( 5 ), sublist( listWithTwoElements, 1, 2 ) );
        Assertions.assertEquals( List.of( 5 ), sublist( listWithThreeElements, 1, 2 ) );
        Assertions.assertEquals( List.of( 4, 5, 6 ), sublist( listWithEightElements, 3, 6 ) );
        Assertions.assertEquals( List.of( 6, 7 ), sublist( listWithNineElements, 5, 7 ) );
    }

    @Test
    void sublistWithBeginIndexAtMiddleAndEndIndexAtMiddle() {
        sublistWithBeginIndexAtMiddleAndEndIndexAtMiddle( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtMiddleAndEndIndexAtMiddle( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtMiddleAndEndIndexAtEnd( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( List.of( 5 ), sublist( listWithOneElement, 0, listWithOneElement.size() ) );
        Assertions.assertEquals( List.of( 5 ), sublist( listWithTwoElements, 1, listWithTwoElements.size() ) );
        Assertions.assertEquals( List.of( 5, 6 ), sublist( listWithThreeElements, 1, listWithThreeElements.size() ) );
        Assertions.assertEquals( List.of( 4, 5, 6, 7, 8 ), sublist( listWithEightElements, 3, listWithEightElements.size() ) );
        Assertions.assertEquals( List.of( 6, 7, 8, 9 ), sublist( listWithNineElements, 5, listWithNineElements.size() ) );
    }

    @Test
    void sublistWithBeginIndexAtMiddleAndEndIndexAtEnd() {
        sublistWithBeginIndexAtMiddleAndEndIndexAtEnd( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtMiddleAndEndIndexAtEnd( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtEndAndEndIndexAtStart( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( List.of(), sublist( listWithOneElement, listWithOneElement.size() - 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithTwoElements, listWithTwoElements.size() - 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithThreeElements, listWithThreeElements.size() - 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithEightElements, listWithEightElements.size() - 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithNineElements, listWithNineElements.size() - 1, 0 ) );
    }

    @Test
    void sublistWithBeginIndexAtEndAndEndIndexAtStart() {
        sublistWithBeginIndexAtEndAndEndIndexAtStart( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtEndAndEndIndexAtStart( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtEndAndEndIndexAtMiddle( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( List.of(), sublist( listWithOneElement, listWithOneElement.size() - 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithTwoElements, listWithTwoElements.size() - 1, 0 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithThreeElements, listWithThreeElements.size() - 1, 1 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithEightElements, listWithEightElements.size() - 1, 4 ) );
        Assertions.assertThrows( IllegalArgumentException.class, () -> sublist( listWithNineElements, listWithNineElements.size() - 1, 5 ) );
    }

    @Test
    void sublistWithBeginIndexAtEndAndEndIndexAtMiddle() {
        sublistWithBeginIndexAtEndAndEndIndexAtMiddle( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtEndAndEndIndexAtMiddle( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    private void sublistWithBeginIndexAtEndAndEndIndexAtEnd( List<Integer> listWithOneElement, List<Integer> listWithTwoElements, List<Integer> listWithThreeElements, List<Integer> listWithEightElements, List<Integer> listWithNineElements ) {
        Assertions.assertEquals( List.of( 5 ), sublist( listWithOneElement, listWithOneElement.size() - 1, listWithOneElement.size() ) );
        Assertions.assertEquals( List.of( 5 ), sublist( listWithTwoElements, listWithTwoElements.size() - 1, listWithTwoElements.size() ) );
        Assertions.assertEquals( List.of( 6 ), sublist( listWithThreeElements, listWithThreeElements.size() - 1, listWithThreeElements.size() ) );
        Assertions.assertEquals( List.of( 8 ), sublist( listWithEightElements, listWithEightElements.size() - 1, listWithEightElements.size() ) );
        Assertions.assertEquals( List.of( 9 ), sublist( listWithNineElements, listWithNineElements.size() - 1, listWithNineElements.size() ) );
    }

    @Test
    void sublistWithBeginIndexAtEndAndEndIndexAtEnd() {
        sublistWithBeginIndexAtEndAndEndIndexAtEnd( arrayListWithOneElement, arrayListWithTwoElements, arrayListWithThreeElements, arrayListWithEightElements, arrayListWithNineElements );
        sublistWithBeginIndexAtEndAndEndIndexAtEnd( linkedListWithOneElement, linkedListWithTwoElements, linkedListWithThreeElements, linkedListWithEightElements, linkedListWithNineElements );
    }

    @Test
    void sublistWithNegativeBeginIndexShouldCoalesceNegativeIndexToZero() {
        Assertions.assertEquals( List.of( 1, 2 ), sublist( arrayListWithNineElements, -100, 2 ) );
        Assertions.assertEquals( List.of( 1, 2 ), sublist( linkedListWithNineElements, -100, 2 ) );
    }

    @Test
    void sublistWithOutOfBoundsBeginIndexShouldReturnEmpty() {
        Assertions.assertEquals( List.of(), sublist( arrayListWithNineElements, 50, 100 ) );
        Assertions.assertEquals( List.of(), sublist( linkedListWithNineElements, 50, 100 ) );
    }

    @Test
    void sublistWithNegativeEndIndexShouldReturnEmpty() {
        Assertions.assertEquals( List.of(), sublist( arrayListWithNineElements, -100, -50 ) );
        Assertions.assertEquals( List.of(), sublist( linkedListWithNineElements, -100, -50 ) );
    }

    @Test
    void sublistWithOutOfBoundsEndIndexShouldCoalesceToEndOfList() {
        Assertions.assertEquals( List.of( 9 ), sublist( arrayListWithNineElements, 8, 100 ) );
        Assertions.assertEquals( List.of( 9 ), sublist( linkedListWithNineElements, 8, 100 ) );
    }

    @Test
    void sublistWithNullListShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> sublist( null, 8, 100 ) );
    }

    private void intersectionWithNothingInCommonShouldBeEmpty( ArrayList<String> meat ) {
        Assertions.assertEquals( List.of(), intersection( meat, List.of() ) );
        Assertions.assertEquals( List.of(), intersection( meat, oneVegetable ) );
        Assertions.assertEquals( List.of(), intersection( meat, twoVegetables ) );
        Assertions.assertEquals( List.of(), intersection( meat, threeVegetables ) );
        Assertions.assertEquals( List.of(), intersection( meat, sixVegetables ) );
        Assertions.assertEquals( List.of(), intersection( meat, sevenVegetables ) );
    }

    @Test
    void intersectionWithNothingInCommonShouldBeEmpty() {
        intersectionWithNothingInCommonShouldBeEmpty( new ArrayList<>() );
        intersectionWithNothingInCommonShouldBeEmpty( oneMeat );
        intersectionWithNothingInCommonShouldBeEmpty( twoMeats );
        intersectionWithNothingInCommonShouldBeEmpty( threeMeats );
        intersectionWithNothingInCommonShouldBeEmpty( sixMeats );
        intersectionWithNothingInCommonShouldBeEmpty( sevenMeats );
    }

    private void intersectionWithSomeThingsInCommon( ArrayList<String> meat, List<String> expectedIntersectionForOneAndTwo, List<String> otherExpectedIntersections ) {
        Assertions.assertEquals( expectedIntersectionForOneAndTwo, intersection( meat, onePizzaTopping ) );
        Assertions.assertEquals( expectedIntersectionForOneAndTwo, intersection( meat, twoPizzaToppings ) );
        Assertions.assertEquals( otherExpectedIntersections, intersection( meat, threePizzaToppings ) );
        Assertions.assertEquals( otherExpectedIntersections, intersection( meat, sixPizzaToppings ) );
        Assertions.assertEquals( otherExpectedIntersections, intersection( meat, sevenPizzaToppings ) );
    }

    @Test
    void intersectionWithSomeThingsInCommon() {
        final var chickenAndPrawns = List.of( "Chicken", "Prawns" );

        intersectionWithSomeThingsInCommon( oneMeat, oneMeat, oneMeat );
        intersectionWithSomeThingsInCommon( twoMeats, oneMeat, oneMeat );
        intersectionWithSomeThingsInCommon( threeMeats, oneMeat, oneMeat );
        intersectionWithSomeThingsInCommon( sixMeats, oneMeat, chickenAndPrawns );
        intersectionWithSomeThingsInCommon( sevenMeats, oneMeat, chickenAndPrawns );
    }

    @Test
    void intersectionWithEverythingInCommonShouldReturnEverything() {
        Assertions.assertEquals( oneMeat, intersection( oneMeat, oneMeat ) );
        Assertions.assertEquals( twoMeats, intersection( twoMeats, twoMeats ) );
        Assertions.assertEquals( threeMeats, intersection( threeMeats, threeMeats ) );
        Assertions.assertEquals( sixMeats, intersection( sixMeats, sixMeats ) );
        Assertions.assertEquals( sevenMeats, intersection( sevenMeats, sevenMeats ) );
    }

    @Test
    void intersectionWithDuplicates() {
        Assertions.assertEquals( twoCatsTwoDogsOneMouse, intersection( threeCatsTwoDogsOneMouse, twoCatsTwoDogsOneMouse ) );
    }

    @Test
    void intersectionWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> intersection( null, List.of() ) );
    }

    @Test
    void intersectionWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> intersection( List.of(), null ) );
    }

    private void complementWithNothingInCommonShouldReturnFirstList( ArrayList<String> meat ) {
        Assertions.assertEquals( meat, complement( meat, List.of() ) );
        Assertions.assertEquals( meat, complement( meat, oneVegetable ) );
        Assertions.assertEquals( meat, complement( meat, twoVegetables ) );
        Assertions.assertEquals( meat, complement( meat, threeVegetables ) );
        Assertions.assertEquals( meat, complement( meat, sixVegetables ) );
        Assertions.assertEquals( meat, complement( meat, sevenVegetables ) );
    }

    @Test
    void complementWithNothingInCommonShouldReturnFirstList() {
        complementWithNothingInCommonShouldReturnFirstList( new ArrayList<>() );
        complementWithNothingInCommonShouldReturnFirstList( oneMeat );
        complementWithNothingInCommonShouldReturnFirstList( twoMeats );
        complementWithNothingInCommonShouldReturnFirstList( threeMeats );
        complementWithNothingInCommonShouldReturnFirstList( sixMeats );
        complementWithNothingInCommonShouldReturnFirstList( sevenMeats );
    }

    private void complementWithSomeThingsInCommon( ArrayList<String> meat, List<String> expectedComplementForOneAndTwo, List<String> otherExpectedComplements ) {
        Assertions.assertEquals( expectedComplementForOneAndTwo, complement( meat, onePizzaTopping ) );
        Assertions.assertEquals( expectedComplementForOneAndTwo, complement( meat, twoPizzaToppings ) );
        Assertions.assertEquals( otherExpectedComplements, complement( meat, threePizzaToppings ) );
        Assertions.assertEquals( otherExpectedComplements, complement( meat, sixPizzaToppings ) );
        Assertions.assertEquals( otherExpectedComplements, complement( meat, sevenPizzaToppings ) );
    }

    @Test
    void complementWithSomeThingsInCommon() {
        final var lamb = List.of( "Lamb" );
        final var lambAndFish = List.of( "Lamb", "Fish" );
        final var lambFishPrawnsCrabVenison = List.of( "Lamb", "Fish", "Prawns", "Crabs", "Venison" );
        final var lambFishCrabsVenison = List.of( "Lamb", "Fish", "Crabs", "Venison" );
        final var lambFishPrawnsCrabsVenisonGoat = List.of( "Lamb", "Fish", "Prawns", "Crabs", "Venison", "Goat" );
        final var lambFishCrabVenisonGoat = List.of( "Lamb", "Fish", "Crabs", "Venison", "Goat" );

        complementWithSomeThingsInCommon( oneMeat, List.of(), List.of() );
        complementWithSomeThingsInCommon( twoMeats, lamb, lamb );
        complementWithSomeThingsInCommon( threeMeats, lambAndFish, lambAndFish );
        complementWithSomeThingsInCommon( sixMeats, lambFishPrawnsCrabVenison, lambFishCrabsVenison );
        complementWithSomeThingsInCommon( sevenMeats, lambFishPrawnsCrabsVenisonGoat, lambFishCrabVenisonGoat );
    }

    @Test
    void complementWithEverythingInCommonShouldReturnAnEmptyList() {
        Assertions.assertEquals( List.of(), complement( oneMeat, oneMeat ) );
        Assertions.assertEquals( List.of(), complement( twoMeats, twoMeats ) );
        Assertions.assertEquals( List.of(), complement( threeMeats, threeMeats ) );
        Assertions.assertEquals( List.of(), complement( sixMeats, sixMeats ) );
        Assertions.assertEquals( List.of(), complement( sevenMeats, sevenMeats ) );
    }

    @Test
    void complementWithDuplicates() {
        Assertions.assertEquals( List.of( "Cat" ), complement( threeCatsTwoDogsOneMouse, twoCatsTwoDogsOneMouse ) );
    }

    @Test
    void complementWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> complement( null, List.of() ) );
    }

    @Test
    void complementWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> complement( List.of(), null ) );
    }

    private void differenceWithNothingInCommonShouldReturnEverything( ArrayList<String> meat ) {
        Assertions.assertEquals( meat, difference( meat, List.of() ) );
        Assertions.assertEquals( combineLists( ArrayList.class, meat, oneVegetable ), difference( meat, oneVegetable ) );
        Assertions.assertEquals( combineLists( ArrayList.class, meat, twoVegetables ), difference( meat, twoVegetables ) );
        Assertions.assertEquals( combineLists( ArrayList.class, meat, threeVegetables ), difference( meat, threeVegetables ) );
        Assertions.assertEquals( combineLists( ArrayList.class, meat, sixVegetables ), difference( meat, sixVegetables ) );
        Assertions.assertEquals( combineLists( ArrayList.class, meat, sevenVegetables ), difference( meat, sevenVegetables ) );
    }

    @Test
    void differenceWithNothingInCommonShouldReturnEverything() {
        differenceWithNothingInCommonShouldReturnEverything( new ArrayList<>() );
        differenceWithNothingInCommonShouldReturnEverything( oneMeat );
        differenceWithNothingInCommonShouldReturnEverything( twoMeats );
        differenceWithNothingInCommonShouldReturnEverything( threeMeats );
        differenceWithNothingInCommonShouldReturnEverything( sixMeats );
        differenceWithNothingInCommonShouldReturnEverything( sevenMeats );
    }

    @Test
    void differenceWithSomeThingsInCommonWithOneMeat() {
        Assertions.assertEquals( List.of(), difference( oneMeat, onePizzaTopping ) );
        Assertions.assertEquals( List.of( "Onion" ), difference( oneMeat, twoPizzaToppings ) );
        Assertions.assertEquals( List.of( "Onion", "Prawns" ), difference( oneMeat, threePizzaToppings ) );
        Assertions.assertEquals( List.of( "Onion", "Prawns", "Tomato", "Cheese", "Olives" ), difference( oneMeat, sixPizzaToppings ) );
        Assertions.assertEquals( List.of( "Onion", "Prawns", "Tomato", "Cheese", "Olives", "Pineapple" ), difference( oneMeat, sevenPizzaToppings ) );
    }

    @Test
    void differenceWithSomeThingsInCommonWithTwoMeats() {
        Assertions.assertEquals( List.of( "Lamb" ), difference( twoMeats, onePizzaTopping ) );
        Assertions.assertEquals( List.of( "Lamb", "Onion" ), difference( twoMeats, twoPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Onion", "Prawns" ), difference( twoMeats, threePizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Onion", "Prawns", "Tomato", "Cheese", "Olives" ), difference( twoMeats, sixPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Onion", "Prawns", "Tomato", "Cheese", "Olives", "Pineapple" ), difference( twoMeats, sevenPizzaToppings ) );
    }

    @Test
    void differenceWithSomeThingsInCommonWithThreeMeats() {
        Assertions.assertEquals( List.of( "Lamb", "Fish" ), difference( threeMeats, onePizzaTopping ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Onion" ), difference( threeMeats, twoPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Onion", "Prawns" ), difference( threeMeats, threePizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Onion", "Prawns", "Tomato", "Cheese", "Olives" ), difference( threeMeats, sixPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Onion", "Prawns", "Tomato", "Cheese", "Olives", "Pineapple" ), difference( threeMeats, sevenPizzaToppings ) );
    }

    @Test
    void differenceWithSomeThingsInCommonWithSixMeats() {
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Prawns", "Crabs", "Venison" ), difference( sixMeats, onePizzaTopping ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Prawns", "Crabs", "Venison", "Onion" ), difference( sixMeats, twoPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Crabs", "Venison", "Onion" ), difference( sixMeats, threePizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Crabs", "Venison", "Onion", "Tomato", "Cheese", "Olives" ), difference( sixMeats, sixPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Crabs", "Venison", "Onion", "Tomato", "Cheese", "Olives", "Pineapple" ), difference( sixMeats, sevenPizzaToppings ) );
    }

    @Test
    void differenceWithSomeThingsInCommonWithSevenMeats() {
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Prawns", "Crabs", "Venison", "Goat" ), difference( sevenMeats, onePizzaTopping ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Prawns", "Crabs", "Venison", "Goat", "Onion" ), difference( sevenMeats, twoPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Crabs", "Venison", "Goat", "Onion" ), difference( sevenMeats, threePizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Crabs", "Venison", "Goat", "Onion", "Tomato", "Cheese", "Olives" ), difference( sevenMeats, sixPizzaToppings ) );
        Assertions.assertEquals( List.of( "Lamb", "Fish", "Crabs", "Venison", "Goat", "Onion", "Tomato", "Cheese", "Olives", "Pineapple" ), difference( sevenMeats, sevenPizzaToppings ) );
    }

    @Test
    void differenceWithEverythingInCommonShouldReturnEmptyList() {
        Assertions.assertEquals( List.of(), difference( oneMeat, oneMeat ) );
        Assertions.assertEquals( List.of(), difference( twoMeats, twoMeats ) );
        Assertions.assertEquals( List.of(), difference( threeMeats, threeMeats ) );
        Assertions.assertEquals( List.of(), difference( sixMeats, sixMeats ) );
        Assertions.assertEquals( List.of(), difference( sevenMeats, sevenMeats ) );
    }

    @Test
    void differenceWithDuplicates() {
        Assertions.assertEquals( List.of( "Cat" ), difference( threeCatsTwoDogsOneMouse, twoCatsTwoDogsOneMouse ) );
    }

    @Test
    void differenceWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> difference( null, List.of() ) );
    }

    @Test
    void differenceWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> difference( List.of(), null ) );
    }

    @Test
    void combineListsWithOneListShouldReturnList() {
        Assertions.assertEquals( List.of(), combineLists( ArrayList.class, new ArrayList<Integer>() ) );
        Assertions.assertEquals( List.of( 1 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1 ) ) ) );
        Assertions.assertEquals( List.of( 1, 2, 3 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1, 2, 3 ) ) ) );
    }

    @Test
    void combineListsWithMultipleLists() {
        Assertions.assertEquals( List.of(), combineLists( ArrayList.class, new ArrayList<>(), new ArrayList<>() ) );
        Assertions.assertEquals( List.of( 1 ), combineLists( ArrayList.class, new ArrayList<>(), new ArrayList<>( List.of( 1 ) ) ) );
        Assertions.assertEquals( List.of( 1, 2, 3 ), combineLists( ArrayList.class, new ArrayList<>(), new ArrayList<>( List.of( 1, 2, 3 ) ) ) );
        Assertions.assertEquals( List.of( 1 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1 ) ), new ArrayList<>( List.of() ) ) );
        Assertions.assertEquals( List.of( 1, 2 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1 ) ), new ArrayList<>( List.of( 2 ) ) ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1 ) ), new ArrayList<>( List.of( 2, 3, 4 ) ) ) );
        Assertions.assertEquals( List.of( 1, 2, 3 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1, 2, 3 ) ), new ArrayList<>( List.of() ) ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1, 2, 3 ) ), new ArrayList<>( List.of( 4 ) ) ) );
        Assertions.assertEquals( List.of( 1, 2, 3, 4, 5, 6 ), combineLists( ArrayList.class, new ArrayList<>( List.of( 1, 2, 3 ) ), new ArrayList<>( List.of( 4, 5, 6 ) ) ) );
    }

    @Test
    void combineListWithFirstNullShouldThrowNullPointerException() {
        Assertions.assertThrows( RuntimeException.class, () -> combineLists( null, new ArrayList<>( List.of( 1 ) ) ) );
    }

    @Test
    void combineListWithSecondNullShouldThrowNullPointerException() {
        Assertions.assertThrows( NullPointerException.class, () -> combineLists( ArrayList.class, null ) );
    }

}
