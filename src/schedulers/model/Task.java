package schedulers.model;

import java.awt.Color;

/**
 *
 * @author Esiel, Marco
 */
public class Task {
    private static int count = 0;
    
    private final int id;
    
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

    public int getId() {
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
    
    
    public static Color taskColor(int id) {
        switch (id % 10) {
            case 0: return Color.RED;
            case 1: return Color.BLUE;
            case 2: return Color.GREEN;
            case 3: return Color.YELLOW;
            case 4: return Color.PINK;
            case 5: return Color.CYAN;
            case 6: return Color.MAGENTA;
            case 7: return Color.GRAY;
            case 8: return Color.ORANGE;
            default: return Color.DARK_GRAY;
        }
    }
    
}
