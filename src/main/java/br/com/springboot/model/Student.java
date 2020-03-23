/**
 * @author cleilton
 * File: Student.java - Date: Sep 11, 2019
 */
package br.com.springboot.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {

	@NotEmpty(message = "O campo nome do estudante é obrigatório")
	private String name;

	@NotEmpty
	@Email(message = "Digite um email válido")
	private String email;

	public Student(@NotEmpty(message = "O campo nome do estudante é obrigatório") String name,
			@NotEmpty @Email(message = "Digite um email válido") String email) {
		this.name = name;
		this.email = email;
	}

	public Student(Long id, @NotEmpty(message = "O campo nome do estudante é obrigatório") String name,
			@NotEmpty @Email(message = "Digite um email válido") String email) {
		this.name = name;
		this.email = email;
		this.id = id;
	}

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}

}
