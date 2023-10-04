package com.hkjava.demo.demofinnhub.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lombok.Getter;

@Getter
public class Line {

  private Interval interval; // MONTH

  private String symbol;

  private List<Point> closePoints; // per month

  public Line(String symbol, Interval interval) { // DAY, WEEK, MONTH
    this.interval = interval; // month
    this.symbol = symbol;
    this.closePoints = new LinkedList<>();
    Comparator<SourcePoint> ascending =
        (SourcePoint p1, SourcePoint p2) -> p1.getTranDayTime().getDatetime()
            .isBefore(p2.getTranDayTime().getDatetime()) ? -1 : 1;

    SourcePoint.sourceMap.get(symbol).stream() //
        .filter(s -> {
          if (interval == Interval.WEEK)
            return s.getTranDayTime().isWeeklyClose();
          else if (interval == Interval.MONTH)
            return s.getTranDayTime().isMonthlyClose();
          else // day
            return true;
        }).sorted(ascending) //
        .forEach(s -> {
          // filtered source points, add to closePoints
          closePoints.add(s.toPoint());
        });
  }

  // instance method -> calculate
  public List<Point> movingAverage(int noOfInterval) {
    int idx = 0;
    List<Point> moveAverages = new ArrayList<>();
    BigDecimal val = BigDecimal.valueOf(0L);
    Point head = new Point(new Price(0.0d), null); // dummy
    int headIdx = -1;
    while (idx < closePoints.size()) {
      val = val.add(
          BigDecimal.valueOf(closePoints.get(idx).getClosePrice().getPrice()));
      if (idx + 1 >= noOfInterval) {
        val = val.subtract(BigDecimal.valueOf(head.getClosePrice().getPrice())) //
            .divide(BigDecimal.valueOf(noOfInterval));
        // add to MA
        moveAverages.add(new Point(val.doubleValue(),
            closePoints.get(idx).getTranDateTime()));
        // update the head
        head = closePoints.get(++headIdx);
      }
      idx++;
    }
    return moveAverages;
  }

  // Override the Getter
  public List<Point> getClosePoints() {
    List<Point> points = new ArrayList<>();
    points.addAll(this.closePoints);
    return points;
  }
}
