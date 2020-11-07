package database;

import models.Repair;

import javax.transaction.Transactional;

@Transactional
class RepairRepository extends GenericRepository<Repair> {
}
