package org.example.thread.example1;

public class RequestParking {
    public static void main(String[] args) {
        int person = 10;
        Carport carport = new Carport();
        RequestParkingThread requestParkingThread = new RequestParkingThread(carport);
        for (var i = 0; i < 10 ; i++) {
            new Thread(requestParkingThread, ("Parking-Thread"+i)).start();
        }

        RequestLeavingThread requestLeavingThread = new RequestLeavingThread(carport);
        for (var i = 0; i < 10 ; i++) {
            new Thread(requestLeavingThread, ("Leaving-Thread"+i)).start();
        }
    }

}

class RequestParkingThread implements  Runnable{

    private Carport carport;

    public RequestParkingThread(Carport carport) {
        this.carport = carport;
    }
    @Override
    public void run() {
        String parkNumber = carport.park();
        System.out.println(Thread.currentThread().getName() +"-->parkNumber=" + parkNumber);
    }
}

class RequestLeavingThread implements  Runnable{

    private Carport carport;

    public RequestLeavingThread(Carport carport) {
        this.carport = carport;
    }
    @Override
    public void run() {
        String parkNumber = carport.leave();
        System.out.println(Thread.currentThread().getName() +"-->LeavingNumber=" + parkNumber);
    }
}

