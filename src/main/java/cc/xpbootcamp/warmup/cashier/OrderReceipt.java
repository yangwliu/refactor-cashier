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

        // print headers
        addHeader(receiptStringBuilder);

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        addOrderBasicInfo(receiptStringBuilder);
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            addLineItem(receiptStringBuilder, lineItem);

            // calculate sales tax @ rate of 10%
            double salesTax = getSalesTaxOfLineItem(lineItem);
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        addSalesTax(receiptStringBuilder, totSalesTx);

        // print total amount
        addTotalAmount(receiptStringBuilder, totalAmount);
        return receiptStringBuilder.toString();
    }

    private void addTotalAmount(StringBuilder sb, double totalAmount) {
        sb.append(TOTAL_AMOUNT_PREFIX).append('\t').append(totalAmount);
    }

    private void addSalesTax(StringBuilder sb, double totSalesTx) {
        sb.append(SALES_TAX_PREFIX).append('\t').append(totSalesTx);
    }

    private double getSalesTaxOfLineItem(LineItem lineItem) {
        return lineItem.totalAmount() * TAX_RATE;
    }

    private void addLineItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private void addOrderBasicInfo(StringBuilder sb) {
        sb.append(order.getCustomerName());
        sb.append(order.getCustomerAddress());
    }

    private void addHeader(StringBuilder sb) {
        sb.append(HEADER);
    }
}