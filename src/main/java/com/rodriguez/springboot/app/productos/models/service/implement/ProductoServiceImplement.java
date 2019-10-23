package com.rodriguez.springboot.app.productos.models.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rodriguez.springboot.app.commons.models.Producto;
//import com.rodriguez.springboot.app.productos.models.entity.Producto;
import com.rodriguez.springboot.app.productos.models.repository.ProductoDao;
import com.rodriguez.springboot.app.productos.models.service.IProductoService;


@Service
public class ProductoServiceImplement  implements IProductoService{
	
	@Autowired
	private ProductoDao productoDao;
	

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findByAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto finById(Long id) {
		return productoDao.findById(id).orElse(null); 
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
	
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDao.deleteById(id);
		
	}

}
