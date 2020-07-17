package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Order {

    public static final double TAX_RATE = .10;
    private static final double DISCOUNT_RATE = 0.98;
    private List<LineItem> lineItemList;
    private LocalDateTime orderDateTime;
    private List<WeekDay> discountDays = Arrays.asList(WeekDay.MONDAY, WeekDay.WEDNESDAY);

    public Order(List<LineItem> lineItemList, LocalDateTime orderDateTime) {

        this.lineItemList = lineItemList;
        this.orderDateTime = orderDateTime;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public LocalDate getOrderDate() {
        return orderDateTime.toLocalDate();
    }

    public double getTotalAmountWithTax() {
        return getTotSalesTx() + getBasicTotalAmount() - getDiscountAmount();
    }

    private double getBasicTotalAmount() {
        return lineItemList.stream().map(LineItem::getTotalAmount).reduce(.0d, Double::sum);

    }

    double getTotSalesTx() {
        return getBasicTotalAmount() * TAX_RATE;
    }

    public boolean isDiscountDay() {
        WeekDay weekDay = WeekDay.of(getOrderDate().getDayOfWeek().getValue());
        if (discountDays.contains(weekDay)) {
            return true;
        }
        return false;
    }

    public double getDiscountAmount() {
        if (isDiscountDay()) {
            return getBasicTotalAmount() * (1 - DISCOUNT_RATE);
        }
        return 0;
    }

    public String getWeekDay() {
        return WeekDay.of(getOrderDate().getDayOfWeek().getValue()).text;
    }
}
