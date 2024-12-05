class Graph {
    Node head = null; 

    public void addNode(String value) {
        Node newNode = new Node(value);
        newNode.nextNode = head;
        head = newNode;
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = findNode(from);
        Node toNode = findNode(to);

        if (fromNode == null || toNode == null) {
            System.out.println("Node tidak ditemukan!");
            return;
        }

        Edge newEdge = new Edge(fromNode, toNode, weight);
        newEdge.nextEdge = fromNode.edgeList;
        fromNode.edgeList = newEdge;
    }

    public void addUndirectedEdge(String node1, String node2, int weight) {
        addEdge(node1, node2, weight);
        addEdge(node2, node1, weight);
    }

    private Node findNode(String value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.nextNode;
        }
        return null;
    }

    private Node find(Node node) {
        if (node.parent != node) {
            node.parent = find(node.parent); 
        }
        return node.parent;
    }

    private void union(Node node1, Node node2) {
        Node root1 = find(node1);
        Node root2 = find(node2);

        if (root1 != root2) {
            if (root1.rank > root2.rank) {
                root2.parent = root1;
            } else if (root1.rank < root2.rank) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.rank++;
            }
        }
    }

    public Edge sortEdges(Edge edges) {
        if (edges == null || edges.nextEdge == null) {
            return edges;
        }

        boolean swapped;
        do {
            swapped = false;
            Edge current = edges;
            while (current != null && current.nextEdge != null) {
                if (current.weight > current.nextEdge.weight) {
                    int tempWeight = current.weight;
                    Node tempFrom = current.from;
                    Node tempTo = current.to;
                    current.weight = current.nextEdge.weight;
                    current.from = current.nextEdge.from;
                    current.to = current.nextEdge.to;
                    current.nextEdge.weight = tempWeight;
                    current.nextEdge.from = tempFrom;
                    current.nextEdge.to = tempTo;
                    swapped = true;
                }
                current = current.nextEdge;
            }
        } while (swapped);

        return edges;
    }

    public void kruskalMST() {
        Edge allEdges = null;
        Node currentNode = head;

        while (currentNode != null) {
            Edge currentEdge = currentNode.edgeList;
            while (currentEdge != null) {
                Edge newEdge = new Edge(currentEdge.from, currentEdge.to, currentEdge.weight);
                newEdge.nextEdge = allEdges;
                allEdges = newEdge;
                currentEdge = currentEdge.nextEdge;
            }
            currentNode = currentNode.nextNode;
        }

        allEdges = sortEdges(allEdges);

        Edge mstEdges = null;
        Edge currentEdge = allEdges;
        int totalWeight = 0;
        while (currentEdge != null) {
            Node fromNode = currentEdge.from;
            Node toNode = currentEdge.to;

            if (find(fromNode) != find(toNode)) {
                union(fromNode, toNode);
                totalWeight += currentEdge.weight;
                Edge mstEdge = new Edge(fromNode, toNode, currentEdge.weight);
                mstEdge.nextEdge = mstEdges;
                mstEdges = mstEdge;
            }

            currentEdge = currentEdge.nextEdge;
        }

        currentEdge = mstEdges;
        while (currentEdge != null) {
            System.out.println(currentEdge.from.value + " - " + currentEdge.to.value + " - " + currentEdge.weight );
            currentEdge = currentEdge.nextEdge;
        }
        System.out.println("Dengan Total    : " + totalWeight);
    }
}