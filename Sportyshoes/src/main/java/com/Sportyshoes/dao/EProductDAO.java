package com.Sportyshoes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Sportyshoes.jdbc.entity.EProduct;

@Repository
public class EProductDAO {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<EProduct> getProducts() {
		return template.query(" select * from eproduct", new RowMapper<EProduct>()
		
		{
			public EProduct mapRow(ResultSet rs, int row) throws SQLException {
				EProduct e = new EProduct();
				e.setID(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setColour(rs.getString(3));
				e.setPrice(rs.getBigDecimal(4));
				e.setCategory(rs.getInt(5));
				e.setDate_added(rs.getDate(6));
				return e;
			}
		});
	}

}