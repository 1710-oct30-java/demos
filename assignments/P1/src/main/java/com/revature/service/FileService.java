package com.revature.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOjdbc;

public class FileService {
	private static FileService fs = new FileService();
	private FileService() {}
	public static FileService getFileService()
	{
		return fs;
	}
	private Logger log = Logger.getRootLogger();
	private ReimbursementDAO rdao = ReimbursementDAOjdbc.getReimburesmentDAOjdbc();
	public void handleFile(Part filePart) {

		try {
			String id = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			InputStream fileContent = filePart.getInputStream();
			System.out.println(filePart.getHeaderNames());
			System.out.println(id);
			rdao.alterReimbursementRecieptById(Integer.parseInt(id), fileContent);
		} catch (IOException | NullPointerException e) {
			log.warn("issue with getting file " + e);
		}
		
		
	}
	public byte[] getFile(String number) {
			log.trace("getting ");
			int id = Integer.parseInt(number);
			byte[] file = rdao.getReimbursementById(id);
			log.trace("got file");
			return file;
	}
}
