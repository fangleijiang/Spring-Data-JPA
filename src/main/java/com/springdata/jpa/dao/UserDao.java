package com.springdata.jpa.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.springdata.model.User;

/**
 * 注意方法命名规范
 * @param user
 * @return
 */
public interface UserDao extends Repository<User,Integer>{

	//保存user
	public User save(User user);
	//通过Id查找，关键字By
	public User findUserById(int id);
	//关键字By
	public List<User> findByusername(String username);
	//关键字And
	public List<User> findByUsernameAndPassword(String username,String password);
	//关键字Or
	public List<User> findByUsernameOrPassword(String username,String password);
	//关键字Like，模糊搜索
	public List<User> findByUsernameLike(String username);
	//查找全部
	public List<User> findAll();
   /* //通过id删除
	@Query("delete from User u where u.id = ?")
	public void delete(int id);*/
	//分页方法
	public Page<User> findAll(Pageable pageable);
	/*//更新update
	@Modifying 
	@Query("update User u set u = ?1") 
	public void update(User user);*/
}
