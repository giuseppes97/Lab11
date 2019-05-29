package it.polito.tdp.bar;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeMap;

import it.polito.tdp.bar.Evento.TipoEvento;

public class Simulatore {
	private PriorityQueue<Evento> coda=new PriorityQueue<>();
	//STATO DEL SISTEMA
 private	Map<Integer,Integer> tavoli;
	
	//PARAMETRI DI SIMULAZIONE
	private int istantetempo;
	private int arrivogruppo;
	private int grupposeneva;
	private int interarrivo;
	
	//STATISTICHE RACCOLTE
	private int clientitotali=0;
	private int clientisodd=0;
	private int clientiinsodd=0;
	
	//VARIABILI INTERNE
	private Random ran=new Random();
	
	
	
	public void init() {
		coda.clear();
		tavoli=new TreeMap<Integer,Integer>();
		tavoli.put(10,2);
		tavoli.put(8,4);
		tavoli.put(6,4);
		tavoli.put(4,5);
		istantetempo=0;
		
		arrivogruppo=istantetempo+interarrivo;
		for(int i=0;i<2000;i++) {
			interarrivo=1+ran.nextInt(9);
			arrivogruppo =istantetempo+interarrivo;
			istantetempo += arrivogruppo;
			Gruppo g=new Gruppo();
			
			
			coda.add(new Evento(arrivogruppo,g,TipoEvento.ARRIVO_GRUPPO_CLIENTI));
			
		}
	}
	
	public void run() {
		
		while(!coda.isEmpty()) {
			Evento ev=coda.poll();
			System.out.println(ev);
			
			switch(ev.getTipo()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				int size=ev.getGruppo().getdim();
				istantetempo=istantetempo+interarrivo;
				int flag=0;
				for(int dimtavolo:tavoli.keySet()) {
					if(dimtavolo>=size || dimtavolo<=(size*2)) {
						if(tavoli.get(dimtavolo)>0) { 
							tavoli.put(dimtavolo,tavoli.get(dimtavolo)-1);
							ev.getGruppo().setDimtavoloassegnato(dimtavolo);
						      clientitotali=clientitotali+size;
						      clientisodd=clientisodd+size;
						      flag=1;
						      coda.add(new Evento(ev.getOraarrivo()+ev.getGruppo().getdurata(),ev.getGruppo(),TipoEvento.GRUPPOCLIENTI_SENEVA));   
						      
							}
						
					}
					
					
				
				}
				if(flag==0)  {
					if(ev.getGruppo().getTolleranza()>0.9)  {
						clientiinsodd=clientiinsodd+size;
						
					}else {
						clientisodd=clientisodd+size;
					}
				}
				
				
				break;
				
			case GRUPPOCLIENTI_SENEVA:
				int dim=ev.getGruppo().getdim();
				int dimtavolo=ev.getGruppo().getDimtavoloassegnato();
				tavoli.put(dimtavolo, tavoli.get(dimtavolo)+1);
				
				
				break;
				
			
			}
			
			
		}
		
		
		
		
	}
	public String toString() {
		
		return "NUMERO CLIENTI SODDISFATTI: "+clientisodd+"\nNUMERO CLIENTI INSODDISFATTI: "+clientiinsodd+"\n\nCLIENTI TOTALI: "+clientitotali;
		
	}
	
	
	
	
	

}
