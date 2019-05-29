package com.capgemini;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.AccountFormFields;
import com.capgemini.beans.AccountType;

@RestController
public class Controller {
	
	@GetMapping("/getexample")
    public ResponseEntity<AccountFormFields> getExample() {
		
		AccountFormFields accountFormFields = new AccountFormFields();
		accountFormFields.setAccountType(AccountType.CHECKING);
		accountFormFields.setBalance(400.0);
		accountFormFields.setDob("01/01/2000");
		accountFormFields.setEmail("falko@email.com");
		accountFormFields.setFirstName("firstName");
		accountFormFields.setHomeAddress("100 homeAddress");
		accountFormFields.setLastName("lastName");
		accountFormFields.setMailingAddress("100 mailingAddress");
		accountFormFields.setMobileNumber("123456789");
		accountFormFields.setSsn("123-45-6789");
		
		
		return new ResponseEntity<>(
      	      accountFormFields,  HttpStatus.OK);
	}

}
