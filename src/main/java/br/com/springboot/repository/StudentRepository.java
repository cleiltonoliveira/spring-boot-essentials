/**
 * @author cleilton
 * File: StudentRepository.java - Date: Sep 16, 2019
 */
package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.springboot.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	public List<Student> findByNameIgnoreCaseContaining(String name);

}
