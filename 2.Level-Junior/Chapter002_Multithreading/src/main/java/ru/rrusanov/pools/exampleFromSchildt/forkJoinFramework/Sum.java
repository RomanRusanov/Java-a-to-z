package ru.rrusanov.pools.exampleFromSchildt.forkJoinFramework;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * A RecursiveTask that computes the summation of an array of doubles.
 */
public class Sum extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start, end;

    Sum(double[] data, int s, int e) {
        this.data = data;
        this.start = s;
        this.end = e;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if((this.end - this.start) < this.seqThreshold) {
            for(int i = this.start; i < this.end; i++) {
                sum += this.data[i];
            }
        } else {
            int middle = (this.start + this.end) / 2;
            Sum subTaskA = new Sum(this.data, this.start, middle);
            Sum subTaskB = new Sum(this.data,  middle, this.end);
            //Start subTasking.
//            subTaskA.fork();
            subTaskB.fork();
            // wait subTasks complete executes.
            sum = subTaskA.invoke() + subTaskB.join();
        }
        return sum;
    }
}

class RecurTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[5000];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }
        Sum task = new Sum(nums, 0, nums.length);
        double summation = fjp.invoke(task);
        System.out.println("Summation " + summation);
    }
}
