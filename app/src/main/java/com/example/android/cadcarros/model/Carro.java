package com.example.android.cadcarros.model;

/**
 * Created by natan on 09/11/16.
 */
public class Carro {
    private String placa;
    private String fabricante;
    private String modelo;
    private String cor;
    private int ano;

    public Carro(String placa, String fabricante, String modelo, String cor, int ano) {
        this.placa = placa;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public Carro(){ }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carro carro = (Carro) o;

        if (ano != carro.ano) return false;
        if (placa != null ? !placa.equals(carro.placa) : carro.placa != null) return false;
        if (fabricante != null ? !fabricante.equals(carro.fabricante) : carro.fabricante != null)
            return false;
        if (modelo != null ? !modelo.equals(carro.modelo) : carro.modelo != null) return false;
        return cor != null ? cor.equals(carro.cor) : carro.cor == null;

    }

    @Override
    public int hashCode() {
        int result = placa != null ? placa.hashCode() : 0;
        result = 31 * result + (fabricante != null ? fabricante.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (cor != null ? cor.hashCode() : 0);
        result = 31 * result + ano;
        return result;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                '}';
    }
}
