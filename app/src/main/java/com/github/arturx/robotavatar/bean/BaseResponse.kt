package com.github.arturx.robotavatar.bean

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

/**
 * Created by arturx on 12.02.18.
 */
@Parcelize
data class BaseResponse(
        @JsonProperty("imageUrl") val imageUrl: String
) : Parcelable