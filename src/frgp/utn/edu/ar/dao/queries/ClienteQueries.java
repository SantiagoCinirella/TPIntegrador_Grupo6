package frgp.utn.edu.ar.dao.queries;

public enum ClienteQueries {

	BUSCA_CLIENTE_SQL("FROM Persona p WHERE p.dni= ? and estado <> 1 ");

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
