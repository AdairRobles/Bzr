package com.vanessabzr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	private String nombreCliente;
	private String producto;
	private String tienda;
	private double costoTienda;
	private double costoCliente;
	private double ganancia;
	private double anticipo;
	private double restaPago;
	private String estado = "NUEVO";
	private boolean entregado;
	private String fechaPedido;
	private String fechaEntrega;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public double getCostoTienda() {
		return costoTienda;
	}

	public void setCostoTienda(double costoTienda) {
		this.costoTienda = costoTienda;
	}

	public double getCostoCliente() {
		return costoCliente;
	}

	public void setCostoCliente(double costoCliente) {
		this.costoCliente = costoCliente;
	}

	public double getGanancia() {
		return ganancia;
	}

	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}

	public double getAnticipo() {
		return anticipo;
	}

	public void setAnticipo(double anticipo) {
		this.anticipo = anticipo;
	}

	public double getRestaPago() {
		return restaPago;
	}

	public void setRestaPago(double restaPago) {
		this.restaPago = restaPago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", nombreCliente=" + nombreCliente + ", producto=" + producto
				+ ", tienda=" + tienda + ", costoTienda=" + costoTienda + ", costoCliente=" + costoCliente
				+ ", ganancia=" + ganancia + ", anticipo=" + anticipo + ", restaPago=" + restaPago + ", estado="
				+ estado + ", entregado=" + entregado + ", fechaPedido=" + fechaPedido + ", fechaEntrega="
				+ fechaEntrega + "]";
	}

}
