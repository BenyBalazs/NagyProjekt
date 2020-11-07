package database;

import models.Mechanic;

import javax.transaction.Transactional;

@Transactional
class MechanicRepository extends GenericRepository<Mechanic>{
}
