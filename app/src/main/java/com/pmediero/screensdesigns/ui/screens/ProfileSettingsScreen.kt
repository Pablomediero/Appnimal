package com.pmediero.screensdesigns.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmediero.screensdesigns.ui.core.LocalSpacing
import com.pmediero.screensdesigns.ui.core.Spacing
import com.pmediero.screensdesigns.ui.screens.components.CustomButton
import com.pmediero.screensdesigns.ui.screens.components.CustomOutlinedDropdown
import com.pmediero.screensdesigns.ui.screens.components.CustomOutlinedTextField
import com.pmediero.screensdesigns.ui.screens.components.ProfileImageViewCustom
import com.pmediero.screensdesigns.ui.screens.components.OutlinedCustomButton
import com.pmediero.screensdesigns.ui.theme.ScreensDesignsTheme

@Composable
fun ProfileSettingsScreen() {
    val spacing = LocalSpacing.current
    val height = LocalConfiguration.current.screenHeightDp.dp

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        ProfileSettingsHeader(
            Modifier
                .fillMaxWidth()
                .padding(
                    top = spacing.medium,
                    start = spacing.medium,
                    end = spacing.medium,
                    bottom = spacing.medium
                ),
            spacing
        )

        ProfileSettingsBody(
            Modifier
                .fillMaxWidth()
                .padding(
                    top = spacing.medium,
                    start = spacing.medium,
                    end = spacing.medium,
                    bottom = spacing.medium
                ),
            spacing
        )

        ProfileSettingsFooter(
            Modifier
                .fillMaxWidth()
                .padding(
                    top = spacing.medium,
                    start = spacing.medium,
                    end = spacing.medium,
                    bottom = spacing.medium
                ),
            spacing
        )
    }
}

// region SCREENS
@Composable
private fun ProfileSettingsHeader(modifier: Modifier, spacing: Spacing) {
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                spacing.large,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Configuración de perfil", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            OutlinedCustomButton(
                modifier = Modifier,
                text = "Ver tu perfil",
                onClick = { }
            )
        }
    }
}

@Composable
private fun ProfileSettingsBody(modifier: Modifier, spacing: Spacing) {
    Column(modifier = modifier) {
        ProfileSettingsSectionProfile(spacing = spacing)
        ProfileSettingsSectionName(spacing = spacing)
        ProfileSettingsSectionAboutYou(spacing = spacing)
    }
}

@Composable
private fun ProfileSettingsFooter(modifier: Modifier, spacing: Spacing) {
    Column(modifier = modifier) {
        CustomButton(
            text = "Guardar Cambios",
            onClick = {}
        )
    }
}
// endregion SCREENS

//region SECTIONS

@Composable
fun ProfileSettingsSectionProfile(spacing: Spacing){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(
            spacing.medium,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.Start,
    ) {
        Text("Imagen de perfil", fontWeight = FontWeight.Bold)
        ProfileImageViewCustom(
            onClick = {}
        )
        Column {
            Text(
                text = "Consejo: utiliza una foto en la que tu rostro sea reconocible.",
                color = Color(0xFF9E9E9E),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify
            )
            Text(
                text = ".JPG o .PNG. Máx. 20 MB",
                color = Color(0xFFBDBDBD),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify
            )
        }
    }
}
@Composable
fun ProfileSettingsSectionName(spacing: Spacing) {
    var userName by remember { mutableStateOf("") }
    var surnameUser by remember { mutableStateOf("") }
    Column(
        Modifier
            .padding(vertical = spacing.medium),
        verticalArrangement = Arrangement.spacedBy(
            spacing.medium,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = "Datos Personales", fontWeight = FontWeight.Bold)
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                spacing.large,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomOutlinedTextField(
                modifier = Modifier.weight(1f),
                value = userName,
                onValueChange = { userName = it },
                label = "Nombre",
            )
            CustomOutlinedTextField(
                modifier = Modifier.weight(2f),
                value = surnameUser,
                onValueChange = { surnameUser = it },
                label = "Apellidos",
            )
        }
    }
}

@Composable
fun ProfileSettingsSectionAboutYou(spacing: Spacing) {
    var userName by remember { mutableStateOf("") }
    val opciones = listOf("Perro", "Gato", "Conejo", "Tortuga")
    var tipoMascota by remember { mutableStateOf(opciones.first()) }

    Column(
        Modifier
            .padding(vertical = spacing.medium),
        verticalArrangement = Arrangement.spacedBy(
            spacing.medium,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = "Acerca de ti", fontWeight = FontWeight.Bold)

        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            height = 150.dp,
            value = userName,
            onValueChange = { userName = it },
            label = "Cuentanos un poco sobre ti...",
        )
        Text(
            text = "Appnimal se basa en relaciones. Ayuda a otras personas a conocerte.",
            color = Color(0xFF9E9E9E),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Nombre de tu mascota",
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Cumpleaños de tu mascota",
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Ubicación",
        )

        CustomOutlinedDropdown(
            label = "Tipo de mascota",
            options = opciones,
            selectedOption = tipoMascota,
            onOptionSelected = { tipoMascota = it },
        )

    }
}
//endregion SECTIONS

@Preview(Devices.PIXEL_7 )
@Composable
private fun ProfileSettingsScreenAboutYouSectionPreview() {
    val spacing = LocalSpacing.current
    val height = LocalConfiguration.current.screenHeightDp.dp
    ScreensDesignsTheme {
        Column (modifier = Modifier.background(Color.White)){
            ProfileSettingsScreen()
        }
    }
}
