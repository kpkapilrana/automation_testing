package com.c2t.p1;

public class File2 {

	protected void display_prot() {
		// TODO Auto-generated method stub
		System.out.println("I am file Protected method");
	}
	
	private void display_pvt() {
		// TODO Auto-generated method stub
		System.out.println("I am file 3");
	}


		public void display2() {
			// TODO Auto-generated method stub
			System.out.println("I am file 2");
			display_pvt();
		}

	}


class File3{
	public void method() {
		File2 f = new File2();
		
		f.display2();
	}
}
