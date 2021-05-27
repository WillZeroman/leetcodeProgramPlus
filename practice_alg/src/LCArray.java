public class LCArray {

    private static final int DEFAULT_LENGTH = 10;

    private int[] elements;

    private int size;

    public LCArray() {
        elements = new int[DEFAULT_LENGTH];
    }

    public void push_back(int n) {
        if (size >= elements.length) {
            int newLength = elements.length << 1;
            int[] newElements = new int[newLength];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size] = n;
        size++;
    }

    public void pop_back() {
        if (size >= 0) {
            size--;
            elements[size] = 0;
            if(size < (elements.length >> 1)){
                int[] newElements = new int[elements.length >> 1];
                System.arraycopy(elements, 0, newElements, 0, size);
                elements = newElements;
            }
        }
    }

    public int size() {
        return size;
    }

    public int index(int idx) {
        //check index overflow
        if (idx < size) {
            return elements[idx];
        } else {
            throw new IndexOutOfBoundsException(idx);
        }
    }

    /**
     * Your LCArray object will be instantiated and called as such:
     * LCArray obj = new LCArray();
     * obj.push_back(n);
     * obj.pop_back();
     * int param_3 = obj.size();
     * int param_4 = obj.index(idx);
     */
    public static void main(String[] args) {
        LCArray obj = new LCArray();
        obj.push_back(100);
        obj.pop_back();
        int param_3 = obj.size();
        int param_4 = obj.index(0);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
