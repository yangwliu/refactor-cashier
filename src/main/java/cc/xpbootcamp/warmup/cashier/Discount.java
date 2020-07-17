package cc.xpbootcamp.warmup.cashier;

import java.util.Arrays;
import java.util.List;

public class Discount {

  private static List<WeekDay> discountDays = Arrays.asList(WeekDay.MONDAY, WeekDay.WEDNESDAY);
  private static double discountRate = 0.98;

  public static List<WeekDay> getDiscountDays() {
    return discountDays;
  }

  public static double getDiscountRate() {
    return discountRate;
  }
}
