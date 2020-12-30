package com.forum.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.forum.entity.LoginTicket;
import com.forum.entity.User;

@Mapper
public interface LoginTicketDao {
	
	String TABLE_NAME = "loginticket";
	String INSERT_FILEDS = " tel , ticket , status , expired ";
	String SELECT_FILEDS = "id," + INSERT_FILEDS;

	@Select({ "select ", SELECT_FILEDS ,"from", TABLE_NAME ,"where tel=#{tel}"  })
	User getLoginTicketByTel(String tel);

	@Insert({"insert into",TABLE_NAME ,"(", INSERT_FILEDS , ") values(#{tel} , #{ticket}, #{status}, #{expired})", })
	void addLoginTicketr(LoginTicket loginTicket);

	


}
