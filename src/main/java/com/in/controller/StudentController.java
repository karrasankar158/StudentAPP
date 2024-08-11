package com.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/find/all")//retrieve all rows operation //Handler method
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> response=studentService.findAllStudents();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	//http://localhost:8080/student/delete/1001  @PathVariable   value
	//http://localhost:8080/student/delete?id=1001 @RequestParam key=value
	@DeleteMapping("/delete")
	public ResponseEntity<String> studentDeleteById(@RequestParam Long id){
		String response=studentService.studentDeleteById(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//@PutMapping(): for full object update(Full Object Update).
	//@PatchMapping(): for few fields update in Object(partial changes/update).
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<String> updateStudentById(@PathVariable("id") long id,@RequestBody Student student){
		String response=studentService.updateStudentByUsingId(id, student);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
