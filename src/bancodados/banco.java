package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.xml.bind.ParseConversionEvent;

public class banco {
	public static void main(String args[]) throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.168.1.33:3306/javathin", "javathin",
				"javathin");
		
		String opcao = JOptionPane
				.showInputDialog("Opções: 1 - Novo | 2 - Pesquisa.");

		switch (Integer.parseInt(opcao)) {

		case 1:// insere no banco
			String nome = JOptionPane.showInputDialog("Digite o nome:");
			String valorHora = JOptionPane
					.showInputDialog("Digite o valor da hora:");

			String sql = "insert into funcionario (nome, valorhora) "
					+ "values (?,?) ";

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setDouble(2, Double.parseDouble(valorHora));
			pst.execute();
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
			break;

		case 2:// Select no banco
			String result = "";
			String nomePesq = JOptionPane
					.showInputDialog("Pesquisa: Digite o nome:");
			PreparedStatement select = conn
					.prepareStatement("select * from funcionario where nome =?");
			select.setString(1, nomePesq);

			ResultSet rs = select.executeQuery();
			// verifica as linhas
			while (rs.next()) {
				result += ("ID: " + rs.getInt("id") + " - Nome: "
						+ rs.getString("nome") + " - Valor Hora: "
						+ rs.getDouble("valorHora") + "\n");
			}
			rs.close();
			select.close();
			
			JOptionPane.showMessageDialog(null, result);

			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			break;
		}

		
		conn.close();

	}
}
