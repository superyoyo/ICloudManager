package bean;

public class App {
	private int id;
	private String appId;//程序的Id
	private String appKey;//程序的key
	private String author_id;//程序的负责人ID
	private String app_name;//程序的名字
	private String app_desc;//程序的简介
	private String app_url;//程序的官网
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public String getApp_desc() {
		return app_desc;
	}
	public void setApp_desc(String app_desc) {
		this.app_desc = app_desc;
	}
	public String getApp_url() {
		return app_url;
	}
	public void setApp_url(String app_url) {
		this.app_url = app_url;
	}
	
	
}
