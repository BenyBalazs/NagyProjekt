package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.Mechanic;
import models.Repair;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class RepairRepository extends GenericRepository<Repair> {

    public void deleteAndSetConnectionToNull(Repair entity){

        if(!entity.getMechanics().isEmpty()) {
            for (Mechanic a : entity.getMechanics()) {
                a.getRepairs().remove(entity);
                Repositories.mechanicRepository.commitChange(a);
            }
        }
        Repositories.repairRepository.simpleDelete(entity);
    }
}
