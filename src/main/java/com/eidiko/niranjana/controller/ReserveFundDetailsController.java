 package com.eidiko.niranjana.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.ReserveFundDetails;
import com.eidiko.niranjana.exception.EmployeeNotFoundException;
import com.eidiko.niranjana.service.ReserveFundDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ReserveFundDetailsController {

	@Autowired
	private ReserveFundDetailsService service;
// =================================Count Method===========
	@GetMapping("/count")
	public long reserveFundDataCount() {
		log.info("..........Count Method.............");
		return service.countNUmberOfData();
	}
// =================================existById method==============================================
	@GetMapping("/checkDataById/{ID}")
	public String checkingreserveFundDataById(@PathVariable(value = "ID") Integer id) {
		boolean status = false;
		log.info(".........existById method..............");
			//status = service.checkReserveFundDetailsDataById(id);
			log.info("boolean data having :"+status);
//			if(status==true)
//			{
//				
//			return "Is Given ID " + id + " data present in DB ? " + status;
//			}
//			else
//			{
//				log.info("Given ID " + id + " data not there in Database");
//				return "Is Given ID " + id + " data present in DB ? " + status;
//			}
			
		try {
			status = service.checkReserveFundDetailsDataById(id);
			if(status)
			return "Is Given ID " + id + " data present in DB ? " + status;
			else
				throw new RuntimeException("Is Given ID " + id + " data not present in DB ? " + status);
		}
		 catch (Exception se) {
			se.printStackTrace();
			log.error("Given ID " + id + " data not there in Database");
			return "Is Given ID " + id + " data present in DB ? " + status;
		}
	}
// ============================findAll method=====================================================
	@GetMapping("/fetchAllData")
	public Iterable<ReserveFundDetails> reserveFundDataFetching() {
		log.info(".........findAll method..............");
		Iterable<ReserveFundDetails> list = service.retrieveReserveFundDetailsAllData();
		log.info("ReserveFundDetails data are:" + list);
		for (ReserveFundDetails lists : list) {
			log.info("Reserve_fund_Id" + lists.getReserveFundId());
		}
		return list;
	}
// ============================findAllById method===================================================
//	//process 1:
	@GetMapping("/fetchAllDataById/{ID}/{IDD}")
	public Iterable<ReserveFundDetails> reserveFundDataFetchingById(@PathVariable(value = "ID") Integer id,@PathVariable(value = "IDD") Integer idd) {
		log.info("------findAllById method process 1--------");
		Iterable<ReserveFundDetails> listDetail = service.retrieveReserveFundDetailsDataById(Arrays.asList(id,idd));
		log.info("ReserveFundDetails data are:" + listDetail);
		for (ReserveFundDetails lists : listDetail) {
			log.info("Reserve_fund_Id: " + lists.getReserveFundId());
		}
		return listDetail;
	}
	//process 2:
		@GetMapping("/fetchAllDataById1/{ID}/{IDD}")
		public Iterable<ReserveFundDetails> reserveFundDataFetchingById1(@PathVariable(value = "ID") Integer id,@PathVariable(value = "IDD") Integer idd){
		log.info("------findAllById method process 2--------");
		List<Integer> list = new ArrayList();
		list.add(4);
		list.add(5);
		Iterable<ReserveFundDetails> listDetail = service.retrieveReserveFundDetailsDataById(list);
		log.info("ReserveFundDetails data are:" + listDetail);
		for (ReserveFundDetails lists : listDetail) {
				log.info("Reserve_fund_Id: " + lists.getReserveFundId());
		}
		return listDetail;
	}
//=================================findById() method==============================================================	
	//process :: 1
	@GetMapping("/fetchSpecificDataById/{id}")
	public ResponseEntity<?> reserveFundSpecificDataFetchingById(@PathVariable Integer id) throws EmployeeNotFoundException  {
		log.info("------findById() method--------");
		ReserveFundDetails retrieveReserveFundDataById = this.service.retrieveReserveFundDataById(id);
		 return new ResponseEntity<ReserveFundDetails>(retrieveReserveFundDataById, HttpStatus.OK);
	}	
	//process :: 2
	@GetMapping("/fetchSpecificDataById1/{id}")
	public ResponseEntity<?> reserveFundSpecificDataFetchingById1(@PathVariable Integer id) throws EmployeeNotFoundException {
		log.info("------findById() method--------");
		 Optional<ReserveFundDetails> retrieveReserveFundDataById = this.service.retrieveReserveFundDetailsById1(id);
		 return new ResponseEntity<Optional<ReserveFundDetails>>(retrieveReserveFundDataById, HttpStatus.OK);
	}
//=========================save() method==========================================================	
	@PostMapping("/saveRfdData")
	public ReserveFundDetails saveReserveFundData(@RequestBody ReserveFundDetails rdf) 
	{
		log.info("------save() method--------");
		System.out.println("Data: "+rdf);
		ReserveFundDetails savedData = service.saveResearchFundData(rdf);
		 System.out.println("ReserveFundDetails savedData: "+savedData);
		 return savedData;
	}
//=========================saveAll() method==========================================================	
	@PostMapping("/saveAllRfdData")
	public Iterable<ReserveFundDetails> saveAllReserveFundData(@RequestBody Iterable<ReserveFundDetails> rdf) 
	{
		log.info("------saveAll() method--------");
		System.out.println("jjjj>>>>"+rdf);
		Iterable<ReserveFundDetails> savedData = this.service.saveListOfResearchFundData(rdf);
		 System.out.println("ReserveFundDetails saved List of Data: "+savedData);
		 return savedData;
	}
}























//	@PostMapping("/fetchSpecificDataById1")
//	public ReserveFundDetails reserveFundSpecificDataFetchingById1(@RequestBody ReserveFundDetails reserve)
//	{
//		System.out.println("------findById method--------");
//		ReserveFundDetails details = service.retrieveReserveFundDataById(reserve.getRESERVE_FUND_ID());
//		System.out.println(details);
//		return details;
//	}

//ResponseEntity details = this.service.retrieveReserveFundDataById(id);
//log.info("ReserveFundDetails: "+details);
//return details;
//if(id!=5) {
//	 throw new EmployeeNotFoundException("EmployeeID Not Found"+id);
// }

//if(retrieveReserveFundDataById==null)
//{
//	 throw new EmployeeNotFoundException("EmployeeID Not Found"+id);
//}
//return retrieveReserveFundDataById;