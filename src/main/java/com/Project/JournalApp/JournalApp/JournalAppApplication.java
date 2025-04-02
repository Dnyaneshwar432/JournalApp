package com.Project.JournalApp.JournalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JournalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalAppApplication.class, args);
		System.out.println("Journal App Started Successfully.....");



		int ordinal = enumData.GHANSHYAM.ordinal();
		System.out.println(ordinal);
		enumData enumDay = enumData.valueOf("RAM");
		System.out.println(enumDay);

		enumData[] values = enumData.values();
		for(enumData name:values)
		{
			System.out.println(name);
		}
		enumData enumD = enumData.BALRAM;

//		switch (enumD)
//		{
//			case RAM -> System.out.println("Siyavar Ram chandra ki jay");
//			case SHAM -> System.out.println("Sham baba ki jay");
//			case GHANSHYAM -> System.out.println("Hello Ghanshyam");
//		}
		
		String result = switch (enumD)
		{
			case GHANSHYAM -> "G";
			case SHAM -> "S";
			case RAM -> "R";

//            case BALRAM -> null;
//            case RAJARAM -> null;
//            case PRANAM -> null;
			default -> "No";
        };

		System.out.println(result);

		System.out.println("Today late night "+enumD.getLower()+" went with "+enumD.getLadies());
		enumD.display();
	}

}
