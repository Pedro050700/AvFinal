package connection.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
		factory.close();
	}
}
