package microservices.book.multiplication.domain;

/**
 * Store information to identify the user
 * @author Maurizio Aru
 *
 */
public final class User {
	
	private final String alias;
	
	protected User() {
		this.alias = null;
	}
	
	public User(String alias) {
		this.alias = alias;
	}
	
	public String getAlias() { return this.alias; }
	
	@Override
	public String toString() {
		return "User{" + 
				"alias=" + this.alias +
				'}';
	}
}
