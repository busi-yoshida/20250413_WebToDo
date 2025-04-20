package com.example.demo.helper;

import com.example.demo.entity.ToDo;
import com.example.demo.form.ToDoForm;

/**
 * ToDo：ヘルパー
 */
public class ToDoHelper {
    /**
     * ToDoへの変換
     */
    public static ToDo convertToDo(ToDoForm form) {
        ToDo todo = new ToDo();
        todo.setId(form.getId());
        todo.setTodo(form.getTodo());
        todo.setDetail(form.getDetail());
        todo.setCreatedAt(form.getCreatedAt());
        todo.getUpdatedAt();
        return todo;
    }

    /**
     * ToDoFormへの変換
     */
    public static ToDoForm convertToDoForm(ToDo todo) {
        ToDoForm form = new ToDoForm();
        form.setId(todo.getId());
        form.setTodo(todo.getTodo());
        form.setDetail(todo.getDetail());
        form.setCreatedAt(todo.getCreatedAt());
        form.setUpdatedAt(todo.getUpdatedAt());
        // 更新画面設定
        form.setIsNew(false);
        return form;
    }
}