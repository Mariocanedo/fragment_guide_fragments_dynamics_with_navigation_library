package com.example.fragment_guide_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fragment_guide_0.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
// clase binding para referencias elementos
    private ActivityMainBinding mBinding;
    // variable boolean para saber cuando esta el fragmento desplegado o no
    private boolean isfragmentShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inflamos la vista
     mBinding = ActivityMainBinding.inflate((getLayoutInflater()));
     setContentView(mBinding.getRoot());


     mBinding.buttonfragment1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(isfragmentShow){

                 CloseFragment();

             }
             else {

                 openFragment();
             }
         }
     });



     mBinding.buttonParametros.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             OpenFragmentBlank("Mario","Canedo");
         }
     });


    }


     // crear un metodo que despliegue el fragmento

    private void openFragment(){

        //1 generar la instancia del fragmento

        QuestionFragment questionFragment = new QuestionFragment();
        //2 tener la instancia de los fragmentos
        FragmentManager manager = getSupportFragmentManager();
        // llamar la transaccion

        FragmentTransaction transaction = manager.beginTransaction().add(
                mBinding.contenedor.getId(),questionFragment,QuestionFragment.class.getSimpleName()).addToBackStack(null);

         transaction.commit();
         mBinding.buttonfragment1.setText("Abrir");
         isfragmentShow= true;


    }

    private void CloseFragment(){

        // generar la instancia del fragmento
        FragmentManager manager = getSupportFragmentManager();
        QuestionFragment questionFragment =(QuestionFragment) manager.findFragmentById(mBinding.contenedor.getId());

        if(questionFragment !=null){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(questionFragment).commit();
            mBinding.buttonfragment1.setText("cerrar");
            isfragmentShow= false;

        }

    }



   // crear metodo para cerrar fragmento
     private void OpenFragmentBlank(String name, String lastname){
        BlankFragment blankFragment = BlankFragment.newInstance(name,lastname);

         //2 tener la instancia de los fragmentos
         FragmentManager manager = getSupportFragmentManager();

         FragmentTransaction transaction = manager.beginTransaction().add(
                 mBinding.contenedor.getId(),blankFragment,BlankFragment.class.getSimpleName());
         transaction.commit();

     }



}