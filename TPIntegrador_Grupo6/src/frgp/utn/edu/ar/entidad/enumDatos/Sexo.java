package frgp.utn.edu.ar.entidad.enumDatos;

public enum Sexo {

	 FEMENINO("Femenino"), NO_ESPECIFICA("No especifica");

	private String sexo;

	private Sexo(String sexo) {
		this.setSexo(sexo);
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
