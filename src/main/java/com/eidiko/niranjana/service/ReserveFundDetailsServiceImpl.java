package com.eidiko.niranjana.service;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.ReserveFundDetails;
import com.eidiko.niranjana.exception.EmployeeNotFoundException;
import com.eidiko.niranjana.repo.ReserveFundDetailsRepo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ReserveFundDetailsServiceImpl implements ReserveFundDetailsService {

	@Autowired
	private  ReserveFundDetailsRepo repo ;
	
	public ReserveFundDetailsServiceImpl(ReserveFundDetailsRepo detailsRepo) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public long countNUmberOfData() {
		System.out.println("In Memory proxy class name:"+repo.getClass()+"......."+Arrays.toString(repo.getClass().getInterfaces()));
		System.out.println("................");
		System.out.println("methods:"+Arrays.toString(repo.getClass().getDeclaredMethods()));
		System.out.println("interface impl class is:"+repo.getClass());
		return repo.count();
	}
//=================================existsById======================================	
	@Override
	public boolean checkReserveFundDetailsDataById(Integer id) {
		return repo.existsById(id);
		
	}
//==============================findAll() method========================================
	@Override
	public Iterable<ReserveFundDetails> retrieveReserveFundDetailsAllData() {
		return  repo.findAll();
	}
//=================================findAllById() method=======================================
	@Override
	public Iterable<ReserveFundDetails> retrieveReserveFundDetailsDataById(Iterable<Integer> id) {
		return repo.findAllById(id);
	}
//=============================findById() method==================================
	@Override
	public ReserveFundDetails retrieveReserveFundDataById(Integer id) throws EmployeeNotFoundException { 
		return repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
	}
	
	@Override
	public Optional<ReserveFundDetails> retrieveReserveFundDetailsById1(Integer id)throws EmployeeNotFoundException {
//		Optional<ReserveFundDetails> opt = repo.findById(id);
//		System.out.println("data "+opt);
//		if(opt.isPresent())
//		{
//			opt.get();
//		}
//		else {
//			throw new NoSuchElementException("Data not present");
//		}
		//return opt;
		return Optional.ofNullable(repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found")));
	}
	//=============================save() method==================================	
	
	@Override
	public ReserveFundDetails saveResearchFundData(ReserveFundDetails rdf) {
		log.info("rdf: "+rdf);
		ReserveFundDetails reserveData = repo.save(rdf);
		return reserveData;	
		}
	//=============================saveAll() method==================================
	@Override
	public Iterable<ReserveFundDetails> saveListOfResearchFundData(Iterable<ReserveFundDetails> listRdf) {
		log.info("listRdf: "+listRdf);
		Iterable<ReserveFundDetails> reserveData = repo.saveAll(listRdf);
		return reserveData;
	}
	
}

















//@Override
//public Optional<ReserveFundDetails> retrieveReserveFundDataById(Integer id) {
//	return repo.findById(id).orElse(new Optional<ReserveFundDetails>());//if record not there then we get empty ReservefundDetails object
//}