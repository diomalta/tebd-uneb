package main;

import model.AddressEntity;
import service.AddressService;
import service.CardService;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Starting app...");

        AddressService addressService = new AddressService();
        CardService cardService = new CardService();
        cardService.save("","");
        // Save
        addressService.save("Rua Everaldina", "987654321");
        addressService.save("Rua Armando leite", "14656589");

        // Get all
        AddressEntity address = (AddressEntity) addressService.getAll().get(1);
        System.out.println("Delete register: " + address.getId());

        // Delete
        addressService.delete(address.getId());

        // Print all address
        addressService.toStringAddress();
    }
}