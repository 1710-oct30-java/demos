package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import beans.User;
import services.UserService;

public class UserController {
	private UserService us = new UserService();
	Logger log = Logger.getRootLogger();
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userURL = request.getRequestURI().substring(request.getContextPath().length() + "/user".length());
		
		if ("/".equals(userURL) || "".equals(userURL)) {

			try {
				List<User> allUsers = us.findAll();
				ObjectMapper om = new ObjectMapper();
				ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(allUsers);
				PrintWriter writer = response.getWriter();
				writer.write(json);
				
				log.debug("wrote users to body of the response");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		if ("/users/login".equals(actualURL)) {
			String json;
            try {
                log.debug("request to login received");
                
                json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
                log.trace("json received: " + json);
                
                ObjectMapper om = new ObjectMapper();
                User u = om.readValue(json, User.class);
                log.trace("username received: " + u.getUsername());
                log.trace("password received: " + u.getPassword());
                User actualUser = us.login(u);
                
                if (actualUser == null){
                	response.setStatus(401);
                }
                else {
                	request.getSession().setAttribute("user",  actualUser);
                }
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
	}
}
