package minhna.androidtesting;

/**
 * Created by Administrator on 04-Sep-17.
 */

import junit.framework.Assert;

import org.junit.Test;

/**
 * Sort single-linked list following the format: 1, n-1, 2, n-2 on descending linked list
 * Sort on the same list
 * The best algorithm BigO(n)
 */
public class SortLinkedListTest1 {
    int startValue = 1;

    @Test
    public void test1() {
        IntNode node1 = new IntNode();
        node1.value = 5;
        node1.nextNode = new IntNode(4, new IntNode(3, new IntNode(2, new IntNode(1, null))));

        int beacon = node1.value;
        IntNode root = node1;
        int testStartValue = startValue;
        node1.value = testStartValue++;
        node1 = node1.nextNode;
        boolean isTock = true;
        while (node1 != null) {
            if (isTock)
                node1.value = beacon--;
            else
                node1.value = testStartValue++;
            isTock = !isTock;
            node1 = node1.nextNode;
        }

        String output = getOutputLinkList(root);
        Assert.assertEquals("1,5,2,4,3", output);
    }

    @Test
    public void test2() {
        Integer a = 1;
        Integer b = a;
        b = 2;
        Assert.assertEquals(Integer.valueOf(1), a);
    }

    private String getOutputLinkList(IntNode root) {
        String output = String.valueOf(root.value);
        root = root.nextNode;
        while (root != null) {
            output += "," + root.value;
            root = root.nextNode;
        }
        return output;
    }
}
