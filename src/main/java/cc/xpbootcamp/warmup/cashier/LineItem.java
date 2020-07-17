package cc.xpbootcamp.warmup.cashier;

public class LineItem {

	private String desc;
	private double price;
	private int qty;

	public LineItem(String desc, double price, int qty) {
		this.desc = desc;
		this.price = price;
		this.qty = qty;
	}

	public String getDesc() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public double getTotalAmount() {
        return price * qty;
    }
}