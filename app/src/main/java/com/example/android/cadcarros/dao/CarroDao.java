package com.example.android.cadcarros.dao;

import com.example.android.cadcarros.model.Carro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by natan on 09/11/16.
 */
public class CarroDao {
    private List<Carro> carros;

    public CarroDao(){
        this.carros = new ArrayList<>();
    }

    public Carro read(String placa){
        for(Carro carro: carros){
            if(carro.getPlaca().equals(placa))
                return carro;
        }
        return null;
    }

    public boolean add(Carro c){
        return carros.add(c);
    }

    public boolean update(Carro c){
        for(int i = 0; i < carros.size(); i++){
            if(carros.get(i).getPlaca().equals(c.getPlaca())){
                carros.set(i, c);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Carro c){
        return carros.remove(c);
    }

    public List listAll(){
        return carros;
    }
}
