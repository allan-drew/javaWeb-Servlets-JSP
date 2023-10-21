package dev.aadc.model;

public class Clientes {

    private Integer id;
    private String nome;
    private Integer idade;
    private String email;
    private Double renda;

    public Clientes () {
    }

    public Clientes(Integer id, String nome, Integer idade, String email, Double renda) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.renda = renda;
    }

    public Clientes(String nome, Integer idade, String email, Double renda) {
        this(null, nome, idade, email, renda);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }


    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", renda=" + renda +
                '}';
    }
}
