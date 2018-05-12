package com.javaservicio.modelo;


public class Tipos {
	
	private int idtipologin;
    private String tipologin;
    
    public Tipos(){}

	public Tipos(String tipologin) {
		super();
		this.tipologin = tipologin;
	}

	public int getIdtipologin() {
		return idtipologin;
	}

	protected void setIdtipologin(int idtipologin) {
		this.idtipologin = idtipologin;
	}

	public String getTipologin() {
		return tipologin;
	}

	public void setTipologin(String tipologin) {
		this.tipologin = tipologin;
	}

	@Override
	public String toString() {
		return "Tipos [tipologin=" + tipologin + "]";
	};

    
    

}
