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
public class PeriodTask extends Task{
  long startini;
  boolean bandera=false;


  public PeriodTask(long s,long d, long tc, long period, int i){
    super(s,d,tc,i);
    startini=s;
    this.period=period;
  }
  
  public boolean Execute(){
    timecompr--;
    if(timecompr==0){
      start+=period;
      timecompr=timecompt;
      return(true);
    }
    return(false);
  }
  public void reset(){
      timecompr=timecompt;
      start=startini;
  }
}