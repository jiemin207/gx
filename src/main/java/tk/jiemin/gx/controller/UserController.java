package tk.jiemin.gx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.jiemin.gx.domain.User;
import tk.jiemin.gx.service.UserService;

@RequestMapping("/")
@Controller
public class UserController {

	@Resource
	UserService userservice;

	@RequestMapping("login")
	public String login() {

		return "login";
	}

	@RequestMapping("valid")
	public String vilid(@RequestParam("username") String username, @RequestParam("password") String password,
			Map<String, Object> map, HttpSession session) {

		if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
			User user = userservice.findall(username);
			String dbpasswd = user.getPassword();

			if (password.equals(dbpasswd)) {
				map.put("username", username);
				session.setAttribute(username, username);

				return "index";
			}
		}

		return "redirect:/login";

	}

	@RequestMapping("lgout")
	public String lgout(HttpSession session) {
		session.invalidate();

		return "redirect:/login";
	}

	@RequestMapping("ajaxTest")
	@ResponseBody
	public Map<String, Object> ajaxTest(@RequestParam("age") int age) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", age);

		return map;

	}

}
