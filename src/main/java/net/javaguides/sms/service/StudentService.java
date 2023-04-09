package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Student;
import org.springframework.ui.Model;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);

	void deleteStudentById(Long id);

	boolean isEmailAlreadyInUse(String email);
}
