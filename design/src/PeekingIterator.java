import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    Integer top = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        it = iterator;
        if(it.hasNext()) {
            top = it.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(top == null){
            throw new NoSuchElementException();
        }
        Integer res = top;
        if (it.hasNext()) {
            top = it.next();
        } else {
            top = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
       return top!=null;
    }

    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIterator(Arrays.asList(1,2,3).iterator());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.hasNext());
    }
}
