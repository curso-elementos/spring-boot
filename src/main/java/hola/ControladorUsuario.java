/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SE
 */


@Controller
public class ControladorUsuario {
 
  @RequestMapping(value="/mensaje", method=RequestMethod.GET, headers={"Accept=text/html"})  
  @ResponseBody String mensaje(){
      
      return "Hola desde spring!!";
  }
    
    
 @RequestMapping(value="/usuario", method=RequestMethod.GET,
         headers={"Accept=application/json"})
 @ResponseBody String guardar()throws Exception{
     ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
    usuarios= DAOUsuario.buscarTodos();
    ObjectMapper maper=new ObjectMapper();
     return maper.writeValueAsString(usuarios); 
 }
 
 @RequestMapping(value="/usuario", method=RequestMethod.POST, headers={"Accept=application/json"})
 @ResponseBody String guardar(@RequestBody String json)throws Exception{
      System.out.println("<<<<<<<<<Se ha recibido el json"+json);
       Map<String,String> map = new HashMap<String,String>();
	ObjectMapper mapper = new ObjectMapper();
 
//Transformamos el json
		map = mapper.readValue(json, 
		    new TypeReference<HashMap<String,String>>(){});
               int edad=Integer.parseInt(map.get("edad"));
               float sueldo=Float.parseFloat(map.get("sueldo"));
               String nombre=map.get("nombre");
              //AJUSTAMOS los campos veniudos de JSON al objeto a guardarse  
                Usuario u =new Usuario();
                u.setEdad(edad);
                u.setNombre(nombre);
                u.setSueldo(sueldo);
              //Guardamos el objeto
            DAOUsuario.guardar(u);
             
      
      return "Se guardo con nombre "+nombre;
 } 
    
}
