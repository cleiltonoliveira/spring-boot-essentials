/**
 * @author cleilton
 * File: Student.java - Date: Sep 11, 2019
 */
package br.com.springboot.model;

import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
