package ru.yandex.practicum.delivery;

public class CommonParcelData {
    final String description;
    final int weight;
    final String deliveryAddress;
    final int sendDay;

    public CommonParcelData(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }
}
