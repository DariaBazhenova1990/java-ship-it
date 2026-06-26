package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParcelBoxTest {
    ParcelBox<StandardParcel> standardParcelBox;
    StandardParcel standardParcel;

    @Test
    void shouldAddParcelWhenMaxWeightNotAchived() {
        standardParcelBox = new ParcelBox<>(10);
        standardParcel = new StandardParcel("стандартная", 9,
                "стандартный адрес", 2);
        Assertions.assertTrue(standardParcelBox.addParcel(standardParcel),
                "Посылка ошибочно добавлена в коробку.");
    }

    @Test
    void shouldNotAddParcelWhenMaxWeightAchived() {
        standardParcelBox = new ParcelBox<>(10);
        standardParcel = new StandardParcel("стандартная", 11,
                "стандартный адрес", 2);
        Assertions.assertFalse(standardParcelBox.addParcel(standardParcel),
                "Посылка ошибочно не добавлена в коробку.");
    }

    @Test
    void shouldAddParcelWhenMaxWeightFitted() {
        standardParcelBox = new ParcelBox<>(10);
        standardParcel = new StandardParcel("стандартная", 10,
                "стандартный адрес", 2);
        Assertions.assertTrue(standardParcelBox.addParcel(standardParcel),
                "Посылка ошибочно добавлена в коробку.");
    }

}
