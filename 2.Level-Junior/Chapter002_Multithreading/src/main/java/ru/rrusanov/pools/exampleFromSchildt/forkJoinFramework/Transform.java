package ru.rrusanov.pools.exampleFromSchildt.forkJoinFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.util.concurrent.ForkJoinTask.invokeAll;

/**
 * A simple program that lets you experement with the effects of changing the threshold and parallelism of a ForkJoinTask.
 */
public class Transform extends RecursiveAction {
    int seqThreshold;
    double[] data;
    int start,end;

    Transform(double[] data, int start, int end, int seqThreshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.seqThreshold = seqThreshold;
    }
    protected void compute() {
        if((this.end - this.start) < this.seqThreshold) {
            for(int i = this.start; i < this.end; i++) {
                if(this.data[i] % 2 == 0) {
                    this.data[i] = Math.sqrt(this.data[i]);
                } else {
                    this.data[i] = Math.cbrt(this.data[i]);
                }
            }
        } else {
            int middle = (this.start + this.end) / 2;
            invokeAll(new SqrtTransform(this.data, this.start, middle),
                    new SqrtTransform(this.data, middle, this.end)
            );
        }
    }
}

class FJExperiment {
    public static void main(String[] args) {
//        int pLevel = 45; // number cpu(core)
        int threshold = 1000;
        long beginT, endT;
//        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[10000000];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        Transform task = new Transform(nums, 0, nums.length, threshold);
        beginT = System.nanoTime();
        task.invoke();
        endT = System.nanoTime();
        System.out.println("Level of parallelism: " + ForkJoinPool.getCommonPoolParallelism());
        System.out.println("Sequential threshold: " + threshold);
        System.out.println("Elapsed time: " + (endT - beginT) + " ns");
        System.out.println();
    }
}
