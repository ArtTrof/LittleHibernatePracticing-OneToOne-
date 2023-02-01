package org.example;

import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//1get any principal and his school
            Principal principal = session.get(Principal.class, 1);
            System.out.println(principal);
            System.out.println(principal.getSchool());
            //2 get any school and get principal from there
            School school = session.get(School.class,1);
            System.out.println(school);
            System.out.println(school.getPrincipal());
//create new principal and school that he manages
//            Principal principal1 = new Principal("Artem",40);
//            School school1 = new School(10);
//            principal1.setSchool(school1);
//            session.save(principal1);
                //set new principal at school
//            Principal principal1 = new Principal("Viktor",50);
//            School school1 = session.get(School.class,5);
//            school1.setPrincipal(principal1);
//            session.save(principal1);
            //add second school to principal who already manages school (Exception will be caught because of unique pr_id
            School school1 = new School(2300);
            Principal principal1 = session.get(Principal.class,1);
            principal1.setSchool(school1);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
