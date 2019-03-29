import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author wang
 * @create 2019-03-28 16:28
 * @desc
 **/
public class main {
    public static void main(String[] args) {
        Tree tree=new Tree();
        Node [] node;//声明对象数组
        node=new Node[6];//创建对象数组
        for (int i=0;i<6;i++){
            node[i]=new Node();
            node[i].setNum((i+1));
        }
        /*Node [] newNode;//路由转发表
        newNode=new Node[6];
        for (int i=0;i<newNode.length;i++){
            newNode[i]=new Node();
            newNode[i].setNum(i+1);
        }*/
        for (int i=0;i<6;i++){
            switch (i+1){
                case 1:
                    Line [] lines1;
                    lines1=new Line[3];

                    lines1[0]=new Line();
                    lines1[0].setWeight(2);
                    lines1[0].setNextnode(node[1]);

                    lines1[1]=new Line();
                    lines1[1].setWeight(22);
                    lines1[1].setNextnode(node[3]);

                    lines1[2]=new Line();
                    lines1[2].setWeight(4);
                    lines1[2].setNextnode(node[2]);
                    node[i].setLine(lines1);
                    break;
                case 2:
                    Line [] lines2;
                    lines2=new Line[3];

                    lines2[0]=new Line();
                    lines2[0].setWeight(6);
                    lines2[0].setNextnode(node[3]);

                    lines2[1]=new Line();
                    lines2[1].setWeight(1);
                    lines2[1].setNextnode(node[2]);

                    lines2[2]=new Line();
                    lines2[2].setWeight(2);
                    lines2[2].setNextnode(node[0]);
                    node[i].setLine(lines2);

                    break;
                case 3:
                    Line [] lines3;
                    lines3=new Line[4];

                    lines3[0]=new Line();
                    lines3[0].setWeight(1);
                    lines3[0].setNextnode(node[3]);

                    lines3[1]=new Line();
                    lines3[1].setWeight(4);
                    lines3[1].setNextnode(node[4]);

                    lines3[2]=new Line();
                    lines3[2].setWeight(4);
                    lines3[2].setNextnode(node[0]);

                    lines3[3]=new Line();
                    lines3[3].setWeight(1);
                    lines3[3].setNextnode(node[1]);
                    node[i].setLine(lines3);

                    break;
                case 4:
                    Line [] lines4;
                    lines4=new Line[5];

                    lines4[0]=new Line();
                    lines4[0].setWeight(22);
                    lines4[0].setNextnode(node[0]);

                    lines4[1]=new Line();
                    lines4[1].setWeight(6);
                    lines4[1].setNextnode(node[1]);

                    lines4[2]=new Line();
                    lines4[2].setWeight(1);
                    lines4[2].setNextnode(node[2]);

                    lines4[3]=new Line();
                    lines4[3].setWeight(10);
                    lines4[3].setNextnode(node[4]);

                    lines4[4]=new Line();
                    lines4[4].setWeight(5);
                    lines4[4].setNextnode(node[5]);
                    node[i].setLine(lines4);

                    break;
                case 5:
                    Line [] lines5;
                    lines5=new Line[3];

                    lines5[0]=new Line();
                    lines5[0].setWeight(4);
                    lines5[0].setNextnode(node[2]);

                    lines5[1]=new Line();
                    lines5[1].setWeight(10);
                    lines5[1].setNextnode(node[3]);

                    lines5[2]=new Line();
                    lines5[2].setWeight(3);
                    lines5[2].setNextnode(node[5]);

                    node[i].setLine(lines5);
                    break;
                case 6:
                    Line [] lines6;
                    lines6=new Line[2];

                    lines6[0]=new Line();
                    lines6[0].setWeight(5);
                    lines6[0].setNextnode(node[3]);

                    lines6[1]=new Line();
                    lines6[1].setWeight(3);
                    lines6[1].setNextnode(node[4]);

                    node[i].setLine(lines6);
                    break;
            }
        }

        try {
            BufferedWriter out=new BufferedWriter(new FileWriter("E:/Dijsktra.txt"));
            out.write("\t");
            System.out.print("\t");
            for (int i=0;i<6;i++){
                System.out.print(i+1+"\t");
                out.write(i+1+"\t");
            }
            out.write("\n");
            System.out.println();
            for (int i=0;i<6;i++){
                System.out.print(i+1);
                out.write((i+1)+"");
                for (int j=0;j<6;j++){
                    for (int k=0;k<node[i].getLine().length;k++) {
                        if (node[j]==node[i].getLine()[k].getNextnode()){//两点之间有连接
                            System.out.print("\t"+node[i].getLine()[k].getWeight());
                            out.write("\t"+node[i].getLine()[k].getWeight());
                            break;
                        }
                        if (k+1==node[i].getLine().length){
                            System.out.print("\t*");
                            out.write("\t*");
                        }
                    }
                }
                System.out.println();
                out.write("\n");
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i=0;i<node.length;i++){
            node[i].setVisited(false);
            node[i].setPrenode(null);
        }
        int minDis=0;
        Node minNode=new Node();
        minNode=node[0];
        Tree tempTree=new Tree();
        tree.setNode(node[0]);
        tree.setRightChild(null);
        tree.setLeftChild(null);
        tempTree=tree;
        node[0].setVisited(true);
        for (int i=0;i<node.length;i++){
            //1.设置前结点、最短距离
            System.out.print("第"+(i+1)+"次");
            for (int j=0;j<node[i].getLine().length;j++){
                if (node[i].getLine()[j].getNextnode().isVisited()==false){
                    //处理没包含的结点
                    if (node[i].getLine()[j].getNextnode().getDistance()<=minDis+node[i].getLine()[j].getWeight()){
                    }else {
                        node[i].getLine()[j].getNextnode().setPrenode(minNode);
                        node[i].getLine()[j].getNextnode().setDistance(minDis+node[i].getLine()[j].getWeight());
                    }
                }
            }
            for (int k=0;k<node.length;k++){
                if (node[k].getPrenode()==null){
                    System.out.print("\tnode"+node[k].getNum()+"到起始点的距离："+node[k].getDistance()+" 无前结点。");
                }else{
                    System.out.print("\tnode"+node[k].getNum()+"到起始点的距离："+node[k].getDistance()+"，前结点："+node[k].getPrenode().getNum()+"。");
                }
            }
            //2.找出最短距离和前结点
            int temp=100;
            for (int k=0;k<node.length;k++){
                if (node[k].isVisited()==false){
                    if (node[k].getDistance()<temp){
                        temp=node[k].getDistance();
                    }
                }
            }
            for (int k=0;k<node.length;k++){
                if (node[k].isVisited()==false){
                    if (node[k].getDistance()==temp){
                        System.out.print("\t最短距离"+node[k].getDistance());
                        minDis=temp;
                        //3.添加该结点
                        node[k].setVisited(true);
                        System.out.print("\t添加结点"+node[k].getNum());
                        //System.out.println("为newNode"+newNode[k].getNum()+"设置前结点"+minNode.getNum());
                        minNode=node[k];
                    }
                }
            }
            System.out.println();
        }
        Node tempNode=new Node();
            for (int j=0;j<node.length;j++){
                tempNode=node[j];
                    if (tempNode.getPrenode()!=null){
                        while (node[0]!=tempNode.getPrenode()){
                            tempNode=tempNode.getPrenode();
                        }
                        System.out.println("目的："+node[j].getNum()+"端口："+tempNode.getNum());
                    }else {
                        System.out.println("node"+tempNode.getNum()+"没有前结点");
                    }
            }

        }
}
