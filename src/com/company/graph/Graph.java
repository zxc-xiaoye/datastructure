package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoye
 * @create 2020-08-23 13:43
 */
public class Graph {
    private List<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public static void main(String[] args) {
        String[] vertexs = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(vertexs.length);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();

        graph.dfs();
        System.out.println();
        graph.bfs();

    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 广度优先
     */
    public void bfs() {
        for (int j = 0; j < getNumOfVertex(); j++) {
            if (!isVisited[j]) {
                bfs(isVisited, j);
            }
        }
        for (int j = 0; j < isVisited.length; j++) {
            isVisited[j] = false;
        }
    }

    public void bfs(boolean[] isVisited, int i) {
        int u; // 队列头结点下标
        int w; // 邻接结点
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighBour(u);
            while (w != -1) {
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighBour(u, w);
            }
        }
    }

    /**
     * 深度优先
     */
    public void dfs() {
        for (int j = 0; j < getNumOfVertex(); j++) {
            if (!isVisited[j]) {
                dfs(isVisited, j);
            }
        }
        for (int j = 0; j < isVisited.length; j++) {
            isVisited[j] = false;
        }
    }

    public void dfs(boolean[] isVisited, int i) {
        if (!isVisited[i]) {
            System.out.print(getValueByIndex(i) + "->");
            isVisited[i] = true;
            int w = getFirstNeighBour(i);
            while (w != -1) {
                if (!isVisited[w]) {
                    dfs(isVisited, w);
                }
                w = getNextNeighBour(i, w);
            }
        }
    }

    /**
     * 获取第一个邻接点
     * @param i
     * @return
     */
    public int getFirstNeighBour(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 获取下一个邻接点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighBour(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return this.numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges ++;
    }
}
