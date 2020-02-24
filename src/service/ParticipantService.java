package service;

import model.AddressEntity;
import model.CardsEntity;
import model.ParticipantsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.sql.Date;

public class ParticipantService {
    public ParticipantService() {}

    public void save(String name, String email, AddressEntity address, CardsEntity card) {
        Transaction transaction = null;
        System.out.println(address.getId() + " - " +address.getAddress());
        System.out.println(card.getId() + " - " +card.getNumber());
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ParticipantsEntity participantObj = new ParticipantsEntity();
            participantObj.setName(name);
            participantObj.setEmail(email);
            participantObj.setAddress(address);
            participantObj.setCard(card);
            System.out.println("Aqui carai");
            session.save(participantObj);
            System.out.println("Aqui carai2");

            transaction.commit();
            System.out.println("Aqui carai3");

            HibernateUtils.closeSession(session);
        } catch (HibernateException e) {
            System.out.println(e);
            assert transaction != null;
            transaction.rollback();
            e.printStackTrace();
        }
    }

}
