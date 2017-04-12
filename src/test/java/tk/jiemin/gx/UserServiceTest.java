package tk.jiemin.gx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tk.jiemin.gx.domain.User;
import tk.jiemin.gx.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Resource
	UserService userService;

	@Test
	public void findbyTest() {
		User p = userService.findall();
		System.out.println(p.getName());
	}
	
	@Test
	public void addTest(){
		
		userService.add("李四", "123456", 19);
		
	}

}
