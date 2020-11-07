package database;

public final class Repositories {

    private Repositories(){}

    public static final CarRepository carRepository = new CarRepository();
    public static final CarModelRepository carModelRepository = new CarModelRepository();
    public static final CarOwnerRepository carOwnerRepository = new CarOwnerRepository();
    public static final MechanicRepository mechanicRepository = new MechanicRepository();
    public static final RepairRepository repairRepository = new RepairRepository();
}
