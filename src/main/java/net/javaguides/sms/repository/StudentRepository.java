package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>{  Optional<Student> findByEmail(String email); }
