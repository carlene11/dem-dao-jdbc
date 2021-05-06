package aplication;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;


public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		SellerDao sellerDao = DaoFactory.createSellerDao();


		System.out.println("===TEST 1: department findById ====");
		Department department = departmentDao.findById(6);
		System.out.println(department);

		System.out.println("\n===TEST 2: department findAll ====");
		List<Department> list =departmentDao.findAll();
		for (Department dep: list) {
			System.out.println(dep);
		}
		
		System.out.println("\n===TEST 3: department insert ====");
		Department newDepartment = new Department(null,"Men");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = "+ newDepartment.getId());

	
		System.out.println("\n===TEST 4: department update ====");
		Department departmentUpdate = departmentDao.findById(9);
		departmentUpdate.setName("Teen");
		departmentDao.update(departmentUpdate);
		System.out.println("Update completed");
		
		
		System.out.println("\n===TEST 5: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		Department dep5 = new Department(id,null);
		List<Seller> listSeller = sellerDao.findByDepartment(dep5);
		if (listSeller.isEmpty()) {
			departmentDao.deleteById(id);
			System.out.println("Delete completed");
			
		}
		else {
			System.out.println("This department can't delete!");
		}
		sc.close();
	}

}
