package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * すること：エンティティ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    /** することID */
    private Integer id;
    /** すること */
    private String todo;
    /** すること詳細 */
    private String detail;
    /** 作成日時 */
    private LocalDateTime createdAt;
    /** 更新日時 */
    private LocalDateTime updatedAt;

    /** 画像 */
    private MultipartFile imageFile;
}