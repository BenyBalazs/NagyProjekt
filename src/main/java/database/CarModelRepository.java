package database;

import models.CarModel;

import javax.transaction.Transactional;

@Transactional
class CarModelRepository extends GenericRepository<CarModel> {
}
