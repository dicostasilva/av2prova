package com.newton.aaw.hr.api;

import java.time.LocalDateTime;

import com.newton.aaw.hr.domain.entity.User;
import com.newton.aaw.hr.domain.entity.enums.Status;
import com.newton.aaw.hr.domain.entity.enums.Role;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Integer id;
	
	private String name;
	
	private String password; 
	
	private String email;
	
	private String mobile;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
	
	private Role role;
	
	private Status status;
	
	
	// construtor Entidade para DTO
	public UserDto(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.password = u.getPassword();
		this.email = u.getEmail();
		this.mobile = u.getMobile();
		this.createdAt = u.getCreatedAt();
		this.modifiedAt = u.getModifiedAt();
		this.status = u.getStatus();
		this.role = u.getRole();
	}
	
}
