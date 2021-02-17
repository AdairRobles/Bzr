package com.vanessabzr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vanessabzr.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	
	@Query(value = "SELECT p FROM Pedido p WHERE p.estado = 'NUEVO'")
	List<Pedido> listarNuevos();
	
	@Query(value = "SELECT p FROM Pedido p WHERE p.estado = 'CANCELADO'")
	List<Pedido> listarCancelados();
	
	@Query(value = "SELECT p FROM Pedido p WHERE p.estado = 'ENTREGADO'")
	List<Pedido> listarEntregados();
	
	@Query(value = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
	public Pedido buscarPorId(@Param("idPedido") Long idPedido);

}
