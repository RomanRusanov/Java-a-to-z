package ru.rrusanov.pools.exampleFromSchildt.forkJoinFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * A simple example of the basic divide-and-conquer strategy.
 * In this case, RecursiveAction is used.
 */
public class SqrtTransform extends RecursiveAction {
    final int seqThreshold = 1000;
    double[] data;
    int start, end;

    SqrtTransform(double[] vals, int s, int e) {
        this.data = vals;
        this.start = s;
        this.end = e;
    }

    protected void compute() {
        if((this.end - this.start) < this.seqThreshold) {
            for(int i = this.start; i < this.end; i++) {
                this.data[i] = Math.sqrt(this.data[i]);
            }
        } else {
            int middle = (this.start + this.end) / 2;
            invokeAll(new SqrtTransform(this.data, this.start, middle),
                    new SqrtTransform(this.data, middle, this.end)
            );
        }
    }
}

class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(); //or use reference to common pool ForkJoinPool.commonPool();
        double[] nums = new double[100000];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        System.out.println("A portion of the original sequence:");
        for(int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        fjp.invoke(task);

        System.out.println("A portion of the transformed sequence (to four decimal places):");
        for(int i = 0; i < 10; i++) {
            System.out.format("%.4f ", nums[i]);
        }
        System.out.println();
    }
}
