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

    public void deleteAndSetConnectionToNull(CarOwner entity){
        for(Car a : entity.getOwnedCars()){
            if(a == null)
                break;

            try {
                a.setModel(null);
                Repositories.carRepository.commitChange(a);
            }catch (Exception e) {System.out.println("Üres Lisa");}

        }
        Repositories.carOwnerRepository.simpleDelete(entity);
    }
}
