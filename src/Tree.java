/**
 * @author wang
 * @create 2019-03-28 21:17
 * @desc
 **/
public class Tree {
    private Node node;
    private Tree leftChild;

    private Tree rightChild;

    public Tree getLeftChild() {
        return leftChild;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void setLeftChild(Tree leftChild) {
        this.leftChild = leftChild;
    }

    public Tree getRightChild() {
        return rightChild;
    }

    public void setRightChild(Tree rightChild) {
        this.rightChild = rightChild;
    }
}
