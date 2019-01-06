package com.company;

import java.util.ArrayList;

public class Entity {
    ArrayList<Attribute> _attributes;
    String _name;

    public Entity(){

        _attributes = new ArrayList<Attribute>();

        System.out.print("Type the entity name: ");
        _name = ScannerOps.read();

        int count = 1;
        String input;
        do{

            Attribute aux = new Attribute();
            _attributes.add(aux);
            System.out.println("Created attribute number: "+count+". \nPress 1 to continue and 0 to exit.");
            input =ScannerOps.read();
            count++;
        }while(!input.equals("0"));

    }

}
