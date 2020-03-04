package skaar;

public class Main {

    public static void main(String[] args) {
        Oppgave1 op1 = new Oppgave1();
        System.out.println(op1.pow(5,5));
        int[] array = {1, 2, 3, 4, 5};
        op1.backwardsArray(array, array.length-1);

        int x = 3;


        System.out.println(op1.searchRec(array, 0, array.length-1, x));

        String[] sarray = {"One", "Two", "Three", "Four", "Five"};
        ArrayPrinter<String> stringArrayPrinter = new ArrayPrinter<>(String.class, sarray);
        Integer[] iarray = {1, 2, 3, 4, 5};
        ArrayPrinter<Integer> integerArrayPrinter = new ArrayPrinter<>(Integer.class, iarray);
        stringArrayPrinter.printArray();
        stringArrayPrinter.reverseArray();
        integerArrayPrinter.printArray();
        integerArrayPrinter.reverseArray();

        ArrayList<String> stringArrayList = new ArrayList<>(String.class, 5);
        stringArrayList.add("One");
        stringArrayList.add("Two");
        stringArrayList.add("Three");
        System.out.println(stringArrayList.get(2));
        System.out.println(stringArrayList.size());

        BensinStateContext bensinStateContext = new BensinStateContext();
        System.out.println(bensinStateContext.getStatus());
        bensinStateContext.setState(new Tank_lav());
        System.out.println(bensinStateContext.getStatus());
        bensinStateContext.setState(new Tank_kritisk());
        System.out.println(bensinStateContext.getStatus());
    }

}
