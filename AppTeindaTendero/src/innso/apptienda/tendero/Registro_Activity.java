package innso.apptienda.tendero;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Registro_Activity extends Activity implements OnClickListener {

	private Button Finalizar;
	private String Nombre;
	private String Nombre_Esta;
	private String Direccion;
	private String Contrasena;
	private String Rcontrasena;
	private Resources Recursos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		this.inicializar();
		this.addEventos();
		CuadroDialogo(Recursos.getString(R.string.titulo_bienvenida), Recursos.getString(R.string.mensaje_registro));
	}

	
	private void inicializar() {
		Finalizar = (Button) findViewById(R.id.registro_finalizar);
		Recursos = getResources();
	}

	private void addEventos() {
		Finalizar.setOnClickListener(this);
		
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro_, menu);
		return true;
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

	@Override
	public void onClick(View v) {
		if(v.getId() == Finalizar.getId()){
			CapturarDatos();
			if(validarInfo()){
				Intent i = new Intent(this,Inicio_Activity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
				startActivity(i);
				finish();
			}
		}
	}


	private boolean validarInfo() {
		String tituloError = Recursos.getString(R.string.titulo_error);
		if(!(Nombre.length() > 5)){
			CuadroDialogo(tituloError, Recursos.getString(R.string.error_nombre_corto));
			return false;
		}
		if(!(Nombre_Esta.length() > 3)){
			CuadroDialogo(tituloError, Recursos.getString(R.string.error_nombreEst_corto));
			return false;
		}
		if(!(Direccion.length() > 7) ){
			CuadroDialogo(tituloError, Recursos.getString(R.string.error_direccion_valida));
			return false;
		}
		if(Contrasena.length() > 5){
			if(!Contrasena.equals(Rcontrasena)){
				CuadroDialogo(tituloError, Recursos.getString(R.string.error_contrasena_conincide));
				return false;
			}
		}else{
			CuadroDialogo(tituloError, Recursos.getString(R.string.error_contrasena_corta));
			return false;
		}
		return true;
	}


	private void CapturarDatos() {
		this.Nombre = ((TextView)findViewById(R.id.registro_nombre)).getText().toString();
		this.Nombre_Esta = ((TextView)findViewById(R.id.registro_nomEstablecimiento)).getText().toString();
		this.Direccion = ((TextView)findViewById(R.id.registro_direccion)).getText().toString();
		this.Contrasena = ((TextView)findViewById(R.id.registro_contrasena)).getText().toString();
		this.Rcontrasena = ((TextView)findViewById(R.id.registro_rcontrasena)).getText().toString();
	}

}
