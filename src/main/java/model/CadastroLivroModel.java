package model;

public class CadastroLivroModel {
    
    private String codigoBarras;
    private String titulo;
    private String editora;
    private String genero;
    private String localArmazenamento;
    private String dataPublicacao;
    private String quantidade;
    private String quantidadeMin;
    private String valor;
    
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getLocalArmazenamento() {
		return localArmazenamento;
	}
	public void setLocalArmazenamento(String localArmazenamento) {
		this.localArmazenamento = localArmazenamento;
	}
	public String getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getQuantidadeMin() {
		return quantidadeMin;
	}
	public void setQuantidadeMin(String quantidadeMin) {
		this.quantidadeMin = quantidadeMin;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

     
}