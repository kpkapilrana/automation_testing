package com.c2t.p2;

import com.c2t.p1.File2;

class File1 extends File2{

	public void display1() {
		// TODO Auto-generated method stub
		System.out.println("I am file 1");
		
		File1 f= new File1();
		f.display_prot();
	}

}
