package com.company;

import java.util.Scanner;

public class Attribute {

    String _name;
    String _type;

    public Attribute(){

        System.out.print("Type the attribute name: ");
        _name = ScannerOps.read();

        System.out.print("Type the data type: ");
        _type=ScannerOps.read();

        if(_type.matches("[0-9]+$")) {
            _type = "varchar(" + _type + ")";
        }

    }

    public Attribute(String name, String type) {
        this._name = name;
        this._type = type;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        this._type = type;
    }
}
