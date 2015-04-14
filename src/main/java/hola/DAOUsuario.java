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
 * @author T-301
 */
public class DAOUsuario {
    
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
    
    public static void guardar(Usuario p)throws Exception{
     obtenerSesion();
    sesion.save(p);
     cerrarSesion();
    }
    
    public static Usuario buscarPorId(Integer id)throws Exception{
        obtenerSesion();
    Usuario p=new Usuario();
    Criteria cricri=sesion.createCriteria(Usuario.class);
    
  p= (Usuario) cricri.add(Restrictions.idEq(id)).uniqueResult();
      cerrarSesion();
      return p;
    }
    
    public static ArrayList<Usuario> buscarTodos()throws Exception{
        obtenerSesion();
        ArrayList<Usuario> peliculas=new ArrayList<Usuario>();
    Criteria cricri=    sesion.createCriteria(Usuario.class);
   peliculas=  (ArrayList<Usuario>) cricri.list();
   cerrarSesion();
  
    return peliculas;
    }
    
    public static void actualizar(Usuario peli)throws Exception{
        obtenerSesion(); 
        sesion.update(peli);
        cerrarSesion();
    }
    
    public static void borrar(Usuario peli) throws Exception{
        obtenerSesion();
        sesion.delete(peli);
        cerrarSesion();
    }
    
}

