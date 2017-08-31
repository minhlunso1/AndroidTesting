package minhna.androidtesting;

/**
 * Created by Administrator on 01-Sep-17.
 */

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
