package org.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Asteroides extends Activity {
	private Button bAcercaDe;
	private MediaPlayer mp;
	
//	private Button bSalir; Comentamos este trozo para hacerlo por xml
	public static AlmacenPuntuaciones almacen=new AlmacenPuntuacionesArray();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Listeners "Acerca de"
        bAcercaDe=(Button) findViewById(R.id.button3);
        bAcercaDe.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		lanzarAcercaDe(null);
        	}
        });
        
        mp = MediaPlayer.create(this, R.raw.audio);
        
        //bAcercaDe.setBackgroundResource(R.drawable.degradado);
        /*Comentamos este trozo para hacerlo por xml
        //Listeners "Salir"
        bSalir=(Button) findViewById(R.id.button4);
        bSalir.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		lanzarSalir();
        	}
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    
    public void lanzarAcercaDe(View view){
    	Intent i = new Intent(this, AcercaDe.class);
    	startActivity(i);
    }
    
    public void lanzarSalir(View view){
    	finish();
    }
    
    public void lanzarPreferencias(View view){
    	Intent i=new Intent(this,Preferencias.class);
    	startActivity(i);
    }
    
    public void lanzarPuntuaciones(View view){
    	Intent i =new Intent(this,Puntuaciones.class);
    	startActivity(i);
    }
    
    public void lanzarJuego(View view){
    	Intent i=new Intent(this,Juego.class);
    	startActivity(i);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId() ){
    	case R.id.acercaDe:
    		lanzarAcercaDe(null);
    		break;
    	case R.id.config:
    		lanzarPreferencias(null);
    		break;
    	}
    	return true;
    }	
    
    @Override protected void onResume(){
    	super.onResume();
    	mp.start();
    }
    
    @Override protected void onPause(){
    	super.onPause();
    	mp.start();
    }
    
    @Override protected void onStop(){
    	super.onStop();
    	mp.stop();
    }
    
    @Override protected void onDestroy(){
    	super.onDestroy();
    	mp.stop();
    }
    
    @Override
    protected void onSaveInstanceState(Bundle estadoGuardado){
           super.onSaveInstanceState(estadoGuardado);
           if (mp != null) {
                  int pos = mp.getCurrentPosition();
                  estadoGuardado.putInt("posicion", pos);
           }
    }
  
    @Override
    protected void onRestoreInstanceState(Bundle estadoGuardado){
           super.onRestoreInstanceState(estadoGuardado);
           if (estadoGuardado != null && mp != null) {
                  int pos = estadoGuardado.getInt("posicion");
                  mp.seekTo(pos);
           }
    }
    
}
