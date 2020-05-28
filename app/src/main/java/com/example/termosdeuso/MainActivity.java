package com.example.termosdeuso;

import android.app.AlertDialog;
import android.app.Notification;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mviewmain = new ViewHolder();

    private static class ViewHolder {
        private EditText nome;
        private EditText cpf;
        private EditText telefone;
        private EditText email;
        private Button enviar;
        private CheckBox cb;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mviewmain.nome = findViewById(R.id.Nome);
        mviewmain.cpf = findViewById(R.id.CPF);
        mviewmain.telefone = findViewById(R.id.Telefone);
        mviewmain.email = findViewById(R.id.Email);
        mviewmain.enviar = findViewById(R.id.enviar);
        mviewmain.cb = findViewById(R.id.cb);
        this.mviewmain.enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == this.mviewmain.enviar.getId()) {
            if (validarCampos()) {
                MensagemDeErro("Dados Incorretos!");

            } else {
                MensagemDeErro("Dados Corretos!");
            }
        }
    }

    public boolean ValidarEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean validarCampos() {
        boolean resultado = false;
        if (resultado = TextUtils.isEmpty(this.mviewmain.nome.getText().toString()) || TextUtils.isEmpty(this.mviewmain.telefone.getText().toString()) || TextUtils.isEmpty(this.mviewmain.cpf.getText().toString()) || TextUtils.isEmpty(this.mviewmain.email.getText().toString())) {
            MensagemDeErro("Preencha todos os campos");
        }
        if (resultado = !ValidarEmail(this.mviewmain.email.getText().toString())) {
            this.mviewmain.email.setError("Email Invalido!");
            this.mviewmain.email.requestFocus();
        }
        if (resultado = !this.mviewmain.cb.isChecked()) {
            MensagemDeErro("Aceite os termos de Uso!");
        }

        return resultado;
    }

    private void MensagemDeErro(String mensagem) {
        AlertDialog.Builder Msg = new AlertDialog.Builder(this);
        Msg.setMessage(mensagem);
        Msg.setNeutralButton("OK", null);
        Msg.create();
        Msg.show();

    }
}


