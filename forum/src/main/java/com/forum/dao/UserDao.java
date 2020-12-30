package com.forum.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.forum.entity.User;

@Mapper
public interface UserDao {
	
	String TABLE_NAME = "user";
	String INSERT_FILEDS = " tel , password , salt , name , headLink ";
	String SELECT_FILEDS = "id," + INSERT_FILEDS;

	@Select({ "select ", SELECT_FILEDS ,"from", TABLE_NAME ,"where tel=#{tel}"  })
	User getUserByTel(String tel);

	@Insert({"insert into ",TABLE_NAME ,"(", INSERT_FILEDS , ") values(#{tel} , #{password}, #{salt}, #{name},#{headLink})" })
	void addUser(User user);

	


}
