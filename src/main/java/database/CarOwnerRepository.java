package database;

import models.CarOwner;

import javax.transaction.Transactional;

@Transactional
class CarOwnerRepository extends GenericRepository<CarOwner> {
}
