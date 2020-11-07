package database;

import models.CarOwner;

import javax.transaction.Transactional;

@Transactional
public class CarOwnerRepository extends GenericRepository<CarOwner> {
}
