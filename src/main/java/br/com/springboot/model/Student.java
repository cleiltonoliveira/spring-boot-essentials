/**
 * @author cleilton
 * File: Student.java - Date: Sep 11, 2019
 */
package br.com.springboot.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {
	@NotEmpty
	private String name;
	@NotEmpty(message = "O campo nome do estudante é obrigatório")
	@Email
	private String email;

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
