package it.polito.tdp.bar;

import java.time.LocalTime;

public class Evento implements Comparable<Evento>{
	public enum TipoEvento {
		
		ARRIVO_GRUPPO_CLIENTI,

		GRUPPOCLIENTI_SENEVA,
	}
	
		
	
	
	//private int numpersone;
	private int istante;
	private Gruppo gruppo;
	private TipoEvento tipo;
	
	public Evento(int a,Gruppo g, TipoEvento t) {
		istante=a;
		gruppo=g;
		tipo=t;
	}
	
	@Override
	public int compareTo(Evento e) {
		return this.istante-e.istante;
		
	}
	public int getOraarrivo() {
		return istante;
	}
	public void setOraarrivo(int oraarrivo) {
		this.istante = oraarrivo;
	}
	public Gruppo getGruppo() {
		return gruppo;
	}
	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return "ISTANTE:"+istante+" DIMENSIONE GRUPPO: "+gruppo.getdim()+" TIPO: "+tipo;
	}
	
	
}
