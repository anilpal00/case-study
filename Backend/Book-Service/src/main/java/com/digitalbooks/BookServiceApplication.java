package com.digitalbooks;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Override
	public void run(String... args) throws Exception {

		//System.out.println(this.passwordEncoder.encode("xyz"));

//		try {
//
//			Role role = new Role();
//			role.setId(AppConstants.ADMIN_USER);
//			role.setName("ROLE_ADMIN");
//
//			Role role1 = new Role();
//			role1.setId(AppConstants.NORMAL_USER);
//			role1.setName("ROLE_NORMAL");
//
//			List<Role> roles = List.of(role, role1);
//
//			List<Role> result = this.roleRepo.saveAll(roles);
//
//			result.forEach(r -> {
//				System.out.println(r.getName());
//			});
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

	}

}
