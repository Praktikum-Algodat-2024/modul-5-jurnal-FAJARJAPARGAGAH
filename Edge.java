class Edge {
    Node from;    
    Node to;      
    int weight;   
    Edge nextEdge = null;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
