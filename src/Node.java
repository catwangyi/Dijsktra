/**
 * @author wang
 * @create 2019-03-28 16:28
 * @desc
 **/
public class Node {
    private int distance=10000;//到起始点的距离
    private Node prenode;//前一个节点

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getPrenode() {
        return prenode;
    }

    public void setPrenode(Node prenode) {
        this.prenode = prenode;
    }

    private int num;
    private boolean visited=false;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    private Line[] line=new Line[10];

    public Line[] getLine() {
        return line;
    }

    public void setLine(Line[] line) {
        this.line = line;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node() {
    }


}
