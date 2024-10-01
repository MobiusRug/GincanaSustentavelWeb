package br.com.springboot.model;

public class Status {
    private Categoria categoria;
    private Float quantidadeTotal;

    public Status(Categoria categoria, Float quantidadeTotal) {
        this.categoria = categoria;
        this.quantidadeTotal = quantidadeTotal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Float getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Float quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
}
