package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.FlashCard;
import com.revature.services.FlashCardService;

public class FlashCardController {
	private Logger log = Logger.getRootLogger();
	private FlashCardService fcs = new FlashCardService();

	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to flashcard controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/flashcard".length());

	}

	public void delegatePost(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to flashcard controller");
		String actualURL = request.getRequestURI().substring(request.getContextPath().length() + "/flashcard".length());
		
		if("".equals(actualURL)) {
			try {
				String json = request.getReader() // get the buffered reader
								.lines() // stream it
								.reduce( (acc, cur) -> acc+cur) // reduce it to a single value
								.get(); // get that single value
				log.trace("json received = " + json);
				ObjectMapper om = new ObjectMapper();
				FlashCard fc = om.readValue(json, FlashCard.class);
				log.trace("object created from json = " + fc);
				
				fcs.save(fc);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
