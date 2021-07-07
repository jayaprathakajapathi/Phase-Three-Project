package com.Sportyshoes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.Sportyshoes.jdbc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Sportyshoes.jdbc.entity.EProduct;

@Repository
public class CategoryDAO {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Category> getDetails() {
		//return template.query(("select *from category where category_id=1 "), new RowMapper<Category>()
				//return template.query(("select *from category where category_id=2 "), new RowMapper<Category>()
				return template.query(("select *from category where category_id=3 "), new RowMapper<Category>()
		
		{
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				Category c = new Category();
				c.setID(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setProduct(rs.getString(3));
				c.setProduct_id(rs.getInt(4));
				c.setCategory_id(rs.getInt(5));
				c.setDate_added(rs.getDate(6));
				return c;
			}
		});
	}

}