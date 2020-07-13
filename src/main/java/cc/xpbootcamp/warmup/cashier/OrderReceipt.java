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
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        addHeader(output);

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        addOrderBasicInfo(output);
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            addLineItem(output, lineItem);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmount);
        return output.toString();
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

    private void addOrderBasicInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void addHeader(StringBuilder output) {
        output.append(HEADER);
    }
}