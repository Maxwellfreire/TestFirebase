package br.com.firebase;

public class Cadastro_pessoa {

    private String Name;
    private Integer Numero;
    private Long cep;
    private Float num_casa;

    public Cadastro_pessoa() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        Numero = numero;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Float getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(Float num_casa) {
        this.num_casa = num_casa;
    }
}
