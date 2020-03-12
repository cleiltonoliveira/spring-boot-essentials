package br.com.springboot.javaclient;

import br.com.springboot.model.Student;

public class JavaSpringClientTest {
	public static void main(String[] args) {
//
//		Student studentPost = new Student();
//
//		studentPost.setName("Joaozinho");
//		studentPost.setEmail("emaildojoao@gmail.com");
//		studentPost.setId(8L);
		JavaClientDAO clientDAO = new JavaClientDAO();

//		System.out.println(clientDAO.findById(889));

//		System.out.println(clientDAO.listAll());

//		System.out.println(clientDAO.save(studentPost));

//		clientDAO.update(studentPost);
		clientDAO.delete(89L);
	}

}
