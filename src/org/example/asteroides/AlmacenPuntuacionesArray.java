package org.example.asteroides;

import java.util.Vector;

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones {
	private Vector<String> puntuaciones;
	
	public AlmacenPuntuacionesArray(){
		puntuaciones=new Vector<String>();
		puntuaciones.add("123000 Philip J. Fry");
		puntuaciones.add("111000 Bender Bending Rodriguez");
		puntuaciones.add("011000 Professor Farnsworth");
	}
	
	@Override
	public void guardarPuntuacion(int puntos, String nombre, long fecha) {
		puntuaciones.add(0,puntos+" "+nombre);

	}

	@Override
	public Vector<String> listaPuntuaciones(int cantidad) {
	
		return puntuaciones;
	}

}
