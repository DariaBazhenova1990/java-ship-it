package ru.yandex.practicum.delivery;

//скоропортящаяся посылка
public class PerishableParcel extends Parcel {
    private static final int BASIC_COST = 3;

    int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getBasicCost() {
        return BASIC_COST;
    }

    public boolean isExpired(int currentDay) {
        if (sendDay + timeToLive >= currentDay) {
            return false;
        } else {
            return true;
        }
    }

}
