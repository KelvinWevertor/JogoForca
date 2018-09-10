package br.com.senaijandira.jogoforca;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class inicioActivity extends Activity {

String [] palavra = {"SENAI","FACULDADE","UNIVERSIDADE", "GEOMETRIA", "ESCOLA", "JANDIRA", "BARUERI", "OSASCO", "CARAGUATATUBA", "UVA", "VACA", "CELULAR", "COMPUTADOR", "TELEFONE", "BRASIL", "VIAGEM", "TURISMO"};
ArrayList<String> letras= new ArrayList<String>();
int palavratual =0 ;
Button btntmp;

    public void btnclick(View ver){
        btntmp = (Button) ver;
        btntmp.setEnabled(false);
        //btntmp.setBackgroundColor(Color.parseColor("#ff0000"));

        letras.add(btntmp.getText().toString().toUpperCase());
        jogo();

    }

    public boolean ler (String a){
        for (int i=0; i<letras.size();i++) {
            if(a.equals(letras.get(i).toString())){
                btntmp.setBackgroundColor(Color.parseColor("#07ff00"));
               return true;
            }
        }
        btntmp.setBackgroundColor(Color.parseColor("#ff0000"));
        return false;
    }

    public void jogo (){
        LinearLayout painel = findViewById(R.id.painelResposta);
        painel.removeAllViews();
        int letrasachadas=0;
        System.out.println("-----------------------------------------------------------------------------");
        for(int i=0;i<palavra[palavratual].length();i++){
            System.out.println("letra atual: "+ palavra[palavratual].substring(i,i+1));
            String letraAtual =  palavra[palavratual].substring(i,i+1).toString();




            if (ler(letraAtual.toString())){
                TextView txttemp = new TextView(this);
                txttemp.setText(letraAtual);
                txttemp.setWidth(50);
                txttemp.setHeight(50);
                txttemp.setTextColor(Color.parseColor("#ffffff"));
                System.out.println("Acheei :"+letraAtual);
                painel.addView(txttemp);
                letrasachadas++;
            }else {
                TextView txttemp = new TextView(this);
                txttemp.setText("_");
                txttemp.setTextColor(Color.parseColor("#ffffff"));
                txttemp.setWidth(50);
                txttemp.setHeight(50);
                System.out.println("Não achei a :"+letraAtual);
                painel.addView(txttemp);
            }


            /*
            *
            * se (letraatual==letra que ja que já exite na ArrayList letras)então{
            *   crie um um textview com a propriedade text como sendo o da letraatual e coloque no painel
            * }senao{
            *   crier um text view com a propriedade text como sendo _  e coloque no painel
            * }
            *
            *
            *
            */
        }

        if(palavra[palavratual].length()==letrasachadas){
            System.out.println("Venceu");
            palavratual++;
            letras.clear();
            onCreate(null);
        }
    }

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_inicio);

        jogo();

    }
}
