
package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AssignmentDS {

    public static void main(String[] args) {
        
       double QueueTT, QueueRT, StackTT, StackRT, LLLIFOTT, LLLIFORT, LLFIFOTT, LLFIFORT;
       
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
        QueueRT = Queue.getAverageResponseTime();
        QueueTT = Queue.getAverageTurnaroundTime();
        System.out.println("Queue Average Response Time: " + QueueRT);
        System.out.println("Queue Average Turnaround Time: " + QueueTT);
        System.out.println("");
        //Execute LL LIFO
        LLLIFO.executeTasksLLLIFO();
        LLLIFORT = LLLIFO.getAverageResponseTime();
        LLLIFOTT = LLLIFO.getAverageTurnaroundTime();
        System.out.println("LL LIFO Average Response Time: " + LLLIFORT);
        System.out.println("LL LIFO Average Turnaround Time: " + LLLIFOTT);
        System.out.println("");
        // Execute LL FIFO
        LLFIFO.executeTasksLLFIFO();
        LLFIFORT = LLFIFO.getAverageResponseTime();
        LLFIFOTT = LLFIFO.getAverageTurnaroundTime();
        System.out.println("LL FIFO Average Response Time: " + LLFIFORT);
        System.out.println("LL FIFO Average Turnaround Time: " + LLFIFOTT);
        System.out.println("");
        // Execute tasks using Stack
        Stack.executeTasksStack();
        StackRT = Stack.getAverageResponseTime();
        StackTT = Stack.getAverageTurnaroundTime();
        System.out.println("Stack Average Response Time: " + StackRT);
        System.out.println("Stack Average Turnaround Time: " + StackTT);
        
        System.out.println(comparePerformance(QueueRT, QueueTT, LLLIFORT, LLLIFOTT, LLFIFORT, LLFIFOTT, StackRT, StackTT));

    }
    
    public static String comparePerformance(double queueRT, double queueTT, double lllifoRT, double lllifoTT, double llfifoRT, double llfifoTT, double stackRT, double stackTT) {

        double fastestResponseTime = Math.min(queueRT, Math.min(lllifoRT, Math.min(llfifoRT, stackRT)));
        double fastestTurnaroundTime = Math.min(queueTT, Math.min(lllifoTT, Math.min(llfifoTT, stackTT)));

        StringBuilder result = new StringBuilder();
        result.append("Comparison of Data Structures:\n");
        result.append("Fastest Response Time: ").append(fastestResponseTime).append(" microseconds (");

        if (fastestResponseTime == queueRT) {
            result.append("Queue)");
        } else if (fastestResponseTime == lllifoRT) {
            result.append("LL LIFO)");
        } else if (fastestResponseTime == llfifoRT) {
            result.append("LL FIFO)");
        } else if (fastestResponseTime == stackRT) {
            result.append("Stack)");
        }

        result.append("\n");

        result.append("Fastest Turnaround Time: ").append(fastestTurnaroundTime).append(" microseconds (");

        if (fastestTurnaroundTime == queueTT) {
            result.append("Queue)");
        } else if (fastestTurnaroundTime == lllifoTT) {
            result.append("LL LIFO)");
        } else if (fastestTurnaroundTime == llfifoTT) {
            result.append("LL FIFO)");
        } else if (fastestTurnaroundTime == stackTT) {
            result.append("Stack)");
        }

        result.append("\n");

        return result.toString();
    }
    
}
