package innso.apptienda.tendero;

import innso.apptienda.adaptador.MyExpandableAdapter;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

public class Productos_Activity extends ExpandableListActivity implements OnClickListener {

	private Button Agregar;
	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productos);
		this.inicializar();
		this.addEventos();
		
	}

	private void addEventos() {
		Agregar.setOnClickListener(this);
		
	}
	
	private void inicializar() {
		Agregar = (Button) findViewById(R.id.productos_nuevo);
		ExpandableListView expandableList = getExpandableListView();
		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		setGroupParents();
		setChildData();
		MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);
		
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener(this);
	}

	public void setGroupParents() {
		parentItems.add("Panaderia");
		parentItems.add("Bebidas");
		parentItems.add("Higiene");
		parentItems.add("Medicamentos");
	}

	
public void setChildData() {
		
		// Android
		ArrayList<String> child = new ArrayList<String>();
		child.add("Pan Frances");
		child.add("Corazon");
		childItems.add(child);
		
		
		// Core Java
		child = new ArrayList<String>();
		child.add("Cocacola 2.5L");
		child.add("Pepsi 3.0L ");
		child.add("AspectJ");
		child.add("Beans");
		child.add("Crypto");
		childItems.add(child);
		
		// Desktop Java
		child = new ArrayList<String>();
		child.add("Accessibility");
		child.add("AWT");
		child.add("ImageIO");
		child.add("Print");
		childItems.add(child);
		
		
		// Enterprise Java
		child = new ArrayList<String>();
		child.add("EJB3");
		child.add("GWT");
		child.add("Hibernate");
		child.add("JSP");
		childItems.add(child);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.productos, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == Agregar.getId()){
			Intent i = new Intent(this,ProductoNuevo_Activity.class);
			startActivity(i);
		}
		
	}
	
	

}
