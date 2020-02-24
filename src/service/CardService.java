package service;

import model.AddressEntity;
import model.CardsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.sql.Date;
import java.sql.Timestamp;

public class CardService {
    public CardService() {}
    public void save(String address, String cep) {
        Transaction transaction = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("aqui");
            CardsEntity cardObj = new CardsEntity();
            cardObj.setId("0712127221812");
            cardObj.setFlag("masterCard");
            cardObj.setCcv("007");
            cardObj.setDue(new Date(2019));
            System.out.println(cardObj.getDue());

            session.save(cardObj);
            System.out.println("aqui3");
            transaction.commit();
            HibernateUtils.closeSession(session);

            System.out.println("Records inserted successfully");
        } catch (HibernateException e) {
            assert transaction != null;
            transaction.rollback();
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
