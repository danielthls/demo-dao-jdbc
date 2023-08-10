package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		System.out.println("=== TESTE 1: insert Department ===");
		Department dep = new Department(null, "Animals");
		DepartmentDAO depdao = DAOFactory.createDepartmentDAO();
		
		depdao.insert(dep);
		System.out.println(String.format("Departamento %d inserted", dep.getId()));
		
		System.out.println("\n=== TESTE 2: update Department ===");
		dep = new Department(8, "Plants");
		depdao.update(dep);

		System.out.println("\n=== TESTE 3: delete Department ===");
		depdao.deleteById(7);
		
		System.out.println("\n=== TESTE 4: findById Department ===");
		dep = depdao.findById(8);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 5: findAll Department ===");
		List<Department> list = depdao.findAll();
		
		list.forEach(System.out::println);
	}

}
