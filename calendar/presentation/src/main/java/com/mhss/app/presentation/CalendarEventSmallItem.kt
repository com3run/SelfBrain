package com.mhss.app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mhss.app.domain.model.CalendarEvent
import com.mhss.app.ui.R
import com.mhss.app.util.date.formatEventStartEnd

@Composable
fun CalendarEventSmallItem(
    event: CalendarEvent,
    onClick: (CalendarEvent) -> Unit
) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(
            6.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(6.dp)
                    .height(26.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(Color(event.color)),
            )
            Spacer(Modifier.width(4.dp))
            Column(
                modifier = Modifier
                    .clickable { onClick(event) }
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    event.title,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    context.formatEventStartEnd(
                        start = event.start,
                        end = event.end,
                        allDayString = stringResource(R.string.all_day),
                        eventTimeAtRes = R.string.event_time_at,
                        eventTimeRes = R.string.event_time,
                        location = event.location,
                        allDay = event.allDay,
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                )

            }
        }
    }
}