import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MinStack {

    private LinkedList<Integer> list = new LinkedList<>();
    private LinkedList<Integer> minList = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
        if(minList.isEmpty()){
            minList.add(x);
        }else {
            minList.add(Math.min(x,minList.getLast()));
        }
    }

    public void pop() {
        if(!list.isEmpty()){
            list.removeLast();
            minList.removeLast();
        }
    }

    public int top() {
        if(!list.isEmpty()){
            return list.getLast();
        }
        throw new NoSuchElementException();
    }

    public int min() {
        if(!list.isEmpty()){
            return minList.getLast();

        }
        throw new NoSuchElementException();
    }
}
