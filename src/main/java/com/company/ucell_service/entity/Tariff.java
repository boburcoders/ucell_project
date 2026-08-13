package com.company.ucell_service.entity;

public class Tariff {
    private Long id;
    private Double priceInMonth;
    private Integer gigabit;
    private Integer minutes;
    private Integer smsCount;

    public Tariff(Long id,
                  Double priceInMonth,
                  Integer gigabit,
                  Integer minutes,
                  Integer smsCount) {
        this.id = id;
        this.priceInMonth = priceInMonth;
        this.gigabit = gigabit;
        this.minutes = minutes;
        this.smsCount = smsCount;
    }
}
