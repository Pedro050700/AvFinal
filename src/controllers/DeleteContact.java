package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Contact;

public class DeleteContact {
	public static void main(String[] args) {
		Contact contact = new Contact();
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Contact Agenda!");
		
		System.out.println("Inform the ID you wish to delete: ");
		String id = sc.nextLine();
		
		contact.setId(Long.parseLong(id));
		
		contact = manager.find(Contact.class, contact.getId());
		
		manager.getTransaction().begin();
		manager.remove(contact);
		manager.getTransaction().commit();
		
		System.out.println("Contact details have been successfully deleted!!!");
		
		manager.close();
		sc.close();
	}
}
