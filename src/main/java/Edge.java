public class Edge {
   private int weight, src, dest;

    public Edge(int weight, int src, int dest) {
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }

    public Edge() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }
}
