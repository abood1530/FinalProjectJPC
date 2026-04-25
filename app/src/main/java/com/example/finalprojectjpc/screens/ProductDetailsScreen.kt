package com.example.finalprojectjpc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.RemoveShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.finalprojectjpc.R

@Composable
fun ProductDetailsScreen(navController: NavHostController) {

    var quantity by remember { mutableIntStateOf(1) }

    val backgroundColor = Color(0xFFF7EFF1)
    val primaryRed = Color(0xFFB9252A)
    val lightGray = Color(0xFFF4F4F4)
    val iconGray = Color(0xFF8D8D8D)

    Scaffold(
        containerColor = Color.White, bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.White)
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier.size(52.dp).clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFFF8F1F2)), contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.RemoveShoppingCart,
                        contentDescription = null,
                        tint = primaryRed
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f).height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryRed
                    )
                ) {
                    Text(
                        text = "Buy now",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }) { padding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {

            Box(
                modifier = Modifier.fillMaxWidth().height(330.dp).background(backgroundColor)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.size(34.dp).background(Color.White, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(
                        onClick = { },
                        modifier = Modifier.size(34.dp).background(Color.White, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = iconGray
                        )
                    }
                }

                Row(
                    modifier = Modifier.align(Alignment.TopStart)
                        .padding(start = 18.dp, top = 70.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SmallPreviewImage(imageRes = R.drawable.product_laser)
                    SmallPreviewImage(imageRes = R.drawable.product_laser)
                    SmallPreviewImage(imageRes = R.drawable.product_laser)
                }
                Image(
                    painter = painterResource(id = R.drawable.product_laser),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center).size(220.dp),
                    contentScale = ContentScale.Fit
                )
                Row(
                    modifier = Modifier.align(Alignment.BottomStart)
                        .padding(start = 18.dp, bottom = 18.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MiniColorImage(imageRes = R.drawable.product_laser)
                    MiniColorImage(imageRes = R.drawable.product_laser)
                    MiniColorImage(imageRes = R.drawable.product_laser)
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color.White).padding(horizontal = 16.dp, vertical = 14.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$10.00",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                    QuantityButton(
                        icon = Icons.Outlined.Remove, onClick = {
                            if (quantity > 1) quantity--
                        }, background = Color(0xFFD88B8E)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = quantity.toString().padStart(2, '0'),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    QuantityButton(
                        icon = Icons.Outlined.Add, onClick = { quantity++ }, background = primaryRed
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE8E8E8))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFF4B400),
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "4.8", fontWeight = FontWeight.Bold, fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "| 50 Orders", color = Color(0xFF666666), fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = ">", color = Color(0xFF8A8A8A), fontSize = 18.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "1. Applicable : 100-240V working voltage, suitable for all the countries in the world.",
                    fontSize = 14.sp,
                    color = Color(0xFF2E2E2E),
                    lineHeight = 24.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "2. Painless: Adjustable optimal energy level according to the skin tolerance. Providing the gentle treatment painlessly and easily , without hurting the skin. The LED light clear shows the energy level.",
                    fontSize = 14.sp,
                    color = Color(0xFF2E2E2E),
                    lineHeight = 24.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "3. Fast and big treatment area : wavelength >510um,3 cm 2: spot size not too bia or neither too small for anv",
                    fontSize = 14.sp,
                    color = Color(0xFF2E2E2E),
                    lineHeight = 24.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(color = lightGray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun SmallPreviewImage(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier.size(42.dp).clip(CircleShape).border(1.dp, Color.White, CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun MiniColorImage(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier.size(width = 44.dp, height = 54.dp).clip(RoundedCornerShape(10.dp))
            .background(Color.White),
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun QuantityButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit, background: Color
) {
    Box(
        modifier = Modifier.size(28.dp).clip(CircleShape).background(background)
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}