package com.migua.tech.test.jdk11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class B002_HashSet_Add {
	public static void main(String[] args) {
		var text = "Banana";
		//      Incompatible types:
		//      text = 1;


		//        Cannot infer type:
		//        var a;
		//        var nothing = null;
		//        var bla = () -> System.out.println("Hallo");
		//        var method = LocalVariableSyntax::someMethod;

		var list1 = new ArrayList<>();   // ArrayList<Object>

		var list2 = new ArrayList<Map<String, List<Integer>>>();

		for (var current : list2) {
			// current is of type: Map<String, List<Integer>>
			System.out.println(current);
		}

		Predicate<String> predicate1 = (@Deprecated var a) -> false;

		String hello = "Hello", lo = "lo";
		System.out.println(hello == "Hello");
		System.out.println(Other.hello == hello);
		//Object other;
		//System.out.println(other.Other.hello == hello);
		System.out.println(hello == ("Hel"+"lo"));
		System.out.println(hello == ("Hel"+lo));
		System.out.println(hello == ("Hel"+lo).intern());
		int i = 1000000;
		System.out.println(i * i);
		long l = i;
		System.out.println(l * l);
//		System.out.println(20296 / (l - i));
	}

	void someMethod() {}

}
class Other { public  static String hello = "Hello"; }