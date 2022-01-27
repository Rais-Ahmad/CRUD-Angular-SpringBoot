package com.example.demo.Model;

import javax.persistence.*;
import java.util.Date;


/**
 * 
 * @author RaisAhmad
 * @date 29/10/2021
 * @Discription Institution Class
 */

@Entity
@Table(name = "t_institution")
public class Institution {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@Column(nullable = true)
	private Date date;

	@Column(nullable = true)
	private Date updatedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
