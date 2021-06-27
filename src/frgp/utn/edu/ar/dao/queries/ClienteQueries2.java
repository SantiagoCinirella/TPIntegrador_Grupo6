package frgp.utn.edu.ar.dao.queries;

public enum ClienteQueries2 {

	BUSCA_CLIENTE_SQL("SELECT p FROM Persona p INNER JOIN p.usuario u WHERE p.estado=0 AND u.tipoUsuario = 1 AND p.dni= ?");

	private String query;

	private ClienteQueries2(String query) {
		this.setQuery(query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
