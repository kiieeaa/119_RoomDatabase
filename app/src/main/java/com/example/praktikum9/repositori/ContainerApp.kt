package com.example.praktikum9.repositori

import android.app.Application
import android.content.Context
import com.example.praktikum9.room.DatabaseSiswa

interface ContainerApp {

    val repositoriSiswa: RepositoriSiswa
}