/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import java.util.ArrayList;

/**
 *
 * @author campitos
 */
public class GenerarEvaluaciones {
    
    public static ArrayList<Evaluacion> obtenerEvaluaciones(){
        ArrayList<Evaluacion> e=new ArrayList<Evaluacion>();
        
        Evaluacion e1=new Evaluacion("Petra", 8.2f);
        Evaluacion e2=new Evaluacion("Nicasia", 9.4f);
        Evaluacion e3=new Evaluacion("Clodomiro", 6.0f);
        Evaluacion e4=new Evaluacion("Ponciano", 5.4f);
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        return e;
        
    }
    
}
