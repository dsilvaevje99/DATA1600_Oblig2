package sample;

import java.lang.reflect.Array;

public class ArrayList<E> {
    E[] arraylist;

    public ArrayList(Class<E> type, int length){
        @SuppressWarnings("unchecked")
        final E[] a = (E[]) Array.newInstance(type, length);
        this.arraylist = a;
    }

    boolean add(E elem){
        for (int i = 0; i < arraylist.length; i++) {
            if(arraylist[i] == null){
                arraylist[i] = elem;
                return true;
            }
        }
        return false;
    }

    E get (int index){
        if (index < 0 || index > arraylist.length){
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        return arraylist[index];
    }

    int size(){
        int count = 0;
        while (arraylist[count] != null){
            count++;
        }
        return count;
    }

}
