package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.CarModel;
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
import java.util.stream.Collectors;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarModelRepository extends GenericRepository<CarModel> {

    private static final Logger logger = LoggerFactory.getLogger("CarModelRepository.class");

    public void deleteAndSetConnectionToNull(CarModel entity) {
        if (!entity.getCars().isEmpty()) {
            for (Car a : entity.getCars()) {
                a.setModel(null);
                Repositories.carRepository.commitChange(a);
            }
        }
        Repositories.carModelRepository.simpleDelete(entity);
    }

    public CarModel getModelByBrandAndType(String brand, String type){
        EntityManager em = EmfHelper.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<CarModel> cq = cb.createQuery(CarModel.class);

        Root<CarModel> from = cq.from(CarModel.class);

        cq.select(from).where(cb.equal(from.get("brand"), brand),cb.equal(from.get("type"),type));

        try{
            Query q = em.createQuery(cq);
            return (CarModel) q.getResultList().get(0);
        }catch (Exception e){
            logger.error("Hiba a modell megtalálása közben.");
        }finally {
            em.close();
        }
        return null;
    }

    public List<String> getEveryBrandAsStringList(){
        return Repositories.carModelRepository.findAll().stream().map(CarModel::getBrand).collect(Collectors.toList());
    }
    public List<String> getEveryTypeAsStringList(){
        return Repositories.carModelRepository.findAll().stream().map(CarModel::getType).collect(Collectors.toList());
    }
    public List<String> getEveryTypeFromGivenBrand(String brand){
        brand = brand + '%';
        EntityManager em = EmfHelper.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<CarModel> cq = cb.createQuery(CarModel.class);

        Root<CarModel> from = cq.from(CarModel.class);

        cq.select(from.get("type")).where(cb.like(from.get("brand"),brand,'%'));

        try{
            Query q = em.createQuery(cq);
            return (ArrayList<String>) q.getResultList();
        }catch (Exception e){
            logger.error("Hiba a modell megtalálása közben.");
        }finally {
            em.close();
        }
        return getEveryTypeAsStringList();
    }
}
