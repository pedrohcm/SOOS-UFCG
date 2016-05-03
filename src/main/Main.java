package main;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) throws Exception {

		args = new String[] { "main.Facade", "testes/usecase_1.txt", "testes/usecase_2.txt",
				"testes/usecase_3.txt", "testes/usecase_4.txt"};

		EasyAccept.main(args);

	}
}