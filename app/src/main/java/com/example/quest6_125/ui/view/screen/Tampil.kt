package com.example.quest6_125.ui.view.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quest6_125.R
import com.example.quest6_125.model.Mahasiswa
import com.example.quest6_125.model.RencanaStudi

@Composable
fun TampilView(
    mahasiswa: Mahasiswa,
    krs : RencanaStudi,
    onResetButtonClicked: () -> Unit,
    onBackButtonClicked: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 14.dp))
        Row(modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.logoumy), contentDescription = "",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.padding(start = 14.dp))
            Column {
                Text(text = "KRS MAHASISWA",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Nim :",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp)
                    Text(text = mahasiswa.nim,
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp)
                    Text(text = "Nama :",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp)
                    Text(text = mahasiswa.nama,
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp)
                    Text(text = "Email :",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp)
                    Text(text = mahasiswa.email,
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.padding(14.dp))
            Column (modifier = Modifier.fillMaxWidth()){
                Text(text = "MataKuliah peminatan yang dipilih :",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(text = krs.namaMK,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp)
                Text(text = "Kelas :",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp)
                Text(text = krs.kelas,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp)
            }
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Button(onClick = {onBackButtonClicked()}) {
                    Text(text = "Kembali")
                }
                Button(onClick = {onResetButtonClicked()}) {
                    Text(text = "Reset")
                }
            }
        }
    }
}