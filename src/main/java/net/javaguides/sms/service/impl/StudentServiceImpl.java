package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		if (isEmailAlreadyInUse(student.getEmail())) {
			throw new RuntimeException("Email address already in use");
		}
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());
		if (existingStudent.isPresent() && !existingStudent.get().getId().equals(student.getId())) {
			throw new IllegalArgumentException("Email address already in use");
		}
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public boolean isEmailAlreadyInUse(String email) {
		Optional<Student> student = studentRepository.findByEmail(email);
		return student.isPresent();
	}
}
