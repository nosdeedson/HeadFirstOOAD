package E3N.com.designpatterns.bubblesorter.strategy;

/**
 * Approach is to use the template method 
 */
public interface SortHandle {
    public void swap(int index);
    public boolean outOfOrder(int index);
    public int length();   
    public void setArray(Object aObject); 
}
