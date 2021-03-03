import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {
    Queue<Dog> dogQueue = new LinkedList<>();
    Queue<Cat> catQueue = new LinkedList<>();


    public void enqueue(Animal a) {
        if(a instanceof Dog){
            dogQueue.add((Dog) a);
        }
        else {
            catQueue.add((Cat) a);
        }
    }

    public Animal dequeueAny() {

        Dog dog = dogQueue.peek();
        Cat cat = catQueue.peek();

        if(dog.isOlderThan(cat)) return dequeueDog();
        return dequeueCat();
    }

    public Dog dequeueDog() {
        if(dogQueue.isEmpty()) return null;
        return dogQueue.poll();
    }

    private Cat dequeueCat() {
        if(catQueue.isEmpty()) return null;
        return catQueue.poll();
    }
}
