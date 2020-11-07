package database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public abstract class GenericRepository<T> {

    private static final Logger logger = LoggerFactory.getLogger("MenuController.class");

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

    public void simpleDelete(T entity){
        EntityManager em = EmfHelper.getEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
            logger.trace("A szimpla törlés sikeresen megtörtént.");
        }catch (Exception e){
            logger.error("Hiba történt az entitás törlése közben: {}", e.toString());
        }finally {
            em.close();
        }
    }
}
