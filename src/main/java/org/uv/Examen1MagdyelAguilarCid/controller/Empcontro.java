
package org.uv.Examen1MagdyelAguilarCid.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class Empcontro {
    @Autowired
    private RepositoryEmpleado RepositoryEmpleado;
    
    @GetMapping("/msg")
    public String holaMiundo(){
        return "Hola mundo";
    }
    
    @GetMapping("/empleado/{id")   
    public Alumnos obtenerEmpleado(@PathVariable("id") long id) {
        Alumnos emp=null;
        if (id == 10) {
            emp = new  Alumnos();
            emp.setClave(10);
            emp.setNombre("Aldo");
            emp.setDireccion("Avenida 1");
            emp.setTelefono("123");
        }
        return emp;
    }
    @GetMapping("/empleado")
    public List<Alumnos> obtenerTodosLosEmpleados() {
        List<Alumnos> lstEmpleados=new ArrayList<>();
            Alumnos emp1 = new Alumnos();
            emp1.setClave(10);
            emp1.setNombre("Aldo");
            emp1.setDireccion("Avenida 1");
            emp1.setTelefono("123");
            
            lstEmpleados.add(emp1);
            Alumnos emp2 = new Alumnos();
            emp2.setClave(12);
            emp2.setNombre("Gabrie");
            emp2.setDireccion("Avenida 2");
            emp2.setTelefono("12345");
            lstEmpleados.add(emp2);
            
            return lstEmpleados;
                
        //Agregar métodos post, delete y update.
        //Formas de consultar datos: Ingresar a localhost:8080 en navegador.
        //Postman: http://localhost:8080/api/empleado
        //http://localhost:8080/api/empleado/10
        //
        /*
        Consulta en Postman
        GET o POST
        body -> raw
        {
                "nombre": "Aldo",
                "direccion": "Avenida 1",
                "telefono": "123"
        }
         */
        
    }
    
    @PostMapping("/empleado")    
    public Alumnos creaEmpleado(@RequestBody Alumnos empleadoDTO){
        Empleado empleadoPojo=new Empleado();
        empleadoPojo.setNombre(empleadoDTO.getNombre());
        empleadoPojo.setDireccion(empleadoDTO.getDireccion());
        empleadoPojo.setTelefono(empleadoDTO.getTelefono());     
        Empleado empleadoPojoNew=RepositoryEmpleado.save(empleadoPojo);
        Alumnos empleadoDTONew=new Alumnos();
        empleadoDTONew.setClave(empleadoPojoNew.getClave());
        empleadoDTONew.setNombre(empleadoPojoNew.getNombre());
        empleadoDTONew.setDireccion(empleadoPojoNew.getDireccion());
        empleadoDTONew.setTelefono(empleadoPojoNew.getTelefono());
            
        return empleadoDTONew;
            //emp.setClave(10);
            //emp.setNombre(empleado.getNombre());
            //emp.setDireccion(empleado.getDireccion());
            //emp.setTelefono(empleado.getTelefono());
            
    }
    @DeleteMapping("/empleado/{id}")
    public void borrarEmpleado(@PathVariable("id") Long id){
        return;
        
    }
    @PutMapping("/empleado/{id")
    public Alumnos modificarEmpleado(@PathVariable("id") Long id,
            @RequestBody Alumnos empleado){
        //Mape, buscar ID y update
        return empleado;
    
    
    }
    
}

