/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulers;

/**
 *
 * @author Alumno
 */

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
public class Sheldule {
  List<Task> generaltasks;
  List<Task> readytasks;
  List<Task> watingtasks;
  long ctime;

  public Sheldule(){
    generaltasks=new LinkedList<Task>();
    readytasks=new LinkedList<Task>();
    watingtasks=new LinkedList<Task>();
  }

  public Sheldule(List<Task> t){
    SetTasks(t);
    readytasks=new LinkedList<Task>();
    watingtasks=new LinkedList<Task>();
  }

  public void AddTask(Task t){
    generaltasks.add(t);
  }

  public void SetTasks(List<Task> t){
    this.generaltasks=t;
  }
  
  public void ResetTask(){
    generaltasks.clear();
    watingtasks.clear();
    readytasks.clear();
  }

  public int[] Shedule(){
    int taskexecution[]=new int[101];
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

  public void WaitTask(int i){
    watingtasks.add(readytasks.get(i));
    readytasks.remove(i);
  }

    
}
