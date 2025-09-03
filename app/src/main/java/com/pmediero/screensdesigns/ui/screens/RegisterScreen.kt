package com.pmediero.screensdesigns.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmediero.screensdesigns.R
import com.pmediero.screensdesigns.ui.core.LocalSpacing
import com.pmediero.screensdesigns.ui.core.Spacing
import com.pmediero.screensdesigns.ui.screens.components.BackNavigationBar
import com.pmediero.screensdesigns.ui.screens.components.CustomButton
import com.pmediero.screensdesigns.ui.screens.components.CustomOutlinedTextField
import com.pmediero.screensdesigns.ui.screens.components.OnboardingProgressBar
import com.pmediero.screensdesigns.ui.screens.components.OptionSelectorGroup
import com.pmediero.screensdesigns.ui.theme.ScreensDesignsTheme

@Composable
fun RegisterScreen() {
    val spacing = LocalSpacing.current
    val height = LocalConfiguration.current.screenHeightDp.dp

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        RegisterHeader(
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

        RegisterBody(
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

      RegisterFooter(
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
private fun RegisterHeader(modifier: Modifier, spacing: Spacing) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            spacing.large,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.Start,
    ) {

        BackNavigationBar(
            text = "Volver atrás",
            onBackClick = {}
        )
        OnboardingProgressBar(
            step = 1,
            totalSteps = 3
        )

    }
}

@Composable
private fun RegisterBody(modifier: Modifier, spacing: Spacing) {
    Column {
        RegisterBodyStep1(spacing = spacing)
        RegisterBodyStep2(spacing = spacing)
        RegisterBodyStep3(spacing = spacing)
    }

}

@Composable
private fun RegisterBodyStep1(spacing: Spacing){
    var userName by remember { mutableStateOf("") }
    Column(
        Modifier
            .padding(spacing.medium),
        verticalArrangement = Arrangement.spacedBy(
            spacing.large,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "¿Cómo te llamas?", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )

        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Nombre",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Apellido",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Contraseña",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Teléfono",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

    }
}
@Composable
private fun RegisterBodyStep2(spacing: Spacing){
    val opciones = listOf("Perro", "Gato", "Conejo", "Tortuga")
    var seleccion by remember { mutableStateOf(opciones.first()) }
    var petName by remember { mutableStateOf("") }
    var petDate by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            spacing.large,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "¿Qué tipo de mascota tienes?", fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
        OptionSelectorGroup(
            options = opciones,
            selectedOption = seleccion,
            onOptionSelected = { seleccion = it },
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "¿Cómo se llama tu mascota?", fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
        CustomOutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal = spacing.medium),
            value = petName,
            onValueChange = { petName = it },
            label = "Nombre",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

        )

        Text(
            text = "¿Cual es su fecha de nacimiento?", fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(
                spacing.medium,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomOutlinedTextField(
                modifier = Modifier.weight(1f),
                value = petDate,
                onValueChange = { petDate = it },
                label = "Dia",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CustomOutlinedTextField(
                modifier = Modifier.weight(1f),
                value = petDate,
                onValueChange = { petDate = it },
                label = "Mes",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CustomOutlinedTextField(
                modifier = Modifier.weight(2f),
                value = petDate,
                onValueChange = { petDate = it },
                label = "Año",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
        }
    }
}
@Composable
private fun RegisterBodyStep3(spacing: Spacing){
    val petName = "Nombre Mascota"
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(
            spacing.large,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.pet_logo),
            contentDescription = null,
        )

        Text(
            text = buildAnnotatedString {
                append("¿Busquemos a buscar los mejores servicios para ")

                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(petName)
                }

                append(" cerca de ti")
            },
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )

    }


}

@Composable
private fun RegisterFooter(modifier: Modifier, spacing: Spacing) {
    Column(modifier = modifier) {
        CustomButton(
            text = "Siguiente",
            onClick = {}
        )
    }
}
// endregion SCREENS

@Preview(Devices.PIXEL_7)
@Composable
private fun ProfileSettingsScreenAboutYouSectionPreview() {
    val spacing = LocalSpacing.current
    val height = LocalConfiguration.current.screenHeightDp.dp
    ScreensDesignsTheme {
        Column(modifier = Modifier.background(Color.White)) {
            RegisterScreen()
        }
    }
}
