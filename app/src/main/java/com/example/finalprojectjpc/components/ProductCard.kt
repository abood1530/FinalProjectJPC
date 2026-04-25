package com.example.finalprojectjpc.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalprojectjpc.screens.Product

@Composable
fun ProductCard(
    product: Product, onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(130.dp),
                    contentScale = ContentScale.Crop
                )
                product.discount?.let {

                    Box(
                        modifier = Modifier.padding(8.dp).background(
                            Color(0xFFE53935), RoundedCornerShape(6.dp)
                        ).padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = it, color = Color.White, fontSize = 12.sp
                        )
                    }

                }
                IconButton(
                    onClick = { },
                    modifier = Modifier.align(Alignment.TopEnd)
                        .background(Color.White, CircleShape),
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }
            }
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black
                )
                Text(
                    text = product.brand, fontSize = 13.sp, color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    product.oldPrice?.let {
                        Text(
                            text = "$$it", style = TextStyle(
                                textDecoration = TextDecoration.LineThrough
                            ), color = Color.Gray, fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                    }

                    product.price?.let {
                        Text(
                            text = "$$it",
                            color = Color(0xFFE53935),
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    if (product.sold > 0) {
                        Text(
                            text = "${product.sold} sold", color = Color.Gray, fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}