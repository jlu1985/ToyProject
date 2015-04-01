package jl.playground.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MyDao {
	private JdbcTemplate tempalte;

	public void setDataSource(DataSource dataSource) {
		this.tempalte = new JdbcTemplate(dataSource);
	}
	
	public List<DerbyData> findAll (){
		return this.tempalte.query("select id,name from myTable", new DerbyDataMapper());
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		MyDao dao = context.getBean("myDao",MyDao.class);
		
		List<DerbyData> data = dao.findAll();
		System.out.println(data);
	}
	
}

class DerbyDataMapper implements RowMapper<DerbyData>{

	@Override
	public DerbyData mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new DerbyData(rs.getInt("id"),rs.getString("name"));
	}
	
}

class DerbyData {
	@Override
	public String toString() {
		return "DerbyData [id=" + id + ", name=" + name + "]";
	}
	private int id;
	private String name;
	
	public DerbyData(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
}
