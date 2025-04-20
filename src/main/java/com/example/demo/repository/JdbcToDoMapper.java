package com.example.demo.repository;

import java.util.List;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entity.ToDo;

public class JdbcToDoMapper implements ToDoMapper {
	private final JdbcTemplate jdbcTemplate;
	
	public JdbcToDoMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ToDo> selectAll() {
		return jdbcTemplate.query("SELECT * FROM todos", new DataClassRowMapper<>(ToDo.class));
	}

	@Override
	public ToDo selectById(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM todos WHERE id=?", new DataClassRowMapper<>(ToDo.class), id);
	}

	@Override
	public void insert(ToDo toDo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean update(ToDo toDo) {
		int count = jdbcTemplate.update("UPDATE todos SET todo=?, detail=? WHERE id=?",
				toDo.getTodo(),
				toDo.getDetail(),
				toDo.getId()
				);
		if(count == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void delete(Integer id) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
