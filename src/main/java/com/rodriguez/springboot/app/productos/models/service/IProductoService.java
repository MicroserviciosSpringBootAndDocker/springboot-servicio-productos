package com.rodriguez.springboot.app.productos.models.service;

import java.util.List;

//import com.rodriguez.springboot.app.productos.models.entity.Producto;
import com.rodriguez.springboot.app.commons.models.Producto;

public interface IProductoService {
	
	public List<Producto>findByAll();
	public Producto finById(Long id);
	
	public Producto save(Producto producto);
	public void deleteById(Long id);
	
	

}