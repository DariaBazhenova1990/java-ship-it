package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParcelTest {
    private static final int STANDART_PARCEL_BASIC_COST = 2;
    private static final int PERISHABLE_PARCEL_BASIC_COST = 3;
    private static final int FRAGILE_PARCEL_BASIC_COST = 4;

    private static StandardParcel standardParcel = new StandardParcel("стандартная", 2,
            "стандартный адрес", 2);

    private static PerishableParcel perishableParcel = new PerishableParcel("скоропортящаяся", 2,
            "скоропортящийся адрес", 2, 5);

    private static FragileParcel fragileParcel = new FragileParcel("хрупкая", 2,
            "хрупкий адрес", 2);

    @Test
    void calculateDeliveryCostForStandardParcel() {
        int result = standardParcel.weight * STANDART_PARCEL_BASIC_COST;
        Assertions.assertEquals(result, standardParcel.calculateDeliveryCost(),
                "Стоимость доставки стандартной посылки считается с ошибкой.");
    }

    @Test
    void calculateDeliveryCostForPerishableParcel() {
        int result = perishableParcel.weight * PERISHABLE_PARCEL_BASIC_COST;
        Assertions.assertEquals(result, perishableParcel.calculateDeliveryCost(),
                "Стоимость доставки скоропортящейся посылки считается с ошибкой.");
    }

    @Test
    void calculateDeliveryCostForFragileParcel() {
        int result = fragileParcel.weight * FRAGILE_PARCEL_BASIC_COST;
        Assertions.assertEquals(result, fragileParcel.calculateDeliveryCost(),
                "Стоимость доставки хрупкой посылки считается с ошибкой.");
    }

}