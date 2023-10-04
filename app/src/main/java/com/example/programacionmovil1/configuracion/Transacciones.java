package com.example.programacionmovil1.configuracion;

public class Transacciones {
    //Nombre de la base de datos
    public Transacciones() {

    }
    public  static final  String namedb = "PM012023";

    //Tablas de base de datos

    public static   final  String Tabla ="personas";

    public static final String id ="id";

    public static final String nombre ="nombre";


    public static final String  apellido="apellido";

    public static final String  edad="edad";

    public static final String  correo="correo";

    //consulta de base de datos


    public static  final String CreateTablePersonas = "CREATE TABLE PERSONAS"+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,apellido TEXT, edad INTEGER, correo TEXT)";

    public  static  final String DropPersonas ="DROP TABLE IF EXITS personas";

    public static  final String selectablePerosnas = "SELECT * FROM " + Transacciones.Tabla;
}
