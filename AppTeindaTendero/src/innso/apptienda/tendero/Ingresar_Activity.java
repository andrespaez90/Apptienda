package innso.apptienda.tendero;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Ingresar_Activity extends Activity implements OnClickListener {

	private Button Ingresar;
	private Button Salir;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		inicializar();
		addEventos();
	}

	private void inicializar() {
		Ingresar = (Button) findViewById(R.id.login_ingresar);
		Salir = (Button) findViewById(R.id.login_salir);
		
	}
	
	private void addEventos(){
		Ingresar.setOnClickListener(this);
		Salir.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == Ingresar.getId()){
			if(Valirdar()){
				Intent i = new Intent(this,Registro_Activity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK );
				startActivity(i);
				finish();
			}
			return;
		}if(v.getId() == Salir.getId()){
			finish();
			return;
		}
		
	}

	private boolean Valirdar() {
		String telefono = ((TextView)findViewById(R.id.registro_nombre)).getText().toString();
		String contrasena = ((TextView)findViewById(R.id.registro_nomEstablecimiento)).getText().toString();
		if((telefono.length() == 7 || telefono.length() == 10) && telefono.charAt(0)!='0' ){
			if(Numeros(telefono)){
				return true;
			}
		}
		CuadroDialogo(getResources().getString(R.string.titulo_error), getResources().getString(R.string.error_num_telefono));
		return false;
	}
	
	
	private void CuadroDialogo(String Tittle,String mensaje){
		 AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 builder.setTitle(Tittle);
		 builder.setMessage(mensaje)
		 	.setPositiveButton("Aceptar",new  DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	
            }
        });
		 builder.create();
		 builder.show();
	}
	

	private boolean Numeros(String tel) {
		try{
			Integer.parseInt(tel);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

}
