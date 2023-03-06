package ohgym.suggest;

public class Suggest {
	private int no;
	private String id;
	private String requestNo;
	private int price;
	private String date;
	private String message;
	public Suggest() {}
	public Suggest(int no, String id, String requestNo, int price, String date, String message) {
		super();
		this.no = no;
		this.id = id;
		this.requestNo = requestNo;
		this.price = price;
		this.date = date;
		this.message = message;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Suggest [no=" + no + ", id=" + id + ", requestNo=" + requestNo + ", price=" + price + ", date=" + date
				+ ", message=" + message + "]";
	}
	
	
	
}
