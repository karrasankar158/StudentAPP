package com.in.controller;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.in.entity.Student;
import com.in.service.StudentService;

@WebMvcTest(controllers = StudentController.class) 
//WebMvcTest will create bean for only controller class.
public class StudentControllerTest {
	
	@MockBean
	private StudentService studentService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final MediaType APPLICATION_JSON_UTF8=
			new MediaType(MediaType.APPLICATION_JSON.getType(),
					MediaType.APPLICATION_JSON.getSubtype(),
					Charset.forName("utf8"));
	
	private Student student;
	
	@BeforeEach //Calling before, every test method...
	public void setup() {
		
		//This method will load before each test case calling.....
		MockitoAnnotations.openMocks(this);//Initializing all Mocks...
		
		student=new Student();
		student.setId(9999L);
		student.setName("Mohan");
		student.setBranch("Civil");
		student.setIsMale(true);
	}
	
	@Test
	public void testSaveStudent() throws Exception {
		//passing controller and method path
		String path="/student/save";
		
		ObjectMapper objectMapper=new ObjectMapper();//Jackson API
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow=objectMapper.writer().withDefaultPrettyPrinter();
		//Here Converting Student Object into JSON String.
		String JSON=ow.writeValueAsString(student);
		
		
		MvcResult response=mockMvc
		   .perform(
				    MockMvcRequestBuilders
				       .post(path)
				       .contentType(APPLICATION_JSON_UTF8)
				       .content(JSON))
		   .andExpect(MockMvcResultMatchers.status().is(201)).andReturn();
		
		//Validating results
		Assertions.assertNotNull(response);
	}

}
