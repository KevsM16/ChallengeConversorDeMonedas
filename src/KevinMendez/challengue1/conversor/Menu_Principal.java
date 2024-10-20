package KevinMendez.challengue1.conversor;

import java.net.URISyntaxException;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Menu_Principal {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String moneda1;
        String moneda2;
        double cantidad;
        boolean salir=false;
        int opcionSalir;
        ConverterAndDates conv=new ConverterAndDates();

            System.out.println("BIENVENIDO AL CONVERSOR DE MONEDAS \uD83E\uDE99: ");

            while(salir==false){
                try {
                    System.out.println("PARA EMPEZAR ELIGE UNA MONEDA (COLOCA LAS SIGLAS DE LA MONEDA EN EL PANEL DE OPCION) , " +
                            "ALGUNAS OPCIONES SON ARS(PESO ARGENTINO),BOB(PESO BOLIVIANO)," + " BRB(REAL BRASILEÑO)," +
                            "CLP(PESO CHILENO),COP(PESO COLOMBIANO),USD(DOLAR ESTADOUNIDENSE),EUR(EUROS) ");
                    moneda1 = scan.nextLine();

                    System.out.println("Ahora selecciona la moneda a la que quieras convertir una cantidad");
                    moneda2 = scan.nextLine();

                    System.out.println("Selecciona la cantidad de la moneda elegida en la primera opcion");

                    try{
                        cantidad=scan.nextDouble();
                        conv.Converter(moneda1,moneda2);
                        conv.ConversionCalc(cantidad);
                    }catch (InputMismatchException | NumberFormatException e){
                        System.out.println("ingresa un valor valido");
                        break;
                    }

                    if(conv.getCalc()==0.0){
                        System.out.println("Ha ocurrido un error en la conversion asegurate de colocar las siglas correctamente para saber de mas siglas ingrese al siguiente link \uD83D\uDC49 https://www.exchangerate-api.com/docs/supported-currencies  ");
                    }else{
                        System.out.println(conv.getMessage());

                    }
                    System.out.println("Si desea salir coloque 1 de lo contrario coloque 2 para continuar ");
                    
                    } catch (Exception e){
                    System.out.println("Oh oh ocurrio un error asegurate de colocar las siglas correctamente y en mayusculas para saber de mas siglas ingrese al siguiente link \uD83D\uDC49 https://www.exchangerate-api.com/docs/supported-currencies");
                    System.out.println("Si desea salir coloque 1 de lo contrario coloque 2 para continuar ");
                }
                opcionSalir=scan.nextInt();

            if (opcionSalir==1){
                System.out.println("Muchas gracias por usar el conversor :D \uD83D\uDC4D");
salir=true;
            }else{
                moneda1=scan.nextLine();
            }


        }

            }
        }
