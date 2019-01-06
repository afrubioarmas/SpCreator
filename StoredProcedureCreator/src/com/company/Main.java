package com.company;

public class Main {

    public static void main(String[] args) {

        Entity e = new Entity();
        SPCreator spc = new SPCreator("C:\\Users\\Andres\\Documents\\Developing\\Projects\\" +
                "Universidad\\ServicioComunitario\\ParroquiaAsuncionDelSenor\\WS\\scripts\\StoredProcedures\\",e);

        spc.execute();


    }
}
