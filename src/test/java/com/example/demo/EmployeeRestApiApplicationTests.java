package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Employee;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class EmployeeRestApiApplicationTests {
	
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@LocalServerPort
    int randomServerPort;
	
	@Test
	public void testAddEmployee() throws URISyntaxException {
		
		Employee employee = new Employee("Jim", "Smith", 3333, "HR");
		HttpHeaders headers = new HttpHeaders();
	      
	        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/addEmployee/";
	        URI uri = new URI(baseUrl);
	        
	        HttpEntity<Employee> request = new HttpEntity<Employee>(employee, headers);
	         
	        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	                	         
	        //Verify request succeed
	        Assertions.assertEquals(201, result.getStatusCodeValue());
	}
	
	@Test
	public void testUpdateEmployee() throws URISyntaxException {
		
		Employee employee = new Employee("Rick", "Martin", 1111, "HR");
		HttpHeaders headers = new HttpHeaders();
	      
	        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/updateEmployee/";
	        URI uri = new URI(baseUrl);
	        
	        HttpEntity<Employee> request = new HttpEntity<Employee>(employee, headers);
	         
	        restTemplate.put(uri, request);
	                	         
	}
	
	@Test
    public void testGetEmployeeList() throws URISyntaxException 
    {
             
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/employeeList";
        URI uri = new URI(baseUrl);
         
        HttpHeaders headers = new HttpHeaders();
         
        HttpEntity<Employee> requestEntity = new HttpEntity<>(null, headers);
 
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
             
        Assertions.assertEquals(200, result.getStatusCodeValue());
      
    }
	
	@Test
    public void testGetEmployee() throws URISyntaxException 
    {
           
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/getEmployee/1112";
        URI uri = new URI(baseUrl);
         
        HttpHeaders headers = new HttpHeaders();
         
        HttpEntity<Employee> requestEntity = new HttpEntity<>(null, headers);
 
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
             
        Assertions.assertEquals(200, result.getStatusCodeValue());
      
    }
	
	@Test
	public void testDeleteEmployee() throws URISyntaxException {
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/employees/deleteEmployee/1113";
	    URI uri = new URI(baseUrl);
	        
	    restTemplate.delete(uri);
	 
	}

}
