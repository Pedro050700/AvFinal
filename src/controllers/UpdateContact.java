package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Contact;

public class UpdateContact {
	public static void main(String[] args) {
		Contact contact = new Contact();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Contact Update");
		
		System.out.println("Inform the Id you want to change:");
		String id = sc.nextLine();
		System.out.println("Inform a new Name:");
		String name = sc.nextLine();
		System.out.println("Inform a new Telefone Number:");
		String tel = sc.nextLine();
		System.out.println("Inform a new CellPhone Number:");
		String cel = sc.nextLine();
		
		
		contact.setId(Long.parseLong(id));
		contact.setName(name);
		contact.setTel(tel);
		contact.setCel(cel);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(contact);
		manager.getTransaction().commit();
		
		System.out.println("New data sucessfully update!");
		
		sc.close();
		manager.close();
	}
}
