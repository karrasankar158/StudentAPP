package com.in.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
//@Data
public class Student {
	
	@Id
	private Long id;
	private String name;
	private String branch;
	private Boolean isMale;

}
