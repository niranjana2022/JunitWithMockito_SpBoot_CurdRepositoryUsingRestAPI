package com.eidiko.niranjana.testService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eidiko.niranjana.entity.ReserveFundDetails;
import com.eidiko.niranjana.repo.ReserveFundDetailsRepo;
import com.eidiko.niranjana.service.ReserveFundDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;
@WebMvcTest(value = ReserveFundDetailsServiceImpl.class)
@Slf4j
public class ReserveFundDetailsServiceTest {
	
	// create MockService by using @MockBean
		@MockBean
		private ReserveFundDetailsRepo repo;
		@Autowired
		private ReserveFundDetailsServiceImpl serviceImpl;
		
	@Test
	public void testCountNUmberOfData()
	{
		log.info("----countNUmberOfData() method using 'count'-----");
			long longValue = 2L;
			Mockito.when(repo.count()).thenReturn(longValue);
			Assertions.assertEquals(2, serviceImpl.countNUmberOfData());
	}
		
		@Test
		public void testCheckReserveFundDetailsDataById()
		{
			log.info("----checkReserveFundDetailsDataById() method using 'existById'-----");
				boolean status = false;
				Mockito.when(repo.existsById(ArgumentMatchers.any())).thenReturn(true);
				Assertions.assertEquals(true, serviceImpl.checkReserveFundDetailsDataById(1));
		}
		
		@Test
		public void testRetrieveReserveFundDetailsAllData()
		{
			log.info("----retrieveReserveFundDetailsAllData() method using 'findAll'-----");
			List<ReserveFundDetails> list = new ArrayList<ReserveFundDetails>();
			ReserveFundDetails rfd = new ReserveFundDetails(1,"77","88",99,66,"33","44","66","33","66");
			list.add(rfd);
			Iterable<ReserveFundDetails> iterable = list;
			Mockito.when(repo.findAll()).thenReturn(iterable);
			Assertions.assertEquals(iterable, serviceImpl.retrieveReserveFundDetailsAllData());
		}
		
		@Test
		public void testSaveResearchFundData()
		{
			ReserveFundDetails details = new ReserveFundDetails(1,"77","88",99,66,"33","44","66","33","66");
			Mockito.when(repo.save(details)).thenReturn(details);
			Assertions.assertEquals(details, serviceImpl.saveResearchFundData(details));
		}
	

}
