package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.CarModel;
import models.CarOwner;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarOwnerRepository extends GenericRepository<CarOwner> {

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
}
