package Moe.Social;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Action {
    private String description;
    private int impact; // влияние на социальный рейтинг
    private LocalDate startDate; // дата совершения поступка

    public Action(String description, int impact, int year, int month, int day) {
        this.description = description;
        this.impact = impact;
        this.startDate = LocalDate.of(year, month, day);
    }

    public String getDescription() {
        return description;
    }

    public int getImpact() {
        return impact;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public long getDaysSinceAction() {
        return ChronoUnit.DAYS.between(startDate, LocalDate.now());
    }



    public int realImpact() {
        int res = getImpact();

        if (impact < 0) {
            int formula = (int) (getImpact() + (getDaysSinceAction() - 30) * (1 + (getDaysSinceAction() * 0.01)));
            res = Math.max(impact, formula);
            res = Math.min(res, 0);
        } else if (impact > 0) {
            int formula = (int) (getImpact() - (getDaysSinceAction() - 30) * (1 + (getDaysSinceAction() * 0.01)));
            res = Math.min(impact, formula);
            res = Math.max(res, 0);
        }

        return res;
    }

}