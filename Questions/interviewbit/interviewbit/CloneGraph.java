package interviewbit; /**
 * Created by naiveCode on 16/6/16.
 */

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Scanner sc = new Scanner(System.in);
        String b = sc.nextLine();

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

        queue.add(node);
        map.put(node, newHead);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.pop();
            List<UndirectedGraphNode> currNeighbors = curr.neighbors;

            for (UndirectedGraphNode aNeighbor : currNeighbors) {
                if (!map.containsKey(aNeighbor)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor, copy);
                    map.get(curr).neighbors.add(copy);
                    queue.add(aNeighbor);
                } else {
                    map.get(curr).neighbors.add(map.get(aNeighbor));
                }
            }

        }
        return newHead;
    }
}