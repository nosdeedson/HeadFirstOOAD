package E3N.com.designpatterns.bubblesorter.templatemethod;

public class IntBubbleSorter extends BubbleSorter {

    private int[] arrayInts = null;

    public IntBubbleSorter(int[] theArray){
        arrayInts = theArray;
        length = arrayInts.length;
    }

    @Override
    protected void swap(int index) {
        int temporary = arrayInts[index];
        arrayInts[index] = arrayInts[index + 1];
        arrayInts[index + 1] = temporary;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (arrayInts[index] > arrayInts[index + 1]);
    }
    
}
