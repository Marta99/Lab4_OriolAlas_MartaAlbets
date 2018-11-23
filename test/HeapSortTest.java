import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.Assert.*;

public class HeapSortTest {

    final int NUM_ELEMENTS = 10;
    Tubercle[] tubercle = new Tubercle[NUM_ELEMENTS];
    Patata[] patata = new Patata[NUM_ELEMENTS];
    Moniato[] moniato = new Moniato[NUM_ELEMENTS];

    @BeforeClass
    public void createObjects(){
        for(int i  = 0; i < NUM_ELEMENTS; i++){
            tubercle[i] = new Tubercle((float) (i * 8 + 350));
            patata[i] =  new Patata((float) (i * 10 + 300));
            moniato[i] = new Moniato((float) (i * 7) + 370);
        }
    }

    @Test
    public <E extends Comparable<? super E>> void sortWithNoComparator(){
        ArrayList<E> arrayList = new ArrayList<E>((Collection<E>) Arrays.asList(4,6,8,9,1,3));
        ArrayList<E> expectedList = new ArrayList<E>((Collection<E>) Arrays.asList(1,3,4,6,8,9));
        HeapSort.sort(arrayList);
        assertArrayEquals(arrayList.toArray(), expectedList.toArray());

        arrayList = new ArrayList<E>((Collection) Arrays.asList());
        expectedList = new ArrayList<E>((Collection<? extends E>) Arrays.asList(patata[0], patata[3], tubercle[0], patata[6], moniato[0], tubercle[3]));

    }

    @Test
    public <E extends Comparable<? super E>> void sortWithComparator(){
        Comparator<E> comp = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        };
        ArrayList<E> arrayList = new ArrayList<E>((Collection<E>) Arrays.asList(4,6,8,9,1,3));
        ArrayList<E> expectedList = new ArrayList<E>((Collection<E>) Arrays.asList(1,3,4,6,8,9));
        HeapSort.sort(arrayList, comp);
    }
}