package sample;

public class Oppg1_Rekursjon {

    //Oppgave 1.1
    int sum(int x, int sum) {
        if(x == 0) {
            return sum;
        }
        sum+=x;
        return sum(x-1, sum);
    }

    //Oppgave 1.2
    int pow(int base, int exponent) {
        if(exponent == 1) {
            return base;
        }
        return base * pow(base, exponent-1);
    }

    //Oppgave 1.3
    void backwardsArray(int[] array, int index) {
        if(index < 0) {
            return;
        }
        System.out.println(array[index]);
        backwardsArray(array, index-1);
    }

    //Oppgave 1.4
    int smallestNumberInArray(int[] array, int index, int num) {
        if(index == array.length -1) {
            return num;
        }
        if(array[index] < num) {
            num = array[index];
        }
        return smallestNumberInArray(array, index+1, num);
    }

    int searchRec(int[] arr, int s, int e, int x) {
        if(e < s) {
            return -1;
        }
        if(arr[s] == x) {
            return s;
        }
        if(arr[e] == x) {
            return e;
        }
        return searchRec(arr, s+1, e-1, x);
    }

}
