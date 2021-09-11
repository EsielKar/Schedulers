package schedulers.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import schedulers.controller.Controller;
import schedulers.model.Task;

/**
 *
 * @author Esiel
 */
public class TasksExecutionPanel extends javax.swing.JPanel {
    private static final int SHORT_NUMBER_LINE = 10;
    private static final int LARGE_NUMBER_LINE = 20;
    private static final int PADDING = 16;
    private static final String Y_HEADER = "TAREAS";
    private static final String X_HEADER = "TIEMPO";
    private static final int HEADER_FONT_SIZE = 16;
    private static final int NUMBER_FONT_SIZE = 12;
    
    
    private Task[] execution;
    private int taskPxLenght;
    private int time;
    private final int C_X = Y_HEADER.length() * HEADER_FONT_SIZE + 2 * NUMBER_FONT_SIZE; //COMMON X
    private final int C_Y = LARGE_NUMBER_LINE + NUMBER_FONT_SIZE + HEADER_FONT_SIZE + PADDING; //COMMON Y
    private Controller controller;
    
        

    /**
     * Creates new form TasksExecutionPanel
     */
    public TasksExecutionPanel() {
        this(100, 32);
    }
    
    public TasksExecutionPanel(int time) {
        this(time, 32);
    }
    
    public TasksExecutionPanel(int time, int taskPxLenght) {
        this.time = time;
        this.taskPxLenght = taskPxLenght;
        initComponents();
        this.changeSize();
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    
    private void drawAxis(Graphics g) {
        
        g.setFont(new Font("default", Font.BOLD, NUMBER_FONT_SIZE));
        g.setColor(Color.BLACK);
        
        int A_Y = getHeight() - C_Y; //Actual y
        g.drawLine( // Linea vertical
                C_X, 
                PADDING, 
                C_X, 
                A_Y
        );
        
        g.drawLine( //Linea horizontal
                C_X, 
                A_Y, 
                getWidth() - PADDING, 
                A_Y
        );
        
        for(int i = 0 ; i <= time; i++) {
            if (i%10==0) {
                g.drawLine(//Lineas largas (Por decenas)
                        C_X + taskPxLenght * i,
                        A_Y,
                        C_X + taskPxLenght * i,
                        getHeight() - (NUMBER_FONT_SIZE + HEADER_FONT_SIZE + PADDING)
                );
                
                g.drawString(//Numero multiplo de 10
                        ""+i,
                        (C_X - NUMBER_FONT_SIZE / 2) + taskPxLenght * i,
                        getHeight() - (HEADER_FONT_SIZE + PADDING) 
                );
            } else {
                if (i % 5 == 0) {
                    g.drawString(//Número multiplos de 5
                        ""+i,
                        (C_X - NUMBER_FONT_SIZE / 2) + taskPxLenght * i,
                        getHeight() - (HEADER_FONT_SIZE + PADDING + SHORT_NUMBER_LINE) 
                    );
                }
                g.drawLine(// Líneas pequeñas (por unidad)
                        C_X + taskPxLenght * i,
                        A_Y,
                        C_X + taskPxLenght * i,
                        A_Y + SHORT_NUMBER_LINE
                );
            }
        }
        drawHeaders(g);   
    }
    
    public void setExecution(Task[] execution) {
        this.execution = execution;
        changeSize();
        repaint();
    }
    
    private void drawHeaders(Graphics g) {
        g.setFont(new Font("default", Font.BOLD, HEADER_FONT_SIZE));
        g.drawString(Y_HEADER, PADDING, getHeight() / 2);
        g.drawString(X_HEADER, (getWidth() / 2) - (X_HEADER.length() / 2) * HEADER_FONT_SIZE, getHeight() - PADDING);
    }
    
    
    private void drawExecution(Graphics g) {
        int A_Y = getHeight() - C_Y - taskPxLenght; //Actual y
        if (this.execution != null && this.execution.length > 0) {
            List<Integer> tasks = differentTasks();
            
            for (int i = 0 ; i < execution.length ; i++) {
                Task t = execution[i];
                if (t != null) {
                    g.setColor(Task.taskColor(t.getId()));
                    //FILL RECTANGULE
                    g.fillRect(
                            i * taskPxLenght + C_X, //X1
                            A_Y - (taskPxLenght * tasks.indexOf(t.getId()) + 1), //Y1
                            taskPxLenght, 
                            taskPxLenght
                    );
                    g.setColor(Color.BLACK);
                    //DRAW RECTANGLE
                    g.drawRect(
                        i * taskPxLenght + C_X, //X1
                        A_Y - (taskPxLenght * tasks.indexOf(t.getId()) + 1), //Y1
                        taskPxLenght, 
                        taskPxLenght
                    );
                }
            }
            g.setColor(Color.BLACK);
            g.setFont(new Font("deafault", Font.BOLD, NUMBER_FONT_SIZE));
            //TAREAS HEADERS
            for (Integer t : tasks) {
                g.drawString(
                        "T" + t, 
                        C_X - NUMBER_FONT_SIZE * 2, 
                        getHeight() - (C_Y + (tasks.indexOf(t) + 1) * taskPxLenght - (taskPxLenght / 2))
                    );
            }
        }
    }
    
    private List<Integer> differentTasks() {
        ArrayList<Integer> ids = new ArrayList();
        if (execution != null)
            for (Task t : execution) 
                if (t != null && !ids.contains(t.getId()))
                    ids.add(t.getId());

        Collections.sort(ids);
        return ids;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAxis(g);
        drawExecution(g);
    }

    public int getTaskPxLenght() {
        return taskPxLenght;
    }

    public void setTaskPxLenght(int taskPxLenght) {
        this.taskPxLenght = taskPxLenght;
        changeSize();
        updateUI();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
        if (this.execution != null) setExecution(controller.getScheduler().schedule(time));
        updateUI();
    }
    
    private void changeSize() {
        setPreferredSize(new Dimension(
            ((2 * PADDING) + C_X + (time * taskPxLenght)),
            execution == null ? getHeight(): differentTasks().size() * taskPxLenght + C_Y + 2 * PADDING
        )); 
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
