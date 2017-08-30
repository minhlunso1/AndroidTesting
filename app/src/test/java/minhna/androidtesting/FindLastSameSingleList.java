package minhna.androidtesting;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 30-Aug-17.
 */

public class FindLastNameSingleList {
    Node node1;
    Node node2;

    public class Node {
        String value;
        Node nextNode;

        public Node() {
        }

        public Node(String value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    @Before
    public void buildNode() {
        node1 = new Node();
        node1.value = "A";
        node1.nextNode = new Node("B", new Node("C", new Node("Y", new Node("Z", null))));

        node2 = new Node();
        node2.value = "D";
        node2.nextNode = new Node("E", new Node("Y", new Node("Z", null)));
    }

    @Test()
    public void testOutput() {
        List<String> list1 = new ArrayList<>();
        Node tmp = node2;
        while (tmp != null) {
            list1.add(tmp.value);
            tmp = tmp.nextNode;
        }

        List<String> list2 = new ArrayList<>();
        tmp = node1;
        while (tmp != null) {
            list2.add(tmp.value);
            tmp = tmp.nextNode;
        }

        String output = "";
        if (list1.size() > list2.size()) {
            int index = list1.size() - list2.size();
            for (int i = index, j = 0; i < list1.size(); i++, j++) {
                if (list1.get(i).equals(list2.get(j)))
                    output += list1.get(i);
            }
        } else {
            int index = list2.size() - list1.size();
            for (int i = index, j = 0; i < list2.size(); i++, j++) {
                if (list2.get(i).equals(list1.get(j)))
                    output += list1.get(j);
            }
        }
        Assert.assertEquals("YZ", output);
    }
}
