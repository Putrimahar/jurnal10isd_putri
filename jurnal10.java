import java.util.*;

public class jurnal10 {
    private static final char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    private static final Map<Character, List<Character>> graph = new HashMap<>();

    static {
        graph.put('A', Arrays.asList('B', 'D'));
        graph.put('B', Arrays.asList('A', 'E'));
        graph.put('C', Arrays.asList('F'));
        graph.put('D', Arrays.asList('A', 'E', 'G'));
        graph.put('E', Arrays.asList('B', 'H', 'I'));
        graph.put('F', Arrays.asList('C'));
        graph.put('G', Arrays.asList('D'));
        graph.put('H', Arrays.asList('E', 'I'));
        graph.put('I', Arrays.asList('E', 'H', 'F', 'C'));
    }

    public static void bfsTraversal(char startVertex) {
        boolean[] visited = new boolean[vertices.length];
        Queue<Character> queue = new LinkedList<>();

        queue.add(startVertex);
        visited[startVertex - 'A'] = true;

        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            System.out.print(vertex + " ");

            for (char neighbor : graph.get(vertex)) {
                if (!visited[neighbor - 'A']) {
                    queue.add(neighbor);
                    visited[neighbor - 'A'] = true;
                }
            }
        }
    }

    public static void dfsTraversal(char startVertex) {
        boolean[] visited = new boolean[vertices.length];

        dfsHelper(startVertex, visited);
    }

    private static void dfsHelper(char vertex, boolean[] visited) {
        visited[vertex - 'A'] = true;
        System.out.print(vertex + " ");

        for (char neighbor : graph.get(vertex)) {
            if (!visited[neighbor - 'A']) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("BFS Traversal:");
        bfsTraversal('A');

        System.out.println("\nDFS Traversal:");
        dfsTraversal('A');
    }
}