import java.util.Queue;

public abstract class Animal {
    String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public boolean isOlderThan(Animal a){
      return this.order < a.order;
    }
}
