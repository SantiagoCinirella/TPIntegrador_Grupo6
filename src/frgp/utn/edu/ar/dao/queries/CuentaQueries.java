package frgp.utn.edu.ar.dao.queries;

public enum CuentaQueries {

	BUSCA_MAX_CUENTA_SQL("FROM Cuenta c WHERE c.dni = ? and c.estado <> 1 and c.nroCuenta = ( SELECT max(cc.nroCuenta) FROM Cuenta cc WHERE c.dni = cc.dni)");

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
