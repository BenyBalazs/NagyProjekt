package database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
abstract class GenericRepository<T> {

    private static final Logger logger = LoggerFactory.getLogger("MenuController.class");
    private Class<T> entityClass;

    public GenericRepository(){
        this.entityClass = ((Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public void createNew(T entity){
        EntityManager em = EmfHelper.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            logger.trace("Új entitás feltöltése sikeres");
        }catch (Exception e){
            logger.error("Hiba történt új entitás feltöltése közben {}", e.toString());
        }finally {
            em.close();
        }
    }

    public boolean simpleDelete(T entity){
        EntityManager em = EmfHelper.getEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
            logger.trace("A szimpla törlés sikeresen megtörtént.");
            return true;
        }catch (Exception e){
            logger.error("Hiba történt az entitás törlése közben: {}", e.toString());
            return false;
        }finally {
            em.close();
        }
    }

    public void commitChange(T entity){
        EntityManager em = EmfHelper.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            logger.trace("A frissítás sikeresen megtörtént.");
        }catch (Exception e){
            logger.error("Hiba történt az entitás frissítése közben: {}", e.toString());
        }finally {
            em.close();
        }
    }

    public List<T> findAll(){
        EntityManager em = EmfHelper.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<T> cq = cb.createQuery(entityClass);

        Root<T> from = cq.from(entityClass);

        cq.select(from);

        try{
            Query q = em.createQuery(cq);
            return q.getResultList();
        }catch (Exception e){
            logger.error("Hiba minden megtalálás közben.");
        }finally {
            em.close();
        }
        return new ArrayList<T>();
    }
}
