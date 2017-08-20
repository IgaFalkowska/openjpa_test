package pl.igafalkowska.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "openjpa" );
//
//        EntityManager entitymanager = emfactory.createEntityManager( );
//        entitymanager.getTransaction( ).begin( );
//
//        User userr = new User("Jan" ,"Kowalski", "jan@gmail.com");
//        User userrr = new User("Janek" ,"Kowal", "janek@gmail.com");
//
//        entitymanager.persist( userr );
//        entitymanager.persist( userrr );
//        entitymanager.getTransaction( ).commit( );
//
//        entitymanager.close( );
//        emfactory.close( );

        EntityManagerFactory efactory = Persistence.createEntityManagerFactory( "openjpa" );

        EntityManager emanager = efactory.createEntityManager( );
        emanager.getTransaction( ).begin( );
        User user = emanager.find( User.class, 1 );

        //before update
        System.out.println( user );
        user.setLastName( "koop" );
        emanager.getTransaction( ).commit( );

        //after update
        System.out.println( user );
        emanager.close();
        efactory.close();
    }
}
