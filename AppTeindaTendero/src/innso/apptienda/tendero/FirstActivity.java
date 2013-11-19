package innso.apptienda.tendero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class FirstActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_first);
		Inicializar();
	}

	private void Inicializar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(8000);
					Intent i = new Intent(FirstActivity.this,Ingresar_Activity.class);
					startActivity(i);
					finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
}