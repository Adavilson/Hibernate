package bancodados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//entidade do banco, isso pra hibernate.
@Table(name = "funcionario")//dizer qual a tabela
public class Funcionario {
	
	@Id//diz qual será a pk do banco
	@GeneratedValue(strategy=GenerationType.AUTO)// auto incremento
	@Column(name = "id")// diz a coluna do banco será o atributo
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "valorHora")
	private Float valorHora;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValorHora() {
		return valorHora;
	}

	public void setValorHora(Float valorHora) {
		this.valorHora = valorHora;
	}
}
