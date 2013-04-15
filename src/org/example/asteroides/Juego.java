package org.example.asteroides;

import android.app.Activity;
import android.os.Bundle;

public class Juego extends Activity{
	private VistaJuego vistaJuego;
	
	@Override public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);
		vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
	}
	
	@Override protected void onPause() {
		   super.onPause();
		   vistaJuego.getThread().pausar();
		   vistaJuego.OffSensors();
		}
		 
		@Override protected void onResume() {
		   super.onResume();
		   vistaJuego.getThread().reanudar();
		   vistaJuego.OnSensors();
		}
		 
		@Override protected void onDestroy() {
		   super.onDestroy();
		   vistaJuego.getThread().detener();
		   vistaJuego.OffSensors();
		   
		   
		}
}
