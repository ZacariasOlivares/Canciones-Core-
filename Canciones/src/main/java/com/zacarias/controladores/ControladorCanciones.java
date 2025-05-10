package com.zacarias.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.zacarias.modelos.Cancion;
import com.zacarias.servicios.ServicioCanciones;
import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	
	@Autowired
	// Atributo
	private final ServicioCanciones servicioCanciones;
	
	// Constructor
	public ControladorCanciones(ServicioCanciones servicioCanciones) {
		this.servicioCanciones = servicioCanciones;
	}
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
		modelo.addAttribute("listaCanciones", listaCanciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(Model modelo,
										  @PathVariable("idCancion") Long id) {
		Cancion cancion = this.servicioCanciones.obtenerCancionPorId(id);
		
		if (cancion == null) {
			return "redirect:/canciones";
		}
		
		modelo.addAttribute("cancionActual", cancion);
		return "detalleCancion.jsp";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute ("cancion") Cancion cancion ) {
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute ("cancion") Cancion cancion,
										 BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		
		this.servicioCanciones.agregarCancion(cancion);
		
		return "redirect:/canciones";
	}
		
}
