package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {
    static int maxParcelBoxWeight;
    static int parcelWeight;
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(maxParcelBoxWeight);
    private static StandardParcel standardParcel = new StandardParcel("стандартная", parcelWeight,
            "стандартный адрес", 2);

    @Test
    void shouldAddParcelWhenMaxWeightNotAchived() {
        maxParcelBoxWeight = 20;
        parcelWeight = 10;
        boolean result = maxParcelBoxWeight >= parcelWeight;
        Assertions.assertEquals(result, standardParcelBox.addParcel(standardParcel),
                "Посылка ошибочно добавлена в коробку.");
    }

    @Test
    void shouldNotAddParcelWhenMaxWeightAchived() {
        maxParcelBoxWeight = 10;
        parcelWeight = 20;
        boolean result = maxParcelBoxWeight >= parcelWeight;
        Assertions.assertEquals(result, standardParcelBox.addParcel(standardParcel),
                "Посылка ошибочно не добавлена в коробку.");
    }

    @Test
    void shouldAddParcelWhenMaxWeightFitted() {
        maxParcelBoxWeight = 10;
        parcelWeight = 10;
        boolean result = maxParcelBoxWeight >= parcelWeight;
        Assertions.assertEquals(result, standardParcelBox.addParcel(standardParcel),
                "Посылка ошибочно добавлена в коробку.");
    }

}
