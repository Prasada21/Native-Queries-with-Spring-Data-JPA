package com.prasad.springbootcrudnativequery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.springbootcrudnativequery.model.Student;
import com.prasad.springbootcrudnativequery.repository.StudentRepo;

@RestController
@RequestMapping("/demo")
@CrossOrigin
public class StudentController {

	@Autowired
	StudentRepo studentRepo;

	
	@PostMapping("/student")
	public void saveStudent(@RequestBody Student student)
	{
		studentRepo.save(student);
	}
	
	
	@GetMapping("/student")
	public List<Student> getAllStudent()
	{
		return studentRepo.findAll();
	}
	
	
	@GetMapping("/studentgetbynameAndCourse/{name}/{course}")
	public List<Student> getByName(@PathVariable String name,@PathVariable String course)
	{
		return studentRepo.getByNameAndCourse(name,course);
    }
	
	
	
	@PostMapping("/insertStudent")
	public void insertStudent(@RequestBody Student student)
	{
	studentRepo.insertStudent(student.getName(), student.getCourse(), student.getAge());
			
	}
		
		
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestBody Student student) 
	{
	studentRepo.updateStudent(student.getName(), student.getAge(), student.getCourse());
	}
	
		
		
	@DeleteMapping("/deleteStudent/{name}")
	public void deleteStudent(@PathVariable String name)
	{
	studentRepo.deleteStudent(name);
	}
		
	
	
}
