
package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AssignmentDS {

    public static void main(String[] args) {
        
       SchedulingSystem Queue = new SchedulingSystem();
       SchedulingSystem LLLIFO = new SchedulingSystem();
       SchedulingSystem LLFIFO = new SchedulingSystem();
       SchedulingSystem Stack = new SchedulingSystem();
        
        try (BufferedReader br = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] taskData = line.split(" ");
                String methodName = taskData[0];
                String inputType = taskData[1];
                String input = taskData[2];

                Task task = new Task(methodName, inputType, input);
                Queue.addTaskQueue(task);
                LLLIFO.addTaskLLLIFO(task);
                LLFIFO.addTaskLLFIFO(task);
                Stack.addTaskStack(task);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Execute using Queue
        Queue.executeTasksQueue();
        System.out.println("Queue Average Response Time: " + Queue.getAverageResponseTime());
        System.out.println("Queue Average Turnaround Time: " + Queue.getAverageTurnaroundTime());
        System.out.println("");
        //Execute LL LIFO
        LLLIFO.executeTasksLLLIFO();
        System.out.println("LL LIFO Average Response Time: " + LLLIFO.getAverageResponseTime());
        System.out.println("LL LIFO Average Turnaround Time: " + LLLIFO.getAverageTurnaroundTime());
        System.out.println("");
        // Execute LL FIFO
        LLFIFO.executeTasksLLFIFO();
        System.out.println("LL FIFO Average Response Time: " + LLFIFO.getAverageResponseTime());
        System.out.println("LL FIFO Average Turnaround Time: " + LLFIFO.getAverageTurnaroundTime());
        System.out.println("");
        // Execute tasks using Stack
        Stack.executeTasksStack();
        System.out.println("Stack Average Response Time: " + Stack.getAverageResponseTime());
        System.out.println("Stack Average Turnaround Time: " + Stack.getAverageTurnaroundTime());
    }
    
}
