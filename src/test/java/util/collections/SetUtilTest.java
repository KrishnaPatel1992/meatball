package util.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static util.collections.SetUtil.createNewSet;
import static util.collections.SetUtil.createNewSetLike;

public class SetUtilTest {

    @Test
    void createNewSetReturnsNewSetOfSpecifiedType() {
        final var set = createNewSet( HashSet.class );
        Assertions.assertEquals( HashSet.class, set.getClass() );
        Assertions.assertEquals( 0, set.size() );
    }

    @Test
    void createNewSetWithNullValueShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> createNewSet( null ) );
    }

    @Test
    void createNewSetWithClassAndComparatorReturnSetOfSpecifiedType() {
        final var set = (Set<Integer>) createNewSet( TreeSet.class, ( a, b ) -> (int) b - (int) a );

        Assertions.assertEquals( TreeSet.class, set.getClass() );
        Assertions.assertEquals( 0, set.size() );

        set.addAll( Set.of( 1, 4, 2 ) );
        Assertions.assertEquals( Set.of( 4, 2, 1 ), set );
    }

    @Test
    void createNewSetWithClassAndNullComparatorReturnSetOfSpecifiedType() {
        final var set = (Set<Integer>) createNewSet( TreeSet.class, null );

        Assertions.assertEquals( TreeSet.class, set.getClass() );
        Assertions.assertEquals( 0, set.size() );

        set.addAll( Set.of( 1, 4, 2 ) );
        Assertions.assertEquals( Set.of( 1, 2, 4 ), set );
    }

    @Test
    void createNewSetWithNullValueAndComparatorShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> createNewSet( null, ( a, b ) -> (int) b - (int) a ) );
        Assertions.assertThrows( RuntimeException.class, () -> createNewSet( null, null ) );
    }

    @Test
    void createNewSetLikeWithHashSetShouldReturnNewSetOfSameTypeAsInput() {
        final var computedHashSet = createNewSetLike( new HashSet<>( Set.of( 1, 4, 2 ) ) );

        Assertions.assertEquals( HashSet.class, computedHashSet.getClass() );
        Assertions.assertEquals( 0, computedHashSet.size() );
    }

    @Test
    void createNewSetLikeWithTreeSetShouldReturnNewSetOfSameTypeAsInput() {
        final var computedTreeSet = createNewSetLike( new TreeSet<>( ( a, b ) -> (int) b - (int) a ) );

        Assertions.assertEquals( TreeSet.class, computedTreeSet.getClass() );
        Assertions.assertEquals( 0, computedTreeSet.size() );

        computedTreeSet.addAll( Set.of( 1, 4, 2 ) );
        Assertions.assertEquals( Set.of( 4, 2, 1 ), computedTreeSet );
    }

    @Test
    void createNewSetLikeWithNullValueShouldThrowRuntimeException() {
        Assertions.assertThrows( RuntimeException.class, () -> createNewSetLike( null ) );
    }


}
