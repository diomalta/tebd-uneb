package main;

import model.AddressEntity;
import model.CardsEntity;
import service.AddressService;
import service.CardService;
import service.ParticipantService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import java.sql.Date;
import java.util.*;
public class AppMain {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema do congresso");

        boolean exiter = true;

        String date [] = new String[3];
        date[0] = "dia";
        date[1] = "mes";
        date[2] = "ano";
         while(exiter){
            String name, email;
            String flag, ccv, number;
            String cep, address;
             String jobCep, jobAddress;

             int[]  due = new int[3];

            Scanner sc = new Scanner(System.in);

            System.out.println("\nDados do usuário:\n");
            System.out.println("Qual seu nome?");
            name = sc.nextLine();
            System.out.println("Qual seu email?");
            email = sc.nextLine();

            System.out.println("\nDados do cartão:\n");
            System.out.println("Qual a bandeira do seu cartão?");
            flag = sc.nextLine();
            System.out.println("Qual o ccv?");
            ccv = sc.nextLine();
            System.out.println("Qual o numero?");
            number = sc.nextLine();
            System.out.println("\nQual a data de vencimento?\n");

            for(int i = 0; i<3; i++){
                System.out.println(date[i]);
                due[i] = sc.nextInt();
            }

            System.out.println("\nDados de endereço de trabalho:\n");
            System.out.println("CEP:");
            jobCep = sc.nextLine();
            System.out.println("endereço:");
            jobAddress = sc.nextLine();

            System.out.println("\nDados de endereço:\n");
            System.out.println("CEP:");
            cep = sc.nextLine();
            System.out.println("endereço:");
            address = sc.nextLine();

             System.out.println("Caso algum dado tenha sido escrito errado digite 1 para recadastrar!");
            int control = sc.nextInt();
            exiter = control == 1?  true: false;
            if(exiter == true){
                continue;
            }else {

                Transaction transaction = null;
                CardsEntity recordCard = new CardsEntity();
                AddressEntity recordAddress = new AddressEntity();
                AddressEntity jobAddressObj = new AddressEntity();

                try (Session session = HibernateUtils.getSessionFactory().openSession()) {
                    transaction = session.beginTransaction();

                    CardService cardService = new CardService();
                    recordCard = cardService.save(number, ccv, flag, new Date(due[2], due[1], due[0]));
                    session.save(recordCard);

                    AddressService addressService = new AddressService();
                    recordAddress = addressService.save(address, cep);
                    session.save(recordAddress);

                    jobAddressObj = addressService.save(jobAddress, jobCep);
                    session.save(jobAddressObj);

                    ParticipantService participantService = new ParticipantService();
                    participantService.save(name, email, recordAddress, recordCard, jobAddressObj);

                    transaction.commit();
                    HibernateUtils.closeSession(session);
                } catch (HibernateException e) {
                    assert transaction != null;
                    transaction.rollback();
                    e.printStackTrace();
                }

            }
         }
    }
}