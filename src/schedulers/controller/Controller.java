package schedulers.controller;

import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import schedulers.model.Scheduler;
import schedulers.model.Task;

/**
 *
 * @author Esiel
 */
public class Controller {
    private DefaultListModel lm;
    private final Scheduler scheduler;

    public Controller() throws InstantiationException, IllegalAccessException {
        lm = new DefaultListModel();
        scheduler = new Scheduler();
    }

    public void addTask(Task task) {
        lm.addElement(task);
    }
    
    public void removeTask(int index) {
        if (index >= 0)
            lm.removeElementAt(index);
    }
    
    public void removeTask(Task task) {
        if (task != null)
            lm.removeElement(task);
    }
    
    public void removeAllTask() {
        lm.removeAllElements();
    }
    
    public DefaultListModel getTaskListModel() {
        return lm;
    }
    
    public List<Task> getTasks() {
        return Collections.list(lm.elements());
    }
    
    public Scheduler getScheduler() {
        return this.scheduler;
    }
    
}
