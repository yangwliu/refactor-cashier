package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {

    List<LineItem> lineItemList;

    public Order(List<LineItem> lineItemList) {

        this.lineItemList = lineItemList;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }
}
