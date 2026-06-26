package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PerishableParcelTest {
    private static final int PERISHABLE_PARCEL_BASIC_COST = 3;
    private static int sendDay = 2;
    private static int timeToLive = 6;
    private static PerishableParcel perishableParcel = new PerishableParcel("стандартная", 2,
            "стандартный адрес", sendDay, timeToLive);

    @Test
    void shouldReturnTrueWhenExpirationPassed() {
        int currentDay = 9;
        boolean result = sendDay + timeToLive < currentDay;
        Assertions.assertEquals(result, perishableParcel.isExpired(currentDay),
                "");

    }

    @Test
    void shouldReturnFalseWhenExpirationNotPassed() {
        int currentDay = 3;
        boolean result = sendDay + timeToLive < currentDay;
        Assertions.assertEquals(result, perishableParcel.isExpired(currentDay),
                "");
    }

    @Test
    void shouldReturnFalseWhenExpirationToCurrentDay() {
        int currentDay = 8;
        boolean result = sendDay + timeToLive < currentDay;
        Assertions.assertEquals(result, perishableParcel.isExpired(currentDay),
                "");
    }
}