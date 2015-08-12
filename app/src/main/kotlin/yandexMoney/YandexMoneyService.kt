package yandexMoney

import retrofit.http.GET
import yandexMoney.model.Category
import java.util.*

interface YandexMoneyService {
    GET("/api/categories-list")
    fun getCategories(): List<Category>
}
