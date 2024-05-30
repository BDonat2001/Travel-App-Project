package com.example.myapplication.Screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.Model.ProfileViewModel
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(viewModel: ProfileViewModel,navController: NavHostController) {
    val userSignedIn = viewModel.userSignedIn.value
    Column(modifier = Modifier.fillMaxSize()) {
        // Top app bar
        TopAppBar(
            title = { Text(
                text = "Profile")
                },
        )

        // Profile picture section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = Icons.Filled.Person,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentDescription = "Profile picture"
            )
        }

        // User name and location
        Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = "John Doe", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "San Francisco, CA", style = MaterialTheme.typography.bodyMedium)
        }

        // Edit profile button or Sign in
        Button(
            onClick = { if(userSignedIn==false)navController.navigate("signin") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(text = if (userSignedIn==true) "Edit Profile" else "Sign In", color = Color.White)
        }

        // List of profile sections
        Column(modifier = Modifier.fillMaxWidth()) {
            ProfileSection(title = "Notifications", icon = Icons.Outlined.Notifications)
            ProfileSection(title = "Appearance", icon = Icons.Outlined.DarkMode)
            ProfileSection(title = "Preferences", icon = Icons.Outlined.Settings)
            ProfileSection(title = "Privacy", icon = Icons.Outlined.Lock)
            ProfileSection(title = "Storage & Data", icon = Icons.Outlined.Storage)
            ProfileSection(title = "About", icon = Icons.Outlined.Info)
            ProfileSection(title = "Sign Out", icon = Icons.AutoMirrored.Outlined.Logout)
        }
    }
}


@Composable
fun ProfileSection(title: String, icon: ImageVector) {
    ListItem(
        headlineContent = {
            Text(text = title)
        },
        leadingContent = {
            Icon(imageVector = icon, contentDescription = title)
        },
        trailingContent = {
            Icon(Icons.Outlined.ChevronRight, contentDescription = "Navigate to section")
        })
}
