package microservices.book.multiplication.domain;

/**
 * Identifies the attemp from a {@link User } to solve a {@link Multiplication}.
 * @author Maurizio Aru
 *
 */
public final class MultiplicationResultAttempt {
	
	private final User user;
	private final Multiplication multiplication;
	private final int resultAttempt;
	
	// Empty construct for JSON (de)serialization
	public MultiplicationResultAttempt(){
		this.user = null;
		this.multiplication = null;
		this.resultAttempt = -1;
	}
	
	// parametric constructor
	public MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt) {
		
		this.user = user;
		this.multiplication = multiplication;
		this.resultAttempt = resultAttempt;
	}
	
	// getter methods
	public User getUser() { return this.user; }
	public Multiplication getMultiplication() { return this.multiplication; }
	public int getResultAttempt() { return this.resultAttempt; }
	
	@Override
	public String toString() {
		return "MultiplicationResultAttempt {" + 
				"User=" + this.user +
				", Multiplication=" + this.multiplication +
				", resultAttempt=" + this.resultAttempt +
			'}';
	}
}
