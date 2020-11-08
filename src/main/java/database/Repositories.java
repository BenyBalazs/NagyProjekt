package database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Repositories {

    public static final CarRepository carRepository = new CarRepository();
    public static final CarModelRepository carModelRepository = new CarModelRepository();
    public static final CarOwnerRepository carOwnerRepository = new CarOwnerRepository();
    public static final MechanicRepository mechanicRepository = new MechanicRepository();
    public static final RepairRepository repairRepository = new RepairRepository();
}
