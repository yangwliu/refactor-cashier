package cc.xpbootcamp.warmup.cashier;

import java.util.HashMap;

public enum WeekDay {
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(1, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日"),
  ;


  private static final HashMap<Integer, WeekDay> valuesToWeekDayMap = new HashMap<>();
  static {
      for (WeekDay weekDay : WeekDay.values()) {
        valuesToWeekDayMap.put(weekDay.value, weekDay);
      }
  }

  public final int value;
  public final String text;

  private WeekDay(int value, String text) {
    this.value = value;
    this.text = text;
  }

  public static WeekDay of(int value) {
    return valuesToWeekDayMap.get(value);
  }
}
