package com.skinconnect.userapps.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class RegisterDetails(
    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("age")
    val age: String,

    @field:SerializedName("weight")
    val weight: String,

    @field:SerializedName("full_name")
    var fullName: String = "",
) : Parcelable

@Parcelize
data class PhotoFile(val file: File, val isBackCamera: Boolean) : Parcelable

@Parcelize
data class ProfileTodoItem(
    val scheduleId: String,
    val itemsId: String,
    val scheduleTitle: String,
    val userId: String,
) : Parcelable

data class Schedule(
    val time: String,
    val title: String,
    val description: String
)