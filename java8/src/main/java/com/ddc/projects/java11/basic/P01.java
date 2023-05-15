package com.ddc.projects.java11.basic;

public class P01 {

    //冒泡排序
    public void BubbleSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = num.length - 1; j > i; j--) {
                if (num[j] < num[j - 1]) {
                    int temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;
                }
            }
        }
//		for(int item:num){
//			System.out.print(item+"\t");
//		}
//		System.out.println();
    }

    //快速查找
    public void QuickSort(int[] a, int i, int j) {
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] <= key) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = key;
    }

    public void getayyay(int[] a, int start, int end) {
        if (end > start) {
            int temp = a[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && a[j] > temp) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (i < j && a[i] < temp) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
                a[i] = temp;
                getayyay(a, start, i - 1);
                getayyay(a, i + 1, end);

            }
        }
    }


//	public void sort(int[] a,int start,int end){
//
//		int i=start;
//		int j=end;
//		int temp=a[i];
//
//		while(i<j){
//			if(a[i]<a[j]&&i<j){
//				j--;
//			}else{
//				a[i]=a[j];
//				i++;
//			}
//			if(a[i]>a[j]&&i<j){
//				i++;
//			}else{
//				a[j]=a[i];
//				j--;
//			}
//		}
//		a[i]=temp;
//		sort(a,start,i-1);
//		sort(a,i+1,end-1);
//	}


    public boolean seach(int[] a, int k) {
        int left = 0;
        int right = a.length;
        int m;
        while (right >= left) {
            m = (right + left) / 2;
            if (a[m] > k) {
                right = m - 1;
            } else if (a[m] < k) {
                left = m + 1;
            } else if (a[m] == k) {
                return true;
            }
        }
        return false;
    }


    public void sort1(int[] a, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            if (a[i] < a[j] && i < j) {
                j--;
            } else {
                a[i] = a[j];
                i++;
            }
            if (a[i] > a[j] && i < j) {
                i++;
            } else {
                a[j] = a[i];
                j--;
            }
        }
    }

    //二分查找
    public void MiddleCheck(int[] a, int s) {
        BubbleSort(a);
        int low = 0;
        int hight = a.length - 1;
        int mid = (low + hight) / 2;
        while (mid != low && mid != hight) {
            if (s <= a[mid]) {
                hight = mid;
                mid = (low + hight) / 2;
            } else {
                low = mid;
                mid = (low + hight) / 2;
            }
        }
        if (s == a[low] || s == a[hight]) {
            System.out.println("数组中存在" + s);
        } else {
            System.out.println("数组中不包括" + s);
        }
    }


    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(int[] a, int low, int high) {
        if (low >= high) return;
        if ((high - low) == 1) {
            if (a[0] > a[1]) swap(a, 0, 1);
            return;
        }
        int p = a[low];
        int left = low + 1;
        int right = high;
        while (right > left) {
            while (right > left && left <= high) {
                if (a[left] > p) break;
                left++;
            }
            while (right >= left && right > low) {
                if (a[right] <= p) break;
                right--;
            }
            if (right > left) {
                swap(a, right, left);
            }
        }
        swap(a, low, right);
        sort(a, low, right);
        sort(a, right, high);
    }
//	栈溢出

    public int list(int[] a, int A, int B) {
        int C = a[A];
        while (A < B) {
            while (C < a[B] && A < B) {
                B--;
            }
            a[A] = a[B];
            while (C > a[A] && A < B) {
                A++;
            }
            a[B] = a[A];
        }
        a[A] = C;
        return A;
    }

    public void Query(int[] a, int beg, int end) {
        if (beg < end) {
            int mid = list(a, beg, end);
            Query(a, beg, mid - 1);
            Query(a, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {100, 40, 60, 87, 34, 11, 56, 0};
        P01 p = new P01();
////		p.BubbleSort(a);
//		p.Query(a, 0, a.length-1);
////		p.seach(a, 0);
////		System.out.println(p.seach(a, 50));
////		p.BubbleSort(a);
//		for(int item:a){
//			System.out.print(item+" ");
//		}
        p.MiddleCheck(a, 11);

//		for(int i=0;i<a.length;i++){
//			int k=i;
//			for(int j=i+1;j<a.length;j++){
//				if(a[k]>a[j]){
//					k=j;
//				}
//
//			}
//			if(k!=i){
//				int temp;
//				temp=a[k];
//				a[k]=a[i];
//				a[i]=temp;
//			}
//
//			System.out.println(a[i]);
//		}
    }
}


