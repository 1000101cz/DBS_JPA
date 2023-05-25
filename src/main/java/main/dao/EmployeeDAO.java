package main.dao;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import main.model.EmailContact;
import main.model.Employee;

import jakarta.persistence.EntityManager;
import main.model.ManufacturingPlant;

import java.util.List;

public class EmployeeDAO {
    private EntityManager em;

    public EmployeeDAO() {

    }

    public EmployeeDAO(EntityManager em) {
        this.em = em;
    }

    public List<Employee> findAll() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public void create(Employee e) {
        em.persist(e);
    }

    public Employee find(Integer id) {
        return em.find(Employee.class, id);
    }

    public Employee merge(Employee e) {
        return em.merge(e);
    }

    public void delete(Employee e) {
        em.remove(e);
    }

    public void changeAddress(Integer id, String street, String city, Integer zip) {
        EntityTransaction transaction = em.getTransaction();
        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            System.out.println("Changing address for: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Old address:");
            System.out.println("    " + employee.getStreet());
            System.out.println("    " + employee.getCity());
            System.out.println("    " + employee.getZip());
            employee.setStreet(street);
            employee.setCity(city);
            employee.setZip(zip);

            transaction.begin();
            em.merge(employee);
            transaction.commit();

            System.out.println("New address:");
            System.out.println("    " + employee.getStreet());
            System.out.println("    " + employee.getCity());
            System.out.println("    " + employee.getZip());
        } else {
            System.out.println("Employee with employee_id " + id + " not found.");
        }
    }

    public void changeSalaryForPosition(String position, Integer change) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        // Create position filter
        Predicate positionPredicate = criteriaBuilder.equal(root.get("position"), position);

        query.select(root).where(criteriaBuilder.and(positionPredicate));

        // get filtered data
        List<Employee> employeeList = em.createQuery(query).getResultList();

        em.getTransaction().begin();
        for (Employee employee : employeeList) {
            Integer oldSalary = employee.getSalary();
            employee.setSalary(oldSalary + change);
            em.merge(employee);
            System.out.println("Salary of employee " + employee.getFirstName() + " " + employee.getLastName() + " changed from " + oldSalary + " to " + employee.getSalary());
        }
        em.getTransaction().commit();
    }
}
