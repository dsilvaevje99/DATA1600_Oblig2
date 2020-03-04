package skaar;

import java.lang.reflect.Array;

public class ArrayPrinter<T> {
    private T[] array;

    public ArrayPrinter(Class<T> c, T[]array){
        @SuppressWarnings("unchecked")
        final T[] a = (T[]) Array.newInstance(c, array.length);
        System.arraycopy(array, 0, a, 0, array.length);
        this.array = a;
    }

    public void printArray(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (T t : array) {
            str.append(t).append(", ");
        }
        str.setLength(str.length()-2);
        str.append("]");
        System.out.println(str);
    }

    public void reverseArray(){
        T tmp;
        int s = 0;
        int e = array.length-1;
        while (s < e){
            tmp = array[s];
            array[s] = array[e];
            array[e] = tmp;
            s++;
            e--;
        }
        printArray();
    }
}
