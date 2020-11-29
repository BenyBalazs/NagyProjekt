package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.CarModel;
import models.CarOwner;
import models.Repair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarRepository extends GenericRepository<Car>{

    private static final Logger logger = LoggerFactory.getLogger("CarRepository.class");

    public void deleteAndSetConnectionToNull(Car entity){

        entity.setOwner(null);
        entity.setModel(null);

        entity.getRepairs().clear();
        Repositories.carRepository.commitChange(entity);
        Repositories.carRepository.simpleDelete(entity);
    }

    public List<Car> findEveryCarWithSameOwner(CarOwner owner){
        logger.trace("Minden autó lekérdezése a tulajdonoshoz!");
        EntityManager em = EmfHelper.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Car> cq = cb.createQuery(Car.class);

        Root<Car> from = cq.from(Car.class);

        cq.select(from).where(cb.equal(from.get("owner"), owner));

        try{
            Query q = em.createQuery(cq);
            return q.getResultList();
        }catch (Exception e){
            logger.error("Hiba a modell megtalálása közben.");
        }finally {
            em.close();
        }
        return new ArrayList<Car>();
    }
}
