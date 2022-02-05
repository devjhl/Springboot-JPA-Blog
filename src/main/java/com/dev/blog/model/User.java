package com.dev.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // auto_increment
	@Column(nullable = false , length = 30, unique = true)
	private String username;
	
	@Column(nullable = false , length = 100)
	private String password;

	@Column(nullable = false , length = 50, unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private Privilege privilege; 
	@CreationTimestamp // 時間自動入力
	private Timestamp createDate;
}
