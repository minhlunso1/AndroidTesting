package minhna.androidtesting;

/**
 * Created by Administrator on 01-Sep-17.
 */

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Merge two ascending single-linked list and make a descending single-linked list
 * The best algorithm BigO(n)
 */
public class DescendingSingleLinkedList {
    IntNode node1;
    IntNode node2;

    @Before
    public void buildNode() {
        node1 = new IntNode();
        node1.value = 1;
        node1.nextNode = new IntNode(5, new IntNode(6, new IntNode(7, new IntNode(8, null))));

        node2 = new IntNode();
        node2.value = 5;
        node2.nextNode = new IntNode(7, new IntNode(8, new IntNode(10, null)));
    }
    
    public IntNode getDescendingSingleLinkedList(IntNode node1, IntNode node2) {
        IntNode returnIntNode = new IntNode();
        while (node1 != null && node2!= null) {
            if (node1.value < node2.value) {
                IntNode tmp = new IntNode();
                IntNode previousList = returnIntNode.nextNode;
                tmp.value = node1.value;
                tmp.nextNode = previousList;
                returnIntNode.nextNode = tmp;
                node1 = node1.nextNode;
            } else {
                IntNode tmp = new IntNode();
                IntNode previousList = returnIntNode.nextNode;
                tmp.value = node2.value;
                tmp.nextNode = previousList;
                returnIntNode.nextNode = tmp;
                node2 = node2.nextNode;
            }
        }
        while (node1 != null) {
            IntNode tmp = new IntNode();
            IntNode previousList = returnIntNode.nextNode;
            tmp.value = node1.value;
            tmp.nextNode = previousList;
            returnIntNode.nextNode = tmp;
            node1 = node1.nextNode;
        }
        while (node2 != null) {
            IntNode tmp = new IntNode();
            IntNode previousList = returnIntNode.nextNode;
            tmp.value = node2.value;
            tmp.nextNode = previousList;
            returnIntNode.nextNode = tmp;
            node2 = node2.nextNode;
        }
        return returnIntNode.nextNode;
    }

    @Test
    public void isDescending() {
        IntNode finalSingleLinkedList = getDescendingSingleLinkedList(node1, node2);
        boolean result = true;
        int previousVal = finalSingleLinkedList.value;
        while (finalSingleLinkedList != null) {
            if (previousVal < finalSingleLinkedList.value) {
                result = false;
                break;
            } else {
                previousVal = finalSingleLinkedList.value;
                finalSingleLinkedList = finalSingleLinkedList.nextNode;
            }
        }
        Assert.assertEquals(true, result);
    }
}
