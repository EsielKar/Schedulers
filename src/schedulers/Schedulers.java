package schedulers;

import java.util.ArrayList;
/**
 *
 * @author Esiel, Marco
 * Prueba
 */
public class Schedulers {

    /**
     * @param args the command line arguments
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println("------------------------------EDF EXECUTION------------------------------");
        Scheduler edf = new Scheduler(new EDFSchedulingStrategy());
     
        ArrayList<Task> a = new ArrayList();
        a.add( new PeriodicTask(0, 1, 4));
        a.add( new PeriodicTask(0, 2, 5));
        a.add( new PeriodicTask(0, 2, 7));
        
        edf.setTasks(a);
        edf.schedule(35);
        
        System.out.println("------------------------------RM EXECUTION------------------------------");
        Scheduler rm = new Scheduler(new RateMonotonicSchedulingStrategy());
        ArrayList<Task> b = new ArrayList();
        b.add( new PeriodicTask(0, 3, 20));
        b.add( new PeriodicTask(0, 2, 5));
        b.add( new PeriodicTask(0, 2, 10));
        //b.add( new PeriodicTask(0, 2, 15));
        
        rm.setTasks(b);
        rm.schedule(20);
    }
    
}
