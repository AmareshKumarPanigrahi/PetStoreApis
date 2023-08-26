package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserCrudOperations;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTest {

	public UserPayload up;
	public String username;
	Faker fk;
	 
	
	@BeforeClass
	public void userPayload() {
		
		fk=new Faker();
		
		up=new UserPayload();
		
		up.setEmail(fk.internet().emailAddress());
		up.setFirsetname(fk.name().firstName());
		up.setId(fk.idNumber().hashCode());
		up.setLastname(fk.name().lastName());
		up.setPasswoed(fk.internet().password(5, 10));
		up.setPhone(fk.phoneNumber().cellPhone());
		up.setUsername(fk.name().username());
		username=up.getUsername();
		
	}
	
	@Test(priority=0)
	public void createUser() {
		
		Response response = UserCrudOperations.createUser(up);
		
		      response.then().statusCode(200);
		      response.then().log().all();
		      
	}
	
	@Test(priority=1)
	public void getUser() {
		
		Response response = UserCrudOperations.readUser(this.up.getUsername());
		
		response.then().log().all();
		
		
		
	}
	
	@Test(priority=2)
	public void upadteUser() {
		
		up.setEmail(fk.internet().emailAddress());
		up.setFirsetname(fk.name().firstName());
		up.setLastname(fk.name().lastName());

		
		
		Response response = UserCrudOperations.updateUser(this.up.getUsername(), up);
		
		response.then().log().body();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		//checking data after updation
		Response response1 = UserCrudOperations.readUser(this.up.getUsername());
		response1.then().log().all();
	}
	
	
	@Test(priority=3)
	public void deleteUser() {
		
		Response response = UserCrudOperations.deleteUser(this.up.getUsername());
		
		int statuscode = response.getStatusCode();
		response.then().log().all();
		System.out.println(statuscode);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
