package bancodados;

import javax.swing.JOptionPane;

import org.hibernate.Session;

public class AcessoConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Insere conta
		//		Session sessao = HibernateUtil.getSession();
		//		ContaCorrente insereConta = (ContaCorrente) sessao.get(ContaCorrente.class, 1);
		//		insereConta.setConta("123456-2");
				
		
		//Consulta
		Session sessao = HibernateUtil.getSession();
		sessao.beginTransaction();
		ContaCorrente consultarConta = (ContaCorrente) sessao.get(ContaCorrente.class, 1);
		//criteria
		JOptionPane.showInputDialog("Seu saldo é: "+(consultarConta.getSaldo())+". O que deseja fazer: /n 1 - Sacar | 2 - Depositar");
		
		
		
		
		/*//Saque
		
		Session sessao = HibernateUtil.getSession();
		ContaCorrente minhaConta = (ContaCorrente) sessao.get(ContaCorrente.class, 1);
		Boolean saqueEfetuado = minhaConta.Sacar(100F);
		
		if (saqueEfetuado = true){
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
		}else{
			JOptionPane.showMessageDialog(null, "Saldo indisponível para saque!");
		}		
		sessao.close();*/
	}

}


