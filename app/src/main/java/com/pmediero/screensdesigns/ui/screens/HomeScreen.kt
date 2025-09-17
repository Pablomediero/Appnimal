package com.pmediero.screensdesigns.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmediero.screensdesigns.R
import com.pmediero.screensdesigns.ui.core.LocalSpacing
import com.pmediero.screensdesigns.ui.core.Spacing
import com.pmediero.screensdesigns.ui.screens.components.BottomNavItem
import com.pmediero.screensdesigns.ui.screens.components.CustomBottomNavBar
import com.pmediero.screensdesigns.ui.screens.components.IconWithBackground
import com.pmediero.screensdesigns.ui.screens.components.ProfileImageViewCustom
import com.pmediero.screensdesigns.ui.screens.model.mockServices
import com.pmediero.screensdesigns.ui.theme.ScreensDesignsTheme

@Composable
fun HomeScreen() {
    val spacing = LocalSpacing.current
    val height = LocalConfiguration.current.screenHeightDp.dp

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        HomeHeader(spacing, modifier = Modifier.weight(1f))
        HomeBody(spacing, modifier = Modifier.weight(8f))
        HomeFooter(spacing, modifier = Modifier.weight(1f))
    }

}

@Composable
private fun HomeHeader(spacing: Spacing,  modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = spacing.medium),
        verticalArrangement = Arrangement.spacedBy(
            spacing.medium,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                spacing.customLarge,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconWithBackground(
                icon = painterResource(R.drawable.ic_category),
                iconTint = Color(0xFFB0B0B0),
                onClick = {}
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    spacing.small,
                    Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Localización Actual",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFBDBDBD),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Madrid",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            ProfileImageViewCustom(
                size = 48.dp,
                showText = false,
                onClick = {}
            )
        }

    }
}

@Composable
private fun HomeBody(spacing: Spacing, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = spacing.medium),
        verticalArrangement = Arrangement.spacedBy(
            spacing.medium,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                spacing.small,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconWithBackground(
                icon = painterResource(R.drawable.ic_category),
                text = "Categoria",
                onClick = {}
            )
            IconWithBackground(
                icon = painterResource(R.drawable.ic_bitcoin),
                text = "Precio",
                onClick = {}
            )
            IconWithBackground(
                icon = painterResource(R.drawable.ic_calendar),
                text = "Fechas",
                onClick = {}
            )
        }
        Column (
            Modifier.fillMaxHeight()
        ) {
            ServicesListScreen()

        }
    }
}

@Composable
fun ServicesListScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp) // o cualquier altura de testeo
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(mockServices()) { servicio ->
            ServiceListItem(
                title = servicio.title,
                location = servicio.location,
                description = servicio.description,
                price = servicio.price
            )
        }
    }

}

@Composable
private fun HomeFooter(spacing: Spacing,  modifier: Modifier) {
    var selected by remember { mutableStateOf(0) }

    val items = listOf(
        BottomNavItem(Icons.Filled.Home, "Home"),
        BottomNavItem(Icons.Filled.Favorite, "Favoritos"),
        BottomNavItem(Icons.Filled.ShoppingCart, "Carrito"),
        BottomNavItem(Icons.Filled.Person, "Perfil")
    )

    CustomBottomNavBar(
        selectedItem = selected,
        onItemSelected = { selected = it },
        items = items
    )
}
@Composable
fun ServiceListItem(
    title: String,
    location: String,
    description: String,
    price: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    placeholderColor: Color = Color(0xFFF5F7FA)
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Placeholder para futura imagen
            Box(
                modifier = Modifier
                    .size(width = 110.dp, height = 110.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(placeholderColor)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF111111)
                )


                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(0xFF004A99),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = location,
                        color = Color(0xFF004A99),
                        fontSize = 12.sp
                    )
                }


                Text(
                    text = description,
                    color = Color(0xFF8A8A8A),
                    fontSize = 12.sp,
                    lineHeight = 18.sp
                )


                Text(
                    text = price,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF111111)
                )
            }
        }
    }
}


@Preview
@Composable
private fun HomePreview() {
    val spacing = LocalSpacing.current
    val height = LocalConfiguration.current.screenHeightDp.dp
    ScreensDesignsTheme {
        Column(modifier = Modifier.background(Color.White)) {
            HomeScreen()
        }
    }
}