package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Mechanic;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MechanicRepository extends GenericRepository<Mechanic>{
}
