package com.example.controller;

import org.springframework.validation.ObjectError;

public class text01 {
    public static void main(String[] args) {


//        int b=0;
//        for (int i=0;i<=a.length;i++){
//
//            for(int j=0;j<a.length-1;j++){
//
//                if (a[j]>a[j+1]){
//                    b=a[j+1];
//                    a[j+1]=a[j];
//                    a[j]=b;
//                }
//            }
//        }
//        for (Object c:a) {
//            System.out.print(c);
//        }

//        int b=0;
//        for(int i=0;i<a.length;i++){
//
//
//            for(int j=0;j<a.length;j++){
//                if(a[i]>a[j]){
//
//                          b=a[j];
//                          a[j]=a[i];
//                          a[i]=b;
//
//                        }
//            }
//
//
//        }
//                for (Object c:a) {
//            System.out.print(c);
//        }
        int[] a={1,6,8,5,9,7};
        int b=0;
        for(int i=0;i<a.length;i++){


            for(int j=0;j<a.length;j++){

                if (a[i]<a[j]){
                   b=a[i];
                   a[i]=a[j];
                   a[j]=b;

                }

            }
        }
        for (Object c:a) {
            System.out.println(c);
        }

    }
}
