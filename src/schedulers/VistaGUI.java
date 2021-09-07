/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package schedulers;

/**
 *
 * @author STEWART
 */
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class VistaGUI extends javax.swing.JFrame {

    /**
     * Creates new form VistaGUI
     */
    DefaultTableModel modelo=new DefaultTableModel();
    
    EDF shelduleEDF=new EDF();
    RM shelduleRM=new RM();
    LL shelduleLL=new LL();
    List<Task> tasks;
    int i=1;
    
    
    public VistaGUI() {
        initComponents();
        //setSize(1200,600);
        setSize(1500,600);
        setLocationRelativeTo(null);
        setResizable(false);
        this.modelo.setColumnIdentifiers(new String[]{"No.Task","Start","WCET","Deadline","Period"});
        this.jTable1.setModel(modelo);
    }

    public void dibujargrafico(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.drawLine(100,400,1100,400);
        g.drawLine(100,400,100,200);
        for(int i=0;i<101;i++){
            if (i%10==0)
            {
                g.drawLine(100+10*i,400,100+10*i,420);
                g.drawString(""+i,95+10*i,430);
            }
            else
                g.drawLine(100+10*i,400,100+10*i,410);
        }
        g.drawString("TIEMPO",600, 450);
        
        g.drawString("PROCESOS",10, 300);
    }

    public void dibujarprocesosEDF(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        int[] values=shelduleEDF.Shedule();
        int k=0;
        for (int j=1;j<101;j++){
            if (values[k]>0){
                if(values[k]!= values[j]){
                    //g.drawLine(100+10*k,300,100+10*(j),300);
                    //g.drawLine(100+10*k,300,100+10*(k),400);
                    //g.drawLine(100+10*j,300,100+10*(j),400);
                    switch (values[k]){
                        case 1: g.setColor(Color.cyan);
                                break;
                        case 2: g.setColor(Color.BLUE);
                                break;
                        case 3: g.setColor(Color.GREEN);
                                break;
                        case 4: g.setColor(Color.MAGENTA);
                                break;
                        case 5: g.setColor(Color.ORANGE);
                                break;
                        case 6: g.setColor(Color.YELLOW);
                                break;
                        default: g.setColor(Color.red);
                                break;
                    }
                    g.fillRect(100+10*k,300,10*(j-k),100);
                    g.setColor(Color.BLACK);
                    g.drawRect(100+10*k,300,10*(j-k),100);
                    g.setColor(Color.white);
                    g.drawString(""+values[k],(int)(100+10*((j+k)/2)),350);
                    g.setColor(Color.BLACK);
                    k=j;
                }
            }else
                if (values[j]>0)
                    k=j;
        }
        
    }
    
    public void dibujarprocesosEDFTiempo(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        int[] values=shelduleEDF.Shedule();
        int k=0;
        for (int j=1;j<101;j++){
            if (values[k]>0){
                if(values[k]!= values[j]){
                    switch (values[k]){
                        case 1: g.setColor(Color.cyan);
                                break;
                        case 2: g.setColor(Color.BLUE);
                                break;
                        case 3: g.setColor(Color.GREEN);
                                break;
                        case 4: g.setColor(Color.MAGENTA);
                                break;
                        case 5: g.setColor(Color.ORANGE);
                                break;
                        case 6: g.setColor(Color.YELLOW);
                                break;
                        default: g.setColor(Color.red);
                                break;
                    }
                    g.fillRect(100+10*k,400-30*(values[k]-1)-19,10*(j-k),19);
                    
                    //g.drawLine(100+10*k,400-30*(values[k]-1)-19,100+10*(j),400-30*(values[k]-1)-19);
                    //g.drawLine(100+10*k,400-30*(values[k]-1)-19,100+10*(k),400-30*(values[k]-1));
                    //g.drawLine(100+10*j,400-30*(values[k]-1)-19,100+10*(j),400-30*(values[k]-1));
                    
                    g.setColor(Color.BLACK);
                    g.drawRect(100+10*k,400-30*(values[k]-1)-19,10*(j-k),19);
                    g.drawLine(100,400-30*(values[k]-1),1100,400-30*(values[k]-1));
                    g.drawLine(100,400-30*(values[k]-1)-19,100,400-30*(values[k]-2)-19);
                    g.drawString(""+values[k],90,400-30*(values[k]-1)-10);
                    k=j;
                }
            }else
                if (values[j]>0)
                    k=j;
        }
    }
    
    public void dibujarprocesosRMTiempo(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        int[] values=shelduleRM.Shedule();
        int k=0;
        for (int j=1;j<101;j++){
            if (values[k]>0){
                if(values[k]!= values[j]){
                    switch (values[k]){
                        case 1: g.setColor(Color.cyan);
                                break;
                        case 2: g.setColor(Color.BLUE);
                                break;
                        case 3: g.setColor(Color.GREEN);
                                break;
                        case 4: g.setColor(Color.MAGENTA);
                                break;
                        case 5: g.setColor(Color.ORANGE);
                                break;
                        case 6: g.setColor(Color.YELLOW);
                                break;
                        default: g.setColor(Color.red);
                                break;
                    }
                    g.fillRect(100+10*k,400-30*(values[k]-1)-19,10*(j-k),19);
                    
                    //g.drawLine(100+10*k,400-30*(values[k]-1)-19,100+10*(j),400-30*(values[k]-1)-19);
                    //g.drawLine(100+10*k,400-30*(values[k]-1)-19,100+10*(k),400-30*(values[k]-1));
                    //g.drawLine(100+10*j,400-30*(values[k]-1)-19,100+10*(j),400-30*(values[k]-1));
                    
                    g.setColor(Color.BLACK);
                    g.drawRect(100+10*k,400-30*(values[k]-1)-19,10*(j-k),19);
                    g.drawLine(100,400-30*(values[k]-1),1100,400-30*(values[k]-1));
                    g.drawLine(100,400-30*(values[k]-1)-19,100,400-30*(values[k]-2)-19);
                    g.drawString(""+values[k],90,400-30*(values[k]-1)-10);
                    k=j;
                }
            }else
                if (values[j]>0)
                    k=j;
        }
    }
    
    public void dibujarprocesosLLTiempo(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        int[] values=shelduleLL.Shedule();
        int k=0;
        for (int j=1;j<101;j++){
            if (values[k]>0){
                if(values[k]!= values[j]){
                    switch (values[k]){
                        case 1: g.setColor(Color.cyan);
                                break;
                        case 2: g.setColor(Color.BLUE);
                                break;
                        case 3: g.setColor(Color.GREEN);
                                break;
                        case 4: g.setColor(Color.MAGENTA);
                                break;
                        case 5: g.setColor(Color.ORANGE);
                                break;
                        case 6: g.setColor(Color.YELLOW);
                                break;
                        default: g.setColor(Color.red);
                                break;
                    }
                    g.fillRect(100+10*k,400-30*(values[k]-1)-19,10*(j-k),19);
                    
                    //g.drawLine(100+10*k,400-30*(values[k]-1)-19,100+10*(j),400-30*(values[k]-1)-19);
                    //g.drawLine(100+10*k,400-30*(values[k]-1)-19,100+10*(k),400-30*(values[k]-1));
                    //g.drawLine(100+10*j,400-30*(values[k]-1)-19,100+10*(j),400-30*(values[k]-1));
                    
                    g.setColor(Color.BLACK);
                    g.drawRect(100+10*k,400-30*(values[k]-1)-19,10*(j-k),19);
                    g.drawLine(100,400-30*(values[k]-1),1100,400-30*(values[k]-1));
                    g.drawLine(100,400-30*(values[k]-1)-19,100,400-30*(values[k]-2)-19);
                    g.drawString(""+values[k],90,400-30*(values[k]-1)-10);
                    k=j;
                }
            }else
                if (values[j]>0)
                    k=j;
        }
    }
    
    public void dibujarprocesosRM(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        int[] values=shelduleRM.Shedule();
        int k=0;
        for (int i=1;i<101;i++){
            if (values[k]>0){
                if(values[k]!= values[i]){
                    switch (values[k]){
                        case 1: g.setColor(Color.cyan);
                                break;
                        case 2: g.setColor(Color.BLUE);
                                break;
                        case 3: g.setColor(Color.GREEN);
                                break;
                        case 4: g.setColor(Color.MAGENTA);
                                break;
                        case 5: g.setColor(Color.ORANGE);
                                break;
                        case 6: g.setColor(Color.YELLOW);
                                break;
                        default: g.setColor(Color.red);
                                break;
                    }
                    g.fillRect(100+10*k,300,10*(i-k),100);
                    g.setColor(Color.BLACK);
                    g.drawRect(100+10*k,300,10*(i-k),100);
                    g.setColor(Color.white);
                    g.drawString(""+values[k],(int)(100+10*((i+k)/2)),350);
                    g.setColor(Color.BLACK);
                    k=i;
                }
            }else
                if (values[i]>0)
                    k=i;
        }
    }
    
    public void dibujarprocesosLL(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        int[] values=shelduleLL.Shedule();
        int k=0;
        for (int i=1;i<101;i++){
            if (values[k]>0){
                if(values[k]!= values[i]){
                    switch (values[k]){
                        case 1: g.setColor(Color.cyan);
                                break;
                        case 2: g.setColor(Color.BLUE);
                                break;
                        case 3: g.setColor(Color.GREEN);
                                break;
                        case 4: g.setColor(Color.MAGENTA);
                                break;
                        case 5: g.setColor(Color.ORANGE);
                                break;
                        case 6: g.setColor(Color.YELLOW);
                                break;
                        default: g.setColor(Color.red);
                                break;
                    }
                    g.fillRect(100+10*k,300,10*(i-k),100);
                    g.setColor(Color.BLACK);
                    g.drawRect(100+10*k,300,10*(i-k),100);
                    g.setColor(Color.white);
                    g.drawString(""+values[k],(int)(100+10*((i+k)/2)),350);
                    g.setColor(Color.BLACK);
                    k=i;
                }
            }else
                if (values[i]>0)
                    k=i;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planificadores");
        setSize(new java.awt.Dimension(0, 0));

        jButton1.setText("EDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Start");

        jLabel2.setText("WCET");

        jLabel3.setText("Deadline");

        jButton2.setText("Add Task");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove Tasks");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Period");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton4.setText("LL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("RM");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Gantt Graph");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Time Graph");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4)
                                        .addComponent(jButton5)
                                        .addComponent(jRadioButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jButton3))
                                    .addComponent(jRadioButton2)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: 
        this.update(this.getGraphics());
        dibujargrafico();
        if(this.jRadioButton2.isSelected())
            dibujarprocesosEDFTiempo();
        if(this.jRadioButton1.isSelected())
            dibujarprocesosEDF();
        this.jLabel4.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.update(this.getGraphics());
        shelduleEDF.ResetTask();
        shelduleRM.ResetTask();
        shelduleLL.ResetTask();
        this.i=1;
        int filas = this.modelo.getRowCount();
        for(int j=0;j<filas;j++)
            this.modelo.removeRow(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
            if(jTextField1.getText()!="" && jTextField2.getText()!="" && jTextField3.getText()!="" && jTextField4.getText()!=""){
                shelduleEDF.AddTask(new PeriodTask(Long.parseLong(jTextField1.getText()),Long.parseLong(jTextField3.getText()),Long.parseLong(jTextField2.getText()),Long.parseLong(jTextField4.getText()),i));
                shelduleRM.AddTask(new PeriodTask(Long.parseLong(jTextField1.getText()),Long.parseLong(jTextField3.getText()),Long.parseLong(jTextField2.getText()),Long.parseLong(jTextField4.getText()),i));
                shelduleLL.AddTask(new PeriodTask(Long.parseLong(jTextField1.getText()),Long.parseLong(jTextField3.getText()),Long.parseLong(jTextField2.getText()),Long.parseLong(jTextField4.getText()),i));
                this.modelo.addRow(new Object[]{""+i+"",jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText()});
                this.i++;
            }
        }
        else{
            if(jTextField1.getText()!="" && jTextField2.getText()!="" && jTextField3.getText()!="" && jTextField4.getText()!=""){
                shelduleEDF.AddTask(new Task(Long.parseLong(jTextField1.getText()),Long.parseLong(jTextField3.getText()),Long.parseLong(jTextField2.getText()),i));
                shelduleRM.AddTask(new Task(Long.parseLong(jTextField1.getText()),Long.parseLong(jTextField3.getText()),Long.parseLong(jTextField2.getText()),i));
                shelduleLL.AddTask(new Task(Long.parseLong(jTextField1.getText()),Long.parseLong(jTextField3.getText()),Long.parseLong(jTextField2.getText()),i));
                this.modelo.addRow(new Object[]{""+i+"",jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),""});
                this.i++;
            }
        }
        //this.jLabel4.setText(this.jLabel4.getText()+"  Task"+i);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.update(this.getGraphics());
        dibujargrafico();
        if(this.jRadioButton2.isSelected())
            dibujarprocesosRMTiempo();
        if(this.jRadioButton1.isSelected())
            dibujarprocesosRM();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.update(this.getGraphics());
        dibujargrafico();
        if(this.jRadioButton2.isSelected())
            dibujarprocesosLLTiempo();
        if(this.jRadioButton1.isSelected())
            dibujarprocesosLL();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
