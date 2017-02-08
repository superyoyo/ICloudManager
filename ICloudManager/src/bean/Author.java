package bean;

/**
 * 程序拥有者
 * @author jacklee
 *
 */
public class Author {
	private int id = -1;//
	private String author_id;//owner的ID
	private String password;//登录密码
	private String phone;//注册手机号码
	private String name;//用户姓名
	private String id_card;//用户身份证号
	private String card_url;//用户身份证的图片地址
	private String is_verified;//用户是否实名认证 true实名  false未实名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getCard_url() {
		return card_url;
	}
	public void setCard_url(String card_url) {
		this.card_url = card_url;
	}
	public String getIs_verified() {
		return is_verified;
	}
	public void setIs_verified(String is_verified) {
		this.is_verified = is_verified;
	}
	
	
}
