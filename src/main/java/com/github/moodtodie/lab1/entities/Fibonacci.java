package com.github.moodtodie.lab1.entities;

public record Fibonacci(String value) {
    public Fibonacci(String value){
        int tmpIndex = Integer.parseInt(value);
        long num = -1;

        if (tmpIndex <= 0) {
            num = 0;
        } else if (tmpIndex == 1){
            num = 1;
        }

        long num1 = 0;
        long num2 = 1;

        for (int i = 1; i < tmpIndex; i++) {
            num = num2 + num1;

            num1 = num2;
            num2 = num;
        }
        this.value = String.valueOf(num);
    }
}