package com.zacarias.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zacarias.modelos.Cancion;
import com.zacarias.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	@Autowired
	private final RepositorioCanciones repositorioCanciones;
	
	public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
		this.repositorioCanciones = repositorioCanciones;
	}
	
	
	public List<Cancion> obtenerTodasLasCanciones() {
		return this.repositorioCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long Id) {
		return this.repositorioCanciones.findById(Id).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion cancionNueva) {
		return this.repositorioCanciones.save(cancionNueva);
	}
	
	public Cancion actualizaCancion(Cancion cancionActual) {
		return this.repositorioCanciones.save(cancionActual);
	}
}
