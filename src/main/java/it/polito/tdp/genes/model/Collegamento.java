package it.polito.tdp.genes.model;

public class Collegamento {
	
	private int cromo1;
	private int cromo2;
	private double peso;
	
	public Collegamento(int cromo1, int cromo2, double peso) {
		super();
		this.cromo1 = cromo1;
		this.cromo2 = cromo2;
		this.peso = peso;
	}

	public int getCromo1() {
		return cromo1;
	}

	public void setCromo1(int cromo1) {
		this.cromo1 = cromo1;
	}

	public int getCromo2() {
		return cromo2;
	}

	public void setCromo2(int cromo2) {
		this.cromo2 = cromo2;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cromo1;
		result = prime * result + cromo2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collegamento other = (Collegamento) obj;
		if (cromo1 != other.cromo1)
			return false;
		if (cromo2 != other.cromo2)
			return false;
		return true;
	}
	
	

	
	

}
