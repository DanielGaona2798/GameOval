package persistence;

import java.awt.Rectangle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;



public class TextFileManager {


	public TextFileManager() {
	}
	public ArrayList<Rectangle> readFile(String path) throws IOException{
		List<String> line = Files.readAllLines(Paths.get(path));
		ArrayList<Rectangle> personList = new ArrayList<>();
		for (String string : line) {
			String c[] = string.split("#");
			
			personList.add(new Rectangle(Integer.parseInt(c[0]),Integer.parseInt(c[1]), 50, 50));
		}
		return personList;
	}
	
	public void writeFile(ArrayList<Rectangle> list, String path) {
		ArrayList<String> listAux = new ArrayList<>();
		for (Rectangle string : list) {
			listAux.add(string.x + "#" + string.y);
		}
		try {
			Files.delete(Paths.get(path));
			Files.write(Paths.get(path), listAux, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}