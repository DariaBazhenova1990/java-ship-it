package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final List<T> parcelsInBox = new ArrayList<>();

    private final int maxWeight;
    private int currentWeight = 0;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.weight < maxWeight) {
            parcelsInBox.add(parcel);
            currentWeight += parcel.weight;
            System.out.println("Добавили посылку в коробку.");
        } else {
            System.out.println("Превышен максимальный вес. Посылка не будет добавлена в коробку.");
        }

    }

    public List<T> getAllParcels() {
        return parcelsInBox;
    }
}
