package E3N.com.designpatterns.bubblesorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import E3N.com.designpatterns.bubblesorter.strategy.DoubleSortHandle;
import E3N.com.designpatterns.bubblesorter.strategy.IntSortHandle;
import E3N.com.designpatterns.bubblesorter.strategy.QuickBubbleSorter;
import E3N.com.designpatterns.bubblesorter.strategy.SortHandle;
import E3N.com.designpatterns.bubblesorter.templatemethod.BubbleSorter;
import E3N.com.designpatterns.bubblesorter.templatemethod.DoubleBubbleSorter;
import E3N.com.designpatterns.bubblesorter.templatemethod.IntBubbleSorter;


public class BubbleSorterTest {

    @Test
    public void givenListOfUnorderedIntegers_shouldOrderThem(){
        int operationsExpected = 10;
        int[] arrayOfInts = {5,4,3,2,1};
        int result = BubbleSorterExample.sort(arrayOfInts);
        Assertions.assertEquals( operationsExpected, result );
    }

    @Test
    public void givenListOfOneInteger_shouldReturnZero(){
        int operationsExpected = 0;
        int[] arrayOfInts = {5};
        int result = BubbleSorterExample.sort(arrayOfInts);
        Assertions.assertEquals( operationsExpected, result );
    }

    @Test
    public void givenListOfUnorderedInts_shouldOrderThem_usingTemplateMethod(){
        int operationsExpected = 10;
        int[] arrayOfInts = {5,4,3,2,1};
        BubbleSorter sorter = new IntBubbleSorter(arrayOfInts);
        int result = sorter.doSort();
        Assertions.assertEquals( operationsExpected, result );
    }

    @Test
    public void givenListWithOneInt_usingTemplateMethod_shoudReturnZero(){
        int operationsExpected = 0;
        int[] arrayOfInts = {1};
        BubbleSorter sorter = new IntBubbleSorter(arrayOfInts);
        int result = sorter.doSort();
        Assertions.assertEquals( operationsExpected, result );
    }

    @Test
    public void givenListWithOneDouble_singTemplateMethod_shoulReturnZero(){
        int operationsExpected = 0;
        double[] arrayOfDoubles = {1.0};
        BubbleSorter sorter = new DoubleBubbleSorter(arrayOfDoubles);
        int result = sorter.doSort();
        Assertions.assertEquals( operationsExpected, result );
    }


    @Test
    public void givenAIntSortHandle_shouldReturnOperationsDone(){
        int operationsExpected = 10;
        int[] arrayOfDoubles = {5,4,3,2,1};
        SortHandle handle = new IntSortHandle();
        QuickBubbleSorter quickBubbleSorter = new QuickBubbleSorter(handle);
        int result = quickBubbleSorter.sort( arrayOfDoubles);
        Assertions.assertEquals( operationsExpected, result );
    }


    @Test
    public void givenADoubleSortHandle_shouldReturnOperationsDone(){
        int operationsExpected = 10;
        double[] arrayOfDoubles = {5.0,4.0,3.0,2.0,1.0};
        SortHandle handle = new DoubleSortHandle();
        QuickBubbleSorter quickBubbleSorter = new QuickBubbleSorter(handle);
        int result = quickBubbleSorter.sort( arrayOfDoubles);
        Assertions.assertEquals( operationsExpected, result );
    }

    @Test
    public void givenAIntSortHandle_withOneInt_shouldReturnOperationsEqualToZero(){
        int operationsExpected = 0;
        int[] arrayOfDoubles = {1};
        SortHandle handle = new IntSortHandle();
        QuickBubbleSorter quickBubbleSorter = new QuickBubbleSorter(handle);
        int result = quickBubbleSorter.sort( arrayOfDoubles);
        Assertions.assertEquals( operationsExpected, result );
    }


    @Test
    public void givenADoubleSortHandle_withOneDouble_shouldReturnOperationsEqualToZero(){
        int operationsExpected = 0;
        double[] arrayOfDoubles = {4.0};
        SortHandle handle = new DoubleSortHandle();
        QuickBubbleSorter quickBubbleSorter = new QuickBubbleSorter(handle);
        int result = quickBubbleSorter.sort( arrayOfDoubles);
        Assertions.assertEquals( operationsExpected, result );
    }

}
