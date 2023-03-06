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


}
