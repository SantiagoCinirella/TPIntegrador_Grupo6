package frgp.utn.edu.ar.dao.queries;

public enum PersonaQueries {

	UPDATE_USUARIO_SQL("UPDATE Persona p SET p.apellido = ?, p.nombre = ?, p.email = ? WHERE p.dni = ?");

	private String query;

	private PersonaQueries(String query) {
		this.setQuery(query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
