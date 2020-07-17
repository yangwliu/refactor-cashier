package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {

    public static final String HEADER = "======Printing Orders======\n";
    public static final double TAX_RATE = .10;
    public static final String SALES_TAX_PREFIX = "Sales Tax";
    public static final String TOTAL_AMOUNT_PREFIX = "Total Amount";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receiptStringBuilder = new StringBuilder();

        addHeader(receiptStringBuilder);

        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receiptStringBuilder.append(lineItem.getItemText());

            totalAmount += lineItem.totalAmount();
        }
        double totSalesTx = totalAmount * TAX_RATE;
        addSalesTax(receiptStringBuilder, totSalesTx);

        addTotalAmount(receiptStringBuilder, totalAmount + totSalesTx);
        return receiptStringBuilder.toString();
    }

    private void addTotalAmount(StringBuilder sb, double totalAmount) {
        sb.append(TOTAL_AMOUNT_PREFIX).append(CharacterConst.BLANK).append(totalAmount);
    }

    private void addSalesTax(StringBuilder sb, double totSalesTx) {
        sb.append(SALES_TAX_PREFIX).append(CharacterConst.BLANK).append(totSalesTx);
    }

    private void addHeader(StringBuilder sb) {
        sb.append(HEADER);
    }
}