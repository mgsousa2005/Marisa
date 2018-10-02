package br.com.marisa.torresDeHanoi;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class TorresDeHanoiTest {
	private final String BASE_PATH = "http://localhost:8080/torresDeHanoi/";
    private RestTemplate restTemplate;    
    
    public TorresDeHanoiTest() {
		this.restTemplate = new RestTemplate();
	}

	@Test
	public void test1() {
		String[] results = this.restTemplate.getForObject(BASE_PATH + 3, String.class).split(": ");
		Assert.assertEquals("7", results[1]);
	}
	
	@Test
	public void test2() {
		String[] results = this.restTemplate.getForObject(BASE_PATH + 4, String.class).split(": ");
		Assert.assertEquals("15", results[1]);
	}
	
	@Test
	public void test3() {
		String[] results = this.restTemplate.getForObject(BASE_PATH + 5, String.class).split(": ");
		Assert.assertEquals("31", results[1]);
	}
	
	@Test
	public void test4() {
		String[] results = this.restTemplate.getForObject(BASE_PATH + 7, String.class).split(": ");
		Assert.assertEquals("127", results[1]);
	}
	
	@Test
	public void test5() {
		String[] results = this.restTemplate.getForObject(BASE_PATH + 10, String.class).split(": ");
		Assert.assertNotEquals("511", results[1]);
	}
	
}
