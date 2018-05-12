package com.javaservicio.modelo;

public class Login {
	
    private int idlogin;
    private String useer;
    private String pass ;
    private boolean superlogin;
    private Tipos tipologin;
    
    public Login(){}

	public Login(String useer, String pass, boolean superlogin, Tipos tipologin) {
		super();
		this.useer = useer;
		this.pass = pass;
		this.superlogin = superlogin;
		this.tipologin = tipologin;
	}

	public int getIdlogin() {
		return idlogin;
	}

	protected void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	public String getUseer() {
		return useer;
	}

	public void setUseer(String useer) {
		this.useer = useer;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isSuperlogin() {
		return superlogin;
	}

	public void setSuperlogin(boolean superlogin) {
		this.superlogin = superlogin;
	}

	public Tipos getTipologin() {
		return tipologin;
	}

	public void setTipologin(Tipos tipologin) {
		this.tipologin = tipologin;
	}

	@Override
	public String toString() {
		return "Login [useer=" + useer + ", pass=" + pass + ", superlogin=" + superlogin + ", tipologin=" + tipologin
				+ "]";
	}

	
    
	
	
	

}
