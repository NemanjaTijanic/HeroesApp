package crud;

import entity.Hero;
import exceptions.NegativanBrojException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class HeroCRUD {
    private static SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
    
    public static List<Hero> readAllHeroes(){
        List<Hero> heroji = new ArrayList<>();
        Session session = sessionFactory.openSession();
        
        try{
            Criteria c = session.createCriteria(Hero.class);
            c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            heroji = c.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        
        return heroji;
    }
    
    public static Hero readHeroById(int id){
        Hero hero = new Hero();
        Session session = sessionFactory.openSession();
        
        try{
            hero = (Hero) session.createCriteria(Hero.class).add(Restrictions.eq("id", id)).uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        
        return hero;
    }
    
    public static Hero readHeroByName(String name){
        Hero hero = new Hero();
        Session session = sessionFactory.openSession();
        
        try{
            hero = (Hero) session.createCriteria(Hero.class).add(Restrictions.eq("name", name)).uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        
        return hero;
    }
    
    public static Hero addHero(Hero hero){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            Integer i = (Integer) session.save(hero);
            hero.setId(i);
            transaction.commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        } catch (NegativanBrojException ex) {
                System.out.println(ex.getMessage());
                transaction.rollback();
            }finally{
            if(session != null){
                session.close();
            }
        }
        
        return hero;
    }
    
    public static void updateHero(Hero hero){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            session.saveOrUpdate(hero);
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
    
    public static void deleteHero(Hero hero){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            session.delete(hero);
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
