package bancodados;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionfactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Funcionario.class);
		
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry registry = standardServiceRegistryBuilder.build();
		
		return configuration.buildSessionFactory(registry);
		
	}
	
	public static Session getSession(){
		return sessionfactory.openSession();
	}
}
