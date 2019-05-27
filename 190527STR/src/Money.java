import java.util.Date;

public class Money {

	private int custno;
	private int salnol;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private Date sdate;

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getSalnol() {
		return salnol;
	}

	public void setSalnol(int salnol) {
		this.salnol = salnol;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "Money [custno=" + custno + ", salnol=" + salnol + ", pcost=" + pcost + ", amount=" + amount + ", price="
				+ price + ", pcode=" + pcode + ", sdate=" + sdate + "]";
	}

}