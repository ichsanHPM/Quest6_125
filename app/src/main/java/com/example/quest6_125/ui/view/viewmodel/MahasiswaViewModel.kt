package com.example.quest6_125.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quest6_125.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    private val _statusUI = MutableStateFlow(Mahasiswa())

    //Membuat Response
    val mahasiswaUiState: StateFlow<Mahasiswa> = _statusUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>){
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }
}