package com.ddc.projects.java11.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class VelocityDemo {

    public VelocityDemo(String templateFile) {
        try {

            Velocity.init("velocity/src/main/resources/velocity.properties");

            VelocityContext context = new VelocityContext();
            context.put("list", getNames());
            Person person = new Person();
            person.setA(1);
            person.setB(3);
            context.put("person", person);

            Template template = null;

            try {
                template = Velocity.getTemplate(templateFile);
            } catch (ResourceNotFoundException rnfe) {
                System.out.println("Example : error : cannot find template " + templateFile);
            } catch (ParseErrorException pee) {
                System.out.println("Example : Syntax error in template " + templateFile + ":" + pee);
            }


            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(System.out));

            if (template != null)
                template.merge(context, writer);

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList getNames() {
        ArrayList list = new ArrayList();

        list.add("ArrayList element 1");
        list.add("ArrayList element 2");
        list.add("ArrayList element 3");
        list.add("ArrayList element 4");

        return list;
    }

    public static void main(String[] args) {
        VelocityDemo t = new VelocityDemo("velocity/src/main/resources/example1.vm");
    }
}
