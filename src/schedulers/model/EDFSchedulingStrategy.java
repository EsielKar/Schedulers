package schedulers.model;

import java.util.List;

/**
 *
 * @author Esiel
 */
public class EDFSchedulingStrategy implements SchedulingStrategy { 
    private long absoluteDeadline(Task task) {
        long taskAbsoluteDeadline = task.getDeadlineTime() + task.getArrivalTime();
        if (task instanceof PeriodicTask) {
            taskAbsoluteDeadline += 
               ((PeriodicTask) task).getCompleteExecutionCount() * 
               ((PeriodicTask) task).getPeriodTime();
        }
        return taskAbsoluteDeadline;
    }
    @Override
    public Task scheduling(List<Task> readyTasks) {
        if (readyTasks != null && !readyTasks.isEmpty()) {
            Task shortestTask = readyTasks.get(0);
            long shortestTaskAbsoluteDeadline = absoluteDeadline(shortestTask);
            System.out.println("Task " + shortestTask.getId() + " value = " + shortestTaskAbsoluteDeadline);
            if (readyTasks.size() > 1) {
                for (Task task : readyTasks.subList(1, readyTasks.size())) {
                     long taskAbsoluteDeadline = absoluteDeadline(task);
                     System.out.println("Task " + task.getId() + " value = " + taskAbsoluteDeadline);
                     if (taskAbsoluteDeadline < shortestTaskAbsoluteDeadline) {
                         shortestTask = task;
                         shortestTaskAbsoluteDeadline = taskAbsoluteDeadline;
                     }
                }
            }
            return shortestTask;
        }
        return null;
    } 
}
