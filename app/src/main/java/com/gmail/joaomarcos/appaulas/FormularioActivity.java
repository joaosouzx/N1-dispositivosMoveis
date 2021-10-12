package com.gmail.joaomarcos.appaulas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome;
    private Spinner spAulas;
    private Spinner spTurnos;
    private Button btnSalvar;
    private String acao;
    private Disciplina disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = findViewById(R.id.etNome);
        spAulas = findViewById(R.id.spSalas);
        spTurnos = findViewById(R.id.spTurnos);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        acao = getIntent().getStringExtra("acao");
        if(acao.equals("editar")){
            carregarFormulario();
        }
    }

    private void carregarFormulario(){
        int idDisciplina = getIntent().getIntExtra("idDisciplina", 0);
        disciplina = DisciplinaDAO.getDisciplinaById(this, idDisciplina);
        etNome.setText(disciplina.getNome());

        String[] salas = getResources().getStringArray(R.array.salas);

        for (int i = 0; i < salas.length; i++){
            if (disciplina.getAula().equals(salas[i])){
                spAulas.setSelection(i);
                break;
            }
        }

        String[] turnos = getResources().getStringArray(R.array.turnos);

        for (int i = 0; i < turnos.length; i++){
            if (disciplina.getTurno().equals(turnos[i])){
                spTurnos.setSelection(i);
                break;
            }
        }
    }

    private void salvar(){
        String nome = etNome.getText().toString();

        if(nome.isEmpty() || spAulas.getSelectedItemPosition() == 0 || spTurnos.getSelectedItemPosition() == 0){
            Toast.makeText(this, "Você deve preencher todos os campos!", Toast.LENGTH_LONG).show();
        }else {

            if (acao.equals("inserir")) {
                disciplina = new Disciplina();
            }
            disciplina.setNome(nome);
            disciplina.setAula(spAulas.getSelectedItem().toString());
            disciplina.setTurno(spTurnos.getSelectedItem().toString());


            if (acao.equals("inserir")) {
                DisciplinaDAO.inserir(this, disciplina);
                etNome.setText("");
                spAulas.setSelection(0, true);
                spTurnos.setSelection(0, true);
            }else{
                DisciplinaDAO.editar(this, disciplina);
                finish();
            }
        }
    }
}