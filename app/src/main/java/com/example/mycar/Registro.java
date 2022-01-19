package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.Cliente.RetrofitCliente;
import com.example.mycar.Servicios.RetrofitApiService;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registro extends AppCompatActivity {

    private RetrofitApiService apiService;
    private EditText nombre,correoElectronico,contrasena;
    private Button ingresar;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        nombre = findViewById(R.id.txtNombre);
        correoElectronico = findViewById(R.id.txtCorreoElectronico);
        contrasena = findViewById(R.id.txtContrasena);
        ingresar = findViewById(R.id.btnIngresar);
        mensaje = findViewById(R.id.lblMensaje);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                ingresarPersona();
            }
        });
    }


    private void initValues(){
        apiService = RetrofitCliente.getApiService();
    }

    public  void ingresarPersona(){
        HashMap<Object,Object> map = new HashMap<>();
        map.put("nombre",nombre.getText().toString());
        map.put("correoEletronico",correoElectronico.getText().toString());
        map.put("contrasena",contrasena.getText().toString());
        apiService.getIngresar(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    if (response.isSuccessful()) {
                        //tvResponse.setText(personas.getNombre().toString());

                        Toast.makeText(Registro.this, "Datos introducidos correctamente", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Registro.this, Login.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(Registro.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(Registro.this,"Datos incorrectos",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Registro.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}