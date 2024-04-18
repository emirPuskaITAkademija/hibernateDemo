*** Project description ***
We have configured Hibernate in old fashion way without JPA spec implemented by Hibernate.

There are few steps required to achieve this:
  1. hibernate.cfg.xml - JDBC connection params configured, MySQL dialect defined
  2. Employee <----- Employee.hbm.xml -----> employees -   Mapping rules between employees table from human_resource DB and Employee class from hibernateDemo app
  3. HibernateUtil: Session, SessionFactory(SINGLETON) - is always looking at the hibernate.cfg.xml and according that creates SessionFactory.

Used technologies:
1. Java SE 17
2. Hibernate(without JPA)
3. MySQL DB
