package com.example.stockpulseapp.presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.stockpulseapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {

    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val bio = remember { mutableStateOf("") }

    Scaffold(

        containerColor = Color.White,

        topBar = {

            TopAppBar(

                modifier = Modifier.height(56.dp),

                windowInsets = WindowInsets(0),

                title = {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Edit Profile",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }
                },

                navigationIcon = {

                    IconButton(
                        onClick = { }
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                contentAlignment = Alignment.BottomEnd
            ) {

                Image(
                    painter = painterResource(
                        id = R.drawable.profile_circle_svgrepo_com
                    ),
                    contentDescription = null,

                    contentScale = ContentScale.Crop,

                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )

                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable { },

                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(

                modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    OutlinedTextField(
                        value = name.value,
                        onValueChange = {
                            name.value = it
                        },

                        label = {
                            Text(text = "Full Name")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true
                    )

                    OutlinedTextField(
                        value = email.value,
                        onValueChange = {
                            email.value = it
                        },

                        label = {
                            Text(text = "Email")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true
                    )

                    OutlinedTextField(
                        value = phone.value,
                        onValueChange = {
                            phone.value = it
                        },

                        label = {
                            Text(text = "Phone Number")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true
                    )

                    OutlinedTextField(
                        value = bio.value,
                        onValueChange = {
                            bio.value = it
                        },

                        label = {
                            Text(text = "Bio")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        minLines = 3
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),

                        shape = RoundedCornerShape(14.dp)
                    ) {

                        Text(
                            text = "Save Changes"
                        )
                    }
                }
            }
        }
    }
}