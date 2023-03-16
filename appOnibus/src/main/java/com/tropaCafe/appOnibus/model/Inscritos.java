package com.tropaCafe.appOnibus.model;

import jakarta.persistence.*;

@Entity
public class Inscritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)//NUlllable = not null
    private String nome;

    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(length = 20, nullable = false)
    private String cpf;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void atualizar(Inscritos inscritos){
        this.nome = inscritos.getNome();
        this.email = inscritos.getEmail();
        this.telefone = inscritos.getTelefone();
        this.cpf = inscritos.getCpf();
    }


}
