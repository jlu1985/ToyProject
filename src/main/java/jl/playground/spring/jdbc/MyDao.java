package jl.playground.spring.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MyDao {
	private JdbcTemplate tempalte;

	public void setDataSource(DataSource dataSource) {
		this.tempalte = new JdbcTemplate(dataSource);
	}
	
	public List<MyData> findAll (){
		return this.tempalte.query("select department_id, department_name from department", new MyDataMapper());
	}
	
	/* get generated key */
	public int insert(String name) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		tempalte.update(
				conn ->	{
					PreparedStatement ps = conn.prepareStatement("INSERT INTO department (department_name) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
					ps.setString(1,name);
					return ps;
				}
		,keyHolder);
		
		return keyHolder.getKey().intValue();
	}
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
//		MyDao dao = context.getBean("myDao",MyDao.class);
		MyDao dao = new MyDao();
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:playgroundSchema.sql").build();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).addScript("hsqldb-schema.sql").addScript("hsqldb-data.sql").build();
		dao.setDataSource(db);
		
		System.out.println(dao.findAll());
		
		int id = dao.insert("oracle");
		System.out.println("id is " + id);
		
		System.out.println(dao.findAll());
		db.shutdown();
	}
	
}

class MyDataMapper implements RowMapper<MyData>{

	@Override
	public MyData mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new MyData(rs.getInt("department_id"),rs.getString("department_name"));
	}
	
}

class MyData {
	@Override
	public String toString() {
		return "MyData [id=" + id + ", name=" + name + "]";
	}
	private int id;
	private String name;
	
	public MyData(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
}
