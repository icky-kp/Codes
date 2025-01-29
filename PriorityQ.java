import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQ {
    static class Task {
        String name;
        int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
    }

    static class TaskComparator implements Comparator<Task> {
        public int compare(Task t1, Task t2) {
            return Integer.compare(t1.priority, t2.priority);
        }
    }

    private PriorityQueue<Task> priorityQueue;

    public PriorityQ() {
        priorityQueue = new PriorityQueue<>(new TaskComparator());
    }

    public void insert(String name, int priority) {
        priorityQueue.add(new Task(name, priority));
    }

    public String peek() {
        return priorityQueue.peek().name;
    }

    public void execute() {
        while (!priorityQueue.isEmpty()) {
            System.out.println("Executing: " + priorityQueue.poll().name);
        }
    }

    public static void main(String[] args) {
        PriorityQ priorityQueue = new PriorityQ();

        priorityQueue.insert("Task A", 3);
        priorityQueue.insert("Task B", 1);
        priorityQueue.insert("Task C", 2);

        System.out.println("Highest-priority task: " + priorityQueue.peek());
        priorityQueue.execute();
    }
}
