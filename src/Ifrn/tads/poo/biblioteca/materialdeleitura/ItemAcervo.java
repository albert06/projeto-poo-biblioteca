package Ifrn.tads.poo.biblioteca.materialdeleitura;
import java.util.Calendar;
import java.util.Date;
public abstract class ItemAcervo{
	double custo;
	boolean pago;
	Date dataAluguel,dataDevolucao;
	Calendar cal = Calendar.getInstance();
	int codigoItem;
	
	public void setCusto(double custo){
		this.custo = custo;
	}
	public double getCusto(){
		return this.custo;
	}
	public boolean getPago(){
		return this.pago;
	}
	public int getCodigoItem(){
		return this.codigoItem;
	}
	public void setDataAluguel(Date data){
		this.dataAluguel = data;
	}
	public void setDataDevolucao(Date data){
		this.dataDevolucao = data;
	}
	public void alugar(Date dataAluguel, int prazo){
		this.dataAluguel = dataAluguel;
		this.cal.setTime(dataAluguel);
		this.cal.add(Calendar.DAY_OF_MONTH, prazo);
		this.dataDevolucao  = this.cal.getTime();
	}
}