package com.example.quest6_125.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quest6_125.ui.view.screen.MahasiswaFormView
import com.example.quest6_125.ui.view.screen.RencanaStudyView
import com.example.quest6_125.ui.view.screen.SplashView
import com.example.quest6_125.ui.view.screen.TampilView
import com.example.quest6_125.ui.view.viewmodel.MahasiswaViewModel
import com.example.quest6_125.ui.view.viewmodel.RencanaStudyViewModel


enum class Halaman{
    Splash,
    Mahasiswa,
    RencanaStudy,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel (),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),

    ){
    //val uiState = viewModel.statusUI.collectAsState()
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsUiState = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(
            route = Halaman.Splash.name){
            SplashView (onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.RencanaStudy.name)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(route = Halaman.RencanaStudy.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onBackButtonClicked = {navController.popBackStack()},
                onSubmitButtonClicked ={krsViewModel.saveDataKRS(it)
                    navController.navigate(Halaman.Tampil.name)}
            )
        }
        composable(route = Halaman.Tampil.name){
            TampilView(mahasiswa = mahasiswaUiState,
                krs =krsUiState,
                onResetButtonClicked = {navController.navigate(Halaman.Splash.name)},
                onBackButtonClicked = {navController.popBackStack() })
        }
    }
}