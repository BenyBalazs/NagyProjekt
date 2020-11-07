package database;

public final class Repositories {

    private Repositories(){}

    public static CarRepository carRepository = new CarRepository();
    public static CarModelRepository carModelRepository = new CarModelRepository();
    public static CarOwnerRepository carOwnerRepository = new CarOwnerRepository();
    public static MechanicRepository mechanicRepository = new MechanicRepository();
    public static RepairRepository repairRepository = new RepairRepository();
}
