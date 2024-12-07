package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

  
        Device device = new Device();
        device.setBrand("Generic");
        device.setModel("Model1");
        device.setPrice(100);

        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 13");
        smartphone.setPrice(999);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("12MP");

    
        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S7");
        tablet.setPrice(649);
        tablet.setScreenSize("11 inches");
        tablet.setBatteryLife("15 hours");

        // Persisting objects
        session.save(device);
        session.save(smartphone);
        session.save(tablet);

        tx.commit();
        session.close();
        factory.close();
    }

}