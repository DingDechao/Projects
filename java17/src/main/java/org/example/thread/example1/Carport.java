package org.example.thread.example1;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class Carport {

    private final ReentrantLock reentrantLock = new ReentrantLock();

    private boolean[] carports = {false, false, false};

    public Carport() {}

    public boolean[] getCarports() {
        return carports;
    }

    public String park() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + "Before Parking : " + Arrays.toString(carports));
        var parkNumber = 0;
        try {
            for (var i = 0; i < carports.length; i++) {
                boolean flag = carports[i];
                if (!flag) {
                   carports[i] = true;
                   parkNumber = i + 1;
                    return "Park-"+parkNumber;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
        return "No Carport";
    }

    public String leave() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + "Before Leaving : " + Arrays.toString(carports));
        var parkNumber = 0;
        try {
            for (var i = 0; i < carports.length; i++) {
                boolean flag = carports[i];
                if (flag) {
                    carports[i] = false;
                    parkNumber = i + 1;
                    return "Leaving-"+parkNumber;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
        return "No car";
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carport carport = (Carport) o;
        return Objects.deepEquals(carports, carport.carports);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(carports);
    }

    @Override
    public String toString() {
        return "Carport{" +
                "carports=" + Arrays.toString(carports) +
                '}';
    }
}
