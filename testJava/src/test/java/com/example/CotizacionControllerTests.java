package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=BaseTestConfig.class)
public class CotizacionControllerTests {

	@Autowired WebApplicationContext wac; 
	@Autowired MockHttpSession session;
	@Autowired MockHttpServletRequest request;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	//Testear respuesta OK de /cotizacion
	@Test
	public void testCotizacion() throws Exception {
		mockMvc.perform(get("/cotizacion").session(session)
				.accept(MediaType.ALL))
		.andExpect(status().isOk());
	}

	//Testear respuesta OK de /cotizacion?name=dolar
	@Test
	public void testCotizacionDolar() throws Exception {
		mockMvc.perform(get("/cotizacion?name=dolar").session(session)
				.accept(MediaType.ALL))
		.andExpect(status().isOk());
	}

	//Testear respuesta Unauthorized de /cotizacion?name=real
	@Test
	public void testCotizacionReal() throws Exception {

		this.mockMvc.perform(get("/cotizacion?name=real").session(session)
				.accept(MediaType.TEXT_HTML))
		.andExpect(status().isUnauthorized());
	}

}
