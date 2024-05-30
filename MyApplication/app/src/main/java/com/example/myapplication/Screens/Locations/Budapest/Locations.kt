package com.example.myapplication.Screens.Locations.Budapest



data class Location(
    val title: String,
    val imageId: Int, // For future use with actual image
    val averageRating: Int,
    val numReviews: Int,
    val openHours: String,
    val reviews: List<Review>
)

data class Review(val author: String, val text: String, val rating: Int)

fun generateSampleLocations(): List<Location> {
    val locations = mutableListOf<Location>()

    // BpPark
    locations.add(
        Location(
            title = "Bp Park",
            imageId = 0, // Placeholder image ID
            averageRating = (3..5).random(),
            numReviews = (10..50).random(),
            openHours = "8:00 AM - 6:00 PM",
            reviews = generateSampleReviews((3..5).random())
        )
    )

    // BpRestaurant
    locations.add(
        Location(
            title = "Bp Restaurant",
            imageId = 0, // Placeholder image ID
            averageRating = (2..5).random(),
            numReviews = (20..100).random(),
            openHours = "10:00 AM - 10:00 PM",
            reviews = generateSampleReviews((5..7).random())
        )
    )

    // BpAttraction
    locations.add(
        Location(
            title = "Bp Attraction",
            imageId = 0, // Placeholder image ID
            averageRating = (4..5).random(),
            numReviews = (50..200).random(),
            openHours = "9:00 AM - 5:00 PM",
            reviews = generateSampleReviews((5..10).random())
        )
    )

    return locations
}

fun generateSampleReviews(numReviews: Int): List<Review> {
    val reviews = mutableListOf<Review>()
    val names = listOf("John Doe", "Jane Smith", "Michael Brown", "Alice Miller", "David Jones")
    val loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."

    repeat(numReviews) {
        reviews.add(
            Review(
                author = names.random(),
                text = loremIpsum.substring(0, (100..200).random()), // Random length excerpt
                rating = (1..5).random()
            )
        )
    }

    return reviews
}