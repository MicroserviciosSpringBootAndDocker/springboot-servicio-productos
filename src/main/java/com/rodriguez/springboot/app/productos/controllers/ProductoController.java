package com.rodriguez.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.springboot.app.commons.models.Producto;
//import com.rodriguez.springboot.app.productos.models.entity.Producto;
import com.rodriguez.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	
	@Autowired
	private IProductoService service;
	
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return service.findByAll();
	}
	
		@GetMapping("/ver/{id}")
		public Producto detalle(@PathVariable Long id) throws Exception {
			
			/*
			boolean ok = false;
			if(ok == false) {
				throw new Exception("No se puedo cargar el producto");
			}
			
		
			try {
				Thread.sleep(2000L);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			*/
			
			
			
			return service.finById(id);
		
	}
	
		
 @PostMapping("/crear") // los datos llegan en el cuerpo del request
 @ResponseStatus(HttpStatus.CREATED)
 public Producto save(@RequestBody Producto producto) {
	 return service.save(producto);
	 
 }
 
 @PutMapping("/editar/{id}")
 @ResponseStatus(HttpStatus.CREATED)
 public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
	 Producto productoBD = service.finById(id);
	 
	 productoBD.setNombre(producto.getNombre());
	 productoBD.setPrecio(producto.getPrecio());
	 
	 return service.save(productoBD);
	 
 }
		
 @DeleteMapping("/eliminar/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void delete(@PathVariable Long id) {
	 service.deleteById(id);
	 
 }
	
 
 
	
}
