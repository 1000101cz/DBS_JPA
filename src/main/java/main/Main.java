package main;

import jakarta.persistence.*;
import jakarta.persistence.spi.PersistenceProvider;
import jakarta.persistence.spi.PersistenceProviderResolver;
import jakarta.persistence.spi.PersistenceProviderResolverHolder;
import main.dao.EmailContactDAO;
import main.dao.EmployeeDAO;
import main.dao.ManufacturingPlantDAO;
import main.model.ManufacturingPlant;

import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        // Get list of all plants
        ManufacturingPlantDAO mpDAO = new ManufacturingPlantDAO(em);
        mpDAO.printAllPlantsList();

        // change employee's address
        EmployeeDAO eDAO = new EmployeeDAO(em);
        eDAO.changeAddress(4, "Nova Ulice 123", "Kladno", 32546);

        // remove email contact on employee
        EmailContactDAO emailDAO = new EmailContactDAO(em);
        emailDAO.removeByEmailAndEmployeeID("Zuzana@Dobrak.cz", 52); // 52

        // create email contact on employee
        EmailContactDAO emailDAO2 = new EmailContactDAO(em);
        emailDAO2.createNewContact(52, "Zuzana2@Dobrak.cz");

        // change salary of employee on selected position
        EmployeeDAO eDAO2 = new EmployeeDAO(em);
        eDAO2.changeSalaryForPosition("Chef", 1000);

        em.close();
        emf.close();
    }
}