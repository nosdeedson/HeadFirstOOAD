package E3N.com.designpatterns.bubblesorter.strategy;

public class IntSortHandle implements SortHandle {

    private int[] arrayOfInts = null;

    @Override
    public void swap(int index) {
        int temporary = arrayOfInts[index];
        arrayOfInts[index] = arrayOfInts[index + 1];
        arrayOfInts[index + 1] = temporary;
    }

    @Override
    public boolean outOfOrder(int index) {
        return arrayOfInts[index] > arrayOfInts[index + 1];
    }

    @Override
    public int length() {
        return arrayOfInts.length;
    }

    @Override
    public void setArray(Object aObject) {
        arrayOfInts = (int[]) aObject;
    }
    
}
