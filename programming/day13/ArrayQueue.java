/**
 * Queue implemented with an array
 */
 // the code I found here was given to me from the teacher from canvas.

public class ArrayQueue<T> implements IQueue<T> {
    int size;
    T[] queue;

    /**
     * Construct a finite sized queue
     * @param s maximum queue size
     */
    public ArrayQueue(int s) {
        size  = 0;
        queue = (T[])new Object[s];
    }

        /**
     * Dequeues the Front element from the queue
     * @return dequeued element
     */
    public T dequeue() {
        if(size==0) { return null; }
        T r = queue[0];
        for(int i=1; i<size; i++) {
            queue[i-1] = queue[i];
        }
        size--;
        return r;
    }

    /**
     * Enqueues an element at the back of the queue
     * @param v enqueued element
     */
    public void enqueue(T v) {
        // if(size==queue.length) { return null; }
        queue[size] = v;
        size++;
    }
}
