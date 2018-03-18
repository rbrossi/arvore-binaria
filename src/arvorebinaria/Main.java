package arvorebinaria;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\temp\\msg.txt");
		if (!file.exists()) {
			System.out.println("arquivo não existe");
			return;
		}
		
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		String str = new String(data, "UTF-8");
		String encoded = new Huffman().Encode(str);
		System.out.println(encoded);

		
		File codedFile = new File("C:\\temp\\msgCoded.txt");
		if (!codedFile.exists()) {
			codedFile.createNewFile();
		}
		try (PrintWriter out = new PrintWriter(codedFile)) {
		    out.println(encoded);
		}
	}
}
