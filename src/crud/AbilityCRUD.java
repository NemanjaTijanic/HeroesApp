package crud;

import entity.Ability;
import exceptions.NegativanBrojException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AbilityCRUD {
    private static SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
    
    public static List<Ability> readAllAbilities(){
        List<Ability> abilityji = new ArrayList<>();
        Session session = sessionFactory.openSession();
        
        try{
            Criteria c = session.createCriteria(Ability.class);
            c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            abilityji = c.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        
        return abilityji;
    }
    
    public static Ability readAbilityById(int id){
        Ability ability = new Ability();
        Session session = sessionFactory.openSession();
        
        try{
            ability = (Ability) session.createCriteria(Ability.class).add(Restrictions.eq("id", id)).uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        
        return ability;
    }
    
    public static Ability addAbility(Ability ability) throws NegativanBrojException{
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            Integer i = (Integer) session.save(ability);
            ability.setAbilityId(i);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
        
        return ability;
    }
    
    public static void updateAbility(Ability ability){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            session.saveOrUpdate(ability);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
    }
    
    public static void deleteAbility(Ability ability){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            session.delete(ability);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
    }
}
