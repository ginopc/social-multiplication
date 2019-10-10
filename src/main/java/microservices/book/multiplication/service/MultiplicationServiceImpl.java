package microservices.book.multiplication.service;

import org.springframework.stereotype.Service;
import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
	
	private RandomGeneratorService randomGeneratorService;
	
	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
		this.randomGeneratorService = randomGeneratorService;
	}

	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}

	@Override
	public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
		int factorA = resultAttempt.getMultiplication().getFactorA();
		int factorB = resultAttempt.getMultiplication().getFactorB();
		return resultAttempt.getResultAttempt() == (factorA * factorB);
	}
}
