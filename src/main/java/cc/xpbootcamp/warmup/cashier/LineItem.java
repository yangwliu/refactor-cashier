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

	public String getItemText() {
		return new StringBuilder()
				.append(desc)
				.append(CharacterConst.BLANK)
				.append(price).append(CharacterConst.BLANK)
				.append(qty)
				.append(CharacterConst.BLANK)
				.append(totalAmount())
				.append(CharacterConst.NEW_LINE)
				.toString();
	}

	double totalAmount() {
        return price * qty;
    }
}