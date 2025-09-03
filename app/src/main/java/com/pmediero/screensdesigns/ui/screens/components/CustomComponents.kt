package com.pmediero.screensdesigns.ui.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedCustomButton(
    onClick: () -> Unit,
    modifier: Modifier,
    shape: Shape = RoundedCornerShape(8.dp),
    borderStroke: BorderStroke = BorderStroke(1.dp, Color(0xFFE0E0E0)),
    text: String
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(minWidth = 1.dp),
        shape = shape,
        border = borderStroke,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = Color(0xFF424242)
        ),
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
fun ProfileImageViewCustom(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(180.dp) // Ajustable según diseño real
            .clip(CircleShape)
            .background(Color(0xFFF9F9F9))
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = CircleShape
            )
            .clickable(onClick = onClick)
    ) {
        Text(
            text = "+ Sube una imagen de perfil...",
            color = Color(0xFF424242),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            lineHeight = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    height: Dp = 64.dp,
    fontSize: TextUnit = 12.sp,
    shape: Shape = RoundedCornerShape(8.dp),
    borderColor: Color = Color(0xFFE0E0E0),
    backgroundColor: Color = Color.White,
    cursorColor: Color = Color(0xFF424242),
    leadingIcon: (@Composable (() -> Unit))? = null,
    trailingIcon: (@Composable (() -> Unit))? = null
) {
    val textColor = Color(0xFF424242)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .heightIn(min = height),
        textStyle = TextStyle(
            fontSize = fontSize,
            color = textColor
        ),
        keyboardOptions = keyboardOptions,
        enabled = isEnabled,
        readOnly = isReadOnly,
        singleLine = singleLine,
        shape = shape,
        label = label?.let {
            {
                Text(
                    text = it,
                    fontSize = fontSize,
                )
            }
        },
        placeholder = placeholder?.let {
            {
                Text(
                    text = it,
                    fontSize = fontSize,
                    color = textColor.copy(alpha = 0.6f)
                )
            }
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor.copy(alpha = 0.5f),
            cursorColor = cursorColor,
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedDropdown(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 12.sp,
    height: Dp = 64.dp,
    shape: Shape = RoundedCornerShape(8.dp),
    borderColor: Color = Color(0xFFE0E0E0),
    backgroundColor: Color = Color.White,
    textColor: Color = Color(0xFF424242),
    iconColor: Color = Color(0xFF424242)
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(
                    text = label,
                    fontSize = fontSize,
                    color = textColor
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = iconColor
                )
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .heightIn(min = height),
            shape = shape,
            textStyle = TextStyle(
                fontSize = fontSize,
                color = textColor
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                disabledTextColor = textColor.copy(alpha = 0.5f),
                cursorColor = textColor,
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption, fontSize = fontSize) },
                    onClick = {
                        onOptionSelected(selectionOption)
                        expanded = false
                    }
                )
            }
        }
    }
}


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 12.sp,
    backgroundColor: Color = Color(0xFF004A99),
    contentColor: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(50), // Pill shape
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            focusedElevation = 0.dp
        )
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight
        )
    }
}

@Composable
fun BackNavigationBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = "",
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = Color.Black
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable(onClick = onBackClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontWeight = fontWeight,
            fontSize = fontSize,
            color = textColor
        )
    }
}

@Composable
fun OnboardingProgressBar(
    step: Int,
    totalSteps: Int,
    modifier: Modifier = Modifier,
    height: Dp = 4.dp,
    backgroundColor: Color = Color(0xFFE0E0E0),
    progressColor: Color = Color(0xFF004A99)
) {
    val progress = step.coerceIn(0, totalSteps).toFloat() / totalSteps.toFloat()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .fillMaxHeight()
                .background(progressColor)
        )
    }
}


@Composable
fun OptionSelectableCard(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedBackgroundColor: Color = Color(0xFF004A99),
    unselectedBackgroundColor: Color = Color.White,
    selectedTextColor: Color = Color.White,
    unselectedTextColor: Color = Color.Black,
    borderColor: Color = Color(0xFFE0E0E0),
    radioSelectedColor: Color = Color.White,
    radioUnselectedColor: Color = Color(0xFFE0E0E0),
    radioDisabledSelectedColor: Color = Color.Gray,
    radioDisabledUnselectedColor: Color = Color.LightGray,
    cornerRadius: Dp = 12.dp,
    textStyle: TextStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
) {
    val backgroundColor = if (selected) selectedBackgroundColor else unselectedBackgroundColor
    val textColor = if (selected) selectedTextColor else unselectedTextColor
    val effectiveBorderColor = if (selected) Color.Transparent else borderColor

    Surface(
        shape = RoundedCornerShape(cornerRadius),
        color = backgroundColor,
        border = BorderStroke(1.dp, effectiveBorderColor),
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = textStyle.copy(color = textColor)
            )

            RadioButton(
                selected = selected,
                onClick = null,
                colors = RadioButtonDefaults.colors(
                    selectedColor = radioSelectedColor,
                    unselectedColor = radioUnselectedColor,
                    disabledSelectedColor = radioDisabledSelectedColor,
                    disabledUnselectedColor = radioDisabledUnselectedColor
                )
            )
        }
    }
}

@Composable
fun OptionSelectorGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    cardStyle: @Composable (
        text: String,
        selected: Boolean,
        onClick: () -> Unit
    ) -> Unit = { text, selected, onClick ->
        OptionSelectableCard(
            text = text,
            selected = selected,
            onClick = onClick
        )
    }
) {
    Column(modifier = modifier) {
        options.forEach { option ->
            cardStyle(option, option == selectedOption) {
                onOptionSelected(option)
            }
        }
    }
}


