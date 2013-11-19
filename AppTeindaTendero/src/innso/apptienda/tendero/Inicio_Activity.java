package innso.apptienda.tendero;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Inicio_Activity extends Activity implements OnClickListener {

	private ImageButton Productos;
	private ImageButton Pedidos;
	private ImageButton MiTienda;
	private ImageButton Instrucciones;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		this.inicializar();
		this.addEventos();
	}

	private void inicializar() {
		Productos = (ImageButton) findViewById(R.id.home_productos);
		Pedidos = (ImageButton) findViewById(R.id.home_pedidos);
		MiTienda = (ImageButton) findViewById(R.id.home_miTienda);
		Instrucciones = (ImageButton) findViewById(R.id.home_instrucciones);
	}

	private void addEventos() {
		Productos.setOnClickListener((android.view.View.OnClickListener) this);
		Pedidos.setOnClickListener(this);
		MiTienda.setOnClickListener(this);
		Instrucciones.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == Productos.getId()){
			Intent i = new Intent(this,Productos_Activity.class);
			startActivity(i);
			return;
		}if(v.getId() == Pedidos.getId()){
			
			return;
		}if(v.getId() == MiTienda.getId()){
			
			return;
		}if(v.getId() == Instrucciones.getId()){
			Intent i = new Intent(this,Instrucciones_Activity.class);
			startActivity(i);
			return;
		}
		
		
	}


}
