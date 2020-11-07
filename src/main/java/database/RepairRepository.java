package database;

import models.Repair;

import javax.transaction.Transactional;

@Transactional
public class RepairRepository extends GenericRepository<Repair> {

}
