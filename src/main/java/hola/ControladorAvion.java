/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author T-107
 */
@Controller
public class ControladorAvion {
  
    @RequestMapping(value="/avion/{asientos}", 
            method=RequestMethod.POST, headers={"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable Integer asientos ) throws Exception{
        //Creamos un Avion
        Avion a=new Avion();
              a.setAsientos(asientos);
            DAOAvion.guardar(a); 
          return "Tu avion ha sido guardado con exito!";  
    }
    
    
}
