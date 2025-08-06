package com.daniel.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.lazyColumn
import androidx.compose.foundation.layout.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import com.daniel.model.Movimiento
import com.daniel.model.Tipo

@Composable
fun DayDetailScreen(date: LocalDate, movimientos: List<Movimiento>) {
    val saldo = movimientos.sumOf { it.amount }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Detalle de ${date}", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Saldo del diás: $${"$"%.format(saldo)}", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(movimientos) { mov ->
                Card {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("${mov.type.name:} ${mov.description}")
                        Text("Monto: $${mov.amount}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}