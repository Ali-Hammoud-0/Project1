package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import webservice.EmployeeWebService;

public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.addHeader("Vary", "Origin");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.addHeader("Produces", "application/json");
        switch(uri) {
        case "/Project1/getCredentials.do": {
        	EmployeeWebService.getCreds(request, response);
        	break;
        	}
		case "/Project1/initForm.do": {
	    	EmployeeWebService.initForm(request, response);
	    	break;
	    }
		case "/Project1/addForm.do": {
	    	EmployeeWebService.addForm(request, response);
	    	break;
	    }
		case "/Project1/initFormView.do": {
	    	EmployeeWebService.initFormView(request, response);
	    	break;
	    }
    }
		
		
	}
}
