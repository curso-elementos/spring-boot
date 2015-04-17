/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author campitos
 */


@ComponentScan
@EnableAutoConfiguration
public class Aplicacion {
    
    public static void main(String args[]){
        
        SpringApplication.run(Aplicacion.class, args);
      //  probarTodo();
    }
    
    
    
    
    public static void probarTodo(){
       Usuario u=new Usuario();
               u.setNombre("Malo");
               u.setSueldo(300f);
               u.setEdad(40);
        try {
   
        } catch (Exception ex) {
            System.out.println("Elgo malo paso"+ex);
        }
    }

}