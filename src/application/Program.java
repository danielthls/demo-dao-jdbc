package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		System.out.println("=== TESTE 1: findById Seller ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		System.out.println("=== TESTE 2: findByDepartment Seller ===");
		Department dep = new Department(4,null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		list.forEach(System.out::println);
	}

}
