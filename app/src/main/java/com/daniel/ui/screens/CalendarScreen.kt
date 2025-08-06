
package com.daniel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CalendarScreen(onDaySelected: (LocalDate) -. Unit) {
    val today = LocalDate.now()
    val yearMonth = YearMonth.of(today.year, today.month)
    val days = (1..yearMonth.lengthOfMonth()).map { day ->
        yearMonth.atDay(day)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "${yearMonth.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${yearMonth.year}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(days) { date ->
                Box
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFB3E5FC), shape = MaterialTheme.shapes.medium)
                        .clickable { onDaySelected(date) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "${$date.dayOfMonth}", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}
