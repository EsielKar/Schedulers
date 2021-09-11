package schedulers.model;

import java.util.List;

/**
 *
 * @author Esiel, Marco
 */
public interface SchedulingStrategy {
    public Task scheduling(List<Task> readyTasks);
}
