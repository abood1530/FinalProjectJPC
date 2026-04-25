package com.example.finalprojectjpc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Payment
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.finalprojectjpc.components.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(navController: NavHostController) {

    var showEditProfile by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var name by remember { mutableStateOf("Mona Fadl Al-Harthy") }
    var phone by remember { mutableStateOf("009665211043") }
    var email by remember { mutableStateOf("Mona Fadl@gmail.com") }

    Scaffold(
        bottomBar = {
            BottomNavBar(navController, "account")
        }) { padding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(padding).background(Color.White)
        ) {
            Text(
                text = "Account",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp).align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Image(
                        painter = painterResource(R.drawable.profile_user),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp).clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier.size(24.dp).align(Alignment.BottomEnd)
                            .background(Color.Red, CircleShape), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = name,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = phone, color = Color.Gray, fontSize = 14.sp
                    )
                    Text(
                        text = email, color = Color.Gray, fontSize = 14.sp
                    )
                }
                IconButton(
                    onClick = { showEditProfile = true }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = Color.Blue
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = DividerDefaults.Thickness,
                color = DividerDefaults.color
            )
            MenuItem(
                icon = Icons.Outlined.Inventory2, title = "My order", endText = "4"
            )
            MenuItem(
                icon = Icons.Outlined.Payment, title = "payment method"
            )
            MenuItem(
                icon = Icons.Outlined.LocationOn, title = "shipping address"
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
            MenuItem(
                icon = Icons.Outlined.HelpOutline, title = "FAQ"
            )
            MenuItem(
                icon = Icons.Outlined.PersonAdd, title = "invite friends"
            )
            MenuItem(
                icon = Icons.Outlined.Settings, title = "settings"
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

            MenuItem(
                icon = Icons.AutoMirrored.Outlined.Logout, title = "Logout"
            )
        }

        if (showEditProfile) {
            ModalBottomSheet(
                onDismissRequest = { showEditProfile = false },
                sheetState = sheetState,
                containerColor = Color.White,
                contentColor = Color.Black
            ) {
                EditProfileContent(
                    name = name,
                    phone = phone,
                    email = email,
                    onDone = { newName, newPhone, newEmail ->
                        name = newName
                        phone = newPhone
                        email = newEmail
                        showEditProfile = false
                    })
            }
        }
    }
}

@Composable
fun MenuItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, endText: String? = null
) {

    Row(modifier = Modifier.fillMaxWidth().clickable { }
        .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically) {

        Icon(
            imageVector = icon, contentDescription = null, tint = Color.Gray
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title, color = Color.Black, fontSize = 16.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        endText?.let {
            Text(
                text = it, color = Color.Red, fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun EditProfileContent(
    name: String, phone: String, email: String, onDone: (String, String, String) -> Unit
) {

    var nameState by remember { mutableStateOf(name) }
    var phoneState by remember { mutableStateOf(phone) }
    var emailState by remember { mutableStateOf(email) }


    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {

        Text("Your Name")

        OutlinedTextField(
            value = nameState,
            onValueChange = { nameState = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Your Phone number")

        OutlinedTextField(
            value = phoneState,
            onValueChange = { phoneState = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Your Email Address")

        OutlinedTextField(
            value = emailState,
            onValueChange = { emailState = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                onDone(nameState, phoneState, emailState)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB9252A))
        ) {
            Text("Done", color = Color.White)
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
