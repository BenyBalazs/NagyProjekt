package database;

import models.Mechanic;

import javax.transaction.Transactional;

@Transactional
public class MechanicRepository extends GenericRepository<Mechanic>{
}
