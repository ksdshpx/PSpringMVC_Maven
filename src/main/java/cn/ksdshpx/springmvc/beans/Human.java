package cn.ksdshpx.springmvc.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

public class Human {
	@JsonView(View.Summary.class)
	private String name;
	@JsonView(View.Summary.class)
	private Integer age;
	private String sex;
	private Integer weight;
	@JsonView(View.Summary.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
	private Date birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", sex=" + sex + ", weight=" + weight + ", birthday=" + birthday
				+ "]";
	}

}
