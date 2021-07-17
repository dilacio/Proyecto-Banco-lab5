package frgp.utn.edu.ar.dao.queries;

public enum UsuarioLoginQueries {

	VERIFICAR_USUARIO_SQL("SELECT p FROM UsuarioLogin p WHERE p.password = ? and p.usuario = ? and p.estado = 0");

	private String query;

	private UsuarioLoginQueries(String query) {
		this.setQuery(query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
