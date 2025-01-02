package com.raj.blog;

import com.raj.blog.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className = this.userRepo.getClass().getName();
		System.out.println("==================="+className);
		String packageName = this.userRepo.getClass().getPackageName();
		System.out.println("==================="+packageName);
	}

}
