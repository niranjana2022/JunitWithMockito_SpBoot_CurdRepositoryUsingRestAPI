//package com.eidiko.niranjana.runner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.eidiko.niranjana.entity.ReserveFundDetails;
//import com.eidiko.niranjana.service.ReserveFundDetailsService;
//@Component
//public class ReserveFundDetailsRunner implements CommandLineRunner {
//	
//	@Autowired
//	private ReserveFundDetailsService service;
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("..........Count Method.............");
//		System.out.println(service.countNUmberOfData());
//		System.out.println();
////===============================================================================		
//		System.out.println(".........exisyById method..............");
//		System.out.println(service.retrieveReseatchFundDetailsDataById(7));
//		System.out.println();
////===============================================================================	
//		System.out.println(".........findAll method..............");
//		Iterable<ReserveFundDetails> list = service.retrieveReserveFundDetailsData();
//		//process1: using enhanced for loop
//		for(ReserveFundDetails lists : list)
//		{
//			System.out.println(lists);
//		}
//		//process2: using forEach method
//		list.forEach(rfd->{ System.out.println(rfd);});
//		System.out.println();
//		//process3: using forEach method
//		list.forEach(rfd->System.out.println(rfd));
//		System.out.println();
//		//process4: using both forEach method + static reference method
//		list.forEach(System.out::print);
//		System.out.println();
//		//process5: using both forEach method + stream api + static reference method
//		Arrays.asList(list).stream().forEach(System.out::print);
//		System.out.println();
////===============================================================================		
//		System.out.println("------findAllById method--------");
//		//return service.retrieveReserveFundDetailsDataById(5); //because it takes list of id(Iterable id)
//	//process1	
//		List<Integer> listIds = new ArrayList();
//		listIds.add(7);
//		listIds.add(9);
//		listIds.add(71);
//		System.out.println("The retrieve datas are by Id:"+service.retrieveReserveFundDetailsDataById(listIds)); //Mutuable list, we can't modify
//		System.out.println();
//	//process2
//		System.out.println("The retrieve datas are by Id:"+service.retrieveReserveFundDetailsDataById(List.of(7,9,71)));//from java9(Immutable list:- we can't modify the content)
//		System.out.println();							//List.of(..),Set.of(..),Map.of(..) these are static factory method,returning Immutable List,Set,Map Collection
//	//process3                                         //if given id is not there in DB then it also gives the other data because it takes the (OR) format.. 
//		System.out.println("The retrieve datas are by Id:"+service.retrieveReserveFundDetailsDataById(Arrays.asList(7,9,71)));//java 1.0//Mutuable list
//		System.out.println();
////===============================================================================
//		System.out.println("------findById method--------");
//		System.out.println(service.retrieveReserveFundDataById(71));
//		//System.out.println(service.retrieveReserveFundDataById(73));//record not found
//		System.out.println(service.retrieveReserveFundDataById(73));
//		
//	}
//}
