package yandexMoney

import retrofit.RestAdapter

object ApiController {

    val adapter: RestAdapter = RestAdapter.Builder()
            .setEndpoint("https://money.yandex.ru")
            .build();

    val restApi: YandexMoneyService = adapter.create(javaClass<YandexMoneyService>())
}
