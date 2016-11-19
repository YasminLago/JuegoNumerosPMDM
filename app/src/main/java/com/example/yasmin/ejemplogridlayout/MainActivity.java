package com.example.yasmin.ejemplogridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    int btnStart = R.id.btnStart;
    int [] botones = {
            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,
    };

    ArrayList<Integer> aleatorio = new ArrayList<>(); //Guarda los números generados aleatoriamente
    ArrayList<Integer> respuesta = new ArrayList<>(); //Guarda las respuestas del jugador
    int contador = 0; //Cuenta el número de botones marcados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Comienza el juego y muestra en una Toast los números aleatorios
     * @param btnSt
     */
    void start(View btnSt){
        findViewById(btnStart).setEnabled(false);
        numAleatorio();
        Toast.makeText(getApplicationContext(),aleatorio.toString(),Toast.LENGTH_SHORT).show();
    }

    /**
     * Guarda en el ArrayList respuestas los números marcados por el jugador y llama al metodo comprobación
     * @param btns
     */
    void pulsarBtn(View btns){
        contador++;
        String num = (String) btns.getTag();
        int btn = Integer.parseInt(num);
        respuesta.add(btn);

        if(contador == 4){
            //Recorre el array botones y los desactiva
            for(int i: botones){
                findViewById(i).setEnabled(false);
            }
            comprobacion();
            contador = 0;
        }
    }

    /**
     * Compara los ArrayList aleatorio y respuesta y muestra en una Toast si se ha ganado o perdido
     */
    void comprobacion(){
        String random = aleatorio.toString();
        String resp = respuesta.toString();

        if(random.equals(resp)){
            Toast.makeText(getApplicationContext(),"Has acertado!",Toast.LENGTH_SHORT).show();

            findViewById(btnStart).setEnabled(true);
            for(int i: botones){
                findViewById(i).setEnabled(true);
            }
        }else{
            Toast.makeText(getApplicationContext(),"Has fallado",Toast.LENGTH_SHORT).show();
        }
        aleatorio.clear();
        respuesta.clear();
    }

    /**
     * Genera el número aleatorio y lo guarda en el ArrayList aleatorio
     */
    void numAleatorio(){
        for (int i = 0; i<4;i++) {
            int random = (int) Math.floor(Math.random() * 9);
            aleatorio.add(random);
        }

    }
}
