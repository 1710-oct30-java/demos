package com.revature.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

	public void writeByte(int output) throws IOException {
		FileOutputStream fos = new FileOutputStream("test.txt");
		fos.write(output);

	}

	public int readByte() throws IOException {
		FileInputStream fis = new FileInputStream("test.txt");
		return fis.read();
	}

	public void writeChar(String c) throws IOException {
		FileWriter fw = new FileWriter("char.txt");
		fw.write(c);
		fw.flush();
		fw.close();
	}

	public char readChar() throws IOException {
		FileReader fr = new FileReader("char.txt");
		return (char) fr.read();
	}

	public void writeLine(String line) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("buffered.txt"));
		bw.write(line);
		bw.newLine();
		bw.flush();
		bw.close();

	}

	public String readLine(int lineNumber) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buffered.txt"));
		String read = null;
		for (int i = 0; i <= lineNumber; i++) {
			if (i == lineNumber) {
				read = br.readLine();
			} else {
				br.readLine();
			}
		}
		br.close();
		return read;
	}

	public List<String> readWholeFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buffered.txt"));
		// String wholeFile = br.lines().reduce( (acc, each) -> {
		// return acc += each + "\n";
		// }).get();
		List<String> wholeFile = br.lines().collect(Collectors.toList());
		br.close();
		return wholeFile;
	}

}
