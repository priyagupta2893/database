package com.cdp.spring.database;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdp.spring.database.dao.PersonJdbcDao;
import com.cdp.spring.database.entity.Person;

//@SpringBootApplication//  comment it as this will trigger spring JDBC operation in PersonDao
public class DatabaseApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(DatabaseApplication.class);
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Custom mapper users {}", dao.findAllByCustomMapper());
		logger.info("All users {}", dao.findAll());
		logger.info("Find user by id 10001 {}", dao.findById(10001));
		logger.info("Find user by name PRIYA GUPTA {}", dao.findByName("PRIYA GUPTA"));
		logger.info("Delete by id {}", dao.deleteById(10002));
		logger.info("Insert into table {}", dao.insert(new Person(10005, "MEGHA GUPTA", "KASHMIR", new Timestamp(new Date().getTime()))));
		logger.info("Update table Person {}", dao.update(new Person(10003, "SHIVU GUPTA", "CHENNAI")));
		logger.info("All users {}", dao.findAll());
	}

}
