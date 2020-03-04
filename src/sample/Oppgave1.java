package skaar;

public class Oppgave1 {
    int pow (int base, int exponent){
        if (exponent == 1){
            return base;
        }
        return base * pow(base, exponent-1);
    }

        void backwardsArray(int[] array, int index){
            if (index < 0){
                return;
            }
            System.out.println(array[index]);
            backwardsArray(array, index-1);
        }

        int searchRec(int[] arr, int s, int e, int x){
            if (e < s){
                return -1;
            }

            if (arr[s] == x){
                return s;
            }

            if (arr[e] == x){
                return e;
            }

            return searchRec(arr, s+1, e-1, x);
        }
}
