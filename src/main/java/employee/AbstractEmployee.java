package employee;

import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public sealed abstract class AbstractEmployee permits Employee {

    public Employee getThis() {
        return (Employee) this;
    }

    public Employee save() {
        executeInTransaction(Session::save);
        return getThis();
//        executeInTransaction(((session, employee) -> session.save(employee)));
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Transaction transaction = session.getTransaction();
//            transaction.begin();
//            session.save(this);
//            transaction.commit();
//        } catch (HibernateException exception) {
//            throw new RuntimeException(exception.getMessage());
//        }
//        return getThis();
    }

    public static Employee getById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.getTransaction().begin();
            Employee employee = session.get(Employee.class, id);
//            session.getTransaction().commit();
            return employee;
        } catch (HibernateException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }

    public static List<Employee> loadAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Employee> query = session.createQuery("from Employee");
            List<Employee> employees = query.getResultList();
            return employees;
        } catch (HibernateException exception) {
            System.err.println(exception.getMessage());
        }
        return new ArrayList<>();
    }

    public void employMe() {
        getThis().setEmployed(true).update();
    }

    public static void sendEmployeesToEmploymentChamber(Employee... employees) {
//        Stream.of(employees).forEach(Employee::sendMeToEmploymentChamber);
        for(Employee employee: employees){
            employee.sendMeToEmploymentChamber();
        }
    }

    public void sendMeToEmploymentChamber() {
        getThis().setEmployed(false).update();
    }

    public void delete() {
        executeInTransaction(Session::delete);
//        executeInTransaction((session, employee) -> session.delete(employee));
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.getTransaction().begin();
//            session.delete(this);
//            session.getTransaction().commit();
//        } catch (HibernateException exception) {
//            System.err.println(exception.getMessage());
//        }
    }

    public Employee update() throws HibernateException {
        executeInTransaction(Session::update);
//        executeInTransaction(((session, employee) -> session.update(employee)));
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.getTransaction();
//        transaction.begin();
//        session.update(this);
//        transaction.commit();
        return getThis();
    }

    private void executeInTransaction(BiConsumer<Session, Employee> employeeConsumer){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            employeeConsumer.accept(session, getThis());
            transaction.commit();
        }catch (HibernateException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
