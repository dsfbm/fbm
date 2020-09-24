package com.qf.controller;

public class text {
    public static void main(String[] args) {
        int[] list={0,0,5,3,0,0,0,0,0,8,0,0,0,0,0,0,2,0,0,7,0,0,1,0,5,0,0,4,0,0,0,0,5,3,0,0,0,1,0,0,7,0,0,0,6,0,0,3,2,0,0,0,8,0,0,6,0,5,0,0,0,0,9,0,0,4,0,0,0,0,3,0,0,0,0,0,0,9,7,0,0};
        int[] list1={1,2,3,4,5,6,7,8,9};
        for(int j=0;j<=list1.length;j++){
        for (int i=0;i<=list.length;i++){
            if ((i+1)<9){
                if(list1[j]!=list[i]){
                    for (int l=0;i<=list.length;i++) {

                        if (l%9==0){
                            if (list[l]!=list1[j]){

                                continue;
                            }else {

                                break;
                            }
                        }
                    }
                    }else {
                    break;
                }
                }
            }
//            System.out.print(list[i]+" ");
//            if ((i+1)%9==0){
//                System.out.println();
//            }
        }
        }
    }

