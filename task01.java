package task01;
// Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму. 
// Пример 1: а = 3, b = 2, ответ: 9 
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 10^3=1000

import java.io.FileReader;
import java.io.FileWriter;

public class task01 {
	public static void main(String[] args) throws Exception {
		String text = readFile("input.txt");
		int[] numArray = getNum(text);
		int a = numArray[0];
		int b = numArray[1];
		double res = Math.pow(a, b);
		String str = a + "^" + b + " = " + res;
		writeToFile(str, "output.txt");
	}

	public static String readFile(String path) throws Exception {
		FileReader file = new FileReader(path);
		int c;
		String text = "";
		while ((c = file.read()) != -1) {
			char ch = (char) c;
			text += ch;
		}
		file.close();
		return text;
	}

	public static int[] getNum(String text) throws Exception {
		String[] newText = text.split("\n");
		String[] num1 = newText[0].split(" ");
		String[] num2 = newText[1].split(" ");
		int a = 0;
		int b = 0;
		String x = "a";
		if (num1[0].codePointAt(0) == x.codePointAt(0)) {
			a = Integer.parseInt(num1[1].strip());
			b = Integer.parseInt(num2[1].strip());
		} else {
			a = Integer.parseInt(num2[1].strip());
			b = Integer.parseInt(num1[1].strip());
		}
		int[] numAB = {a, b};
		return numAB;
	}
	
	public static void writeToFile(String text, String Path) throws Exception {
		FileWriter fw = new FileWriter(Path);
		fw.write(text);
		fw.close();
	}
}