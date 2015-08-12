package yandexMoney.model

import com.google.gson.annotations.SerializedName

class Category (
        val title: String,
        SerializedName("subs") var subs: List<Subs>)
