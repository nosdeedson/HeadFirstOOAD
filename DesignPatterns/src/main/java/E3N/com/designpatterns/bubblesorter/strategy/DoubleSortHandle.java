package E3N.com.designpatterns.bubblesorter.strategy;

public class DoubleSortHandle implements SortHandle{

    private double[] arrayOfDoubles = null;

    @Override
    public void swap(int index) {
        double temporary = arrayOfDoubles[index];
        arrayOfDoubles[index] = arrayOfDoubles[index + 1];
        arrayOfDoubles[index + 1] = temporary;
    }

    @Override
    public boolean outOfOrder(int index) {
        return arrayOfDoubles[index] > arrayOfDoubles[index + 1];
    }

    @Override
    public int length() {
        return arrayOfDoubles.length;
    }

    @Override
    public void setArray(Object aObject) {
        this.arrayOfDoubles = (double[]) aObject;
    }
    
}
