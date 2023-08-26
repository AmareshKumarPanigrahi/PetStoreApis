package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import api.endpoints.UserCrudOperations;
import api.payload.UserPayload;
import api.utilities.DataProvider;
import io.restassured.response.Response;

public class DataDrivenTesting {

	
	
	@Test(dataProvider="Data",dataProviderClass=DataProvider.class)
	public void dataDrivenCreate_User(String userid,String username,String firstname,String lastname,String email,String password,String phn) {
	
		UserPayload up=new UserPayload();
		
		int id=Integer.parseInt(userid);
		
		up.setEmail(email);
		up.setFirsetname(firstname);
		up.setId(id);
		up.setLastname(lastname);
		up.setPasswoed(password);
		up.setPhone(phn);
		up.setUsername(username);
	
		Response res = UserCrudOperations.createUser(up);
		
		res.then().log().all();
		
	}
}
