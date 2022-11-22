package com.operation.calculator.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.operation.calculator.services.OperationsCalculatorService;


@RunWith(SpringRunner.class)
@WebMvcTest(CalcRestControllerTest.class)
public class CalcRestControllerTest {

	
	@MockBean
	@Qualifier("operationsCalculatorService")
	OperationsCalculatorService operationsCalculatorService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void controllerGetCalcTest() throws UnsupportedEncodingException, Exception {
		boolean flag = false;
		when(operationsCalculatorService.allOperations( Mockito.any())).thenReturn(new BigDecimal(10));
		String response = mvc.perform(post("/calc").param("RequestOperacion", "2+2")
				.contentType(MediaType.MULTIPART_FORM_DATA))
		.andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		flag = Double.parseDouble(response)>0?true:false;	
		assertTrue(flag);
	}

}
