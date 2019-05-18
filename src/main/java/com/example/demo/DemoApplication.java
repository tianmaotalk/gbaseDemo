package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@RequestMapping("/test")
	public String test() {
		Connection conn = null;
		try {
			conn = this.dataSource.getConnection();
			System.out.println("adfadsf+++++++++" + conn.getSchema());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn == null) {
				System.err.println("=============");
			} else {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return "ok";
	}

}
