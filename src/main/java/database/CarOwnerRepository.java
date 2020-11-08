package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.CarOwner;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarOwnerRepository extends GenericRepository<CarOwner> {
}
