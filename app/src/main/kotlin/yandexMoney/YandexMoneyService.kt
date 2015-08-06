package yandexMoney

import retrofit.http.GET
import yandexMoney.model.CategoryResponse

interface YandexMoneyService {
    GET("/api/categories-list")
    fun getCategories(): CategoryResponse
}
