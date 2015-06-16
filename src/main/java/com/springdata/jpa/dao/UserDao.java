package com.springdata.jpa.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.springdata.model.User;

/**
 * ע�ⷽ�������淶
 * @param user
 * @return
 */
public interface UserDao extends Repository<User,Integer>{

	//����user
	public User save(User user);
	//ͨ��Id���ң��ؼ���By
	public User findUserById(int id);
	//�ؼ���By
	public List<User> findByusername(String username);
	//�ؼ���And
	public List<User> findByUsernameAndPassword(String username,String password);
	//�ؼ���Or
	public List<User> findByUsernameOrPassword(String username,String password);
	//�ؼ���Like��ģ������
	public List<User> findByUsernameLike(String username);
	//����ȫ��
	public List<User> findAll();
   /* //ͨ��idɾ��
	@Query("delete from User u where u.id = ?")
	public void delete(int id);*/
	//��ҳ����
	public Page<User> findAll(Pageable pageable);
	/*//����update
	@Modifying 
	@Query("update User u set u = ?1") 
	public void update(User user);*/
}
