package patterns;



import java.util.LinkedList;
import java.util.function.Supplier;

public class ObjectPool<T> {
    private LinkedList<T> pool;
    private Supplier<T> creator;
    private int initialSize;

    public ObjectPool(Supplier<T> creator, int initialSize) {
        this.pool = new LinkedList<>();
        this.creator = creator;
        this.initialSize = initialSize;
        // Pre-fill the pool with the initial size of objects
        for (int i = 0; i < initialSize; i++) {
            pool.addFirst(creator.get());
        }
    }

    public T borrow() {
        if (pool.isEmpty()) {
            return creator.get();  // Create a new object if pool is empty
        } else {
            return pool.removeFirst();  // Reuse an object from the pool
        }
    }

    public void release(T object) {
        pool.addFirst(object);
        
    }
}
