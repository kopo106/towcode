package com.hnkypg.pojo;
/**
 * 用户表
 * @author wsdhr
 *
 */
public class JiKeUser {
	private int id;//ID自增主键
	private String name;//用户名
	private int age;
//	private String password;//密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
}
