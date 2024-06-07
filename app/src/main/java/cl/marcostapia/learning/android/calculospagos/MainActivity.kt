package cl.marcostapia.learning.android.calculospagos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.content.Intent
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import cl.marcostapia.learning.android.calculospagos.ui.theme.CalculosPagosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculosPagosTheme {
                PantallaInicio()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicio() {
    val contexto = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cálculo de Pagos",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier
                .height(60.dp)
                .width(200.dp),
            onClick = {
                val intent = Intent(contexto, CalculoHonorariosActivity::class.java)
                contexto.startActivity(intent)
            }
        ) {
            Text("Honorarios")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .height(60.dp)
                .width(200.dp),
            onClick = {
                val intent = Intent(contexto, CalculoEmpleadoActivity::class.java)
                contexto.startActivity(intent)
            }
        ) {
            Text("Empleado Regular")
        }
    }
}
