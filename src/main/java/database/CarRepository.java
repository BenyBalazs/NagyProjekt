package database;

import models.Car;

import javax.transaction.Transactional;

@Transactional
public class CarRepository extends GenericRepository<Car>{
}
