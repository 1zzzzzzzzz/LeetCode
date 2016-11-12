package main2;

import java.util.TreeSet;

public class JavaFormat {

	public static void main(String[] args) {
		double x = 3.1415926;
		System.out.println(new java.text.DecimalFormat("#.00").format(x));
		
//		byte b1 = 3, b2 =4, b3, b6, b8;
//		final byte b4 = 4, b5 = 6, b7;
//		// b3 = b1+b2; //编译错误
//		b6 = b4 + b5; //正确
//		b8 = b1 + b4; //编译错误
//		b7 = b2 + b5; // 编译错误
		
		/*
		 * TreeSet是一个有序集合，TreeSet中的元素将按照升序排列，缺省是按照自然排序进行排列，意味着TreeSet中的元素
		 * 要实现Comparable接口。或者有一个自定义的比较器。
		 * 因为String 类实现了Comparable接口。
		 */
		TreeSet<String> ts = new TreeSet<String>();
		if(ts.add("one"))
			if(ts.add("two"))
				if(ts.add("three"))
					ts.add("four");
		for(String s: ts){
			System.out.print(s+" ");
		}
		//输出：four one three two 
		
	}

}
