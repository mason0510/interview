//package main;
//
//import java.util.Scanner;
//
//public class Main {
//    //是否走过，棋盘
//    static int a[][];
//    //保存路径条数
//    static int s;
//
//    //剪枝函数
//    public static boolean check(int x,int y) {
//        //不在棋盘里或者走过的剪掉
//        if(x>=1&&x<=5&&y>=1&&y<=4&&a[x][y]==0)
//            return true;
//        else
//            return false;
//    }
//
//    public static void solve(int x,int y,int step) {
//        if(step==20) {
//            s++;
//            return;
//        }
//        //方向引导数组
//        int fx[] = {1,2,2,1,-1,-2,-2,-1};
//        int fy[] = {2,1,-1,-2,-2,-1,1,2};
//        int dx,dy;
//        for(int i=0;i<=7;i++) {
//            dx = x + fx[i];
//            dy = y + fy[i];
//            if(check(dx, dy)) {
//                a[x][y] = step;
//                //记录当前的xy
//                System.out.println("x="+x+"y="+y);
//                solve(dx, dy, step+1);
//                a[x][y] = 0;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            a = new int[10][10];
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            for(int i=1;i<=5;i++)
//                for(int j=1;j<=5;j++)
//                    a[i][j] = 0;
//            s = 0;
//            //从第一步开始
//            solve(x,y,1);
//            if (s == 0)
//                System.out.println("No solution!");
//            else
//
//                System.out.println(s);
//        }
//    }
//}

import java.util.Scanner;
import java.util.Arrays;
public class horse {
    public static int num=0;
    //    public static int []arr1 = new int[20];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);           //初始化的输入操作
        System.out.println("棋盘高：");
        int height = sc.nextInt();
        System.out.println("棋盘宽：");
        int width = sc.nextInt();
        System.out.println("起始横坐标：");
        int startx = sc.nextInt();
        System.out.println("起始纵坐标：");
        int starty = sc.nextInt();
        int []arr = new int[height*width];
        int []arr1 = new int[height*width];            //arr1列表用来存放所有格子，同时保证了出界的问题
        int i=0;
        for(int x=0; x<height; x++){
            for(int y=0; y<width;y++){
                arr1[i++]=10*x+y;
            }
        }
        System.out.println(Arrays.toString(arr1));
        arr[0] = 10*startx+starty;
        int finish_index = 1;
        int node_num = height*width;
        horse_ri(arr,arr1,finish_index);
        System.out.printf("共%d种走法",num);
    }
    static void horse_ri(int arr[],int arr1[],int finish_index){
        boolean flag=true;
        if(finish_index==arr.length){
            num++;
            System.out.printf("第%d种走法",num);
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int ind=1;ind<arr1.length; ind++){
            arr[finish_index]=arr1[ind];
            flag = true;
            //不是日字的情况
            if((Math.abs(arr[finish_index]-arr[finish_index-1])!=8)&&(Math.abs(arr[finish_index]-arr[finish_index-1])!=12)&&(Math.abs(arr[finish_index]-arr[finish_index-1])!=19)&&(Math.abs(arr[finish_index]-arr[finish_index-1])!=21)){
                flag = false;
            }
            //之前走过的格子
            for(int index=0;index<finish_index;index++){
                if(arr[finish_index]==arr[index]){
                    flag = false;
                }
            }
            if(flag==true){
                horse_ri(arr,arr1,finish_index+1);
            }
        }
    }
}