package com.example.finalprojectjpc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.finalprojectjpc.R

@Composable
fun LoginScreen(navController: NavHostController) {

    var phone by remember { mutableStateOf("") }

    val backgroundColor = Color(0xFFD7D6CC)
    val buttonColor = Color(0xFFB9252A)
    val blueColor = Color(0xFF1E73FF)

    Column(
        modifier = Modifier.fillMaxSize().background(backgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.login_banner),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(240.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Your Phone number", fontSize = 20.sp, fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text("Enter Your Phone Number")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Sign in with ", color = buttonColor, fontSize = 14.sp
                )
                Text(
                    text = "Email",
                    color = buttonColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    if (phone.isNotEmpty()) {
                        navController.navigate("home")
                    }
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                )
            ) {

                Text(
                    text = "login", color = Color.White, fontSize = 18.sp
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = buildAnnotatedString {
                    append("By clicking login you agree to our ")
                    withStyle(SpanStyle(color = blueColor)) {
                        append("terms & conditions")
                    }
                    append(" and ")

                    withStyle(SpanStyle(color = blueColor)) {
                        append("privacy policy")
                    }

                }, fontSize = 13.sp, color = Color.Gray
            )
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f), thickness = 1.dp, color = Color.LightGray
                )
                Text(
                    text = "  OR  ", fontSize = 14.sp
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f), thickness = 1.dp, color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SocialCircle("G", Color(0xFFDB4437))
                SocialCircle("f", Color(0xFF1877F2))
                SocialCircle("t", Color(0xFF1DA1F2))
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}


@Composable
fun SocialCircle(text: String, color: Color) {

    Card(
        modifier = Modifier.size(48.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                text = text, color = color, fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
        }
    }
}