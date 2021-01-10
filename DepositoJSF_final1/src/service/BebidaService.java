package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import model.Bebida;

public class BebidaService {

	//public static final String xmlFilePath = "D:\\Ws-JAVA\\DepositoJSF_final1\\src\\Bebidas.xml";

	private static List<Bebida> todosRegistros = new ArrayList<Bebida>();

	public static void salvarBebida(Bebida bebida) {
		//tratar exception
		bebida.setId(getRandomId());
		todosRegistros.add(bebida);
		Collections.sort(todosRegistros, new BebidaComparatorByDescricao());
	}
	public static void deletarBebida(Bebida bebida) {
		todosRegistros.remove(bebida);
	}

	public static List<Bebida> listarTodasBebidas() {
		if (todosRegistros.isEmpty()) {
			preencherListaBebidas();
		}
		return todosRegistros;

	}

	private static void preencherListaBebidas() {
		salvarBebida(new Bebida(getRandomId(), "Coca Cola Zero 350 ml", "Coca Cola", 5.00, 147852, 50));
		salvarBebida(new Bebida(getRandomId(), "Pepsi Twist 350  ml", "Pepsi", 5.00, 854741, 35));
		salvarBebida(new Bebida(getRandomId(), "Fanta Uva 350 ml", "Fanta", 4.50, 548745, 25));
		salvarBebida(new Bebida(getRandomId(), "Skol Beats 269 ml", "Skol", 6.00, 225400, 70));
		salvarBebida(new Bebida(getRandomId(), "Skol Beats Zodiac 269 ml", "Skol", 7.00, 541225, 70));
		salvarBebida(new Bebida(getRandomId(), "Ch� Matte P�ssego 1,5 L", "Matte", 5.5, 998742, 28));
		salvarBebida(new Bebida(getRandomId(), "�gua Mineral Indai� 1L", "Indai�", 2.5, 247155, 90));

	}

	private static Integer getRandomId() {
		Random gerador = new Random();
		return gerador.nextInt(501);
	}

}

class BebidaComparatorByDescricao implements Comparator<Bebida> {
	@Override
	public int compare(Bebida c1, Bebida c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
}