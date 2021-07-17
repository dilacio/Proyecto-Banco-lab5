package frgp.utn.edu.ar.dao.queries;

public enum CuentaQueries {

	BUSCA_MAX_CUENTA_SQL("SELECT MAX(nroCuenta) FROM Cuenta c "),BUSCA_MAX_CBU_SQL("SELECT MAX(cbu) FROM Cuenta c "),CANT_CUENTAS_SQL("SELECT COUNT(*) FROM Cuenta c where c.dni = ?");
	

	private String query;

	private CuentaQueries(String query) {
		this.setQuery(query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
