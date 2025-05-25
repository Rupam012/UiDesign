package com.rupam.basicinterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rupam.basicinterface.ui.theme.BasicInterfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicInterfaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CredProfileScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CredProfileScreen(modifier: Modifier = Modifier) {
    val background = Color(0xFF1C1C1E)
    val cardBackground = Color(0xFF0A0A0A)
    val dividerColor = Color(0xFF2C2C2E)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text("Profile", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(
                onClick = {},
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Icon(Icons.Default.ChatBubbleOutline, contentDescription = "support", modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("support", fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Profile Info
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.profile_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Rupam Mondal", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("member since Dec, 2020", color = Color.Gray, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedIconButton(
                onClick = {},
                border = BorderStroke(1.dp, Color.DarkGray),
                modifier = Modifier.size(36.dp)
            ) {
                Icon(Icons.Default.Edit, contentDescription = null, tint = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // CRED Garage
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = cardBackground),
            border = BorderStroke(1.dp, dividerColor)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Default.DirectionsCar, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("get to know your vehicles, inside out", color = Color.Gray, fontSize = 14.sp)
                    Text("CRED garage", color = Color.White, fontSize = 16.sp)
                }
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Credit Info Section with dividers
        Column(
            modifier = Modifier
        ) {
            MetricRow("credit score", "757", Color(0xFF00FF00), "REFRESH AVAILABLE")
            Divider(color = dividerColor, thickness = 1.dp)
            MetricRow("lifetime cashback", "₹3")
            Divider(color = dividerColor, thickness = 1.dp)
            MetricRow("bank balance", "check")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Rewards Background
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .padding(18.dp)
        ) {
            Text("YOUR REWARDS & BENEFITS", color = Color.Gray, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
            RewardsRow("cashback balance", "₹0")
            Divider(color = dividerColor, thickness = 1.dp)
            RewardsRow("coins", "26,46,583")
            Divider(color = dividerColor, thickness = 1.dp)
            RewardsRow("win upto Rs 1000", "refer and earn")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Transactions
        Text("TRANSACTIONS & SUPPORT", color = Color.Gray, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
        RewardsRow("all transactions", "")
    }
}

@Composable
fun MetricRow(title: String, value: String, valueColor: Color = Color.White, extra: String = "") {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Icon(Icons.Default.Circle, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(14.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Row {
                Text(title, color = Color.LightGray, fontSize = 14.sp)
                if (extra.isNotEmpty()) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("• $extra", color = Color(0xFF00FF00), fontSize = 14.sp)
                }
            }
        }
        Text(value, color = valueColor, fontSize = 14.sp)
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.White)
    }
}

@Composable
fun RewardsRow(title: String, subtitle: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = Color.White, fontSize = 14.sp)
            if (subtitle.isNotEmpty()) {
                Text(subtitle, color = Color.Gray, fontSize = 13.sp)
            }
        }
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCredProfileScreen() {
    BasicInterfaceTheme {
        CredProfileScreen()
    }
}
