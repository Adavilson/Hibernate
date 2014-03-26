package bancodados;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class HibernateTeste {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		List list = session.createCriteria(Funcionario.class).list();

		System.out.println("Funcionarios: " + list.size());

		//Busca
		session.createCriteria(Funcionario.class).add(
				Restrictions.eq("nome", "Adavilson"))
				//.add(Restrictions.like("nome", "Adavilson", MatchMode.ANYWHERE));
				//.add(Restrictions.ilike("nome", "Adavilson", MatchMode.ANYWHERE));
				//.uniqueresult();
				.list();		
		// Insere funcionario
		// Funcionario f = new Funcionario();
		// f.setNome("Adavilson");
		// f.setValorHora(1F);
		// //f.setId(list.size() + 1); podera omitir o id, por esta gerando
		// automatico
		// session.save(f);
		

		// busca funcionario
		// Funcionario f = (Funcionario) session.get(Funcionario.class, 1);
		// f.setValorHora(15F);
		// session.update(f);

		// deleta funcionario
		Funcionario f = (Funcionario) session.get(Funcionario.class, 1);
		session.delete(f);

		session.getTransaction().commit();
		session.close();
	}

}
