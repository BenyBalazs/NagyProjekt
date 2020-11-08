package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.CarModel;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarModelRepository extends GenericRepository<CarModel> {
}
