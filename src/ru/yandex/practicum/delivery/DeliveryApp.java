package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Ввод не должен быть пустым.");
                return;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    sendNotification();
                    break;
                case 0:
                    running = false;
                    System.out.println("Завершение...");
                    break;
                default:
                    System.out.println("Неверный выбор.\n");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отправить SMS-оповещение");
        System.out.println("0 — Завершить");
        System.out.print("Ваш выбор: ");
    }

    private static void addParcel() {
        showAddParcelMenu();
        int parcelType = readParcelType();
        if (parcelType == -1) {
            return;
        }

        Parcel parcel = null;
        CommonParcelData data = readCommonParcelData();
        switch (parcelType) {
            case 1:
                parcel = new StandardParcel(data.description, data.weight, data.deliveryAddress, data.sendDay);
                break;
            case 2:
                parcel = new FragileParcel(data.description, data.weight, data.deliveryAddress, data.sendDay);
                trackableParcels.add((Trackable) parcel);
                break;
            case 3:
                System.out.print("Введите срок в днях, за который посылка не испортится: ");
                String inputTimeToLive = scanner.nextLine();
                int timeToLive = Integer.parseInt(inputTimeToLive);
                parcel = new PerishableParcel(data.description, data.weight, data.deliveryAddress, data.sendDay, timeToLive);
                break;
        }

        allParcels.add(parcel);
        System.out.println("Посылка успешно добавлена!\n");

    }

    private static void showAddParcelMenu() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
    }

    private static int readParcelType() {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("Ввод не должен быть пустым.");
            return -1;
        }

        int parcelType = Integer.parseInt(input);
        if (parcelType < 1 || parcelType > 3) {
            System.out.println("Неверный тип посылки.");
            return -1;
        }

        return parcelType;
    }

    private static CommonParcelData readCommonParcelData() {
        System.out.print("Введите описание посылки: ");
        String description = scanner.nextLine();

        System.out.print("Введите вес посылки: ");
        String inputWeight = scanner.nextLine();
        int weight = Integer.parseInt(inputWeight);

        System.out.print("Введите адрес места назначения посылки: ");
        String deliveryAddress = scanner.nextLine();

        System.out.print("Введите день отправки: ");
        String inputSendDay = scanner.nextLine();
        int sendDay = Integer.parseInt(inputSendDay);

        return new CommonParcelData(description, weight, deliveryAddress, sendDay);
    }

    private static void sendParcels() {
        System.out.println("Начинаю отправку посылок...");
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        System.out.println("Все посылки оправлены!\n");
    }

    private static void calculateCosts() {
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок равна: " + totalCost + "\n.");
    }

    public static void sendNotification() {
        if(trackableParcels.isEmpty()) {
            System.out.println("В доставке нет посылок с услугой SMS-оповещения.\n");
            return;
        }

        System.out.print("Введите новое местоположение посылки: ");
        String newLocation = scanner.nextLine();
        if (newLocation.isEmpty()) {
            System.out.println("Ввод не должен быть пустым.\n");
            return;
        }

        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
        }
    }

}

