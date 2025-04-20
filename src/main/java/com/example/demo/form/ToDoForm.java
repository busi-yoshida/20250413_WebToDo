package com.example.demo.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * すること：Form
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoForm {
    /** することID */
    private Integer id;
    
    /** すること */
    @NotBlank
    private String todo;
    
    /** すること詳細 */
    @Size(min = 1, max = 100)
    private String detail;
    
    /** 作成日時 */
    private LocalDateTime createdAt;
    
    /** 更新日時 */
    private LocalDateTime updatedAt;
    
    /** 新規判定 */
    private Boolean isNew;
    
    /** 画像 */
//    private byte[] imageFile;
}