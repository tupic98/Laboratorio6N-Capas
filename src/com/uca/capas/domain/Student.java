package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "student")
public class Student {

	@Id
	@GeneratedValue(generator = "student_id_student_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_id_student_seq", sequenceName = "public.student_id_student_seq", allocationSize = 1)
	@Column(name = "id_student")
	private Integer cStudent;

	@Column(name = "s_name")
	private String sName;

	@Column(name = "s_lname")
	private String lName;

	@Column(name = "s_age")
	private Integer sAge;

	@Column(name = "b_active")
	private Boolean bActivo;

	public Student() {

	}

	public Student(Integer codeStudent, String studentName, String studentLName, Integer studentAge,
			Boolean studentActive) {
		this.cStudent = codeStudent;
		this.sName = studentName;
		this.lName = studentLName;
		this.sAge = studentAge;
		this.bActivo = studentActive;
	}

	public Integer getcStudent() {
		return cStudent;
	}

	public void setcStudent(Integer cStudent) {
		this.cStudent = cStudent;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	public Boolean getbActivo() {
		return bActivo;
	}

	public void setbActivo(Boolean bActivo) {
		this.bActivo = bActivo;
	}

	public String getActivoDelegate() {
		if (this.bActivo == null)
			return "";
		else {
			return bActivo == true ? "Activo" : "Inactivo";
		}
	}
}