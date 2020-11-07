package database;

import models.CarModel;

import javax.transaction.Transactional;

@Transactional
public class CarModelRepository extends GenericRepository<CarModel> {
}
