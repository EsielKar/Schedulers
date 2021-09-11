/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulers.view;

import javax.swing.JOptionPane;
import schedulers.controller.Controller;
import schedulers.model.EDFSchedulingStrategy;
import schedulers.model.RateMonotonicSchedulingStrategy;
import schedulers.model.Scheduler;
import schedulers.model.SchedulingStrategy;

/**
 *
 * @author Esiel
 */
public class MainFrame extends javax.swing.JFrame {
    private Controller controller;
    private SchedulingStrategy edf = new EDFSchedulingStrategy();
    private SchedulingStrategy rm = new RateMonotonicSchedulingStrategy();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
        this.addTaskPanel.setController(controller);
        this.taskListPanel.setController(controller);
        this.tasksExecutionPanel.setController(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addTaskPanel = new schedulers.view.AddTaskPanel();
        taskListPanel = new schedulers.view.TaskListPanel();
        executionScrollPane = new javax.swing.JScrollPane();
        tasksExecutionPanel = new schedulers.view.TasksExecutionPanel();
        menuBar = new javax.swing.JMenuBar();
        EDF_Menu = new javax.swing.JMenu();
        EDF_MenuItem = new javax.swing.JMenuItem();
        RM_MenuItem = new javax.swing.JMenuItem();
        RM_Menu = new javax.swing.JMenu();
        setTimeMenuItem = new javax.swing.JMenuItem();
        setTaksSizeMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 500));

        executionScrollPane.setBackground(new java.awt.Color(204, 255, 51));
        executionScrollPane.setViewportView(tasksExecutionPanel);

        EDF_Menu.setText("Algoritmo");

        EDF_MenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        EDF_MenuItem.setText("Earliest Deadline First");
        EDF_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDF_MenuItemActionPerformed(evt);
            }
        });
        EDF_Menu.add(EDF_MenuItem);

        RM_MenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        RM_MenuItem.setText("Rate Monotonic");
        RM_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RM_MenuItemActionPerformed(evt);
            }
        });
        EDF_Menu.add(RM_MenuItem);

        menuBar.add(EDF_Menu);

        RM_Menu.setText("Configuración");

        setTimeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        setTimeMenuItem.setText("Time");
        setTimeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTimeMenuItemActionPerformed(evt);
            }
        });
        RM_Menu.add(setTimeMenuItem);

        setTaksSizeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        setTaksSizeMenuItem.setText("Task size");
        setTaksSizeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTaksSizeMenuItemActionPerformed(evt);
            }
        });
        RM_Menu.add(setTaksSizeMenuItem);

        menuBar.add(RM_Menu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(executionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addTaskPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(taskListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(executionScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addTaskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EDF_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDF_MenuItemActionPerformed
        System.out.println("EDF");
        Scheduler s = controller.getScheduler();
        s.setStrategy(edf);
        s.setTasks(controller.getTasks());
        tasksExecutionPanel.setExecution(
                s.schedule(this.tasksExecutionPanel.getTime())
        );
    }//GEN-LAST:event_EDF_MenuItemActionPerformed

    private void RM_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RM_MenuItemActionPerformed
        System.out.println("RM");
        Scheduler s = controller.getScheduler();
        s.setStrategy(rm);
        s.setTasks(controller.getTasks());
        tasksExecutionPanel.setExecution(
                s.schedule(this.tasksExecutionPanel.getTime())
        );
    }//GEN-LAST:event_RM_MenuItemActionPerformed

    private void setTimeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTimeMenuItemActionPerformed
        String resp = JOptionPane.showInputDialog(this, "Ingresa el tiempo de duración de la ejecución: ", "Tiempo de ejecución", JOptionPane.INFORMATION_MESSAGE);
        try {
            if (resp != null) {
                int newTime = Integer.parseInt(resp);
                if (newTime > 0) this.tasksExecutionPanel.setTime(newTime);
                else throw new Exception("El tiempo no puede ser menor a 1.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_setTimeMenuItemActionPerformed

    private void setTaksSizeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTaksSizeMenuItemActionPerformed
        String resp = JOptionPane.showInputDialog(this, "Ingresa tamaño en pixeles de las tareas: "
                + "\n Se recomineda minimamente 10.", "Tamaño de tareas", JOptionPane.INFORMATION_MESSAGE);
        try {
            if (resp != null) {
                int newSize = Integer.parseInt(resp);
                if (newSize > 0) this.tasksExecutionPanel.setTaskPxLenght(newSize);
                else throw new Exception("El tamaño debe ser mayor a 0");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_setTaksSizeMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EDF_Menu;
    private javax.swing.JMenuItem EDF_MenuItem;
    private javax.swing.JMenu RM_Menu;
    private javax.swing.JMenuItem RM_MenuItem;
    private schedulers.view.AddTaskPanel addTaskPanel;
    private javax.swing.JScrollPane executionScrollPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem setTaksSizeMenuItem;
    private javax.swing.JMenuItem setTimeMenuItem;
    private schedulers.view.TaskListPanel taskListPanel;
    private schedulers.view.TasksExecutionPanel tasksExecutionPanel;
    // End of variables declaration//GEN-END:variables

}