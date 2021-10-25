package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.crud.modelo.ListaDeCompras;
import com.example.crud.modelo.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListaDeCompras lista=ListaDeCompras.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verLista(View view)
    {
        ArrayList<Producto> productos=lista.getListaDeCompras();
        if (productos.size()>0) {
            Intent intent = new Intent(this, ListaProductosActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "La lista de compras esta vacia",Toast.LENGTH_SHORT).show();
        }
    }

    public void ingresarNuevo(View view)
    {
        Intent intent= new Intent(this, NuevoProductoActivity.class);
        startActivity(intent);

    }

    public void eliminarComprados(View view)
    {
        lista.eliminarComprados();
        Toast.makeText(this, "Se ha eliminado los productos comprados",Toast.LENGTH_SHORT).show();
    }
}