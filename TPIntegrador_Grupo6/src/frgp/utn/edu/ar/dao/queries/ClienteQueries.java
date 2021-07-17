package frgp.utn.edu.ar.dao.queries;

public enum ClienteQueries {

	BUSCA_CLIENTE_SQL("FROM Persona p WHERE p.dni= ? and estado <> 1 "),
	VERIFICAR_CLIENTE_EXISTENTE("FROM Persona p WHERE p.dni= ?"),
	BUSCA_CLIENTE_TIPO_USUARIO_SQL("SELECT p FROM Persona p INNER JOIN p.usuario u WHERE p.estado=0 AND u.tipoUsuario = 1 AND p.dni= ?");
	

	private String query;

	private ClienteQueries(String query) {
		this.setQuery(query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
