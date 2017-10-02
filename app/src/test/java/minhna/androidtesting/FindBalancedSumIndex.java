package minhna.androidtesting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 02-Oct-17.
 */

/**
 * Find the pivot matching the condition: Sum of left equals to sum of right.
 * Value in array is positive numbers.
 * The best algorithm BigO(n).
 */
public class FindBalancedSumIndex {
    int[] intArray = {5, 3, 1, 1, 4, 3, 1, 1};
    int[] intArray2 = {4, 10, 2, 3, 1, 1, 9};
    int[] intArray3 = {0, 0 ,0};

    @Test
    public void test() {
        int pivot = findPivot(intArray);
        Assert.assertEquals(3, pivot);

        int pivot2 = findPivot(intArray2);
        Assert.assertEquals(2, pivot2);

        int pivot3 = findPivot(intArray3);
        Assert.assertEquals(1, pivot3);
    }

    private int findPivot(int[] intArray) {
        if (intArray.length == 0)
            return -1;
        else {
            int leftSum = 0;
            int rightSum = 0;
            int pivot = intArray.length / 2;
            for (int i = pivot - 1; i >= 0; i--)
                leftSum += intArray[i];
            for (int i = pivot + 1; i < intArray.length; i++)
                rightSum += intArray[i];
            while (leftSum != rightSum) {
                if (pivot < 0 || pivot >= intArray.length)
                    return -1;
                if (leftSum < rightSum) {
                    leftSum += intArray[pivot];
                    pivot++;
                    if (pivot >= intArray.length) {
                        if (leftSum == 0)
                            return intArray.length - 1;
                    } else
                        rightSum -= intArray[pivot];
                } else {
                    rightSum += intArray[pivot];
                    pivot--;
                    if (pivot < 0) {
                        if (rightSum == 0)
                            return 0;
                    } else
                        leftSum -= intArray[pivot];
                }
            }
            return pivot;
        }
    }
}