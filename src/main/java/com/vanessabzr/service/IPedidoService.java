package com.vanessabzr.service;

import java.util.List;

import com.vanessabzr.entity.Pedido;

public interface IPedidoService {
	
	List<Pedido> listarNuevos();
	
	List<Pedido> listarCancelados();
	
	Pedido buscarPorId(Long idPedido);
	
	void cancelarPedido(Long pedido);
	
	void entregarPedido(Long pedido);
	
	void eliminar (Long idPedido);
	
	Pedido guardar(Pedido pedido);
	
	List<Pedido> listarEntregados();
	

}
