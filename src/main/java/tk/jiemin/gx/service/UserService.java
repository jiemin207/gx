package tk.jiemin.gx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tk.jiemin.gx.dao.UserDao;
import tk.jiemin.gx.domain.User;

@Service
public class UserService {
	@Resource
	UserDao userDao;

	public User findall(String name) {

		return userDao.findByName(name);
	}

	public int add(String name, String password, int age) {

		User user = new User();

		user.setName(name);
		user.setPassword(password);
		user.setAge(age);

		return userDao.add(user);

	}

}
