package com.dolph.chapter2;

import java.util.Arrays;

/***
 * 插入排序
 * @author Administrator
 *
 */
public class _01InsertionSort {
	public static void main(String[] args) {
		int[] source = {5,2,4,6,1,3};
		int[] sorted = insertionSort(source);
		System.out.println(Arrays.toString(sorted));
	}
	
	public static int[] insertionSort(int[] source){
		for(int i=1;i<source.length;i++){
			int key = source[i];
			int j=i-1;
			while(j>=0 && source[j]>key){
				source[j+1] = source[j];
				j--;
			}
			source[j+1] = key;
		}
		return source;
		
	}
}
