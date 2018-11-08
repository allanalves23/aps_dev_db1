/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Allan
 */
public class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cidade;
    private String estado;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String email, String logradouro, int numero, String complemento, String cidade, String estado) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "*****************\n"
                + "nome=" + nome + ", "
                + "telefone=" + telefone + ", "
                + "email=" + email + ", "
                + "logradouro=" + logradouro + ", "
                + "numero=" + numero + ", "
                + "complemento=" + complemento + ", "
                + "cidade=" + cidade + ", "
                + "estado=" + estado+"\n";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
