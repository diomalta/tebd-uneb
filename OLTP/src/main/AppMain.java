package main;

import model.AddressEntity;
import model.CardsEntity;
import service.AddressService;
import service.CardService;
import service.ParticipantService;

import java.sql.Date;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Starting app...");

        CardService cardService = new CardService();
        CardsEntity recordCard = cardService.save("072698635699","575",  "sha", new Date(2020, 2, 2));

        AddressService addressService = new AddressService();
        AddressEntity recordAddress = addressService.save("Testando relation2", "26589894");

        ParticipantService participantService = new ParticipantService();
        participantService.save("Diego", "diomalta@gmail.com", recordAddress, recordCard);
    }
}