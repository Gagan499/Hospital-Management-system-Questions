package B;

public class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void insert(int asset) {

        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        queue[rear] = asset;
        rear = (rear + 1) % capacity;
        size++;
    }

    public int retrieve() {

        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        int asset = queue[front];

        front = (front + 1) % capacity;
        size--;

        return asset;
    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(3);

        q.insert(10);
        q.insert(20);

        System.out.println(q.retrieve());

        q.insert(30);
        q.insert(40);
    }
}
