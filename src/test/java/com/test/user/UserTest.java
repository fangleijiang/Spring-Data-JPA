package com.test.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springdata.jpa.dao.UserDao;
import com.springdata.model.User;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
@WebAppConfiguration
public class UserTest {

	@Autowired UserDao userdao;
	
	@Test
	public void saveUser(){
		User user = new User();
		user.setUsername("fang");
		user.setPassword("123456");
		this.userdao.save(user);
	}
	
	@Test
	public void findUserById(){
		User user = this.userdao.findUserById(1);
		System.out.println("-----------"+user.getUsername());
	}
	
	
	@Test
	public void findByUsername(){
		List<User> list = this.userdao.findByusername("fang");
		System.out.println("-----------------------"+list.size());
	}
	
	@Test
	public void findByUsernameAndPassword(){
		List<User> list = this.userdao.findByUsernameAndPassword("fang", "123456");
		System.out.println("-----------------------"+list.size());
	}
	
	@Test
	public void findByUsernameOrPassword(){
		List<User> list = this.userdao.findByUsernameOrPassword("fang", "123456");
		System.out.println("-----------------------"+list.size());
	}
	
	@Test
	public void findByUsernameLike(){
		List<User> list = this.userdao.findByUsernameLike("fang");
		System.out.println("-----------------------"+list.size());
	}
	
	@Test
	public void findAll(){
		List<User> list = this.userdao.findAll();
		System.out.println("-----------------------"+list.size());
	}
	
	@Test 
	public void page(){
		Pageable pageable = new PageRequest(0,2);
		Page<User> p =  this.userdao.findAll(pageable);
		System.out.println("----------------"+p.getContent());
	}
	
	/*@Test 
	public void delete(){
		this.userdao.delete(1);
	}
	
	@Test 
	public void Update(){
		User user = this.userdao.findUserById(1);
		user.setUsername("fangleijiang");
		this.userdao.update(user);
	}*/
}
