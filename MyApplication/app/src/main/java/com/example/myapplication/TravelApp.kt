package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Screens.Home
import com.example.myapplication.Model.ProfileViewModel
import com.example.myapplication.Model.SearchViewModel
import com.example.myapplication.Model.SignInViewModel
import com.example.myapplication.Model.SignUpViewModel
import com.example.myapplication.Screens.Lists
import com.example.myapplication.Screens.Locations.Budapest.Budapest
import com.example.myapplication.Screens.Locations.Budapest.attractions.AttractionBp
import com.example.myapplication.Screens.Locations.Budapest.generateSampleLocations
import com.example.myapplication.Screens.Locations.Budapest.parks.ParkBp
import com.example.myapplication.Screens.Locations.Budapest.restaurants.RestaurantBp
import com.example.myapplication.Screens.Locations.Rome.Rome
import com.example.myapplication.Screens.Locations.Vienna.Vienna
import com.example.myapplication.Screens.Map
import com.example.myapplication.Screens.Profile
import com.example.myapplication.Screens.Search
import com.example.myapplication.Screens.SignIn
import com.example.myapplication.Screens.SignUp

@Composable
fun TravelApp() {
    val list =generateSampleLocations()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            Navigation(navController = navController)
        }
    ) {
        NavHost(navController = navController, startDestination = NavGraph.Home, modifier = Modifier.padding(paddingValues = it)) {
            composable(NavGraph.Home) { Home(navController) }
            composable(NavGraph.Search) {
                val viewModel: SearchViewModel = viewModel()
                Search(viewModel = viewModel,navController) }
            composable(NavGraph.Lists) { Lists() }
            composable(NavGraph.Profile) {
                val viewModel: ProfileViewModel = viewModel()
                Profile(viewModel = viewModel,navController)
            }
            composable(NavGraph.SignIn) {
                val viewModel: SignInViewModel = viewModel()
                SignIn(viewModel=viewModel,navController) }
            composable(NavGraph.SignUp) {
                val viewModel: SignUpViewModel = viewModel()
                SignUp(viewModel=viewModel,navController) }
            composable(NavGraph.Budapest) {
                Budapest(navController) }
            composable(NavGraph.Vienna) {
                Vienna(navController) }
            composable(NavGraph.Rome) {
                Rome(navController) }
            composable(NavGraph.Map) {
                Map() }
            composable(NavGraph.BudapestPark) {
                ParkBp(list[0],navController) }
            composable(NavGraph.BudapestRest) {
                RestaurantBp(list[1],navController) }
            composable(NavGraph.BudapestAtt) {
                AttractionBp(list[2],navController) }

        }
    }
}
object NavGraph {
    const val Home = "home"
    const val Search = "search"
    const val Lists = "lists"
    const val Profile = "profile"
    const val SignIn = "signin"
    const val SignUp = "signup"
    const val Budapest = "Budapest"
    const val BudapestAtt = "attractionBP"
    const val BudapestRest = "restaurantBP"
    const val BudapestPark = "parkBP"
    const val Vienna = "Vienna"
    const val Rome = "Rome"
    const val Map = "map"
}
