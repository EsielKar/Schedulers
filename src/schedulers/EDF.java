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
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class EDF{
  List<Task> generaltasks;
  List<Task> readytasks;
  List<Task> watingtasks;
  long ctime;

  public EDF(){
    generaltasks=new LinkedList<Task>();
    readytasks=new LinkedList<Task>();
    watingtasks=new LinkedList<Task>();
  }

  public EDF(List<Task> t){
    SetTasks(t);
    readytasks=new LinkedList<Task>();
    watingtasks=new LinkedList<Task>();
  }

  public void AddTask(Task t){
    generaltasks.add(t);
  }
  
  public void ResetTask(){
    generaltasks.clear();
    watingtasks.clear();
    readytasks.clear();
  }

  public void SetTasks(List<Task> t){
    this.generaltasks=t;
  }

  public int[] Shedule(){
    int taskexecution[]=new int[101];
    int i=0;
    int taskexecute;
    boolean finish;
    long fin;
    Task aux;
    if(generaltasks.size()>0){
    Preparation();
    System.out.println("menor inicio "+(ctime=EarliestStart()));
    ctime=0;
    fin=ctime+100;
    while(ctime<=fin){
      UpdateReady();
      taskexecute=TaskShortestAbsoluteDeadline();
      if(taskexecute == -1){
        System.out.println(ctime+" - NT");
        taskexecution[i]=0;
      }else{
        aux=readytasks.get(taskexecute);
        System.out.println(ctime+" - T"+aux.indice);
        taskexecution[i]=aux.indice;
        if(aux.Execute())
          WaitTask(taskexecute);
      }
      i++;
      ctime++;
    }
    taskexecution[100]=0;
    }
    return taskexecution;
  }

  public void ShowGeneral(){
    int n=generaltasks.size();
    Task aux;
    for(int i=0;i<n;i++){
      aux=generaltasks.get(i);
      System.out.println("s "+aux.start+" : c "+aux.timecompr+" : p "+aux.period+" : d "+(aux.deadline+aux.start)+" ");
    }
  }

  public void ShowReady(){
    int n=readytasks.size();
    Task aux;
    for(int i=0;i<n;i++){
      aux=readytasks.get(i);
      System.out.println("s "+aux.start+" : c "+aux.timecompr+" : p "+aux.period+" : d "+(aux.deadline+aux.start)+" ");
    }
  }

  public void ShowWaiting(){
    int n=watingtasks.size();
    Task aux;
    for(int i=0;i<n;i++){
      aux=watingtasks.get(i);
      System.out.println("s "+aux.start+" : c "+aux.timecompr+" : p "+aux.period+" : d "+(aux.deadline+aux.start)+" ");
    }
  }

  public long EarliestStart(){
    int tam=generaltasks.size();
    long aux,earliest=generaltasks.get(0).start;
    for(int i=0;i<tam;i++){
      aux=generaltasks.get(i).start;
      earliest=(earliest>aux)?aux:earliest;
    }
    return earliest;
  }

  public void Preparation(){
    watingtasks.clear();
    readytasks.clear();
    int tam=generaltasks.size();
    for(int i=0;i<tam;i++)
        generaltasks.get(i).reset();
    for(int i=0;i<tam;i++)
        watingtasks.add(generaltasks.get(i));
  }

  public void UpdateReady(){
    for(int i=0;i<watingtasks.size();i++)
      if(watingtasks.get(i) instanceof PeriodTask){
      if(watingtasks.get(i).start<=ctime){
        readytasks.add(watingtasks.get(i));
        watingtasks.remove(i);
        i--;
      }
      }else
       if(watingtasks.get(i).start==ctime){
        readytasks.add(watingtasks.get(i));
        watingtasks.remove(i);
        i--;
      }
  }

  public int TaskShortestAbsoluteDeadline(){
    int tam=readytasks.size();
    int shortest=-1;
    long aux=0;
    for(int i=0;i<tam;i++)
        if(shortest==-1){
          shortest=i;
          aux=readytasks.get(i).deadline+readytasks.get(i).start;
        }else if((readytasks.get(i).deadline+readytasks.get(i).start)<aux){
          //aux=readytasks.get(i).period;
          aux=readytasks.get(i).deadline+readytasks.get(i).start;
          shortest=i;
        }
    return shortest;
  }

  public void WaitTask(int i){
    watingtasks.add(readytasks.get(i));
    readytasks.remove(i);
  }


  /*public static void main(String[] args){
    Scanner lee= new Scanner(System.in);
    int n;
    long s,d,t;
    EDF edf=new EDF();

    System.out.println("cuantas tareas planificaras?");
    n=lee.nextInt();

    for(int i=0;i<n;i++){
      System.out.println("inicio");
      s=lee.nextInt();
      System.out.println("computo");
      t=lee.nextInt();
      System.out.println("deadline");
      d=lee.nextInt();
      edf.AddTask(new PeriodTask(s,d,t,i));
    }

    edf.Shedule();


  }
*/
}
