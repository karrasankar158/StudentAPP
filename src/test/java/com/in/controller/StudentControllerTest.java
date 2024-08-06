package com.in.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.in.entity.Student;
import com.in.service.StudentService;

@WebMvcTest(controllers = StudentController.class) 
//WebMvcTest will create bean for only controller class.
public class StudentControllerTest {
	/*
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
	}*/
	/*
	@MockBean
	private StudentService studentService;
	
	@Autowired
	private MockMvc mockMvc;
	
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
		//Here Converting Student Object into JSON String.
		String JSON=objectMapper.writeValueAsString(student);
		
		
		MvcResult response=mockMvc
		   .perform(
				    MockMvcRequestBuilders
				       .post(path)
				       .contentType(MediaType.APPLICATION_JSON)
				       .content(JSON))
		   .andExpect(MockMvcResultMatchers.status().is(201)).andReturn();
		
		//Validating results
		Assertions.assertNotNull(response);
	}*/
	
	/*
	@MockBean
	private StudentService studentService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSaveStudent() throws Exception {
		
		MvcResult response=mockMvc
		   .perform(
				    MockMvcRequestBuilders
				       .post("/student/save")
				       .contentType(MediaType.APPLICATION_JSON)
				       .content("{\"id\" : 1001,\"name\" : \"ravi\",\"branch\" : \"mech\",\"isMale\" : true}"))
		   .andExpect(MockMvcResultMatchers.status().is(201)).andReturn();
		
		//Validating results
		Assertions.assertNotNull(response);
	}*/
	/*
	@MockBean
	private StudentService studentService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSaveStudent() throws Exception {
		
		MvcResult response=mockMvc
		   .perform(
				    MockMvcRequestBuilders
				       .post("/student/save").contentType(MediaType.APPLICATION_JSON)
				       .content("{}"))
		   .andExpect(MockMvcResultMatchers.status().is(201)).andReturn();
		
		//Validating results
		Assertions.assertNotNull(response);
	}*/
	
	@MockBean //Advanced of @Mock
	private StudentService studentService;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveStudent() throws Exception {
		//Setting expectations or stubbing or Mocking the service behavior. 
		String expected="done";
		Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenReturn(expected);
		
		//Actual method call or performing an HTTP request to create an Student
		//While passing path need to add both class level and method level path
		String path="/student/save";
		//While creating object is Java Student student=new Student();
		//To create object in JSON {}
		ResultActions response=mockMvc
		                           .perform(MockMvcRequestBuilders
		    		                  .post(path)
		    		                  .contentType(MediaType.APPLICATION_JSON)
		    		                  .content("{}"));
		
		//Assertions the response expectations.
		response.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.content().string(CoreMatchers.equalTo(expected)));
		Assertions.assertNotNull(response);
	}
}
