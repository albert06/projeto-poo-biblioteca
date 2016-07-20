
public class Administrador extends Usuario{
	String loguin, senha;
	public Administrador(int codUsuario, String nome, String endereco, String cpf, String loguin, String senha) {
		super(codUsuario, nome, endereco, cpf);
		this.loguin = loguin;
		this.senha = senha;
	}
	   
}
