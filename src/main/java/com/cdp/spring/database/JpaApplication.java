package com.cdp.spring.database;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdp.spring.database.entity.Person;
import com.cdp.spring.database.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(JpaApplication.class);
	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Insert into table {}", personJpaRepository.insert(new Person(10005, "MEGHA GUPTA", "KASHMIR", new Timestamp(new Date().getTime()))));
		logger.info("Update table Person {}", personJpaRepository.update(new Person(10003, "SHIVU GUPTA", "CHENNAI")));
		logger.info("Find user by id 1 {}", personJpaRepository.findById(1));
	}

}
