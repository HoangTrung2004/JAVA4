package Utils;

import jakarta.persistence.*;

public class XJPA {
    private static final EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("Lab6"); 
    }
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
