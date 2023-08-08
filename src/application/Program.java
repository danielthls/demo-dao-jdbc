package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		System.out.println("=== TESTE 1: findById Seller ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		System.out.println();
		System.out.println("=== TESTE 2: findByDepartment Seller ===");
		Department dep = new Department(4,null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		list.forEach(System.out::println);
		
		System.out.println();
		System.out.println("=== TESTE 3: findAll Seller ===");
		List<Seller> list2 = sellerDao.findAll();
		
		list2.forEach(System.out::println);
		
		System.out.println("=== TESTE 4: insert Seller ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.0, dep);
		sellerDao.insert(newSeller);
		
		System.out.println("\n=== TESTE 5: update Seller ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update complete");
		
		System.out.println("\n=== TESTE 6: delete Seller ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		
		System.out.println("Delete complete");
		
		sc.close();
	}

}
