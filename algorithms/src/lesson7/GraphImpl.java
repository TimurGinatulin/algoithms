package lesson7;


import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    private int totalWidth = 0;
    private List<String> shortWay = new ArrayList<>();

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        for (int i = 0; i < maxVertexCount; i++) {
            for (int j = 0; j < maxVertexCount; j++) {
                adjMatrix[i][j] = -1;
            }
        }
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String endLabel, int width) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = width;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != -1) {
                    System.out.println(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel());
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != -1 && !vertexList.get(i).isVisited()) {
                totalWidth += adjMatrix[currentIndex][i];
                shortWay.add(vertexList.get(i).getLabel() + "->");
                return vertexList.get(i);
            }
        }
        return null;
    }
    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
    }


    @Override
    public Stack<String> findShortPathViaBfs(String startLabel, String finishLabel) {
        String curKey = startLabel;

        Stack<String> buffer = new Stack<>();
        buffer.add(startLabel);
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }
        HashMap<String, String> map = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                if (vertex.getLabel().equals(finishLabel)) {
                    map.put(finishLabel, curKey);
                    System.out.println();
                    break;
                }
                map.put(vertex.getLabel(), curKey);
                buffer.add(vertex.getLabel());
                visitVertex(queue, vertex);

                buffer.pop();
            } else {
                queue.remove().getLabel();
                curKey = queue.peek().getLabel();
            }
        }
        Stack<String> stack = new Stack<>();
        stack.add(finishLabel);
        while (true) {
            String addingCollection = map.get(stack.lastElement());
            if (addingCollection == null)
                break;
            stack.add(addingCollection);
        }
        buffer.clear();
        int count = 0;
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (i > 0) {
                int lastElement = indexOf(stack.get(i));
                int firstElement = indexOf(stack.get(i - 1));
                count += adjMatrix[lastElement][firstElement];
            }
            buffer.add(stack.get(i));
        }
        System.out.println(count);
        return buffer;
    }
}
