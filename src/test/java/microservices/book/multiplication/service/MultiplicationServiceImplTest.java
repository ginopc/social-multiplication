package microservices.book.multiplication.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.domain.User;
import microservices.book.multiplication.service.RandomGeneratorService;

public class MultiplicationServiceImplTest {
	
	private MultiplicationServiceImpl multiplicationServiceImpl;
	
	@Mock
	private RandomGeneratorService randomGeneratorService;
	
	@Before
	private void setUp() {
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
		multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
		
	}
	
	@Autowired
	private MultiplicationService multiplicationService;

	@Test
	public void createRandomMultiplicationTest() {
		Multiplication multiplication = multiplicationService.createRandomMultiplication();
		
		assertEquals(50, multiplication.getFactorA());
		assertEquals(30, multiplication.getFactorB());
		assertEquals(1500, multiplication.getResult());
	}
	
	@Test
	public void checkCorrectAttemptTest() {
		fail("Not yet implemented");
		
		// given 
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("john_doe");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000);
		
		// when
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);
		
		// assert
		assertTrue(attemptResult);
	}
	
	@Test
	public void checkWrongAttemptTest() {
		fail("Not yet implemented");
	}

}
