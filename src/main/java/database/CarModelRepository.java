package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.CarModel;
import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarModelRepository extends GenericRepository<CarModel> {

    public void deleteAndSetConnectionToNull(CarModel entity) {
        if (!entity.getCars().isEmpty()) {
            for (Car a : entity.getCars()) {
                a.setModel(null);
                Repositories.carRepository.commitChange(a);
            }
        }
        Repositories.carModelRepository.simpleDelete(entity);
    }
}
