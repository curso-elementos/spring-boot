/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ControladorInicial {

@RequestMapping(value="/hola", method=RequestMethod.GET, 
         headers={"Accept=text/html"})
    public @ResponseBody String hola(){
        
        return "Bienvenido a mi primer servicios con spring";
    }
    
    @RequestMapping(value="/resultados-json", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String respuesta()throws Exception{
       ObjectMapper maper=new ObjectMapper();
       String respuesta=maper.writeValueAsString(GenerarEvaluaciones.obtenerEvaluaciones());
       return respuesta;
    }
    
    @RequestMapping(value="/pelicula", method=RequestMethod.GET)
    public String guardar(@ModelAttribute Pelicula pelicula, Model model){
        String mensaje="Bienvenido soquete";
        if(pelicula.getTitulo()==null)mensaje="NO diste tu nombre";
        else{
            
        }
        model.addAttribute("mensaje", mensaje);
        
        return "peliculas";
    }
    
   @RequestMapping(value="/resultados", method=RequestMethod.GET)
   public String miresultado(Model model){
       Evaluacion e=new Evaluacion("Juan Carlos", 10);
       model.addAttribute("yo", e);
       return "presentacion";
   }


    
}
