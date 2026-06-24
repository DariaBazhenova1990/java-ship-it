package ru.yandex.practicum.delivery;

//хрупкая посылка
public class FragileParcel extends Parcel {
    private static final int BASIC_COST = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getBasicCost() {
        return BASIC_COST;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }


}
