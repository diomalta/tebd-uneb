package service;

import model.CardsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.sql.Date;

public class CardService {
    public CardService() {}

    public CardsEntity save(String number, String ccv, String flag, Date date) {
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

            return cardObj;
        } catch (HibernateException e) {
            assert transaction != null;
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

}
