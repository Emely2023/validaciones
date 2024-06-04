package emely.benitez.validacionesyspinner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. Mandar a llamar todos los elementos
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val txtDui = findViewById<EditText>(R.id.txtDui)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2. Agregar unn evento al boton
        btnAgregar.setOnClickListener {

            //Validemos que los camposno estèn vaciod
            if (txtEdad.text.isEmpty()
                || txtNombre.text.isEmpty()
                || txtCorreo.text.isEmpty()
                || txtContrasena.text.isEmpty()
                || txtDui.text.isEmpty()
            ) {
                Toast.makeText(this, "Llené todos los campos", Toast.LENGTH_LONG).show()

                //Validamos solo números
            } else if (txtEdad.text.matches("[0-9]+".toRegex())) {
                Toast.makeText(this, "Campos Agregados", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "por favor ingrese numero de la Edad", Toast.LENGTH_LONG)
                    .show()
            }
            //Validamos el correo lleve arroba
            if (txtCorreo.text.matches("[a-zA-Z0-9._]+@[a-z]+////.+[a-z]+]".toRegex())) {


                Toast.makeText(this, "Correo real", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "correo no real", Toast.LENGTH_SHORT).show()
            }

            //Validar la contraseña para que tenga mas de 7 digitos
            if (txtContrasena.text.length <= 6) {
                Toast.makeText(this, "Debe tener mas de de digitos", Toast.LENGTH_LONG).show()
            }
            //Validar el Dui

        }
        //Validar el Dui
        if (txtDui.text.matches("[0-9]+-[0-9]".toRegex())
            && txtDui.text.length <= 10
        ) {


        } else {

        }
        if (txtNombre.text.matches("[a-zA-Z]=".toRegex())){
        }


    }
}