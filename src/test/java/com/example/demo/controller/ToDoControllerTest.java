package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ToDoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test_list() throws Exception{
		mockMvc.perform(
				get("/todos")
		)
		.andExpect(status().isOk())
		.andExpect(view().name("todo/list"))
		.andExpect(content().string(containsString("買い物")))
		;
	}

	@Test
	public void test_detail() throws Exception{
		mockMvc.perform(
				get("/todos/{id}", "2")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("todo/detail"))
		.andExpect(content().string(containsString("図書館に行く")))
		;
	}

}
