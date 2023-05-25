package main.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import main.model.EmailContact;
import main.model.Employee;

import jakarta.persistence.EntityManager;
import java.util.List;

public class EmailContactDAO {
    private EntityManager em;

    public EmailContactDAO() {

    }

    public EmailContactDAO(EntityManager em) {
        this.em = em;
    }

    public List<EmailContact> findAll() {
        return em.createQuery("SELECT e FROM EmailContact e", EmailContact.class).getResultList();
    }

    void create(EmailContact e) {
        em.persist(e);
    }

    public EmailContact find(Employee employee) {
        return em.find(EmailContact.class, employee);
    }

    public EmailContact merge(EmailContact e) {
        return em.merge(e);
    }

    public void delete(EmailContact e) {
        em.remove(e);
    }

    public void removeByEmailAndEmployeeID(String email, Integer id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<EmailContact> query = criteriaBuilder.createQuery(EmailContact.class);
        Root<EmailContact> root = query.from(EmailContact.class);

        // Find Employee by employee_id
        EmployeeDAO eDAO = new EmployeeDAO(em);
        Employee e = eDAO.find(id);

        // Create filters by email and employee
        Predicate emailPredicate = criteriaBuilder.equal(root.get("email"), email);
        Predicate employeePredicate = criteriaBuilder.equal(root.get("employee"), e);

        // create query to filter EmailContact table
        query.select(root).where(criteriaBuilder.and(emailPredicate, employeePredicate));

        // get filtered data (one or no record)
        List<EmailContact> resultList = em.createQuery(query).getResultList();

        if (!resultList.isEmpty()) {
            EmailContact foundContact = resultList.get(0);
            System.out.println("Found contact for " + foundContact.getEmployee().getFirstName() + " " + foundContact.getEmployee().getLastName() + " [" + foundContact.getEmployee().getEmployeeId() + "] and " + foundContact.getEmail());
            em.getTransaction().begin();
            em.remove(foundContact);
            em.getTransaction().commit();
            System.out.println("Contact removed successfully");

        }
        else {
            System.out.println("Contact " + email + " & employee_id " + id + " not found!");
        }
    }

    public void createNewContact(Integer id, String email) {
        // Find Employee by employee_id
        EmployeeDAO eDAO = new EmployeeDAO(em);
        Employee e = eDAO.find(id);

        if (e != null) {
            EmailContact new_contact = new EmailContact(e, email);
            try {
                em.getTransaction().begin();
                em.persist(new_contact);
                em.getTransaction().commit();
                System.out.println("Contact " + id + " " + email + " created");
            } catch (Exception exc) {
                System.out.println("Contact already exists!");
            }

        } else {
            System.out.println("Employee with id " + id + " not found!");
        }
    }
}