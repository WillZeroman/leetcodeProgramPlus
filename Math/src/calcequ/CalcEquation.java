package calcequ;

import java.util.*;

public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // construct a graph
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String firstStr = equation.get(0);
            String secondStr = equation.get(1);
            Node node1 = nodeMap.getOrDefault(firstStr, new Node(firstStr, new ArrayList<>()));
            Node node2 = nodeMap.getOrDefault(secondStr, new Node(secondStr, new ArrayList<>()));
            node1.edges.add(new Edge(node1, node2, value));
            node2.edges.add(new Edge(node2, node1, 1 / value));
            nodeMap.putIfAbsent(firstStr, node1);
            nodeMap.putIfAbsent(secondStr, node2);
        }
        //System.out.println(nodeMap);
        // calculator
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String firstStr = query.get(0);
            String secondStr = query.get(1);
            if (nodeMap.containsKey(firstStr) && nodeMap.containsKey(secondStr)) {
                if (firstStr.equals(secondStr)) {
                    result[i] = 1.0;
                } else {
                    Node node1 = nodeMap.get(firstStr);
                    Node node2 = nodeMap.get(secondStr);

                    result[i] = dfs(node1, node2, new HashSet<>());
                    if (result[i] < 0) {
                        result[i] = -1.0;
                    }
                }
            } else {
                result[i] = -1.0;
            }
        }

        return result;
    }

    private double dfs(Node start, Node end, Set<String> visited) {
        if (start.str.equals(end.str)) {
            return 1.0;
        }
        visited.add(start.str);
        for (Edge edge : start.edges) {
            if (!visited.contains(edge.second.str)) {
                double result = dfs(edge.second, end, visited);
                if (result > 0) {
                    return result * edge.value;
                }
            }
        }
        visited.remove(start.str);
        return -1.0;
    }

    class Node {
        String str;
        List<Edge> edges;

        public Node(String str, List<Edge> edges) {
            this.str = str;
            this.edges = edges;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "str='" + str + '\'' +
                    ", edges=" + edges +
                    '}';
        }
    }

    class Edge {
        Node first;
        Node second;
        double value;

        public Edge(Node first, Node second, double value) {
            this.first = first;
            this.second = second;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "first=" + first.str +
                    ", second=" + second.str +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("c", "d"));
        double[] values = {2.0, 3.0, 4.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "d"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("c", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(new CalcEquation().calcEquation(equations, values, queries)));
    }
}
