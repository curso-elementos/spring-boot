/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

/**
 *
 * @author T-107
 */
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author T-107
 */
public class DAOAvion {
    private static SessionFactory fac;
    private static Session sesion;
   private static Transaction tranza;
   
   private synchronized static void obtenerSesion(){
         fac=HibernateUtilidades.getSessionFactory();
        sesion=fac.openSession();
        tranza=sesion.beginTransaction();
   }
   
   private synchronized static void cerrarSesion(){
       tranza.commit();
      sesion.close();
   }
   
   //Metodo para guardar
    
    public static void guardar(Avion p)throws Exception{
     obtenerSesion();
    sesion.save(p);
     cerrarSesion();
    }
    
    public static Avion buscarPorId(Integer id)throws Exception{
        obtenerSesion();
    Avion p=new Avion();
    Criteria cricri=sesion.createCriteria(Avion.class);
    
  p= (Avion) cricri.add(Restrictions.idEq(id)).uniqueResult();
      cerrarSesion();
      return p;
    }
    
    public static ArrayList<Avion> buscarTodos()throws Exception{
        obtenerSesion();
        ArrayList<Avion> peliculas=new ArrayList<Avion>();
    Criteria cricri=    sesion.createCriteria(Avion.class);
   peliculas=  (ArrayList<Avion>) cricri.list();
   cerrarSesion();
  
    return peliculas;
    }
    
    public static void actualizar(Avion peli)throws Exception{
        obtenerSesion(); 
        sesion.update(peli);
        cerrarSesion();
    }
    
    public static void borrar(Avion peli) throws Exception{
        obtenerSesion();
        sesion.delete(peli);
        cerrarSesion();
    }
    
}
