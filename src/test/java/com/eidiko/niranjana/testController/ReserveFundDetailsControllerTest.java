package com.eidiko.niranjana.testController;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eidiko.niranjana.controller.ReserveFundDetailsController;
import com.eidiko.niranjana.entity.ReserveFundDetails;
import com.eidiko.niranjana.service.ReserveFundDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@WebMvcTest(value = ReserveFundDetailsController.class)
@Slf4j
public class ReserveFundDetailsControllerTest {

	// create MockService by using @MockBean
	@MockBean
	private ReserveFundDetailsService service;

	// send the request to RestAPI by using @MockMvc
	@Autowired
	private MockMvc mockMvc;

// =================================Count Method===========
	@Test
	public void testReserveFundDataCount() {
		// we need to create the MockService by using @MockBean object
		Long count = 10L;
		when(service.countNUmberOfData()).thenReturn(count);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/count");
		// send the get request to RestAPI by using MockMvc
		ResultActions perform;
		try {
			perform = mockMvc.perform(requestBuilder);
			MvcResult mvcResult = perform.andReturn();
			MockHttpServletResponse response = mvcResult.getResponse();
			int status = response.getStatus();
			log.info("status is: " + status);
			Assertions.assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error generate for sending the request and getting Response: " + e.getMessage());
		}
	}

// =================================existById method==============================================
	@Test
	public void testCheckingreserveFundDataById() throws Exception {
		when(service.checkReserveFundDetailsDataById(ArgumentMatchers.any())).thenReturn(true);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checkDataById/289");
		// send the get request to RestAPI by using MockMvc
		ResultActions perform;
		perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		log.info("status is: " + status);
		Assertions.assertEquals(200, status);
	}

	@Test
	public void testCheckingreserveFundDataByIdIfElse() throws Exception {
		when(service.checkReserveFundDetailsDataById(1)).thenThrow(RuntimeException.class);
		Assertions.assertThrows(RuntimeException.class, new Executable() {
			@Override
			public void execute() throws Throwable {				
					 ReserveFundDetailsController controller = new ReserveFundDetailsController();
					 controller.checkingreserveFundDataById(null);
					 throw new RuntimeException();

			}
		});
	}

// ============================findAll method=====================================================
	@Test
	public void testReserveFundDataFetching() throws Exception {
		List<ReserveFundDetails> list = new ArrayList<ReserveFundDetails>();
		ReserveFundDetails rdf = new ReserveFundDetails(1, "77", "88", 99, 66, "33", "44", "66", "33", "66");
		list.add(rdf);
		// list.forEach(list::add); //also working(no garanty)
		log.info("list of data" + list);
		for (ReserveFundDetails lists : list) {
			log.info("Reserve_fund_Id" + lists.getReserveFundId());
		}
		Iterable<ReserveFundDetails> iterable = list;
		when(service.retrieveReserveFundDetailsAllData()).thenReturn(iterable);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fetchAllData");
		// send the get request to RestAPI by using MockMvc
		ResultActions perform;
		perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		log.info("status is: " + status);
		Assertions.assertEquals(200, status);
	}

// ============================findAllById method===================================================
	@Test
	public void testReserveFundDataFetchingById() throws Exception {
		List<ReserveFundDetails> list = new ArrayList();
		ReserveFundDetails rdf = new ReserveFundDetails(1, "77", "88", 99, 66, "33", "44", "66", "33", "66");
		list.add(rdf);
		log.info("list of data" + list);
		for (ReserveFundDetails lists : list) {
			log.info("Reserve_fund_Id" + lists.getReserveFundId());
		}
		Iterable<ReserveFundDetails> iterable = list;
		when(service.retrieveReserveFundDetailsDataById(ArgumentMatchers.any())).thenReturn(iterable);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fetchAllDataById/289/36");
		// send the get request to RestAPI by using MockMvc
		ResultActions perform;
		perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		log.info("status is: " + status);
		Assertions.assertEquals(200, status);
	}

	// process 2::
	@Test
	public void testReserveFundDataFetchingById1() throws Exception {
		List<ReserveFundDetails> list = new ArrayList();
		ReserveFundDetails rdf = new ReserveFundDetails(1, "77", "88", 99, 66, "33", "44", "66", "33", "66");
		list.add(rdf);
		log.info("list of data" + list);
		for (ReserveFundDetails lists : list) {
			log.info("Reserve_fund_Id" + lists.getReserveFundId());
		}
		List<Integer> listt = new ArrayList();
		listt.add(4);
		listt.add(5);
		// Iterable<ReserveFundDetails> iterable = listt;
		when(service.retrieveReserveFundDetailsDataById(listt)).thenReturn(list);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fetchAllDataById1/289/36");
		// send the get request to RestAPI by using MockMvc
		ResultActions perform;
		perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		log.info("status is: " + status);
		Assertions.assertEquals(200, status);
	}

//=================================findById() method==============================================================
	// process :: 1
	@Test
	public void testReserveFundSpecificDataFetchingById() throws Exception {
		ReserveFundDetails listData = new ReserveFundDetails(1, "77", "88", 99, 66, "33", "44", "66", "33", "66");
		listData.getReserveFundId();
		when(service.retrieveReserveFundDataById(ArgumentMatchers.any())).thenReturn(listData);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fetchSpecificDataById/1");
		// send the get request to RestAPI by using MockMvc
		ResultActions perform;
		perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		log.info("status is: " + status);
		Assertions.assertEquals(200, status);
	}

	// process :: 2
	@Test
	public void testReserveFundSpecificDataFetchingById1() throws Exception {
		ReserveFundDetails listData = new ReserveFundDetails(1, "77", "88", 99, 66, "33", "44", "66", "33", "66");
		listData.getReserveFundId();
		log.info("list of data: " + listData);
		when(service.retrieveReserveFundDataById(ArgumentMatchers.any())).thenReturn(listData);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fetchSpecificDataById1/1");
		// send the get request to RestAPI by using MockMvc
		ResultActions perform;
		perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		log.info("status is: " + status);
		Assertions.assertEquals(200, status);
	}

	// =========================save()
	// method==========================================================
	@Test
	public void testSaveReserveFundData() throws JsonProcessingException {
		ReserveFundDetails rfd = null;
		when(service.saveResearchFundData(ArgumentMatchers.any())).thenReturn(rfd);
		ReserveFundDetails reserveFunDdetails = new ReserveFundDetails(201, "123456789", "987654321", 101, 201,
				"9876543210", "Y", "074", "9.6", "01-SEPT-2022");
		ObjectMapper mapper = new ObjectMapper();
		// convert java object to JsonObject using ObjectMapper
		String rdfJson = mapper.writeValueAsString(reserveFunDdetails);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveRfdData")
				.contentType(MediaType.APPLICATION_JSON).content(rdfJson);
		// send the post request to RestAPI by using MockMvc
		ResultActions perform;
		try {
			perform = mockMvc.perform(requestBuilder);
			MvcResult mvcResult = perform.andReturn();
			MockHttpServletResponse response = mvcResult.getResponse();
			int status = response.getStatus();
			log.info("status is: " + status);
			Assertions.assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error generate for sending the request and getting Response: " + e.getMessage());
		}
	}

	// =========================saveAll()
	// method==========================================================
	@Test
	public void testSaveAllReserveFundData() throws JsonProcessingException {
		List<ReserveFundDetails> listDetails = new ArrayList<ReserveFundDetails>();
		listDetails.forEach(listDetails::add);
		Iterable<ReserveFundDetails> iterable = listDetails;
		when(service.saveListOfResearchFundData(ArgumentMatchers.any())).thenReturn(iterable);
		ObjectMapper mapper = new ObjectMapper();
		// convert java object to JsonObject using ObjectMapper
		String rdfJson = mapper.writeValueAsString(iterable);
		// create the request by using MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveAllRfdData")
				.contentType(MediaType.APPLICATION_JSON).content(rdfJson);
		// send the post request to RestAPI by using MockMvc
		ResultActions perform;
		try {
			perform = mockMvc.perform(requestBuilder);
			MvcResult mvcResult = perform.andReturn();
			MockHttpServletResponse response = mvcResult.getResponse();
			int status = response.getStatus();
			log.info("status is: " + status);
			Assertions.assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error generate for sending the request and getting Response: " + e.getMessage());
		}
	}
}
