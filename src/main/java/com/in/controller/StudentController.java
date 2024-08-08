package com.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.entity.Student;
import com.in.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService; //Has-A
	
	@PostMapping("/save") //save operation //Handler method
	public ResponseEntity<String> saveStudent(@RequestBody Student student){//payload
		String response=studentService.saveStudent(student);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{id}")//retrieve Single row operation //Handler method
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
		Student response=studentService.findByStudentByUsingId(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
