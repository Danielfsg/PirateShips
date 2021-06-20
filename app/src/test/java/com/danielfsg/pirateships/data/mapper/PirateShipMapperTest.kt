package com.danielfsg.pirateships.data.mapper

import com.danielfsg.pirateships.data.model.PirateShipEntity
import com.danielfsg.pirateships.domain.model.PirateShip
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PirateShipMapperTest {

    private lateinit var mapper: PirateShipMapper

    @Before
    fun setUp() {
        mapper = PirateShipMapper()
    }

    @Test
    fun `test mapToEntity normal ship with all the properties`() {
        val actualShip = PirateShipEntity(
            id = 1,
            title = "title",
            description = "description",
            price = 123,
            image = "image",
            greetingType = "greetingType"
        )
        val expectedShip = PirateShip(
            id = 1,
            title = "title",
            description = "description",
            price = "123 Doubloons",
            image = "image",
            greetingType = "Ahoi!"
        )
        assertEquals(expectedShip, mapper.mapToPirateShip(actualShip))
    }

    @Test
    fun `test mapToEntity normal ship with all the properties and greeting type 1`() {
        val actualShip = PirateShipEntity(
            id = 1,
            title = "title",
            description = "description",
            price = 123,
            image = "image",
            greetingType = "ay"
        )
        val expectedShip = PirateShip(
            id = 1,
            title = "title",
            description = "description",
            price = "123 Doubloons",
            image = "image",
            greetingType = "Aye Aye!"
        )
        assertEquals(expectedShip, mapper.mapToPirateShip(actualShip))
    }

    @Test
    fun `test mapToEntity normal ship with all the properties and greeting type 2`() {
        val actualShip = PirateShipEntity(
            id = 1,
            title = "title",
            description = "description",
            price = 123,
            image = "image",
            greetingType = "ar"
        )
        val expectedShip = PirateShip(
            id = 1,
            title = "title",
            description = "description",
            price = "123 Doubloons",
            image = "image",
            greetingType = "Arrr!"
        )
        assertEquals(expectedShip, mapper.mapToPirateShip(actualShip))
    }

    @Test
    fun `test mapToEntity normal ship with all the properties and greeting type 3`() {
        val actualShip = PirateShipEntity(
            id = 1,
            title = "title",
            description = "description",
            price = 123,
            image = "image",
            greetingType = "yo"
        )
        val expectedShip = PirateShip(
            id = 1,
            title = "title",
            description = "description",
            price = "123 Doubloons",
            image = "image",
            greetingType = "Yo ho hooo!"
        )
        assertEquals(expectedShip, mapper.mapToPirateShip(actualShip))
    }

    @Test
    fun `test mapToEntity normal ship with some properties missing`() {
        val actualShip = PirateShipEntity(
            id = 1,
            title = "",
            description = "",
            price = null,
            image = ""
        )
        val expectedShip = PirateShip(
            id = 1,
            title = "",
            description = "",
            price = "",
            image = "",
            greetingType = "Ahoi!"
        )
        assertEquals(expectedShip, mapper.mapToPirateShip(actualShip))
    }

    @Test
    fun `test mapToEntity normal ship with all null properties`() {
        val actualShip = PirateShipEntity(
            id = 1,
            title = null,
            description = null,
            price = null,
            image = null
        )
        val expectedShip = PirateShip(
            id = 1,
            title = "",
            description = "",
            price = "",
            image = "",
            greetingType = "Ahoi!"
        )
        assertEquals(expectedShip, mapper.mapToPirateShip(actualShip))
    }

}