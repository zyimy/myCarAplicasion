package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.Cliente.RetrofitCliente;
import com.example.mycar.Entidades.Personas;
import com.example.mycar.Servicios.RetrofitApiService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private TextView tvResponse,mensaje;
    private EditText contrase,usuario,email;
    private RetrofitApiService apiService;
    private Button Entrar,confirmar;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN = 1;
    String TAG = "GoogleSignIn";
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        confirmar= findViewById(R.id.btnLogin);
        contrase = findViewById(R.id.textpassw);
        email = findViewById(R.id.txtEmail);
        btnSignIn = findViewById(R.id.btnGoogle);


        //darse de alta con google
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged( FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){ //si no es null redirigir
                    Intent intentDashboard = new Intent(getApplicationContext(), Marcas.class);
                    intentDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentDashboard);
                }
            }
        };

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                getRegistros(email.getText().toString() , contrase.getText().toString());



            }
        });
    }

    public void registrarse(View view){
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Resultado devuelto al iniciar el Intent de GoogleSignInApi.getSignInIntent (...);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            if(task.isSuccessful()){

                try {
                    // Google Sign In was successful, authenticate with Firebase
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                    firebaseAuthWithGoogle(account.getIdToken());
                } catch (ApiException e) {
                    // Google Sign In fallido, actualizar GUI
                    Log.w(TAG, "Google sign in failed", e);

                }

            }else{
                Log.d(TAG, "Error, login no exitoso:" + task.getException().toString());
                Toast.makeText(this, "Ocurrio un error. "+task.getException().toString(), Toast.LENGTH_LONG).show();
            }

        }


    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            //Iniciar DASHBOARD u otra actividad luego del SigIn Exitoso
                            Intent dashboardActivity = new Intent(Login.this, Marcas.class);
                            startActivity(dashboardActivity);
                            Login.this.finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());

                        }
                    }
                });
    }

    protected void onStart() {
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null){ //si no es null el usuario ya esta logueado
            //mover al usuario al dashboard
            Intent dashboardActivity = new Intent(this, Marcas.class);
            startActivity(dashboardActivity);
        }
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);
        super.onStart();
    }



    private void initValues(){
        apiService = RetrofitCliente.getApiService();
    }


   //Metodo para confirmar contraseña
    public  void getRegistros(String correo_electronico,String contrasena){

        apiService.getPersonaId(correo_electronico,contrasena).enqueue(new Callback<List<Personas>>() {
            @Override
            public void onResponse(Call<List<Personas>> call, Response <List<Personas>> response) {
                List<Personas>listapersonas = response.body();

                try {
                    if (response.isSuccessful()){


                        Toast.makeText(Login.this,"Datos correctos",Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Login.this,Marcas.class);
                        startActivity(intent);
                    }else{

                        Toast.makeText(Login.this,"contraseña o usuario incorrectos",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(Login.this,"contraseña o usuario incorrectos",Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call <List<Personas>> call, Throwable t) {

                Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}


