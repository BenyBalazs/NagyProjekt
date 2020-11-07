package database;

import models.Car;

import javax.transaction.Transactional;

@Transactional
class CarRepository extends GenericRepository<Car>{
}
