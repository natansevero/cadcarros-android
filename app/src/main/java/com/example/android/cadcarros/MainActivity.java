package com.example.android.cadcarros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.cadcarros.dao.CarroDao;
import com.example.android.cadcarros.model.Carro;

public class MainActivity extends AppCompatActivity {

    CarroDao dao;

    EditText placa;
    EditText fabricante;
    EditText modelo;
    Spinner cor;
    EditText ano;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();

        dao = new CarroDao();

        placa = (EditText) findViewById(R.id.placa_edit_view);
        fabricante = (EditText) findViewById(R.id.fabricante_edit_view);
        modelo = (EditText) findViewById(R.id.modelo_edit_view);
        cor = (Spinner) findViewById(R.id.color_car_spinner);
        ano = (EditText) findViewById(R.id.ano_edit_view);
    }

    private void createSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.color_car_spinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_car_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void salvarCarro(View view){
        if (placa.getEditableText().toString().equals("")){
            Toast toastPlaca = Toast.makeText(this, "É necessario infomar a Placa", Toast.LENGTH_SHORT);
            toastPlaca.show();
        } else {
            Carro carro = new Carro();
            carro.setPlaca(placa.getEditableText().toString());
            carro.setFabricante(fabricante.getEditableText().toString());
            carro.setModelo(modelo.getEditableText().toString());
            carro.setCor(cor.getSelectedItem().toString());
            int anoCarro = Integer.parseInt(ano.getEditableText().toString());
            carro.setAno(anoCarro);

            dao.add(carro);
            Log.v("Novo Carro: ", carro.toString());

            Toast toastSalvar = Toast.makeText(this, "Carro adicionado! Placa: " + carro.getPlaca(), Toast.LENGTH_SHORT);
            toastSalvar.show();

            limparCampos();
        }
    }

    public void buscarCarro(View view){
        Carro carro = dao.read(placa.getEditableText().toString());
        if(carro != null){
            fabricante.setText(carro.getFabricante());
            modelo.setText(carro.getModelo());
            int position = adapter.getPosition(carro.getCor());
            cor.setSelection(position);
            ano.setText(""+carro.getAno());
        } else {
            Toast toastBuscar = Toast.makeText(this, "Esta Placa não existe", Toast.LENGTH_SHORT);
            toastBuscar.show();
        }
    }

    public void editarCarro(View view){
        if (placa.getEditableText().toString().equals("")){
            Toast toastPlaca = Toast.makeText(this, "É necessario infomar a Placa", Toast.LENGTH_SHORT);
            toastPlaca.show();
        } else {
            Carro carro = new Carro();
            carro.setPlaca(placa.getEditableText().toString());
            carro.setFabricante(fabricante.getEditableText().toString());
            carro.setModelo(modelo.getEditableText().toString());
            carro.setCor(cor.getSelectedItem().toString());
            int anoCarro = Integer.parseInt(ano.getEditableText().toString());
            carro.setAno(anoCarro);

            dao.update(carro);
            Log.v("Update Carro: ", carro.toString());

            Toast toastEditar = Toast.makeText(this, "Carro Editado! Placa: " + carro.getPlaca(), Toast.LENGTH_SHORT);
            toastEditar.show();

            limparCampos();
        }
    }

    public void excluirCarro(View view){
        if (placa.getEditableText().toString().equals("")){
            Toast toastPlaca = Toast.makeText(this, "É necessario infomar a Placa", Toast.LENGTH_SHORT);
            toastPlaca.show();
        } else {
            Carro carro = new Carro();
            carro.setPlaca(placa.getEditableText().toString());
            carro.setFabricante(fabricante.getEditableText().toString());
            carro.setModelo(modelo.getEditableText().toString());
            carro.setCor(cor.getSelectedItem().toString());
            int anoCarro = Integer.parseInt(ano.getEditableText().toString());
            carro.setAno(anoCarro);

            if(dao.remove(carro)){
                Toast toastExcluir = Toast.makeText(this, "Carro Excluido!", Toast.LENGTH_SHORT);
                toastExcluir.show();
                limparCampos();
            } else {
                Toast toastExcluir = Toast.makeText(this, "Erro ao Excluir!", Toast.LENGTH_SHORT);
                toastExcluir.show();
            }
        }
    }

    private void limparCampos(){
        placa.setText("");
        fabricante.setText("");
        modelo.setText("");
        cor.setSelection(0);
        ano.setText("");
    }

}
