package com.forum.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.forum.entity.LoginTicket;

@Mapper
public interface LoginTicketDao {
	
	String TABLE_NAME = "loginticket";
	String INSERT_FILEDS = " tel , ticket , status , expired ";
	String SELECT_FILEDS = "id," + INSERT_FILEDS;

	@Select({ "select ", SELECT_FILEDS ,"from", TABLE_NAME ,"where tel=#{tel}"  })
	LoginTicket getLoginTicketByTel(String tel);

	@Insert({"insert into",TABLE_NAME ,"(", INSERT_FILEDS , ") values(#{tel} , #{ticket}, #{status}, #{expired})", })
	void addLoginTicketr(LoginTicket loginTicket);

	@Update({"update ", TABLE_NAME , "set status =#{status} where tel = #{tel}"})
	void updateLoginTicket(String tel, Integer status);

	@Update({"update ", TABLE_NAME , "set expired =#{date} where tel = #{tel}"})
	void updateLoginTicketExpired(String tel, Date date);

	


}
