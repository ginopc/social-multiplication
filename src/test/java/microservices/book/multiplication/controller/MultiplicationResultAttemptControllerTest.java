package microservices.book.multiplication.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.domain.User;
import microservices.book.multiplication.service.MultiplicationService;
import microservices.book.multiplication.controller.MultiplicationResultAttemptController;
import microservices.book.multiplication.controller.MultiplicationResultAttemptController.ResultResponse;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {

	@MockBean
	private MultiplicationService multiplicationService;
	
	@Autowired
	private MockMvc mvc;
	
	// This object will be magically initialized by the initFields method below.
	private JacksonTester<MultiplicationResultAttempt> jsonResult;
	private JacksonTester<ResultResponse> jsonResponse;
		
	@Before
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
	}
	
	@Test
	public void postResultReturnCorrect() throws Exception {
		genericParametrizedTest(true);
	}
	
	@Test
	public void postResultReturnNotCorrect() throws Exception {
		genericParametrizedTest(false);
	}
	
	void genericParametrizedTest(final boolean correct) throws Exception {
		
		// given (Remeber we are not testing here the service itself)
		User user = new User("john_doe");
		Multiplication multiplication = new Multiplication(50, 70);
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500);
		
		given(multiplicationService
				.checkAttempt(any(MultiplicationResultAttempt.class)))
				.willReturn(correct);
		
		// when
		MockHttpServletResponse response = mvc.perform(post("/results")
					.contentType(MediaType.APPLICATION_JSON)
					.content(jsonResult.write(attempt).getJson()))
				.andReturn().getResponse();
		
		// then
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(jsonResponse
				.write(new ResultResponse(correct)).getJson()
			, response.getContentAsString());
	}
	
	@Test
	public void getResultsTest() throws Exception {
		// given
		
		// when
		MockHttpServletResponse response = mvc.perform(
				get("/results")
					.accept(MediaType.TEXT_PLAIN)
				)
				.andReturn().getResponse();
		
		// then
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("GET /results", response.getContentAsString());
	}

}
