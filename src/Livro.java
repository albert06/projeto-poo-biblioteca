import java.lang.Integer;
public class Livro extends ItemAcervo{
	String titulo, autor, isbn;
	int quantidade;
	Integer edicao; 
	public Livro(String titulo, String autor, String isbn, Integer edicao, int qtd){
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.edicao = edicao;
		this.quantidade = qtd;
	}
}
