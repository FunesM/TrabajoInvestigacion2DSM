package sv.edu.udb.trabajodeinvestigacion;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.edu.udb.trabajodeinvestigacion.Persona;

import androidx.appcompat.app.AppCompatActivity;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtDUI, edtNombre, edtEdad;
    String key="",nombre="",dui="",accion="", edad="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edtEdad = findViewById(R.id.edtEdad);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        edad=datos.getString("edad");
        accion=datos.getString("accion");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        edtEdad.setText(edad);
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String edad = edtEdad.getText().toString();
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre,edad);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}
