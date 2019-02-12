package com.hnkypg.pojo;
/*
 * 作者表，注意jikeUser的引用
 * @author wsdhr
 */
public class Author {
	private Integer id; //自增主键
	private JiKeUser jikeUser; //外键引用JiKeUser表
	private String realName;//真实姓名
	private String IDCard;//身份证
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public JiKeUser getJikeUser() {
		return jikeUser;
	}
	public void setJikeUser(JiKeUser jikeUser) {
		this.jikeUser = jikeUser;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	
	
}
