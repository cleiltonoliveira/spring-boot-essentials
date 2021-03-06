/*
  @author cleilton
 * File: StudentRepository.java - Date: Sep 16, 2019
 */
package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.springboot.model.Student;
import org.springframework.stereotype.Repository;

//
//public interface StudentRepository extends CrudRepository<Student, Long> {
//	public List<Student> findByNameIgnoreCaseContaining(String name);
//}
@Repository
public interface StudentRepository    extends PagingAndSortingRepository<Student, Long> {
	List<Student> findByNameIgnoreCaseContaining(String name);
}
