package com.ayoub.resourciumoptima;

import com.ayoub.resourciumoptima.Services.EmployeeService;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserIdentityImp implements HttpAuthenticationMechanism
{
    EmployeeService employeeService;


    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest req, HttpServletResponse httpServletResponse, HttpMessageContext httpMessageContext) throws AuthenticationException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        if(employeeService.checkLogin(username, password)!=null){
            return AuthenticationStatus.SUCCESS;
        }
        return AuthenticationStatus.NOT_DONE;
    }

    @Override
    public AuthenticationStatus secureResponse(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
        return HttpAuthenticationMechanism.super.secureResponse(request, response, httpMessageContext);
    }

    @Override
    public void cleanSubject(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) {
        HttpAuthenticationMechanism.super.cleanSubject(request, response, httpMessageContext);
    }
}
