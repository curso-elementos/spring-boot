/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SE
 */


@Controller
public class ControladorUsuario {
    
 @RequestMapping(value="/usuario", method=RequestMethod.GET,
         headers={"Accept=text/html"})
 @ResponseBody String guardar(){
     
     String mensaje="REgistro guardado con exito";
     return mensaje;
 }
 
    
}
