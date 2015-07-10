package com.dolph.chapter2;

import java.util.Arrays;
import java.util.Random;

/***
 * 归并排序
 * @author ludonghua
 *
 */
public class _02MergeSort {
	
	public static void main(String[] args) {
		Random ran = new Random();
		int[] tar = new int[ran.nextInt(5000)];
		for(int i=0;i<tar.length;i++){
			tar[i] = ran.nextInt();
		}
		int[] tar2 = new int[tar.length];
		System.arraycopy(tar,0,tar2,0,tar.length);
		mergeSort(tar, 0, tar.length-1);
		_01InsertionSort.insertionSort(tar2);
		
//		merge(target, 2, 2, 3);
		System.out.println(Arrays.equals(tar, tar2));
		
	}
	
	public static void mergeSort(int[] A,int start,int end){
		if(start<end){
//			System.out.println(start+" "+end);
			int middle = (end+start)/2;
			mergeSort(A, start, middle);
			mergeSort(A, middle+1, end);
			merge(A, start, middle, end);
//			System.out.println(Arrays.toString(A));
		}
	}
	
	//   0       9        10       19
	// A[start..middle],B[middle+1..end]
	/***
	 * merge两个数组()
	 */
	public static void merge(int[] A,int start,int middle,int end){
		// 计算前后半个数组的大小
		int n1 = middle-start+1;
		int n2 = end-middle;
		// 新建两个子数组,数组长度为 (原数组长度/2)
		int[] left = new int[n1];
		int[] right = new int[n2];
		// 将原数组前后等分成两个子数组
		for(int i=0;i<n1;i++){
			left[i] = A[start+i];
		}
		for(int j=0;j<n2;j++){
			right[j] = A[middle+j+1];
		}
		// 子数组的最后可以增加一个最大的值以避免判断数组是否越界
//		left[n1] = Integer.MAX_VALUE;
//		right[n2] = Integer.MAX_VALUE;
		int rightIdx = 0;
		int leftIdx = 0;
		// 循环中从左右两个数组中取出数组头中比较小的那一个放入原数组中
		for(int k=start;k<=end;k++){
			// 右边已取完||(左边没取完|| && 左边的leftIdx位是否比右边的小)
			if((rightIdx>=right.length) ||
					(leftIdx+1<=left.length&& left[leftIdx]<=right[rightIdx])){
				A[k] = left[leftIdx];
				leftIdx++;
			}else{
				A[k] = right[rightIdx];
				rightIdx++;
			}
		}
	}
}
