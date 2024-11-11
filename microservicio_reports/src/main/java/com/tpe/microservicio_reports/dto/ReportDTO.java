package com.tpe.microservicio_reports.dto;
/*
* . Como encargado de mantenimiento quiero poder generar un reporte de uso de monopatines por
kilómetros para establecer si un monopatín requiere de mantenimiento. Este reporte debe poder
configurarse para incluir (o no) los tiempos de pausa.
* */
public class ReportDTO {

    private int id;
    //kilometros recorrido en general
    private float km;
    //tiempo en el que el monopatin esta en pausa
    private int timeOut;

    public ReportDTO(int id, float km, int timeOut) {
        this.id = id;
        this.km = km;
        this.timeOut = timeOut;
    }

}
