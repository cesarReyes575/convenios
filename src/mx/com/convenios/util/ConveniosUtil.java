package mx.com.convenios.util;

public class ConveniosUtil {

	public static String lPad(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}

	public static String rPad(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}

}
