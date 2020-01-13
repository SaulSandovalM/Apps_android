package com.hacksite.almacenamiento_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
    }

    public void alta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String desc = et2.getText().toString();
        String pre = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", desc);
        registro.put("precio", pre);
        bd.insert("articulos", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this, "Se cargaron los datos del articulo", Toast.LENGTH_LONG).show();
    }

    public void consultaporcodigo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select descripcion, precio from articulos where codigo=" + cod, null);
        if (fila.moveToFirst()){
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else {
            Toast.makeText(this, "No existe un articulo con dicho codigo", Toast.LENGTH_LONG).show();
        }
        bd.close();
    }

    public void consultapordescripcion(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String desc = et2.getText().toString();
        Cursor fila = bd.rawQuery(
                "select codigo, precio from articulos where descripcion='" + desc +"'", null
        );
        if (fila.moveToFirst()){
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else {
            Toast.makeText(this, "No existe un articulo con dcha descripcion", Toast.LENGTH_LONG).show();
        }
        bd.close();
    }

    public void bajaporcodigo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        int cant = bd.delete("articulos", "codigo=" + cod, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        if (cant == 1){
            Toast.makeText(this, "Se borro el articulo con dicho codigo", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No existe un articulo con dicho condigo", Toast.LENGTH_LONG).show();
        }
    }

    public void modificacion(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String desc = et2.getText().toString();
        String pre = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", desc);
        registro.put("precio", pre);
        int cant = bd.update("articulos", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1){
            Toast.makeText(this, "se modificarion los datos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No exxiste un articulo con ese codigo", Toast.LENGTH_SHORT).show();
        }
    }
}
