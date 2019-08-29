package cn.ksdshpx.springmvc.beans;

import com.fasterxml.jackson.annotation.JsonView;

public class Human {
	@JsonView(View.Summary.class)
	private String name;
	@JsonView(View.Summary.class)
	private Integer age;
	private String sex;
	private Integer weight;

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

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", sex=" + sex + ", weight=" + weight + "]";
	}
}
