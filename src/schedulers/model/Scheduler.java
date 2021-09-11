package schedulers.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Esiel, Marco
 */
public class Scheduler {
    protected List<Task> tasks;
    protected List<Task> readyTasks;
    protected List<Task> waitingTasks;
    protected SchedulingStrategy scheduling;

    public Scheduler(List<Task> tasks, SchedulingStrategy scheduling) throws InstantiationException, IllegalAccessException {
        this.tasks = tasks;
        this.readyTasks = tasks.getClass().newInstance();
        this.waitingTasks = tasks.getClass().newInstance();
        this.scheduling = scheduling;
    }
    
    public Scheduler(SchedulingStrategy scheduling) throws InstantiationException, IllegalAccessException {
        this(new LinkedList(), scheduling);
    }
    
    public Scheduler() throws InstantiationException, IllegalAccessException {
        this(new LinkedList(), null);
    }
    
    public void setStrategy(SchedulingStrategy scheduling) {
        this.scheduling = scheduling;
    }
    
    public void addTask(Task task) { tasks.add(task); }
    public void setTasks(List<Task> tasks) { 
        this.tasks.clear();
        this.tasks.addAll(tasks);
    }
    
    private Task getEarliestTask() {
        if (tasks != null && !tasks.isEmpty()) {
            Task earliestTask = tasks.get(0);
            if (tasks.size() > 1) {
                for (Task task : tasks.subList(1, tasks.size())) {
                    if (task.getArrivalTime() < earliestTask.getArrivalTime()) {
                        earliestTask = task;
                    }
                }
            }
            return earliestTask;
        }
        return null;
    }

    private void preparation() {
        if (tasks != null)  {
            waitingTasks.clear();
            readyTasks.clear();
     
            for (Task task : tasks){
                task.reset();
                if (task instanceof PeriodicTask)
                    ((PeriodicTask) task).resetCompleteExecutionCount();
            }
            waitingTasks.addAll(tasks);
        }
    }
    
    private void updateReadyTasks(int currentTime) {
        for(Task task : waitingTasks) {
            boolean band = true;
            if (task instanceof PeriodicTask) {
                if (((PeriodicTask) task).getCompleteExecutionCount() 
                        * ((PeriodicTask) task).getPeriodTime()
                        + task.getArrivalTime() > currentTime) {
                    band = false;
                }
            }
            if (band) readyTasks.add(task);
        }
        waitingTasks.removeAll(readyTasks);
    }
    
    
    public Task[] schedule(int time) {
        Task[] execution = new Task[time];
        if (tasks != null && !tasks.isEmpty()) {
            preparation();  //Preparation
            for (int i = 0 ; i < time ; i++) {
                System.out.println("EXE " + i);
                updateReadyTasks(i);//Update ready tasks list
                Task task = scheduling.scheduling(readyTasks); //Scheduling strategy
                if (task != null) {
                    task.execute(); //Task execution
                    System.out.println("Se ejecuta: " + task.getId());
                    if (task.isExecutionCompleted()) {
                        if (task instanceof PeriodicTask) {
                            task.reset();
                            waitingTasks.add(task);
                        }   
                        readyTasks.remove(task);
                    }
                }
                execution[i] = task; //Registered 
            }
        }
        return execution;
    }
    
}
