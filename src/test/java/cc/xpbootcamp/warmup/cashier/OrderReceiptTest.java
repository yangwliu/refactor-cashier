package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void should_print_line_item_and_sales_tax_information_when_print_receipt_given_not_discount_day() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, LocalDateTime.parse("2020-07-17T00:00:00")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("=====老王超市，值得信赖====="));
        assertThat(output, containsString("milk, 10.0 x 2, 20.0\n"));
        assertThat(output, containsString("biscuits, 5.0 x 5, 25.0\n"));
        assertThat(output, containsString("chocolate, 20.0 x 1, 20.0\n"));
        assertThat(output, containsString("税额:\t6.5"));
        assertThat(output, containsString("总价:\t71.5"));
    }

    @Test
    public void should_print_line_item_and_sales_tax_information_when_print_receipt_given_discount_day() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, LocalDateTime.parse("2020-07-15T00:00:00")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("=====老王超市，值得信赖====="));
        assertThat(output, containsString("milk, 10.0 x 2, 20.0\n"));
        assertThat(output, containsString("biscuits, 5.0 x 5, 25.0\n"));
        assertThat(output, containsString("chocolate, 20.0 x 1, 20.0\n"));
        assertThat(output, containsString("税额:\t6.5"));
        assertThat(output, containsString("折扣:\t1.3"));
        assertThat(output, containsString("总价:\t70.2"));
    }

}