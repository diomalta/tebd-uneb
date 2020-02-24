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

    public void save(String number, String ccv, String flag, Date date) {
        Transaction transaction = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            CardsEntity cardObj = new CardsEntity();
            cardObj.setNumber(number);
            cardObj.setFlag(flag);
            cardObj.setCcv(ccv);
            cardObj.setDue(date);

            session.save(cardObj);

            transaction.commit();
            HibernateUtils.closeSession(session);

            System.out.println("Records inserted successfully");
        } catch (HibernateException e) {
            assert transaction != null;
            transaction.rollback();
            e.printStackTrace();
        }
    }

}
