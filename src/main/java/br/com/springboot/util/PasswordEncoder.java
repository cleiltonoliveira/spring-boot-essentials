/**
 * @author cleilton
 * File: PasswordEncoder.java - Date: Nov 20, 2019
 */
package br.com.springboot.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("cleilton"));

	}
}
