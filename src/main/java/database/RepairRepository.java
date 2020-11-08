package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Repair;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class RepairRepository extends GenericRepository<Repair> {

}
