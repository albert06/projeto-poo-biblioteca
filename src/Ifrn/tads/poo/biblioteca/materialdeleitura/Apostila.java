package Ifrn.tads.poo.biblioteca.materialdeleitura;

public class Apostila extends ItemAcervo{
	String titulo, autor;
	int quantidade;
	
	public Apostila(String titulo, String autor, int quantidade) {
		this.titulo = titulo;
		this.autor = autor;
		this.quantidade = quantidade;
	}
	
}
