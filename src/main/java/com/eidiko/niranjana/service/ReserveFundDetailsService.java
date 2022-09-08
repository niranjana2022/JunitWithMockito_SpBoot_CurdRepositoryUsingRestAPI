package com.eidiko.niranjana.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.ReserveFundDetails;
import com.eidiko.niranjana.exception.EmployeeNotFoundException;

@Service
public interface ReserveFundDetailsService {
	//count method, which return type is "long"
	public long countNUmberOfData();
	
	//existById, which return type is "boolean"
	public boolean checkReserveFundDetailsDataById(Integer id);
	
	//findAll() method, which return type is "Iterable<T>" (T->means Type:-any data type, Entity class...etc )
	public Iterable<ReserveFundDetails> retrieveReserveFundDetailsAllData();
	
	
	//findAllById(Iterable<ID> id), which return type is "Iterable<T>" and method arguments also Iterable<ID datatype>
	public Iterable<ReserveFundDetails> retrieveReserveFundDetailsDataById(Iterable<Integer> id);
	
	//findById(ID id), which return type is "Optional<T>"
	public ReserveFundDetails retrieveReserveFundDataById(Integer id) throws EmployeeNotFoundException;
	public Optional<ReserveFundDetails> retrieveReserveFundDetailsById1(Integer id) throws EmployeeNotFoundException;
	
	
	//save() method
	public ReserveFundDetails saveResearchFundData(ReserveFundDetails rdf);

	
	//saveAll() method
	public Iterable<ReserveFundDetails> saveListOfResearchFundData(Iterable<ReserveFundDetails> listRdf);

	
	
	
	
	
	
	
	
	
	//public Optional<ReserveFundDetailsDTO> retrieveReserveFundDetailsById2(Integer id);
	
	
	

}
