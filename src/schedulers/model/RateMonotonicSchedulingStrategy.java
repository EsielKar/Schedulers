package schedulers.model;

import java.util.List;

/**
 *
 * @author Marco
 */
public class RateMonotonicSchedulingStrategy implements SchedulingStrategy {
    private long getPeriod(Task task) {
        return task instanceof PeriodicTask ? ((PeriodicTask) task).getPeriodTime() : task.getDeadlineTime();
    }
    @Override
    public Task scheduling(List<Task> readyTasks) {
        if (readyTasks != null && !readyTasks.isEmpty()) {
            Task shortestTask = readyTasks.get(0);
            long shortestTaskPeriod = getPeriod(shortestTask);
            System.out.println("Task " + shortestTask.getId() + " value = " + shortestTaskPeriod);
            if (readyTasks.size() > 1) {
                for (Task task : readyTasks.subList(1, readyTasks.size())) {
                     long taskPeriod = getPeriod(task);
                     System.out.println("Task " + task.getId() + " value = " + taskPeriod);
                     if (taskPeriod < shortestTaskPeriod) {
                         shortestTask = task;
                         shortestTaskPeriod = taskPeriod;
                     }
                }
            }
            return shortestTask;
        }
        return null;
    } 
}
