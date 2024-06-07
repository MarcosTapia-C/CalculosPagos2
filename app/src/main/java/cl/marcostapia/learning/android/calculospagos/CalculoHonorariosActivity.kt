package cl.marcostapia.learning.android.calculospagos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions

class CalculoHonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaCalculoHonorarios()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PantallaCalculoHonorarios() {
    var sueldoBruto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val contexto = LocalContext.current as ComponentActivity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cálculo Honorarios",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            placeholder = { Text("Sueldo Bruto") },
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val sueldo = sueldoBruto.toDoubleOrNull() ?: 0.0
            val empleado = EmpleadoHonorarios(sueldo)
            val liquido = empleado.calcularLiquido()
            resultado = "El sueldo líquido es de $liquido"
        }) {
            Text("Calcular Sueldo Líquido")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(resultado)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { contexto.finish() }) {
            Text("<- Volver")
        }
    }
}
