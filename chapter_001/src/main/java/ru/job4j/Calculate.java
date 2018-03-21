package ru.job4j.calculate;

/**
* Calculate.
*
* @author Dmitry Ilyshev (dilyshev@mac.com)
* @version $Id$
* @since 0.1
*/

public class Calculate{

	/**
	* Конструктор, вывод строки в консоль
	* @param args - args
	* @return string Hello world
	*/

	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	/**
	* Method echo.
	* @param name Your name
	* @return Echo plus your name
	*/
	public String echo (String name) {
		return "Echo, echo, echo: "+name;
	}

}
