/**
 * 
 */
package microservices.book.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.service.MultiplicationService;

/**
 * @author Maurizio Aru
 *
 */
@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

	private final MultiplicationService multiplicationService;
	
	@Autowired
	public MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}
	
	public MultiplicationService getMultiplicationService() {
		return this.multiplicationService;
	}
	
	@PostMapping
	ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt){
		return ResponseEntity.ok(
				new ResultResponse(multiplicationService
						.checkAttempt(multiplicationResultAttempt)));
	}
	
	@GetMapping
	public String getUserResults() {
		return "GET /results";
	}
	
	static final class ResultResponse {
		
		private final boolean correct;
		public boolean getCorrect() { return this.correct; }
		
		public ResultResponse() { this.correct = true; }
		public ResultResponse(boolean correct) { this.correct = correct; }
	}		
}
