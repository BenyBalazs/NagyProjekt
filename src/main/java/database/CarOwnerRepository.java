package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.CarModel;
import models.CarOwner;
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
public class CarOwnerRepository extends GenericRepository<CarOwner> {

    private static final Logger logger = LoggerFactory.getLogger("CarModelRepository.class");

    public void deleteAndSetConnectionToNull(CarOwner entity) {
        if (!entity.getOwnedCars().isEmpty())
         {
            for (Car a : entity.getOwnedCars()) {
                a.setOwner(null);
                Repositories.carRepository.commitChange(a);
            }
        }
        Repositories.carOwnerRepository.simpleDelete(entity);
    }

    public List<CarOwner> getEveryTypeFromGivenBrand(String name){
        name += '%';
        EntityManager em = EmfHelper.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<CarOwner> cq = cb.createQuery(CarOwner.class);

        Root<CarOwner> from = cq.from(CarOwner.class);

        cq.select(from).where(cb.like(from.get("name"),name,'%'));

        try{
            Query q = em.createQuery(cq);
            return (List<CarOwner>) q.getResultList();
        }catch (Exception e){
            logger.error("Hiba a modell megtalálása közben.");
        }finally {
            em.close();
        }
        return Repositories.carOwnerRepository.findAll();
    }
}
