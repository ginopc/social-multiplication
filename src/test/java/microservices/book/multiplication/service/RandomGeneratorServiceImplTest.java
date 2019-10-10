package microservices.book.multiplication.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class RandomGeneratorServiceImplTest {
	
	private RandomGeneratorServiceImpl randomGeneratorServiceImpl;
	
	@Before
	public void setUp() {
		randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
	}

	@Test
	public void testGenerateRandomFactor() throws Exception {
		
		// when a good sample of randomly generated factors is generated
		List<Integer> randomFactors = IntStream.range(0,  1000)
				.map(i -> randomGeneratorServiceImpl.generateRandomFactor())
				.boxed().collect(Collectors.toList());
		
		// then all of them should be betwee 11 to 99
		// beacause we want a middle-complexity calculation
		boolean result = true;
		for( int i=0; i<randomFactors.size(); i++) {
			int item = randomFactors.get(i);
			if (item < 11 && item >= 100) {
				result = false;
			}
		}
		assertTrue(result);
		
	}

}
