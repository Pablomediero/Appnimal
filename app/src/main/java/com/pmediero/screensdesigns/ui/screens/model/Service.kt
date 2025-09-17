package com.pmediero.screensdesigns.ui.screens.model

data class Service(
    val title: String,
    val location: String,
    val description: String,
    val price: String
)

fun mockServices(): List<Service> {
    return listOf(
        Service(
            title = "Veterinaria VitalPet",
            location = "Madrid, España",
            description = "Vacunación, consultas generales y emergencias 24h.",
            price = "45€"
        ),
        Service(
            title = "Peluquería Canina Peluditos",
            location = "Barcelona, España",
            description = "Cortes personalizados, baño y secado para perros y gatos.",
            price = "30€"
        ),
        Service(
            title = "Guardería Mascotas Felices",
            location = "Sevilla, España",
            description = "Guardería diurna y nocturna con espacios al aire libre.",
            price = "25€/día"
        ),
        Service(
            title = "Adiestramiento Canino Alpha",
            location = "Valencia, España",
            description = "Cursos de obediencia básica y modificación de conducta.",
            price = "60€"
        ),
        Service(
            title = "Veterinaria San Francisco",
            location = "Bilbao, España",
            description = "Cirugías menores, vacunación y revisiones de rutina.",
            price = "50€"
        ),
        Service(
            title = "Tienda de Mascotas Animal City",
            location = "Zaragoza, España",
            description = "Venta de alimentos, accesorios y juguetes para mascotas.",
            price = "Desde 5€"
        ),
        Service(
            title = "Hotel Canino Dog Palace",
            location = "Granada, España",
            description = "Estancias confortables con vigilancia 24h.",
            price = "40€/noche"
        ),
        Service(
            title = "Servicios a Domicilio PetHome",
            location = "Málaga, España",
            description = "Veterinaria, peluquería y paseo de mascotas en casa.",
            price = "Variable"
        ),
        Service(
            title = "Veterinaria Marítima",
            location = "A Coruña, España",
            description = "Especialistas en animales exóticos y marinos.",
            price = "55€"
        ),
        Service(
            title = "Centro Felino Gatolandia",
            location = "Valladolid, España",
            description = "Clínica exclusiva para gatos con zona de juegos.",
            price = "38€"
        )
    )
}
