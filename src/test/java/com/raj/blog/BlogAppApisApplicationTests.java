package com.raj.blog;

import com.raj.blog.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	public UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void userRepoTest()
	{
		String className = this.userRepo.getClass().getName();
		String packageName = this.userRepo.getClass().getPackageName();

		System.out.println("////////////////////////////");
		System.out.println("Class Name :"+className);
		System.out.println("Package Name :"+packageName);
	}
}
