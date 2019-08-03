package br.com.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText txtName, txtNumero, txtCep, txtNumCasa;
    Button btnSalvar;
    DatabaseReference reff;
    Cadastro_pessoa member;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnWeb = (Button) findViewById(R.id.btnView);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainIntent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(MainIntent);
            }
        });

        Toast.makeText(MainActivity.this, "Conectado com o banco de dados.", Toast.LENGTH_LONG).show();

        txtName = (EditText) findViewById(R.id.txtName);
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        txtCep = (EditText) findViewById(R.id.txtCep);
        txtNumCasa = (EditText) findViewById(R.id.txtNumCasa);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        member = new Cadastro_pessoa();
        reff = FirebaseDatabase.getInstance().getReference().child("Cadastro_pessoa");
        reff.keepSynced(true);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int T = Integer.parseInt(txtNumero.getText().toString().trim());
                Float NC = Float.parseFloat((txtNumCasa.getText().toString().trim()));
                Long CP = Long.parseLong(txtCep.getText().toString().trim());
                member.setName(txtName.getText().toString().trim());
                member.setNumero(T);
                member.setNum_casa(NC);
                member.setCep(CP);
                reff.child(String.valueOf("Usuário " + (maxid + 1))).setValue(member);

                Toast.makeText(MainActivity.this, "Os dados foram salvos com sucesso!", Toast.LENGTH_LONG).show();

            }
        });


    }
}
