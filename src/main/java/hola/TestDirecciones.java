/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author campitos
 */
public class TestDirecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      SessionFactory factory=  HibernateUtilidades.getSessionFactory();
                     Session sesion=          factory.openSession();
          Transaction tranza=           sesion.beginTransaction();
          Cliente c=new Cliente("Anacleta",45000f);
          sesion.save(c);
          sesion.save(new Direccion("La Viga","de las sirenas",c));
          tranza.commit();
          sesion.close();
          System.out.println("Guardado con exito");
    }
    
}
