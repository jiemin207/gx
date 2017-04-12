//package tk.jiemin.gx.config;
//
//import javax.annotation.Resource;
//
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import tk.jiemin.gx.interceptor.LoginInterceptor;
//
//public class MyWebConfig extends WebMvcConfigurerAdapter {
//
//	@Resource
//	LoginInterceptor loginInterceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loginInterceptor).excludePathPatterns("/login").excludePathPatterns("/valid")
//				.addPathPatterns("/**");
//		super.addInterceptors(registry);
//	}
//}
