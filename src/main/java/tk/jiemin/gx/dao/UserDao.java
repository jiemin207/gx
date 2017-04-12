package tk.jiemin.gx.dao;

import org.apache.ibatis.annotations.Mapper;

import tk.jiemin.gx.domain.User;

@Mapper
public interface UserDao {

	User findBy();
    
	int add(User user);
    	
}
