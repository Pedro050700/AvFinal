package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Contact;

public class SearchContactById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Search...");
		System.out.println("Inform the id you wish to find:");
		String id = sc.nextLine();
		
		Contact contact = manager.find(Contact.class, Long.parseLong(id));
		System.out.println("\n=== List Contact ===");
		System.out.println("Name: " + contact.getName() + "\nTelephone Number: " + contact.getTel() + "\nCellphone Number: " + contact.getCel() + "\n--");
		
		sc.close();
		manager.close();
	}
}
