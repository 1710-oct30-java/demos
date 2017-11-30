package com.revature.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.revature.service.FileService;
import com.revature.token.Token;

public class FileController {
	private static Token t = Token.getToken();
	private Logger log = Logger.getRootLogger();
	private static FileController fc = new FileController();
	private FileService fs = FileService.getFileService();

	private FileController() {
	}

	public static FileController getFileController() {
		return fc;
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		log.trace("Handling post in File Controller");
		try {
			Part filePart = request.getPart("receipt");
			fs.handleFile(filePart);
		} catch (IOException | ServletException e) {
			log.error("issue with file: " + e);
		}
	}

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		if (t.validateToken(request)) {
			log.trace("Handling get in File Controller");
			String id = request.getRequestURI().substring(request.getContextPath().length() + "/file/".length());
			try {
				byte[] file = fs.getFile(id);
				OutputStream output = response.getOutputStream();
				output.write(file);
				output.close();
			} catch (IOException e) {
				log.error("issue with file: " + e);
			}
		} else {
			try {
				response.sendError(403);
			} catch (IOException e) {
				log.error("Error YOU SHOULD NOT BE HERE! " + e);
			}
		}
	}

}
