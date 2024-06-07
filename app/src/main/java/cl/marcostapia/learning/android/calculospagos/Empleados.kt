package cl.marcostapia.learning.android.calculospagos



abstract class Empleado(val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double = sueldoBruto * 0.87
}

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double = sueldoBruto * 0.80
}
