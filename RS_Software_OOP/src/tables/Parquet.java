package tables;

import java.util.Scanner;

import fileOperation.Coding;
import fileOperation.FileOperation;
import helpStuffs.IntCheck;
import print.MaterialPrint;

public class Parquet {
	private Scanner scan;

	public Parquet(Scanner scan) {
		this.scan = scan;

	}
	Coding coder = new Coding();
	IntCheck intCheck = new IntCheck(scan);
	FileOperation file = new FileOperation();
	private String[] parquet = file.readMaterial("parquet");

	public String[] getParquet() {
		return parquet;
	}

	public void delete() {
		MaterialPrint printer = new MaterialPrint();
		printer.print(parquet);
		System.out.println("Kérem írja be a törölni kívánt anyag indexét!");

		int i = intCheck.checker(parquet.length);
		System.out.println("Biztosan törölni szeretné? (i/n)");
		String[] materialDel = parquet[i].split(";");
		System.out.println(materialDel[0]);
		String inputLetter;
		do {
			inputLetter = scan.next();
			checkExit(inputLetter);
			System.out.println();
		} while (!inputLetter.equals("i") && !inputLetter.equals("i"));
		if (inputLetter.equals("i")) {
			StringBuilder sb1 = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb1.append(String.format("%s%n", coder.coder(parquet[j], 5)));
			}
			for (int j = i + 1; j < parquet.length; j++) {
				sb1.append(String.format("%s%n", coder.coder(parquet[j], 5)));
			}
			file.writeTextToFile(sb1.toString().trim(),"parquet");
			parquet = file.readMaterial("parquet");
		}
	}

	public void add() {
		String input = "";
		System.out.printf("Kérem, adja meg az anyag nevét: ");
		scan.nextLine();
		input += scan.nextLine();
		checkExit(input);
		input += ";";
		System.out.printf("Kérem, adja meg az anyag árát: ");
		input += Integer.toString(intCheck.checker(Integer.MAX_VALUE));
		input += ";";
		System.out.printf("Kérem, adja meg a m2/pack: ");
		input += Integer.toString(intCheck.checker(Integer.MAX_VALUE));
		file.fileAppend(input , "parquet");
		parquet = file.readMaterial("parquet");
	}
	public void checkExit(String value) {
		if(value.equals("-1")) {
			System.out.println("Viszlát");
			System.exit(0);
		}
	}

}
