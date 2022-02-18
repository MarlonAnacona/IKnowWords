package canvas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Diccionario {

    private ArrayList<String> diccionario= new ArrayList<String>();
    private ModelWord mandarPalabra= new ModelWord();
    private ArrayList<String> palabrasHanSalido= new ArrayList<String>();
    private ArrayList<String> palabrastotalesNivel= new ArrayList<>() ;
    private ArrayList<String> palabrasCalificar2= new ArrayList<>() ;
    private String pal;
    String pal3;

    public Diccionario(){
        FileManager fileManager= new FileManager();
        diccionario=fileManager.lecturaFile();
    }

    public String getFrase(){
        Random aleatorio= new Random();

        pal=diccionario.get(aleatorio.nextInt(diccionario.size()));
        while(palabrasHanSalido.contains(pal)){
            pal=diccionario.get(aleatorio.nextInt(diccionario.size()));
        }
        palabrasHanSalido.add(pal);
        mandarPalabra.setPalabrasEnNivel(pal);
        return pal;

    }
    public String getFrasenuevas(){
        Random aleatorio= new Random();

        pal=diccionario.get(aleatorio.nextInt(diccionario.size()));
        return pal;

    }

    public  ArrayList<String> getPalabrasHanSalido(){

        return palabrasHanSalido;
    }
    public void agregarPalabras(){
        Random aleatorioPalabra=new Random();


        String  pal2 ;
        String pal1;

        palabrastotalesNivel=palabrasHanSalido;
        int tamaño=palabrasHanSalido.size();
        for (int i=0;i<tamaño;i++){

            do{
                pal2 = getFrasenuevas();

            }while (palabrasHanSalido.contains(pal2));

            palabrastotalesNivel.add(pal2);

        }
        Collections.shuffle(palabrastotalesNivel);
        System.out.println(palabrastotalesNivel);
    }


    public String getfraseMostrar(int i){

        Random aleatorio= new Random();
        if(i<=0){
            agregarPalabras();
        }
        pal3 = palabrastotalesNivel.get(aleatorio.nextInt(palabrastotalesNivel.size()));
        do {
            pal3 = palabrastotalesNivel.get(aleatorio.nextInt(palabrastotalesNivel.size()));
        }while (palabrasCalificar2.contains(pal3));
        palabrasCalificar2.add(pal3);
        return pal3;

    }


    public void limpiar(){
        palabrasHanSalido.clear();
        palabrasCalificar2.clear();
        palabrastotalesNivel.clear();
    }

}
