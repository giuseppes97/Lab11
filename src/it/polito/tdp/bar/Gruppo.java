package it.polito.tdp.bar;

import java.time.LocalTime;
import java.util.Random;

public class Gruppo {
	private int dimensione;
	private double tolleranza;
	private int durata;
	private int dimtavoloassegnato=0;
	
	public Gruppo() {
		
		//numero=(int)((Math.random()*10)+1);
		Random ran=new Random();
		dimensione=1+(ran.nextInt(9));
		tolleranza=Math.random();
		durata=60+(ran.nextInt(60));
		
	}
	public int getdim() {
		return dimensione;
	}
  public int getdurata() {
	  return durata;
  }
public double getTolleranza() {
	
	return tolleranza;
}
public int getDimtavoloassegnato() {
	return dimtavoloassegnato;
}
public void setDimtavoloassegnato(int dimtavoloassegnato) {
	this.dimtavoloassegnato = dimtavoloassegnato;
}

}
