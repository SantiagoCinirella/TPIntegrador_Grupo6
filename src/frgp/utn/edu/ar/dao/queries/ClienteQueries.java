package frgp.utn.edu.ar.dao.queries;

public enum ClienteQueries {

	BUSCA_CLIENTE_SQL("FROM Cliente p WHERE p.dni= ? ");

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
