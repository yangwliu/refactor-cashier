package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {

    public static final String HEADER = "======老王超市，值得信赖======\n";
    public static final String SALES_TAX_PREFIX = "税额:";
    public static final String TOTAL_AMOUNT_PREFIX = "总价:";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receiptStringBuilder = new StringBuilder();

        addHeader(receiptStringBuilder);
        addOrderDate(receiptStringBuilder, order);

        for (LineItem lineItem : order.getLineItems()) {
            receiptStringBuilder.append(lineItem.getItemText());
        }

        addSalesTax(receiptStringBuilder, order.getTotSalesTx());

        if (order.isDiscountDay()) {
            addDiscount(receiptStringBuilder, order);
        }
        addTotalAmount(receiptStringBuilder, order.getTotalAmountWithTax());
        return receiptStringBuilder.toString();
    }

    private void addDiscount(StringBuilder sb, Order order) {
        sb.append("折扣:\t").append(order.getDiscountAmount());
    }

    private void addTotalAmount(StringBuilder sb, double totalAmount) {
        sb.append(TOTAL_AMOUNT_PREFIX).append(CharacterConst.BLANK).append(totalAmount);
    }

    private void addOrderDate(StringBuilder sb, Order order) {
        LocalDate orderDate = order.getOrderDate();
        String dateTxtFormat = "%S年%S月%S日，%S\n";
        String dateTxt = String.format(dateTxtFormat, orderDate.getYear(), orderDate.getMonth().getValue(), orderDate.getDayOfMonth(), order.getWeekDay());
        sb.append(dateTxt);
    }

    private void addSalesTax(StringBuilder sb, double totSalesTx) {
        sb.append(SALES_TAX_PREFIX).append(CharacterConst.BLANK).append(totSalesTx).append(CharacterConst.NEW_LINE);
    }

    private void addHeader(StringBuilder sb) {
        sb.append(HEADER);
    }
}