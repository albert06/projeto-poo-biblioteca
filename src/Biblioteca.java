import java.util.ArrayList;

import Ifrn.tads.poo.biblioteca.materialdeleitura.*;

public class Biblioteca {
	String nomeBiblioteca;
	
	ArrayList<Livro> livros = new ArrayList<Livro>();
	ArrayList<Apostila> apostilas = new ArrayList<Apostila>();
	ArrayList<Texto> textos = new ArrayList<Texto>();
	
	public boolean verificarISBN(String num){
		boolean verdade  = false;
		if(num.length() == 13){
			if((num.charAt(0) == '9') & (num.charAt(1) == '7') & (num.charAt(2) == '8')){
				verdade  = true;
			}			
		}
		return verdade;
	}
	public void adicionarLivro(Livro novo){
		livros.add(novo);
	}
	public void adicionarApostila(Apostila nova){
		apostilas.add(nova);
	}
	public void adicionarTexto(Texto novo){
		textos.add(novo);
	}
}
