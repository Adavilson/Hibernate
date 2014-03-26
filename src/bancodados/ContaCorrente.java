package bancodados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta_corrente")//dizer qual a tabela
public class ContaCorrente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "conta")
	private String conta;
	
	@Column(name = "saldo")
	private Float saldo = 0F;

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Float getSaldo() {
		return saldo;
	}
	
	public ContaCorrente(){
		
	}
	
	public ContaCorrente (String conta){
		this.conta = conta;
	}
	
	public Boolean Sacar(Float saque){
		if (saque < saldo){
			saldo = saldo-saque;
			return true;
		}else{
			return false;
		}
	}
	
	public void Depositar(Float deposito){
		saldo = saldo+deposito;
	}
	

}
