import employee.Employee;
import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <li>
 *     1. MYSQL driver
 * </li>
 * <li>
 *     2. Hibernate ORM
 * </li>
 * <li>
 *     3. Konfigurisati hibernate.cfg.xml
 * </li>
 * <li>
 *     4. Mapiranje pomoću XML
 *     employees -> Employee.java
 *
 *     Employee.hbm.xml <-> Employee.java
 *                      <-> employees TABELA
 * </li>
 * <li>
 *     5. HibernateUtil -> SessionFactory -> Session
 * </li>
 */
public class Application {
    public static void main(String[] args) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

//            //HQL
//            //select * from employees
//            Query<Employee> query = session.createQuery("from Employee");
//            List<Employee> employees = query.getResultList();
//            for(Employee employee: employees){
//                System.out.println(employee);
//            }

            Employee employee = new Employee();
            employee.setFirstName("Dženis");
            employee.setLastName("Hamidović");
            employee.setCreatedAt(LocalDateTime.now());
            employee.setEmployed(false);
            session.persist(employee);
            transaction.commit();
        }catch (HibernateException exception){
            System.err.println(exception.toString());
        }
    }
}
