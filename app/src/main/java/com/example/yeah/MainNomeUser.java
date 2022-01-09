package com.example.yeah;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yeah.methods.Methods;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainNomeUser extends AppCompatActivity {

    private EditText nome;
    private final Methods methods;
    private CircleImageView logo;

    public MainNomeUser(){
        methods = new Methods();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nome_user);

        nome = (EditText) findViewById(R.id.editTextNome);
        logo = (CircleImageView)findViewById(R.id.imageView10);
        logo.setImageResource(R.mipmap.ic_fun_logo);
    }

    public void BotaoNome(View view) {
        if (nome.getText().toString().equals("") || nome.getText().toString() == null) {
            Toast.makeText(getApplicationContext(),"Você Precisa de um NickName",Toast.LENGTH_SHORT).show();

        } else{
            methods.addVidas(getApplicationContext(), 4);
            methods.addPontoNivel(getApplicationContext(), 100);
            methods.salvarNomeUser(getApplicationContext(),nome.getText().toString());
            Intent intent = new Intent(getApplicationContext(),BottomNavigation.class);
            startActivity(intent);
            finish();
        }
    }

    public void onBackPressed() {

    }
}
