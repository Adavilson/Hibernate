package bancodados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity//entidade do banco, isso pra hibernate.
@Table(name = "conta_corrente")//dizer qual a tabela
public class Depositar {
	
	@Id//diz qual será a pk do banco
	@GeneratedValue(strategy=GenerationType.AUTO)// auto incremento
	@Column(name = "id")// diz a coluna do banco será o atributo
	private Integer id;
	
	@Column(name = "conta")
	private String conta;
	
	@Column(name = "saldo")
	private Float saldo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

}
