package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfHelper {

    private EmfHelper(){}

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cars");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void closeEmf(){
        emf.close();
    }
}
