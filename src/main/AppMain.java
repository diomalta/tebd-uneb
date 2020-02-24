package main;

import model.AddressEntity;
import service.AddressService;
import service.CardService;

import java.sql.Date;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Starting app...");

        CardService cardService = new CardService();
        cardService.save("072698635699","575",  "master", new Date(2020, 2, 2));
    }
}