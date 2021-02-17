package com.vanessabzr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vanessabzr.entity.Pedido;
import com.vanessabzr.service.IPedidoService;

@Controller
public class PedidoController {
	
	@Autowired
	private IPedidoService iPedidoService;


		
	@GetMapping("/crear")
	public String crearPedido() {
		return "pedido/pedidoCreate";
	}
	
	@PostMapping("/save")
	public String guardarPedido(Pedido pedido, Model model) {
		this.iPedidoService.guardar(pedido);
		List<Pedido> pedidosList = this.iPedidoService.listarNuevos();
		model.addAttribute("pedidosList", pedidosList);
		return "pedido/pedidosList";
	}
	
	@GetMapping({"/pedidosList", "/"})
	public String pedidosList(Model model) {
		List<Pedido> pedidosList = this.iPedidoService.listarNuevos();
		model.addAttribute("pedidosList", pedidosList);
		return "pedido/pedidosList";
	}
	
	@GetMapping("/pedidosCanceladosList")
	public String pedidosCancelados(Model model) {
		List<Pedido> pedidosList = this.iPedidoService.listarCancelados();
		model.addAttribute("pedidosList", pedidosList);
		return "pedido/pedidosList";
	}
	
	@GetMapping("/pedidosEntregadosList")
	public String pedidosEntregados(Model model) {
		List<Pedido> pedidosList = this.iPedidoService.listarEntregados();
		model.addAttribute("pedidosList", pedidosList);
		return "pedido/pedidosList";
	}
	
	@GetMapping("/entregar/{id}")
	public String entregarPedido(@PathVariable("id") Long idPedido, Model model) {
		this.iPedidoService.entregarPedido(idPedido);
		List<Pedido> pedidosList = this.iPedidoService.listarNuevos();
		model.addAttribute("pedidosList", pedidosList);
		return "pedido/pedidosList";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelarPedido(@PathVariable ("id") Long idPedido, Model model) {
		this.iPedidoService.cancelarPedido(idPedido);
		List<Pedido> pedidosList = this.iPedidoService.listarNuevos();
		model.addAttribute("pedidosList", pedidosList);
		return "pedido/pedidosList";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPedido(@PathVariable("id")Long idPedido, Model model) {
		this.iPedidoService.eliminar(idPedido);
		List<Pedido> pedidosList = this.iPedidoService.listarNuevos();
		model.addAttribute("pedidosList", pedidosList);
		return "pedido/pedidosList";
	}
	
}
