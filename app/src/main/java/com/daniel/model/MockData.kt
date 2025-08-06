
package com.daniel.model

import java.time.LocalDate

enum class Tipo {
    INGRESO, EGRESO
    fun simbolo() = name.toLowerCase()
}

data class Movimiento(
    val date: LocalDate,
    val type: Tipo,
    val description: String,
    val amount: Double
)

object MockData {
    val movimientos = listOf(
        Movimiento(LocalDate.of(2025, 8, 1), Tipo.INGRESO, "Pensión", 2000.0),
        Movimiento(LocalDate.of(2025, 8, 2), Tipo.EGRESO, "Compra supermercado", -150.0),
        Movimiento(LocalDate.of(2025, 8, 2), Tipo.EGRESO, "Medicamentos", -50.0),
        Movimiento(LocalDate.of(2025, 8, 3), Tipo.INGRESO, "Regalo familiar", 100.0),
        Movimiento(LocalDate.of(2025, 8, 5), Tipo.EGRESO, "Clube de lectura", -25.0)
    )
}