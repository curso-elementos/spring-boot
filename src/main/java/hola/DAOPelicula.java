/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

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
public class DAOPelicula {
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
    
    public static void guardar(Pelicula p)throws Exception{
     obtenerSesion();
    sesion.save(p);
     cerrarSesion();
    }
    
    public static Pelicula buscarPorId(Integer id)throws Exception{
        obtenerSesion();
    Pelicula p=new Pelicula();
    Criteria cricri=sesion.createCriteria(Pelicula.class);
    
  p= (Pelicula) cricri.add(Restrictions.idEq(id)).uniqueResult();
      cerrarSesion();
      return p;
    }
    
    public static ArrayList<Pelicula> buscarTodos()throws Exception{
        obtenerSesion();
        ArrayList<Pelicula> peliculas=new ArrayList<Pelicula>();
    Criteria cricri=    sesion.createCriteria(Pelicula.class);
   peliculas=  (ArrayList<Pelicula>) cricri.list();
   cerrarSesion();
  
    return peliculas;
    }
    
    public static void actualizar(Pelicula peli)throws Exception{
        obtenerSesion(); 
        sesion.update(peli);
        cerrarSesion();
    }
    
    public static void borrar(Pelicula peli) throws Exception{
        obtenerSesion();
        sesion.delete(peli);
        cerrarSesion();
    }
    
}
