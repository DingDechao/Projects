package org.example.thread;

import java.awt.event.HierarchyBoundsAdapter;

public class PriorityTest0 extends Thread {

    public PriorityTest0(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (var i = 0; i < 50; i++) {
            System.out.println("Current Thread Name=" + getName() + "--> Current Priority=" + getPriority() + "--> i=" + i);
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setPriority(5);
        for (var i = 0; i < 50; i++) {
            if (i == 10) {
                PriorityTest0 priorityTest0 = new PriorityTest0("LOW");
                priorityTest0.start();

                System.out.println("Current Priority=" + priorityTest0.getPriority());

                priorityTest0.setPriority(MIN_PRIORITY);

                System.out.println("Current Priority=" + priorityTest0.getPriority());

            }

            if (i == 20) {
                PriorityTest0 priorityTest1 = new PriorityTest0("HIGH");
                priorityTest1.start();

                System.out.println("Current Priority=" + priorityTest1.getPriority());

                priorityTest1.setPriority(MAX_PRIORITY);

                System.out.println("Current Priority=" + priorityTest1.getPriority());

            }
        }
    }
}
