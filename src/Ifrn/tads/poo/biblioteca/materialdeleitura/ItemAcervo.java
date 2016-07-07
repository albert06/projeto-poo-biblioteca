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
	
	public void alugar(Date dataAluguel, int prazo){
		this.dataAluguel = dataAluguel;
		this.cal.setTime(dataAluguel);
		this.cal.add(Calendar.DAY_OF_MONTH, prazo);		
	}
}