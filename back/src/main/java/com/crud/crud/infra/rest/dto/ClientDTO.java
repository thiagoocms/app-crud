package com.crud.crud.infra.rest.dto;

public class ClientDTO {

    private Long id;

    private String name;

    private String fone;

    private String email;

    private String job;

    private String birth;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String fone, String email, String job, String birth) {
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
