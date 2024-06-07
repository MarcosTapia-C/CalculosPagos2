package cl.marcostapia.learning.android.calculospagos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculoEmpleadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_empleado)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val sueldoBruto = findViewById<EditText>(R.id.etSueldoBruto)

        btnCalcular.setOnClickListener {
            val sueldo = sueldoBruto.text.toString().toDoubleOrNull() ?: 0.0
            val empleado = EmpleadoRegular(sueldo)
            val liquido = empleado.calcularLiquido()
            resultado.text = "El sueldo líquido es $liquido"
        }
    }

    fun volverAtras(view: View) {
        finish()
    }
}

