package com.example.healthcare.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AccessTokenEntity(
    val accessToken: String? = null,
    @PrimaryKey
    val id: Int? = null
)