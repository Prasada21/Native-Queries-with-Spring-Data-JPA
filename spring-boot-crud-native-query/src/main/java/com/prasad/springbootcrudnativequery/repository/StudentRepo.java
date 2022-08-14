package com.prasad.springbootcrudnativequery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.prasad.springbootcrudnativequery.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	
	@Modifying
	@Query(value = "insert into student(name,course,age)values(?1,?2,?3)",nativeQuery = true)
	@Transactional
	public void insertStudent(String name, String course, int age);
	

	 
	@Query(value = "select * from student  where name=?1",nativeQuery = true)
	 public List<Student> getByName(String name);
	 
	
	
	@Query(value = "select * from student where name=?1 and course=?2",nativeQuery = true)
	public List<Student> getByNameAndCourse(String name, String course);
	

	@Modifying
	@Query(value = "update student set name=?1, age=?2 where course=?3",nativeQuery = true)
	@Transactional
	public void updateStudent(String name,int age, String course);
	
	
	@Modifying
	@Query(value = "delete from  student where name=?1",nativeQuery=true)
	@Transactional
	public void deleteStudent(String name);
	
	
	
	
}
