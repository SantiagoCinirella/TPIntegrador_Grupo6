package frgp.utn.edu.ar.dao.queries;

public enum UsuarioLoginQueries {

	VERIFICAR_USUARIO_SQL("SELECT p.usuario FROM UsuarioLogin p WHERE p.password = ? and p.usuario = ?");

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
