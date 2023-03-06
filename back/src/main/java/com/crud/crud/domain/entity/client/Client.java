package com.crud.crud.domain.entity.client;

import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="Nome", length=255)
    private String name;

    @Column(name="Telefone", length=11)
    private String fone;

    @Column(name="Email", length=255)
    private String email;

    @Column(name="Profissão", length=50)
    private String job;


    @Column(name="Data_de_nascimento", length=255)
    private String birth;

    public Client() {

    }

    public Client(Long id, String name, String fone, String email, String job, String birth) {
        this.id = id;
        this.name = name;
        this.fone = fone;
        this.email = email;
        this.job = job;
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
