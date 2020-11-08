package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarRepository extends GenericRepository<Car>{
}
