package E3N.com.designpatterns.bubblesorter;

public class BubbleSorterExample {

    private static int operations = 0;

    public static int sort(int[] array){
        operations = 0;
        if (array.length <= 1) return operations;
        for (int nextToLast = array.length - 2; nextToLast >= 0; nextToLast--)
            for (int index = 0; index <= nextToLast; index++){
                compareAndSwap(array, index);
            }
        System.out.println(operations);
        return operations;
    }

    private static void compareAndSwap(int[] array, int index){
        if (array[index] > array[index + 1]) swap(array, index);
        operations++;
    }

    private static void swap(int[] array, int index){
        int temporary = array[index];
        array[index] = array[index + 1 ];
        array[index + 1 ] = temporary;
    }

}
