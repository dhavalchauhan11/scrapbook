package ch3_stacks;

import java.util.Arrays;

/**
 * Created by dhavalchauhan on 2/20/16.
 */
public class ArrayMultipleStacks {

    int stackSize = 5;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointers = new int[]{0,0,0};

    void push(int stackNum, int data){
        /* Find the index of the top element in the array + 1, and
            * increment the stack pointer */
        int index = stackNum * stackSize + stackPointers[stackNum];
        stackPointers[stackNum]++;
        buffer[index] = data;
    }

    public int pop(int stackNum){
        if(stackNum > stackPointers.length){
            throw new UnsupportedOperationException();
        }
        int index = stackNum * stackSize + stackPointers[stackNum];
        stackPointers[stackNum]--;
        int temp = buffer[--index];
        buffer[index] = 0;
        return temp;
    }

    public static void main(String[] args) {
        ArrayMultipleStacks ams = new ArrayMultipleStacks();
        ams.push(0,1);
        ams.push(0,2);
        ams.push(0,3);

        ams.push(1,5);
        ams.push(1,6);
        ams.push(1,7);

        ams.push(2,8);
        ams.push(2,9);
        ams.push(2,10);

        System.out.println(Arrays.toString(ams.buffer));

        System.out.println(ams.pop(3));

    }
}
