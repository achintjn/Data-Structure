import java.util.*;

class Producer implements Runnable{
    Queue<Integer> queue;

    public Producer(Queue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                while(queue.size()>=10){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Random ran =new Random();
                int a = ran.nextInt();
                System.out.println("Producing "+ a+" in queue");
                queue.add(a);
                queue.notify();
            }
        }
    }
}

class Consumer implements Runnable{
    Queue<Integer> queue;

    public Consumer(Queue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Consuming, queue size "+queue.size());
                queue.remove();
                queue.notify();
            }
        }

    }
}

public class ProducerConsumer {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 5, 6, 8, 9, 3, 45);
        LinkedList<Integer> queue = new LinkedList<>(list);

        Thread t1 = new Thread(new Producer(queue));

        Thread t2 = new Thread(new Consumer(queue));

        t1.start();
        t2.start();
    }

}
