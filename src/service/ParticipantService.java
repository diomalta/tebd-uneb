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

    public void save(String name, String email, AddressEntity address, AddressEntity job, CardsEntity card) {
        Transaction transaction = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ParticipantsEntity participantObj = new ParticipantsEntity();
            participantObj.setName(name);
            participantObj.setEmail(email);
            participantObj.setAddress(address);
            participantObj.setCard(card);
            participantObj.setJob(job);

            session.save(participantObj);

            transaction.commit();
            HibernateUtils.closeSession(session);
        } catch (HibernateException e) {
            assert transaction != null;
            transaction.rollback();
            e.printStackTrace();
        }
    }

}
