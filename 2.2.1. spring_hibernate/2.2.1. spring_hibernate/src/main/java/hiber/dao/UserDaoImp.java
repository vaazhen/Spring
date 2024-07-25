package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.NonUniqueResultException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }



   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public User getUser(String model, int series) {
      Query<User> query=sessionFactory.openSession().createQuery("from User where car.model = :model and car.series = :series", User.class);
      query.setParameter("model",model);
      query.setParameter("series",series);
      try {
         return query.uniqueResult();
      } catch (NoResultException e) {
         return null;
      } catch (NonUniqueResultException e) {
         return query.getResultList().get(0);
      }
   }
}
