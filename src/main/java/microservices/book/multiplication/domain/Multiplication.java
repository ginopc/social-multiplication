package microservices.book.multiplication.domain;

/**
 * This class represents a Multiplication in our application
 * @author Maurizio Aru
 *
 */
public class Multiplication {

	// Both factors
	private int factorA;
	private int factorB;
	
	// the result of operation A * B
	private int result;

	// Empty constructor for JSON (de)serialization
	public Multiplication(int factorA, int factorB) {
		this.factorA = factorA;
		this.factorB = factorB;
		
		this.result = factorA * factorB;
	}
	
	// getter methods
	public int getFactorA() { return this.factorA; }
	public int getFactorB() { return this.factorB; }
	public int getResult()  { return this.result;  }
	
	@Override
	public String toString() {
		return "Multiplication{" + 
			"factorA=" + this.factorA +
			", factorB=" + this.factorB +
			", result(A*B)=" + this.result +
			'}';
	}
}
