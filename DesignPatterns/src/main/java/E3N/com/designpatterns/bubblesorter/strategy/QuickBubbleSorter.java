package E3N.com.designpatterns.bubblesorter.strategy;

public class QuickBubbleSorter {

    private int length = 0;
    private int operations = 0;
    private SortHandle handle = null;

    public QuickBubbleSorter(SortHandle aHandle){
        handle = aHandle;
    }
    
    public int sort(Object aObject){
        handle.setArray(aObject);
        length = handle.length();
        if (length <= 1) operations = 0;

        for(int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
            for(int index = 0; index <= nextToLast; index++){
                if(handle.outOfOrder(index)){
                    handle.swap(index);
                    operations++;
                }
            }
        return operations;
    }
}
