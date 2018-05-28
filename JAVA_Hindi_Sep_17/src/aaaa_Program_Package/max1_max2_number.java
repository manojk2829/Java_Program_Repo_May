package aaaa_Program_Package;

import java.util.HashSet;
import java.util.Set;

public class max1_max2_number {

	public static void main(String[] args) {
		int n[]={2,43,55,3,24,34,34,33,55,45,35};
		int m1=0;
		int m2=0;
		for(int num:n){
			if(m1<num){
				m2=m1;
				m1=num;
			}
			else if(m2<num){
				m2=num;
			}
		}
		System.out.println(m1+"  max 1  "+  m2 + " max 2 ");
	
	 
		int s=n[0];
		int l=n[0];
		for(int i=0;i<n.length;i++){
			if(n[i]<s){
				s=n[i];
			}
			if(n[i]>l){
				l=n[i];
			}
		}
		System.out.println(s+"     "+l);
	    int temp=0;
		for(int i=0;i<n.length;i++){
			for(int j=i+1;j<n.length;j++){
				if(n[i]>n[j]){
					temp=n[i];
					n[i]=n[j];
					n[j]=temp;
				}
			}
			System.out.print(n[i]+",");
		}
		
	System.out.println();
		Set<Integer> store = new HashSet<Integer>();
		for(Integer num:n){
			if(store.add(num)==false){
				System.out.println("Duplicate number -- > " + num);
			}
		}
	
	}

}
