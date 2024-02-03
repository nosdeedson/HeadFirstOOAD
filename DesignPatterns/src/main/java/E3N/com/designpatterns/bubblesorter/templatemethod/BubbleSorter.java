package E3N.com.designpatterns.bubblesorter.templatemethod;

public abstract class BubbleSorter {
    private int operations;
    protected int length = 0;

    public int doSort(){
        if (length <= 1) return operations;
        
        for(int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
            for(int index = 0; index <= nextToLast; index++){
                if (outOfOrder(index)){
                    swap(index);
                    operations++;
                }
            }

        return operations;
    }

    protected abstract void swap(int index);
    protected abstract boolean outOfOrder(int index);
}
