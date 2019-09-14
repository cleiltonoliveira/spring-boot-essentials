/**
 * @author cleilton
 * File: Student.java - Date: Sep 11, 2019
 */
package br.com.springboot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
	private String name;
	private int id;
	public static List<Student> studentList;

	static {
		studentRepository();
	}

	public Student(String name, int id) {
		this(name);
		this.id = id;
	}

	public Student(String name) {
		this.name = name;
	}

	public Student() {
	}

	public static void studentRepository() {
		studentList = new ArrayList<>(Arrays.asList(new Student("Jonas", 1), new Student("Tomás", 2)));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static List<Student> getStudentList() {
		return studentList;
	}

	public static void setStudentList(List<Student> studentList) {
		Student.studentList = studentList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
