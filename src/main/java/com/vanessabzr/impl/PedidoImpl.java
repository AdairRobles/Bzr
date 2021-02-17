package com.vanessabzr.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanessabzr.entity.Pedido;
import com.vanessabzr.repository.PedidoRepository;
import com.vanessabzr.service.IPedidoService;

@Service
public class PedidoImpl implements IPedidoService {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> listarNuevos() {		
		return this.pedidoRepository.listarNuevos();
	}


	@Override
	public Pedido buscarPorId(Long idPedido) {
		return this.pedidoRepository.buscarPorId(idPedido);
	}

	@Override
	public List<Pedido> listarCancelados() {
		return this.pedidoRepository.listarCancelados();
	}


	@Override
	public void eliminar(Long idPedido) {
		Pedido pedido = this.buscarPorId(idPedido);
		this.pedidoRepository.delete(pedido);
		
	}


	@Override
	public void cancelarPedido(Long idPedido) {
		Pedido pedido = this.buscarPorId(idPedido);
		pedido.setFechaEntrega(null);
		pedido.setEstado("CANCELADO");
		pedido.setEntregado(false);
		this.pedidoRepository.save(pedido);
		
	}


	@Override
	public void entregarPedido(Long idPedido) {
		Pedido pedido = this.buscarPorId(idPedido);
		pedido.setFechaEntrega(sdf.format(new Date()));
		pedido.setEstado("ENTREGADO");
		pedido.setRestaPago(0);
		pedido.setEntregado(true);
		this.pedidoRepository.save(pedido);
		
	}


	@Override
	public Pedido guardar(Pedido pedido) {
		pedido.setGanancia(pedido.getCostoCliente() - pedido.getCostoTienda());
		pedido.setRestaPago(pedido.getCostoCliente() - pedido.getAnticipo());
		pedido.setFechaPedido(sdf.format(new Date()));
		pedido.setEntregado(false);
		this.pedidoRepository.save(pedido);
		return pedido;
	}


	@Override
	public List<Pedido> listarEntregados() {
		return this.pedidoRepository.listarEntregados();
	}
	


}
