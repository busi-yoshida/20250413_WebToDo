package com.example.demo.ui;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.codeborne.selenide.Configuration;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ToDoUiTest {
    @Value("${local.server.port}")
    int randomPort;

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @BeforeEach
    void setup() {
    	//バージョンを合わせる為、webdriverの指定。
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        Configuration.baseUrl = "http://localhost:" + randomPort;
    }
    
    @Test
    void test_AllToDo() {
    	open("/todos");
    	$("a").click();
    	$("input[name = todo]").setValue("test_ToDo");
    	$("textarea[name = detail]").setValue("test_detail");
    	$("input[type = submit]").click();
    	$("button").click();
    	
    	Map<String, Object> todoMap = jdbcTemplate.queryForMap("select * from todos where todo = ?", "test_ToDo");
    	assertThat(todoMap.get("todo")).isEqualTo("test_ToDo");
    	
    }

}
