package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SPCreator {

    private FileOps _file;
    private Entity _e;

    public SPCreator(String file,Entity e){
        _file = new FileOps(file + e._name);
        _e = e;
    }


    private void create(){

        _file.writeLn("-- Begin Create");
        _file.writeLn("");
        _file.writeLn("DELIMITER $$");
        _file.writeLn("DROP PROCEDURE IF EXISTS "+"Create"+ _e._name+" $$");
        _file.writeLn("CREATE PROCEDURE "+"Create"+ _e._name+"(");

        for (int i = 1; i < _e._attributes.size()-1; i++) {
            Attribute aux = _e._attributes.get(i);

            _file.writeLn("     IN "+aux._name+" "+aux._type+",");
        }
        _file.writeLn("     IN "+ _e._attributes.get(_e._attributes.size()-1)._name+" " +
                                    _e._attributes.get(_e._attributes.size()-1)._type);

        _file.writeLn(") BEGIN");
        _file.writeLn("");
        _file.write("INSERT INTO "+_e._name.toUpperCase()+" (");

        String attsList="";
        for (int i = 1; i < _e._attributes.size()-1 ; i++) {
           attsList = attsList + _e._attributes.get(i)._name+",";
        }
        attsList = attsList + _e._attributes.get(_e._attributes.size()-1)._name;

        _file.writeLn(attsList+")");
        _file.write("VALUES (");
        _file.writeLn(attsList+");");
        _file.writeLn("");
        _file.writeLn("END $$");
        _file.writeLn("DELIMITER ;");
        _file.writeLn("");
        _file.writeLn("-- CALL "+"Create"+ _e._name+"("+dataTypes()+");");
        _file.writeLn("-- End Create");

    }

    private void getAll(){

        _file.writeLn("-- Begin Get all");
        _file.writeLn("");
        _file.writeLn("DELIMITER $$");
        _file.writeLn("DROP PROCEDURE IF EXISTS "+ "GetAll"+_e._name+ "$$");
        _file.writeLn("CREATE PROCEDURE "+"GetAll"+_e._name+"(");
        _file.writeLn(") BEGIN");
        _file.writeLn("");
        _file.writeLn("SELECT * FROM "+ _e._name.toUpperCase() + ";");
        _file.writeLn("END $$");
        _file.writeLn("DELIMITER ;");
        _file.writeLn("");
        _file.writeLn("-- CALL "+"GetAll"+_e._name+"();");
        _file.writeLn("-- End Get All");
    }

    private void get(){

        _file.writeLn("-- Begin Get");
        _file.writeLn("");
        _file.writeLn("DELIMITER $$");
        _file.writeLn("DROP PROCEDURE IF EXISTS "+"Get"+_e._name+" $$");
        _file.writeLn("CREATE PROCEDURE "+"Get"+_e._name+"(");
        _file.writeLn("IN ID int");
        _file.writeLn(") BEGIN");
        _file.writeLn("");
        _file.writeLn("SELECT * FROM "+ _e._name.toUpperCase() + " WHERE "+_e._name.toUpperCase()+".id = ID;");
        _file.writeLn("END $$");
        _file.writeLn("DELIMITER ;");
        _file.writeLn("");
        _file.writeLn("-- CALL "+"Get"+_e._name+"(1);");
        _file.writeLn("-- End Get");

    }

    private void update(){

        _file.writeLn("-- Begin Update");
        _file.writeLn("");
        _file.writeLn("DELIMITER $$");
        _file.writeLn("DROP PROCEDURE IF EXISTS "+ "Update"+_e._name+" $$");
        _file.writeLn("CREATE PROCEDURE "+"Update"+_e._name+"(");

        for (int i = 1; i < _e._attributes.size(); i++) {
            Attribute aux = _e._attributes.get(i);

            _file.writeLn("     IN "+aux._name+" "+aux._type+",");
        }
        _file.writeLn("     IN ID int");

        _file.writeLn(") BEGIN");
        _file.writeLn("");
        _file.write("UPDATE "+_e._name.toUpperCase()+" SET ");

        String attsList="";
        for (int i = 1; i < _e._attributes.size()-1 ; i++) {
            attsList = attsList + _e._attributes.get(i)._name+" = " + _e._attributes.get(i)._name + ",";
        }
        attsList = attsList + _e._attributes.get(_e._attributes.size()-1)._name + " = " + _e._attributes.get(_e._attributes.size()-1)._name;

        _file.writeLn(attsList);
        _file.write("WHERE "+_e._name.toUpperCase()+".ID=ID;");
        _file.writeLn("");
        _file.writeLn("END $$");
        _file.writeLn("DELIMITER ;");
        _file.writeLn("");
        _file.writeLn("-- CALL "+"Update"+_e._name+"(1,"+dataTypes()+");");
        _file.writeLn("-- End Create");
        _file.writeLn("");
        _file.writeLn("");

    }

    private void delete(){

        _file.writeLn("-- Begin Delete");
        _file.writeLn("");
        _file.writeLn("DELIMITER $$");
        _file.writeLn("DROP PROCEDURE IF EXISTS "+ "Delete"+_e._name+" $$");
        _file.writeLn("CREATE PROCEDURE "+"Delete"+_e._name+"(");
        _file.writeLn("IN ID int");
        _file.writeLn(") BEGIN");
        _file.writeLn("");
        _file.writeLn("DELETE FROM "+ _e._name.toUpperCase() + " WHERE "+_e._name.toUpperCase()+".id = ID;");
        _file.writeLn("END $$");
        _file.writeLn("DELIMITER ;");
        _file.writeLn("");
        _file.writeLn("-- CALL "+"Delete"+_e._name+"(1);");
        _file.writeLn("-- End Delete");

    }

    private String dataTypes(){
        String output="";

        Attribute aux;

        for (int i = 1; i < _e._attributes.size(); i++) {
            aux = _e._attributes.get(i);
            if (aux._type.equals("int")){
                output = output + "53";
            }else if (aux._type.equals("float")){
                output = output + "34.6";
            }else if (aux._type.equals("date")){
                output = output + "'2018-9-4'";
            }else if (aux._type.equals("boolean")){
                output = output + "true";
            }else{
                output = output + "'string'";
            }
        }
        return output;
    }

    public void execute() {
        create();
        getAll();
        get();
        update();
        delete();
    }
}
