package yandexMoney

import retrofit.Callback
import retrofit.http.GET
import yandexMoney.model.Category


interface YandexMoneyService {
    GET("/api/categories-list")
    fun getCategories(callback: Callback<List<Category>>)
}
