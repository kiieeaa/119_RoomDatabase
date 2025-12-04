package com.example.praktikum9.ViewModel.provider

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum9.repositori.AplikasiSiswa
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.praktikum9.ViewModel.DetailViewModel
import com.example.praktikum9.ViewModel.EditViewModel
import com.example.praktikum9.ViewModel.EntryViewModel
import com.example.praktikum9.ViewModel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        // HAPUS BARIS INI: val aplikasiSiswa = this.aplikasiSiswa()

        initializer {
            // Pindah variabel ke sini, di mana 'this' adalah CreationExtras
            val aplikasiSiswa = this.aplikasiSiswa()
            HomeViewModel(
                aplikasiSiswa.container.repositoriSiswa
            )
        }
        initializer {
            // Ulangi untuk EntryViewModel
            val aplikasiSiswa = this.aplikasiSiswa()
            EntryViewModel(
                aplikasiSiswa.container.repositoriSiswa
            )
        }
        initializer {
            DetailViewModel(this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa)

        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)