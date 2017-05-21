package br.com.own.bean;

import br.com.own.model.Interesse;

public class UsuarioDados {

	private String latitude;
	private String longetude;
	private Interesse Interesse;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongetude() {
		return longetude;
	}

	public void setLongetude(String longetude) {
		this.longetude = longetude;
	}

	public Interesse getInteresse() {
		return Interesse;
	}

	public void setInteresse(Interesse interesse) {
		Interesse = interesse;
	}

}
