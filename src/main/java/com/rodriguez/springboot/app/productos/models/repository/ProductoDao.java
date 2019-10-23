package com.rodriguez.springboot.app.productos.models.repository;

import org.springframework.data.repository.CrudRepository;

//import com.rodriguez.springboot.app.productos.models.entity.Producto;
import com.rodriguez.springboot.app.commons.models.Producto;
public interface ProductoDao extends CrudRepository<Producto, Long> {
	
	
	
	

}
