package service;
import model.AddressEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import utils.HibernateUtils;

import java.util.List;

public class AddressService {
    public AddressService() {}

    public AddressEntity save(String address, String cep) {
        /*Transaction transaction = null;
        Integer cardID = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
    */
            AddressEntity addressObj = new AddressEntity();
            addressObj.setAddress(address);
            addressObj.setCep(cep);

        //    session.save(addressObj);

          //  transaction.commit();
           // HibernateUtils.closeSession(session);

            return addressObj;
        /*} catch (HibernateException e) {
            assert transaction != null;
            transaction.rollback();
            e.printStackTrace();
        }
        return null;

         */
    }

    public List getAll() {
        Transaction transaction = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List addressDb = session.createQuery("FROM AddressEntity").getResultList();

            transaction.commit();
            HibernateUtils.closeSession(session);

            return addressDb;
        } catch (HibernateException e) {
            assert transaction != null;
            transaction.rollback();
            e.printStackTrace();
        }

        return null;
    }

    public void delete(Integer id) {
        Transaction transaction = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM AddressEntity WHERE id = :id");
            query.setParameter("id", id);

            AddressEntity address = (AddressEntity) query.uniqueResult();
            session.delete(address);
            transaction.commit();
            HibernateUtils.closeSession(session);

            System.out.println("Address records deleted");
        } catch (HibernateException e) {
            assert transaction != null;
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void toStringAddress() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            List beforeDeletedAddressList = this.getAll();
            for (Object o : beforeDeletedAddressList) {
                AddressEntity addressEntity1 = (AddressEntity) o;
                System.out.println(addressEntity1.getAddress() + "  "
                        + addressEntity1.getCep());
            }

            HibernateUtils.closeSession(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
