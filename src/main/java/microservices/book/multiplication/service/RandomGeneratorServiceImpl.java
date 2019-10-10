package microservices.book.multiplication.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {
	
	private static int MINIMUM_FACTOR = 11;
	private static int MAXIMUM_FACTOR = 99;

	@Override
	public int generateRandomFactor() {
		int result = new Random().nextInt((MAXIMUM_FACTOR - MINIMUM_FACTOR) + 1) + MINIMUM_FACTOR; 
		return result;
	}

}
