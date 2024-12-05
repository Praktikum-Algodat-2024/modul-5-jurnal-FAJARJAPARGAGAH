public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Menambahkan node
        graph.addNode("Sofia");
        graph.addNode("Enklang");
        graph.addNode("Akaku");
        graph.addNode("El Scaro");
        graph.addNode("Copia");
        graph.addNode("Brahe");
        graph.addNode("Korda");
        graph.addNode("Lonogo");
        graph.addNode("Lutaros");
        graph.addNode("Calle Mort");
        graph.addNode("Witeka");

        // Menambahkan edge dengan bobot
        graph.addUndirectedEdge("Sofia", "Brahe", 20);
        graph.addUndirectedEdge("Sofia", "Copia", 15);
        graph.addUndirectedEdge("Sofia", "Enklang", 12);

        graph.addUndirectedEdge("Enklang", "Brahe", 9);
        graph.addUndirectedEdge("Enklang", "Korda", 10);
        graph.addUndirectedEdge("Enklang", "Akaku", 11);

        graph.addUndirectedEdge("Akaku", "El Scaro", 8);
        graph.addUndirectedEdge("Akaku", "Lonogo", 16);
        // graph.addUndirectedEdge("Akaku", "El Scaro", 8);

        graph.addUndirectedEdge("El Scaro", "Lonogo", 5);

        graph.addUndirectedEdge("Lonogo", "Witeka", 21);
        graph.addUndirectedEdge("Lonogo", "Korda", 12);

        graph.addUndirectedEdge("Korda", "Witeka", 19);
        graph.addUndirectedEdge("Korda", "Calle Mort", 15);
        graph.addUndirectedEdge("Korda", "Brahe", 12);

        graph.addUndirectedEdge("Brahe", "Calle Mort", 12);
        graph.addUndirectedEdge("Brahe", "Korda", 12);
        graph.addUndirectedEdge("Brahe", "Lutaros", 11);
        graph.addUndirectedEdge("Brahe", "Copia", 10);

        graph.addUndirectedEdge("Lutaros", "Calle Mort", 16);
        graph.addUndirectedEdge("Witeka", "Calle Mort", 20);

        graph.addUndirectedEdge("Copia", "Lutaros", 8);

        // Menjalankan Kruskal untuk MST
        graph.kruskalMST();
    }
}
