package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Car;
import models.Mechanic;
import models.Repair;

import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MechanicRepository extends GenericRepository<Mechanic>{

    public void deleteAndSetConnectionToNull(Mechanic entity){

        if(!entity.getRepairs().isEmpty()) {
            for (Repair a : entity.getRepairs()) {
                a.getMechanics().remove(entity);
                Repositories.repairRepository.commitChange(a);
            }
        }
        Repositories.mechanicRepository.simpleDelete(entity);
    }
}
