package com.newton.aaw.hr.domain.entity;

import java.time.LocalDateTime;
import com.newton.aaw.hr.domain.entity.enums.Status;
import com.newton.aaw.hr.domain.entity.enums.Role;

import com.newton.aaw.hr.api.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private Integer id;
	
	private String name;
	
	private String password; 
	
	private String email;
	
	private String mobile;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
	    
    private Status status;
		
    private Role role;
	
	public User(UserDto userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.password = userDto.getPassword();
		this.email = userDto.getEmail();
		this.mobile = userDto.getMobile();
		this.status = userDto.getStatus();
		this.role = userDto.getRole();
		this.createdAt = userDto.getCreatedAt();
		this.modifiedAt = userDto.getModifiedAt();
	}
	
}
