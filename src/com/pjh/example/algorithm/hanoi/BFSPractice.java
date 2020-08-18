package com.pjh.example.algorithm.hanoi;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class Graph{
    static class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data){
            this.data = data;
            adjacent = new LinkedList<Node>();
            this.marked = false;
        }
    }

    //node 통 만들기
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size];
        for(int i = 0; i < size; i++){
            nodes[i] = new Node(i);
        }
    }

    //각 노드의 인접한 노드에 서로가 있는지 확인 후 없으면 add
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) n1.adjacent.add(n2);
        if(!n2.adjacent.contains(n1)) n2.adjacent.add(n1);
    }

    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new LinkedBlockingDeque<>();
        queue.offer(root);
        root.marked = true;

        while(!queue.isEmpty()){
            Node r = queue.poll();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    queue.offer(n);
                }
            }
            visit(r);
        }

    }

    void bfs(){ bfs(0);}

    void visit(Node n){
        System.out.print(n.data + " ");
    }
}
public class BFSPractice {
    public static void main(String[] args){
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.bfs();
    }
}

