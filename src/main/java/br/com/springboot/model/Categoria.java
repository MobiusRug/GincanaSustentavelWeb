package br.com.springboot.model;

public enum Categoria {

	PAPEL("Papel"),
	PLASTICO("Plástico"),
	VIDRO("Vidro"),
	METAL("Metal");
	
	private String descricao;
	
	Categoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
