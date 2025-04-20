package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.ToDoMapper;
import com.example.demo.service.ToDoService;

import lombok.RequiredArgsConstructor;

/**
 * ToDo：サービス実装クラス
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    /** DI */
    private final ToDoMapper toDoMapper;
    
	/** プロフィール画像の保存先フォルダ */
	@Value("${image.folder}")
	private String imgFolder;

	/** プロフィール画像の保管拡張子 */
	@Value("${image.extract}")
	private String imgExtract;
    
    @Override
    public List<ToDo> findAllToDo() {
        return toDoMapper.selectAll();
    }

    @Override
    public ToDo findByIdToDo(Integer id) {
        return toDoMapper.selectById(id);
    }

    @Override
    public void insertToDo(ToDo toDo) {
        toDoMapper.insert(toDo);
    }

    @Override
    public void updateToDo(ToDo toDo) {
        toDoMapper.update(toDo);
    }

    @Override
    public void deleteToDo(Integer id) {
        toDoMapper.delete(id);
    }

	@Override
	public void testToDo(ToDo toDo) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}