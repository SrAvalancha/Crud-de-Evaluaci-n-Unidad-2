package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.crud.R;
import com.example.crud.modelo.ListaDeCompras;
import com.example.crud.modelo.Producto;

public class DetallesActivity extends AppCompatActivity {

    public Producto producto;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idProducto");
        producto= ListaDeCompras.getInstancia().getProducto(id);

        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        TextView txtUnidad=(TextView) findViewById(R.id.txtUnidad);
        txtUnidad.setText(producto.getCantidad() + " "+ producto.getUnidad());

        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button cambiar=(Button) findViewById(R.id.estado);

        if (producto.isEstado()==Producto.PENDIENTE)
        {
            txtEstado.setText("Pendiente");
            cambiar.setText("Marcar como Comprado");
        }
        else
        {
            txtEstado.setText("Comprado");
            cambiar.setText("Marcar como Pendiente");
        }

    }
    public void cambiarEstado(View view)
    {
        producto.setEstado(!producto.isEstado());
        setResult(RESULT_OK, intent);
        finish();
    }
}