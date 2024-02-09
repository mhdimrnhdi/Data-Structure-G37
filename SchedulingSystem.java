
package assignment;

public class SchedulingSystem {
    SystemAQueue<Task> taskQueue = new SystemAQueue<>();
    SystemBLL<Task> taskList = new SystemBLL<>();
    SystemCStack<Task> taskStack = new SystemCStack<>();
    int totalTime = 0;
    int totalTasks = 0;
    
    private long schedulingStartTime;
    private long totalTurnaroundTime;

    public void addTaskQueue(Task task) {
        taskQueue.enqueue(task);
    }

    public String executeTasksQueue() {
        StringBuilder executionDetails = new StringBuilder();
        schedulingStartTime = System.nanoTime();
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.dequeue();
            int executionTime = executeTask(currentTask);
            totalTime += executionTime;
            totalTasks++;
            
            totalTurnaroundTime += (System.currentTimeMillis() - schedulingStartTime);
            
            executionDetails.append("Executing task: ").append(currentTask.methodName).append("(").append(currentTask.inputType).append(" ").append(currentTask.input).append(")").append("\n");
            executionDetails.append("Execution time: ").append(executionTime).append(" microseconds").append("\n");
        }
        return executionDetails.toString();
    }
    
    public void addTaskLLLIFO(Task task){
        taskList.insertAtHead(task);
    }
    
    public void addTaskLLFIFO(Task task){
        taskList.insertAtTail(task);
    }
    
    public String executeTasksLLLIFO(){
        StringBuilder executionDetails = new StringBuilder();
        schedulingStartTime = System.nanoTime();
        while(!taskList.isEmpty()){
            Task currentTask = taskList.deleteAtHead();
            int executionTime = executeTask(currentTask);
            totalTime += executionTime;
            totalTasks++;
            
            totalTurnaroundTime += (System.currentTimeMillis() - schedulingStartTime);
            
            executionDetails.append("Executing task: ").append(currentTask.methodName).append("(").append(currentTask.inputType).append(" ").append(currentTask.input).append(")").append("\n");
            executionDetails.append("Execution time: ").append(executionTime).append(" microseconds").append("\n");
        }
        return executionDetails.toString();
    }
    
    public String executeTasksLLFIFO(){
        StringBuilder executionDetails = new StringBuilder();
        schedulingStartTime = System.nanoTime();
        while(!taskList.isEmpty()){
            Task currentTask = taskList.deleteAtHead();
            int executionTime = executeTask(currentTask);
            totalTime += executionTime;
            totalTasks++;
            
            totalTurnaroundTime += (System.currentTimeMillis() - schedulingStartTime);    
            executionDetails.append("Executing task: ").append(currentTask.methodName).append("(").append(currentTask.inputType).append(" ").append(currentTask.input).append(")").append("\n");
            executionDetails.append("Execution time: ").append(executionTime).append(" microseconds").append("\n");
        }
        return executionDetails.toString();
    }
   
    public void addTaskStack(Task task) {
        taskStack.push(task);
    }

    public String executeTasksStack() {
        StringBuilder executionDetails = new StringBuilder();
        schedulingStartTime = System.nanoTime();
        while (!taskStack.isEmpty()) {
            Task currentTask = taskStack.pop();
            int executionTime = executeTask(currentTask);
            totalTime += executionTime;
            totalTasks++;
            
            totalTurnaroundTime += (System.currentTimeMillis() - schedulingStartTime);
            
            executionDetails.append("Executing task: ").append(currentTask.methodName).append("(").append(currentTask.inputType).append(" ").append(currentTask.input).append(")").append("\n");
            executionDetails.append("Execution time: ").append(executionTime).append(" microseconds").append("\n");
        }
        return executionDetails.toString();
    }
    
    public int executeTask(Task task){
        long startTime = System.currentTimeMillis();
        int executionTime=0;
        
        switch(task.methodName){
            case "fib":
                int fibInput = Integer.parseInt(task.input);
                executionTime = StarterPack.fib(fibInput);
                break;
            case "isPrime":
                long isPrimeInput = Long.parseLong(task.input);
                executionTime = StarterPack.isPrime(isPrimeInput) ? 1 : 0;
                break;
            case "longestPalSubstr":
                executionTime = StarterPack.longestPalSubstr(task.input).length();
                break;
            case "sumOfDigitsFrom1ToN":
                int sumInput = Integer.parseInt(task.input);
                executionTime = StarterPack.sumOfDigitsFrom1ToN(sumInput);
                break;
            case "getNthUglyNo":
                int uglyInput = Integer.parseInt(task.input);
                executionTime = StarterPack.getNthUglyNo(uglyInput);
                break;
            default:
                System.out.println("Invalid method name: " + task.methodName);
        }
        long endTime = System.currentTimeMillis();

        long responseTimeMicro = endTime - startTime;
        System.out.println("Executing task: " + task.methodName + "(" + task.inputType + " " + task.input + ")");
        System.out.println("Response Time: " + responseTimeMicro + " microseconds");
        return executionTime;
        }
    
     public double getAverageResponseTime() {
        long endTime = System.nanoTime();
        long totalResponseTimeNanos = endTime - schedulingStartTime;
        long totalResponseTimeMicro = totalResponseTimeNanos / 1000;
        
        System.out.println("Total Response Time: " +  totalResponseTimeMicro + " microseconds");
        
        return (double) totalResponseTimeMicro / totalTasks;
    }

    public double getAverageTurnaroundTime() {
        long endTime = System.nanoTime();
        long totalResponseTimeNanos = endTime - schedulingStartTime;

        double  totalTurnaroundTimeMicro = (double) totalResponseTimeNanos / 1000;

        System.out.println("Total Turnaround Time: " +  totalTurnaroundTimeMicro + " microseconds");

        return totalTurnaroundTimeMicro / totalTasks;    
    }
    
}