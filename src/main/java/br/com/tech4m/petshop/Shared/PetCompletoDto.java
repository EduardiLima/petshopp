package br.com.tech4m.petshop.Shared;

public class PetCompletoDto {
    private String id;
    private String nome;
    private String tipo;
    private String detalhes; // Adicione outros detalhes relevantes aqui
    
    public PetCompletoDto() {
    }

    public PetCompletoDto(String id, String nome, String tipo, String detalhes) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.detalhes = detalhes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}