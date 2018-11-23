import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class HeapSort {

    private static class Heap<E>{
        private final ArrayList<E> elements;
        private final Comparator<? super E> comparator;

        private int heapSize = 0;

        private Heap(ArrayList<E> elements, Comparator<? super E> comparator) {
            this.elements = elements;
            this.comparator = comparator;
        }

        private void add(int index){
            heapSize++;
            while(hasParent(index) && comparator.compare(elements.get(Heap.parent(index)),elements.get(index)) < 0){
                swap(Heap.parent(index), index);
                index = Heap.parent(index);
            }
        }

        private void remove(){
            int index = 0;
            swap(index, heapSize - 1);
            heapSize--;
            while(hasLeft(index)){
                if(hasRight(index) && comparator.compare(elements.get(index), elements.get(maxElement(left(index),right(index)))) < 0){
                    int maxElement = maxElement(left(index), right(index));
                    swap(index, maxElement);
                    index = maxElement;
                } else if(comparator.compare(elements.get(index), elements.get(left(index))) < 0) {
                    swap(index, left(index));
                    index = left(index);
                } else {
                    break;
                }
            }
        }

        private void remove(int index){

        }

        private int maxElement(int left, int right) {
            if(comparator.compare(elements.get(left), elements.get(right)) > 0){
                return left;
            } else {
                return right;
            }
        }


        private void swap(int i1, int i2){
            E tmp = elements.get(i1);
            elements.set(i1, elements.get(i2));
            elements.set(i2, tmp);
        }

        private static int parent(int index){
            /*if(index % 2 == 0){
                return index / 2 - 1;
            } else {
                return (index - 1)/ 2;
            }*/
            //return (index - index % 2)/ 2 - 1 + index % 2;
            return (index - 1)/2;
        }

        private static int left(int index){
            return index * 2 + 1;
        }

        private static int right(int index){
            return index * 2 + 2;
        }

        private boolean hasLeft(int index){
            return heapSize > Heap.left(index);
        }

        private boolean hasRight(int index){
            return heapSize > Heap.right(index);
        }

        private boolean hasParent(int index){
            return index != 0 && heapSize > index;
        }
    }

    public static <E> void sort(ArrayList<E> list, Comparator<? super E> comp){
        //1a Part
        Heap<E> heap =  new Heap<>(list,comp);
        for(int i = 0; i < list.size(); i++){
            heap.add(i);
        }
        //2a Part
        for(int i = 0; i < list.size(); i++){
            heap.remove();
        }
    }

    public static <E extends Comparable<? super E>> void sort(ArrayList<E> list){
        Comparator<E> comp= new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        };
        sort(list,comp);
    }

}
