package com.api.lambda;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        List<Apple> apples= Arrays.asList();
    }

    class Apple{
        private String color;
        private Integer weight;
        public void setColor(String color,Integer weight){
            this.color = color;
            this.weight=weight;
        }
        public void setleight(Integer weight){
            this.weight = weight;
        }
        public String getColor(){
            return this.color;
        }
        public Integer getweight(){
            return this.weight;
        }
    }

}
