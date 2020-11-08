package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.CarOwner;
import models.Repair;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarRepository extends GenericRepository<Car>{

    public void deleteAndSetConnectionToNull(Car entity){

        if(!entity.getRepairs().isEmpty()) {
            for (Repair a : entity.getRepairs()) {
                a.setCarOnRepair(null);
                Repositories.repairRepository.commitChange(a);
            }
        }
        Repositories.carRepository.simpleDelete(entity);
    }
}
