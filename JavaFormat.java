package main2;

import java.util.TreeSet;

public class JavaFormat {

	public static void main(String[] args) {
		double x = 3.1415926;
		System.out.println(new java.text.DecimalFormat("#.00").format(x));
		
//		byte b1 = 3, b2 =4, b3, b6, b8;
//		final byte b4 = 4, b5 = 6, b7;
//		// b3 = b1+b2; //�������
//		b6 = b4 + b5; //��ȷ
//		b8 = b1 + b4; //�������
//		b7 = b2 + b5; // �������
		
		/*
		 * TreeSet��һ�����򼯺ϣ�TreeSet�е�Ԫ�ؽ������������У�ȱʡ�ǰ�����Ȼ����������У���ζ��TreeSet�е�Ԫ��
		 * Ҫʵ��Comparable�ӿڡ�������һ���Զ���ıȽ�����
		 * ��ΪString ��ʵ����Comparable�ӿڡ�
		 */
		TreeSet<String> ts = new TreeSet<String>();
		if(ts.add("one"))
			if(ts.add("two"))
				if(ts.add("three"))
					ts.add("four");
		for(String s: ts){
			System.out.print(s+" ");
		}
		//�����four one three two 
		
	}

}
