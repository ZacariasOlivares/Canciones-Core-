package com.zacarias.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zacarias.modelos.Artista;
import com.zacarias.modelos.Cancion;
import com.zacarias.servicios.ServicioArtistas;
import com.zacarias.servicios.ServicioCanciones;
import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	
	@Autowired
	// Atributo
	private final ServicioCanciones servicioCanciones;
	private final ServicioArtistas servicioArtistas;
	
	// Constructor
	public ControladorCanciones(ServicioCanciones servicioCanciones,
								ServicioArtistas servicioArtistas) {
		this.servicioCanciones = servicioCanciones;
		this.servicioArtistas = servicioArtistas;
	}
	
	// Obtener cancion
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
	
	// Agregar cancion
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute ("cancion") Cancion cancion,
										   Model modelo) {
		List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
		modelo.addAttribute("listaArtistas",listaArtistas);
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute ("cancion") Cancion cancion,
										 BindingResult validaciones, Model modelo){
		if (validaciones.hasErrors()) {
			List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
			modelo.addAttribute("listaArtistas",listaArtistas);
			return "agregarCancion.jsp";
		}
		
		this.servicioCanciones.agregarCancion(cancion);
		
		return "redirect:/canciones";
	}
	
	// Actualizar cancion
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable ("idCancion") Long id,
										  Model modelo) {
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(id);
		if (cancionActual == null) {
			return "redirect:/canciones";
		}
		List<Artista> listaArtistas = this.servicioArtistas.obtenerTodosLosArtistas();
		modelo.addAttribute("cancionActual", cancionActual);
		modelo.addAttribute("listaArtistas", listaArtistas);
		return "editarCancion.jsp";
	}
	
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute("cancionActual") Cancion cancion,
										BindingResult validaciones,
										@PathVariable("idCancion") Long id,
										Model modelo)
										{
		if (validaciones.hasErrors()) {
			cancion.setId(id);
			List<Artista> listaArtistas = this.servicioArtistas.obtenerTodosLosArtistas();
			modelo.addAttribute("listaArtistas", listaArtistas);
			return "editarCancion.jsp";
		}
		// Obtener fecha de creacion
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(id);
		
		// Set id y fecha de creacion
		cancion.setId(cancionActual.getId());
		cancion.setFechaCreacion(cancionActual.getFechaCreacion());
		
		
		this.servicioCanciones.actualizaCancion(cancion);
		return "redirect:/canciones";
	}
	
	// Eliminar cancion
	@DeleteMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
		this.servicioCanciones.eliminaCancion(idCancion);
		return "redirect:/canciones";
	}
	
	
	
	
	
		
}
