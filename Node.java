class Node {
    String value;
    Edge edgeList = null; 
    Node nextNode = null; 
    Node parent;   
    int rank;      

    public Node(String value) {
        this.value = value;
        this.parent = this; 
        this.rank = 0;
    }
}

