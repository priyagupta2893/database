package com.cdp.spring.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdp.spring.database.entity.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// Create a custom row mapper to use in case when entity and table have diff column names
	// using inner class as we need this mapper here only
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			// target_date is the column name in table and this will set in birthDate in entity by custom mapper
			//person.setBirthDate(rs.getTimestamp("target_date"));
			return person ;
		}
		
	}
	public List<Person> findAllByCustomMapper() {
		return jdbcTemplate.query("select * from Person", new PersonRowMapper()); // this mapper is used as column names and properties in entity is same
	}
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper(Person.class)); // this mapper is used as column names and properties in entity is same
	}
	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from Person where id=?", 
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByName(String name) {
		return jdbcTemplate.query("select * from Person where name=?", 
				new Object[] {name},
				new BeanPropertyRowMapper(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from Person where id=?", 
				new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) "
				+ "values (?, ?, ?, ?)", 
				new Object[] {person.getId(), person.getName(), 
						person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("update person set name=?, location=? where id= ?", 
				new Object[] {person.getName(), person.getLocation(), person.getId()});
	}

}
