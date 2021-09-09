package schedulers;

/**
 *
 * @author Esiel, Marco
 */
public class Task {
    private static long count = 0;
    
    private final long id;
    
    private final long arrivalTime;
    
    private final long burstTime;
    
    private final long deadlineTime;

    protected long currentExecutionTime;

    public Task(long arrivalTime, long burstTime, long deadlineTime) {
        this.id = ++count;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.deadlineTime = deadlineTime;
        
        this.currentExecutionTime =  0;
    }

    public long getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getBurstTime() {
        return burstTime;
    }
    
    public long getDeadlineTime() {
        return deadlineTime;
    }
    
    public void reset() {
        currentExecutionTime = 0;
    }
    
    public boolean isExecutionCompleted() {
        return currentExecutionTime == burstTime;
    }
    
    public long getCurrentExecutionTime() {
        return currentExecutionTime;
    }
    
    // TODO: REVISAR
    public void execute() {
        if (!isExecutionCompleted())
            ++currentExecutionTime;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", arrivalTime=" + arrivalTime + ", burstTime=" + burstTime + ", deadlineTime=" + deadlineTime + ", currentExecutionTime=" + currentExecutionTime + '}';
    }
    
    
}
