package com.Sportyshoes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Sportyshoes.jdbc.entity.Userinfo;

@Repository
public class UserinfoDAO {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Userinfo> getProducts() {
		return template.query(" select * from userinfo", new RowMapper<Userinfo>()
		
		{
			public Userinfo mapRow(ResultSet rs, int row) throws SQLException {
				Userinfo e = new Userinfo();
				e.setID(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setInfo(rs.getString(3));
				e.setProduct_id(rs.getInt(4));
				e.setCategory_id(rs.getInt(5));
				e.setDate_added(rs.getDate(6));
				return e;
			}
		});
	}
}