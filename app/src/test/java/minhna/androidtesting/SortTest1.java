package minhna.androidtesting;

/**
 * Created by Administrator on 21-Aug-17.
 */

import junit.framework.Assert;

import org.junit.Test;

/**
 * Sort list following the format: 1, n-1, 2, n-2 on descending list
 * The best algorithm BigO(n)
 */
public class SortTest1 {
    int[] list = new int[]{8, 7, 6, 5, 4, 3, 1};
    int[] assertList = new int[]{1, 8, 3, 7, 4, 6, 5};
    int[] list1 = new int[]{12, 10, 1, -3};
    int[] assertList1 = new int[]{-3, 12, 1, 10};
    int[] list2 = new int[]{5, 3, 2};
    int[] assertList2 = new int[]{2, 5, 3};

    public int[] sortList(int[] list) {
        int[] result = new int[list.length];
        int pivot = list.length / 2;
        if (list.length % 2 != 0)
            pivot++;
        pivot--;
        for (int i = list.length - 1, j = 0, k = 0; j < list.length ; i--, j++) {
            if (i > pivot) {
                result[j++] = list[i];
                result[j] = list[k++];
            } else if (pivot % 2 != 0 && i == pivot)
                result[j] = list[i];
        }
        return result;
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

    @Test
    public void testList() {
        int[] sortedList = sortList(list);
        Assert.assertEquals(assertList(sortedList, assertList), true);
        Assert.assertEquals(assertList(sortList(list1), assertList1), true);
        Assert.assertEquals(assertList(sortList(list2), assertList2), true);
    }
}
