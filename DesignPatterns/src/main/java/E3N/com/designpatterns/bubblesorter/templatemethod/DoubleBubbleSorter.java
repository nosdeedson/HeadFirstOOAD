package E3N.com.designpatterns.bubblesorter.templatemethod;


public class DoubleBubbleSorter extends BubbleSorter {

    private double[] arrayDoubles = null;

    public DoubleBubbleSorter(double[] theArray){
        arrayDoubles = theArray;
        length = arrayDoubles.length;
    }
    
    @Override
    protected void swap(int index) {
        double temporary = arrayDoubles[index];
        arrayDoubles[index] = arrayDoubles[index + 1];
        arrayDoubles[index + 1] = temporary;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (arrayDoubles[index] > arrayDoubles[index + 1]);
    }
    
}
