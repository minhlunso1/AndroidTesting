package minhna.androidtesting;

/**
 * Created by Administrator on 14-Aug-17.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Merge two descending list and make a descending sort array
 * list2.maxVal > list1.maxVal && list2.length > list1.length
 * The best algorithm BigO(n)
 */
public class SortMergeDecreaseTest {
    private int elementCount;
    private int[] list1 = new int[]{5, 4, 1, 0};
    private int[] list2 = new int[]{6, 5, 3, -1, -2, -3};
    private int[] assertList = new int[]{6, 5, 5, 4, 3, 1, 0, -1, -2, -3};

    @Before
    public void setUp() {
        elementCount = list1.length + list2.length;
    }

    @Test
    public void testSortMergeDescending() {
        int[] list = new int[elementCount];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < list1.length && j < list2.length) {
            if (list1[i] > list2[j])
                list[index++] = list1[i++];
            else
                list[index++] = list2[j++];
        }
        while (i < list1.length)
            list[index++] = list1[i++];
        while (j < list2.length)
            list[index++] = list2[j++];

        Assert.assertEquals(true, isDescendingList(list, elementCount));
        Assert.assertEquals(assertList(list, assertList), true);
    }

    public boolean isDescendingList(int[] list, int total) {
        if (list.length > 0 && list.length == total) {
            boolean isDescending = true;
            int previousVal = list[0];
            for (int i = 1; i < list.length; i++) {
                if (list[i] > previousVal) {
                    isDescending = false;
                    break;
                }
                previousVal = list[i];
            }
            return isDescending;
        } else
            return false;
    }

    public boolean assertList(int[] list, int[] assertList) {
        boolean isEquals = true;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != assertList[i]) {
                isEquals = false;
                break;
            }
        }
        return isEquals;
    }
}
