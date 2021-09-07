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
public class Task{
  long start,deadline,timecompt,timecompr;
  long period;
  int indice;

  public Task(long s,long d, long tc, int i){
    start=s;
    period=0;deadline=d;
    timecompt=timecompr=tc;
    indice=i;
  }
  public boolean Execute(){
    timecompr--;
    if(timecompr==0)
      return(true);
    return(false);
  }
  
  public void reset(){
      timecompr=timecompt;
  }
}
