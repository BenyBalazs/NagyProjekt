package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.CarModel;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarModelRepository extends GenericRepository<CarModel> {

    public void forceDelete(CarModel entity){
        for(Car a : entity.getCars()){
           try {
               a.setModel(null);
               Repositories.carRepository.commitChange(a);
           }catch (Exception e) {System.out.println("Üres Lisa");}

        }
        Repositories.carModelRepository.simpleDelete(entity);
    }
}
