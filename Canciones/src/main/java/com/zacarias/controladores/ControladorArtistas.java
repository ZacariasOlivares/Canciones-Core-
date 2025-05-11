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

import com.zacarias.modelos.Artista;
import com.zacarias.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
	@Autowired
	private final ServicioArtistas servicioArtistas;
	
	public ControladorArtistas(ServicioArtistas servicioArtistas) {
		this.servicioArtistas = servicioArtistas;
	}
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model modelo) {
		List<Artista> listaArtistas = this.servicioArtistas.obtenerTodosLosArtistas();
		modelo.addAttribute("listaArtistas", listaArtistas);
		return "artistas.jsp";
	}
	
	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleCancion(Model modelo,
										  @PathVariable("idArtista") Long id) {
		Artista artista = this.servicioArtistas.obtenerArtistaPorId(id);
		
		if (artista == null) {
			return "redirect:/artistas";
		}
		
		modelo.addAttribute("artistaActual", artista);
		return "detalleArtista.jsp";
	}
	
	@GetMapping("/artistas/formulario/agregar")
	public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
		return "agregarArtista.jsp";
	}
	
	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista,
										 BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarArtista.jsp";
		}
		
		this.servicioArtistas.agregarArtista(artista);
		return "redirect:/artistas";
	}
	
	
	
	
}
