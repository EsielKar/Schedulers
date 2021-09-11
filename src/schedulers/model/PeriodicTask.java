package schedulers.model;

/**
 *
 * @author Esiel, Marco
 */
public class PeriodicTask extends Task {
    
    private final long periodTime;
    
    private long completeExecutionCount = 0;

    public PeriodicTask(long arrivalTime, long burstTime, long deadlineTime) {
        super(arrivalTime, burstTime, deadlineTime);
        periodTime = deadlineTime;
    }
    
    public PeriodicTask(long arrivalTime, long burstTime, long deadlineTime, long periodTime) {
        super(arrivalTime, burstTime, deadlineTime);
        this.periodTime = periodTime;
    }

    public long getPeriodTime() {
        return periodTime;
    }

    public long getCompleteExecutionCount() {
        return completeExecutionCount;
    }
    
    public void resetCompleteExecutionCount() {
        this.completeExecutionCount = 0;
    }
    
    @Override
    public void execute() {
        super.execute();
        if (isExecutionCompleted()) completeExecutionCount++;
    }

    @Override
    public String toString() {
        return super.toString() + " PeriodicTask{" + "periodTime=" + periodTime + ", completeExecutionCount=" + completeExecutionCount + '}';
    }
    
    
}
